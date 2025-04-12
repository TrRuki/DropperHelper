package me.trruki.dropper_helper;

import me.trruki.dropper_helper.config.ModConfig;
import me.trruki.dropper_helper.feature.MapHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;

import java.util.Objects;

public class DropperHelperClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConfig.loadConfig();
        WorldRenderEvents.START.register((context) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.world != null && client.world.getScoreboard() != null && ScoreboardManager.getRawDisplayName(client.world.getScoreboard()) != null) {
                if (client.world != null && Objects.equals(ScoreboardManager.getRawDisplayName(client.world.getScoreboard()), "DROPPER")) {
                    MapHelper.tick(client);
                }
            }
        });
    }
}
