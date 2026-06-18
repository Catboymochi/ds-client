package com.mod.gui;

import com.mod.module.Module;
import com.mod.module.ModuleManager;
import com.mod.settings.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends Screen {
    private final List<Frame> frames = new ArrayList<>();
    private Module listeningModule = null;

    public ClickGUI() {
        super(Text.literal("ClickGUI"));
        int x = 10;
        for (Module.Category cat : Module.Category.values()) {
            frames.add(new Frame(cat, x, 10));
            x += 110;
        }
    }

    public void setListeningModule(Module module) {
        this.listeningModule = module;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        for (Frame frame : frames) {
            frame.render(context, mouseX, mouseY, delta);
        }
        if (listeningModule != null) {
            String msg = "Press a key for " + listeningModule.getName() + " (ESC to cancel)";
            int w = textRenderer.getWidth(msg);
            int x = (width - w) / 2;
            int y = height / 2 - 10;
            context.fill(x - 5, y - 5, x + w + 5, y + 20, 0xAA000000);
            context.drawText(textRenderer, msg, x, y, 0xFFFFFF, false);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (listeningModule != null) return false;
        for (Frame frame : frames) {
            if (frame.mouseClicked(mouseX, mouseY, button)) return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (Frame frame : frames) {
            frame.mouseReleased(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (listeningModule != null) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                listeningModule = null;
            } else if (keyCode != GLFW.GLFW_KEY_UNKNOWN) {
                listeningModule.setKeyBind(keyCode);
                listeningModule = null;
            }
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    // Inner Frame class (simplified)
    private static class Frame {
        private final Module.Category category;
        private int x, y, width = 100, height = 20;
        private boolean expanded = true;
        private boolean dragging = false;
        private int dragX, dragY;
        private final List<ModuleButton> buttons = new ArrayList<>();

        public Frame(Module.Category category, int x, int y) {
            this.category = category;
            this.x = x;
            this.y = y;
            for (Module m : ModuleManager.getModulesInCategory(category)) {
                buttons.add(new ModuleButton(m));
            }
        }

        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            context.fill(x, y, x + width, y + height, 0xFF222222);
            context.fill(x, y, x + width, y + 1, 0xFF555555);
            context.drawText(client.textRenderer, category.name(), x + 5, y + 5, 0xFFFFFFFF, false);
            if (expanded) {
                int yOff = height;
                for (ModuleButton btn : buttons) {
                    btn.render(context, x + 2, y + yOff, mouseX, mouseY);
                    yOff += btn.getTotalHeight();
                }
            }
        }

        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                if (button == 0) {
                    dragging = true;
                    dragX = (int)mouseX - x;
                    dragY = (int)mouseY - y;
                } else if (button == 1) {
                    expanded = !expanded;
                }
                return true;
            }
            if (expanded) {
                int yOff = height;
                for (ModuleButton btn : buttons) {
                    if (btn.mouseClicked(mouseX, mouseY, button, x + 2, y + yOff)) {
                        return true;
                    }
                    yOff += btn.getTotalHeight();
                }
            }
            return false;
        }

        public void mouseReleased(double mouseX, double mouseY, int button) {
            dragging = false;
            for (ModuleButton btn : buttons) {
                btn.mouseReleased(mouseX, mouseY, button);
            }
        }
    }

    private static class ModuleButton {
        private final Module module;
        private boolean settingsExpanded = false;
        private final List<SettingComponent> settingComponents = new ArrayList<>();

        public ModuleButton(Module module) {
            this.module = module;
            for (Setting<?> s : module.getSettings()) {
                settingComponents.add(new SettingComponent(s));
            }
        }

        public int getTotalHeight() {
            return 16 + (settingsExpanded ? settingComponents.size() * 16 : 0);
        }

        public void render(DrawContext context, int x, int y, int mouseX, int mouseY) {
            boolean hovered = mouseX >= x && mouseX <= x + 96 && mouseY >= y && mouseY <= y + 14;
            int color = module.isEnabled() ? 0xFF00AA00 : 0xFF444444;
            if (hovered) color = 0xFF666666;
            context.fill(x, y, x + 96, y + 14, color);
            context.drawText(client.textRenderer, module.getName(), x + 4, y + 3, 0xFFFFFFFF, false);
            String keyName = module.getKeyBind() == GLFW.GLFW_KEY_UNKNOWN ? "None" : GLFW.glfwGetKeyName(module.getKeyBind(), 0);
            int keyX = x + 96 - client.textRenderer.getWidth(keyName) - 4;
            context.drawText(client.textRenderer, keyName, keyX, y + 3, 0xFFAAAAAA, false);

            if (settingsExpanded) {
                int yOff = y + 16;
                for (SettingComponent comp : settingComponents) {
                    comp.render(context, x + 2, yOff, mouseX, mouseY);
                    yOff += 16;
                }
            }
        }

        public boolean mouseClicked(double mouseX, double mouseY, int button, int x, int y) {
            if (mouseX >= x && mouseX <= x + 96 && mouseY >= y && mouseY <= y + 14) {
                String keyName = module.getKeyBind() == GLFW.GLFW_KEY_UNKNOWN ? "None" : GLFW.glfwGetKeyName(module.getKeyBind(), 0);
                int keyWidth = client.textRenderer.getWidth(keyName);
                int keyX = x + 96 - keyWidth - 4;
                if (mouseX >= keyX && mouseX <= x + 96 - 4) {
                    if (button == 0) {
                        ((ClickGUI) client.currentScreen).setListeningModule(module);
                        return true;
                    }
                } else {
                    if (button == 0) {
                        module.toggle();
                        return true;
                    } else if (button == 1) {
                        settingsExpanded = !settingsExpanded;
                        return true;
                    }
                }
            }
            if (settingsExpanded) {
                int yOff = y + 16;
                for (SettingComponent comp : settingComponents) {
                    if (comp.mouseClicked(mouseX, mouseY, button, x + 2, yOff)) {
                        return true;
                    }
                    yOff += 16;
                }
            }
            return false;
        }

        public void mouseReleased(double mouseX, double mouseY, int button) {
            for (SettingComponent comp : settingComponents) {
                comp.mouseReleased(mouseX, mouseY, button);
            }
        }
    }

    private static class SettingComponent {
        private final Setting<?> setting;
        private int x, y;
        private boolean dragging = false;

        public SettingComponent(Setting<?> setting) {
            this.setting = setting;
        }

        public void render(DrawContext context, int x, int y, int mouseX, int mouseY) {
            this.x = x;
            this.y = y;
            context.fill(x, y, x + 92, y + 14, 0xFF333333);
            if (setting instanceof BoolSetting) {
                BoolSetting bs = (BoolSetting) setting;
                context.drawText(client.textRenderer, bs.getName(), x + 4, y + 3, 0xFFFFFF, false);
                boolean val = bs.getValue();
                int boxX = x + 75;
                context.fill(boxX, y + 2, boxX + 12, y + 12, val ? 0xFF00AA00 : 0xFFAA0000);
            } else if (setting instanceof NumSetting) {
                NumSetting ns = (NumSetting) setting;
                String label = ns.getName() + ": " + String.format("%.1f", ns.getValue());
                context.drawText(client.textRenderer, label, x + 4, y + 3, 0xFFFFFF, false);
                int barX = x + 4, barY = y + 10, barW = 84, barH = 2;
                context.fill(barX, barY, barX + barW, barY + barH, 0xFF555555);
                double percent = (ns.getValue() - ns.getMin()) / (ns.getMax() - ns.getMin());
                int thumbX = (int)(barX + percent * barW);
                context.fill(thumbX - 2, barY - 2, thumbX + 2, barY + barH + 2, 0xFFFFFFFF);
                if (dragging) {
                    double p = (double)(mouseX - barX) / barW;
                    p = Math.max(0, Math.min(1, p));
                    double newVal = ns.getMin() + (ns.getMax() - ns.getMin()) * p;
                    newVal = Math.round(newVal / ns.getIncrement()) * ns.getIncrement();
                    ns.setValue(newVal);
                }
            } else if (setting instanceof ModeSetting) {
                ModeSetting ms = (ModeSetting) setting;
                String label = ms.getName() + ": " + ms.getMode();
                context.drawText(client.textRenderer, label, x + 4, y + 3, 0xFFFFFF, false);
            }
        }

        public boolean mouseClicked(double mouseX, double mouseY, int button, int x, int y) {
            if (mouseX >= x && mouseX <= x + 92 && mouseY >= y && mouseY <= y + 14) {
                if (setting instanceof BoolSetting) {
                    ((BoolSetting) setting).toggle();
                    return true;
                } else if (setting instanceof ModeSetting) {
                    ((ModeSetting) setting).cycle(true);
                    return true;
                } else if (setting instanceof NumSetting) {
                    dragging = true;
                    return true;
                }
            }
            return false;
        }

        public void mouseReleased(double mouseX, double mouseY, int button) {
            dragging = false;
        }
    }
}