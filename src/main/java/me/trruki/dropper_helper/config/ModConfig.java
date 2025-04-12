package me.trruki.dropper_helper.config;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ModConfig {
    private static final Gson GSON = new Gson();
    private static final File CONFIG_FILE = new File("config/DropperHelper.json");
    private static ConfigData CONFIG_DATA;

    public static void loadConfig() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                CONFIG_DATA = GSON.fromJson(reader, ConfigData.class);
            } catch (Exception e) {
                CONFIG_DATA = new ConfigData();
            }
        } else {
            CONFIG_DATA = new ConfigData();
            saveConfig();
        }
    }

    public static void saveConfig() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(CONFIG_DATA, writer);
        } catch (Exception ignored) {
        }
    }


    public static boolean getPathHighlighter() {
        return CONFIG_DATA.pathHighlighter;
    }


    public static void setPathHighlighter(boolean pathHighlighter) {
        CONFIG_DATA.pathHighlighter = pathHighlighter;
        saveConfig();
    }

    public static class ConfigData {
        public boolean pathHighlighter = true;
    }
}
