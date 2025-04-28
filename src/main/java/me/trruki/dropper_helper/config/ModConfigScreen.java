package me.trruki.dropper_helper.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ModConfigScreen {

    public static Screen getScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("Dropper Helper Config"));

        builder.setSavingRunnable(ModConfig::saveConfig);

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        builder.getOrCreateCategory(Text.literal("General"))
                .addEntry(entryBuilder.startBooleanToggle(Text.literal("Drop path highlighter §8§o(with red blocks)"), ModConfig.getPathHighlighter())
                        .setSaveConsumer(ModConfig::setPathHighlighter)
                        .setYesNoTextSupplier((aBoolean -> {
                            if (aBoolean) return Text.literal("§aEnabled");
                            else return Text.literal("§cDisabled");
                        }))
                        .build())
                .addEntry(entryBuilder.startBooleanToggle(Text.literal("Drop direction arrow §8§o(an arrow will show you where to fall)"), ModConfig.getDirectionArrow())
                        .setSaveConsumer(ModConfig::setDirectionArrow)
                        .setYesNoTextSupplier((aBoolean -> {
                            if (aBoolean) return Text.literal("§aEnabled");
                            else return Text.literal("§cDisabled");
                        }))
                        .build());



        return builder.build();
    }
}
