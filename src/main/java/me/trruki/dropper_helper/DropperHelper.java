package me.trruki.dropper_helper;

import me.trruki.dropper_helper.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

public class DropperHelper implements ModInitializer {
	public static final String MOD_ID = "dropper-helper";

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
	}
}