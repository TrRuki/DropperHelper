package me.trruki.dropper_helper.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;

public class ArrowBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.of("facing", Direction.Type.HORIZONTAL);

    public ArrowBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
