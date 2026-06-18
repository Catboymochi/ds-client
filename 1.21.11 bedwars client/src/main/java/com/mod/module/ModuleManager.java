package com.mod.module;

import com.mod.event.EventManager;
import com.mod.gui.ClickGUI;
import com.mod.module.modules.*;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void registerModules() {
        // ============================================================
        //  ADD ALL YOUR MODULES HERE – one line per module
        // ============================================================
        // Combat
        addModule(new AimAssist());
        addModule(new AutoClicker());
        addModule(new BlockHelper());
        addModule(new HitFlick());
        addModule(new TargetSelector());
        addModule(new ExtendedReach());
        addModule(new AutoRightClick());
        addModule(new SilentRotations());
        addModule(new WTap());
        addModule(new Triggerbot());
        addModule(new CrystalHelper());
        addModule(new FireballDeflector());
        addModule(new WeaponSwapper());
        addModule(new KnockbackAdjuster());
        addModule(new KnockbackReducer());
        addModule(new TargetFilter());
        addModule(new WindChargeHelper());
        addModule(new PotionThrower());
        // Visual
        addModule(new DebugCleaner());
        addModule(new DirectionArrows());
        addModule(new WallGlow());
        addModule(new BoxESP());
        addModule(new ExplosionOverlay());
        addModule(new Fullbright());
        addModule(new HealthBars());
        addModule(new TargetIndicators());
        addModule(new ItemGlow());
        addModule(new EnhancedTags());
        addModule(new ProjectileTrails());
        addModule(new BlockFinder());
        addModule(new SpawnerLocator());
        addModule(new StorageGlow());
        addModule(new Tracers());
        addModule(new TrajectoryPrediction());
        addModule(new OreHighlighter());
        addModule(new BedLocator());
        addModule(new BlockHighlighter());
        addModule(new CustomBlockAnim());
        addModule(new ClearWater());
        addModule(new DamageFlashColor());
        addModule(new InventoryBlur());
        addModule(new TimeVisualizer());
        addModule(new WeatherToggler());
        // Movement
        addModule(new AutoSprint());
        addModule(new JumpReset());
        addModule(new PearlHelper());
        addModule(new PositionRewind());
        addModule(new MovementBuffer());
        addModule(new ClutchHelper());
        addModule(new LagSimulator());
        addModule(new BridgingHelper());
        addModule(new Freecam());
        addModule(new MLGHelper());
        addModule(new ParkourHelper());
        addModule(new SafeWalking());
        addModule(new Freelook());
        addModule(new JumpCooldownFix());
        // Utility
        addModule(new AntiIdle());
        addModule(new AutoFishing());
        addModule(new AutoTool());
        addModule(new BlockDefense());
        addModule(new ChestAutoLoot());
        addModule(new FastPlacement());
        addModule(new AnchorPlacer());
        addModule(new ThrowTester());
        // Inventory
        addModule(new ArmorUpgrader());
        addModule(new AutoEquip());
        addModule(new HotbarOrganizer());
        addModule(new TotemMover());
        addModule(new InventoryCleaner());
        addModule(new InventorySorter());
        addModule(new SlotFiller());
        addModule(new AutoRefill());
        // Minigame
        addModule(new BedDestroyer());
        addModule(new MurderDetector());
        addModule(new PropFinder());
        // HUD
        addModule(new ArmorDurability());
        addModule(new TimeDisplay());
        addModule(new CompassHelper());
        addModule(new CoordinateDisplay());
        addModule(new FPSCounter());
        addModule(new KeystrokeDisplay());
        addModule(new PotionStatusDisplay());
        addModule(new ReachDisplay());
        addModule(new ScoreboardCustomizer());
        // Misc
        addModule(new PanicButton());
        addModule(new InputDelayFix());
        addModule(new ClickDelayFix());
        addModule(new DamageShakeRemover());
        // ... add any other modules you have
    }

    private static void addModule(Module module) {
        modules.add(module);
        EventManager.register(module);
    }

    public static List<Module> getModules() { return modules; }
    public static Module getModuleByName(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }
    public static List<Module> getModulesInCategory(Module.Category category) {
        List<Module> result = new ArrayList<>();
        for (Module m : modules) {
            if (m.getCategory() == category) result.add(m);
        }
        return result;
    }

    // Called from MixinKeyboard when a key is pressed
    public static void onKeyPress(int keyCode) {
        if (MinecraftClient.getInstance().currentScreen != null) return;

        // Open ClickGUI with Right Shift
        if (keyCode == GLFW.GLFW_KEY_RIGHT_SHIFT) {
            MinecraftClient.getInstance().setScreen(new ClickGUI());
            return;
        }

        // Toggle modules
        for (Module m : modules) {
            if (m.getKeyBind() == keyCode) {
                m.toggle();
                break; // only one module per key
            }
        }
    }
}