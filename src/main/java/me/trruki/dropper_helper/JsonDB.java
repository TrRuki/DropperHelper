package me.trruki.dropper_helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JsonDB {
    private static final JsonObject json = loadJson();

    private static JsonObject loadJson() {
        try {
            Identifier jsonFile = Identifier.of("dropper-helper", "data.json");
            Resource resource = MinecraftClient.getInstance().getResourceManager().getResource(jsonFile).orElse(null);
            if (resource == null) {return null;}
            InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception ignored) {
        }
        return null;
    }

    public static JsonObject getJson() {
        return json;
    }
}
