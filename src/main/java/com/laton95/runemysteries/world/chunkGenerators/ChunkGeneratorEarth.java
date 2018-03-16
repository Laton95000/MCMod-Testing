package com.laton95.runemysteries.world.chunkGenerators;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ChunkGeneratorEarth extends ChunkGeneratorSolidWorld
{
	
	public ChunkGeneratorEarth(World worldIn, long seed)
	{
		super(worldIn, seed, 256, Blocks.DIRT.getDefaultState());
	}
	
}
