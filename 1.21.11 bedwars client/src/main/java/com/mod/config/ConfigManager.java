package com.mod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mod.module.Module;
import com.mod.module.ModuleManager;
import com.mod.settings.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    private static final Path CONFIG_PATH = Paths.get("config/clientmod.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) return;
        try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
            JsonObject root = GSON.fromJson(reader, JsonObject.class);
            for (Module m : ModuleManager.getModules()) {
                if (root.has(m.getName())) {
                    JsonObject modObj = root.getAsJsonObject(m.getName());
                    if (modObj.has("enabled")) m.setEnabled(modObj.get("enabled").getAsBoolean());
                    if (modObj.has("keybind")) m.setKeyBind(modObj.get("keybind").getAsInt());
                    for (Setting<?> s : m.getSettings()) {
                        if (modObj.has(s.getName())) {
                            if (s instanceof BoolSetting) {
                                ((BoolSetting) s).setValue(modObj.get(s.getName()).getAsBoolean());
                            } else if (s instanceof NumSetting) {
                                ((NumSetting) s).setValue(modObj.get(s.getName()).getAsDouble());
                            } else if (s instanceof ModeSetting) {
                                ((ModeSetting) s).setValue(modObj.get(s.getName()).getAsString());
                            } else if (s instanceof KeybindSetting) {
                                ((KeybindSetting) s).setValue(modObj.get(s.getName()).getAsInt());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        JsonObject root = new JsonObject();
        for (Module m : ModuleManager.getModules()) {
            JsonObject modObj = new JsonObject();
            modObj.addProperty("enabled", m.isEnabled());
            modObj.addProperty("keybind", m.getKeyBind());
            for (Setting<?> s : m.getSettings()) {
                if (s instanceof BoolSetting) {
                    modObj.addProperty(s.getName(), ((BoolSetting) s).getValue());
                } else if (s instanceof NumSetting) {
                    modObj.addProperty(s.getName(), ((NumSetting) s).getValue());
                } else if (s instanceof ModeSetting) {
                    modObj.addProperty(s.getName(), ((ModeSetting) s).getMode());
                } else if (s instanceof KeybindSetting) {
                    modObj.addProperty(s.getName(), ((KeybindSetting) s).getValue());
                }
            }
            root.add(m.getName(), modObj);
        }
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(root, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}