package me.trruki.dropper_helper.block;

import me.trruki.dropper_helper.DropperHelper;
import me.trruki.dropper_helper.block.custom.ArrowBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block ARROW_BLOCK;
    public static Block RED_BLOCK;
    public static void registerBlocks() {
        RED_BLOCK = registerBlock("red_block",
                new Block(AbstractBlock.Settings.create()
                        .mapColor(MapColor.STONE_GRAY)
                        .strength(-1f)
                )
        );

        ARROW_BLOCK = registerBlock("arrow_block",
                new ArrowBlock(AbstractBlock.Settings.create()
                        .mapColor(MapColor.STONE_GRAY)
                        .strength(-1f)
                        .noCollision()
                        .nonOpaque()
                )
        );
    }
    private static Block registerBlock(String name, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(DropperHelper.MOD_ID, name), block);
    }
}
