package com.mcmoddev.ironagefurniture.api.Blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class Stool extends Chair {

	public Stool(float hardness, float blastResistance, SoundType sound, String name) {
		super(hardness, blastResistance, sound, name);
	}
	
	@Override
	protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
        	VoxelShape shapes = VoxelShapes.empty();
        
    		// short stool body
        	shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(3, 6, 3, 13, 7, 13), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); // chair base
        	
        	//short stool legs
        	shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(7, 0, 11, 9, 7, 12), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); 
            shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(10, 0, 5, 13, 7, 8), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); 
            shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(4, 0, 5,6, 7, 8), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); 	
        	
            builder.put(state, shapes.simplify());
        }
        
        return builder.build();
    }
}
