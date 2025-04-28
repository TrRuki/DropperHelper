package me.trruki.dropper_helper;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.trruki.dropper_helper.config.ModConfigScreen;
import net.minecraft.client.gui.screen.Screen;

public class DropperHelperModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> ModConfigScreen.getScreen((Screen) parent);
    }
}
