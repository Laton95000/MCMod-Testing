package com.laton95.runemysteries.world.mapGenerators;

import com.laton95.runemysteries.world.WorldGenerator;
import com.laton95.runemysteries.world.structureComponents.ComponentSurfaceRuin;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

import javax.annotation.Nullable;
import java.util.Random;

public class MapGenRuinAstral extends MapGenStructure
{
	@Override
	public String getStructureName()
	{
		return "astral_ruin";
	}
	
	@Nullable
	@Override
	public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored)
	{
		return new BlockPos(0, 0, 0);
	}
	
	@Override
	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
	{
		try
		{
			BlockPos pos = WorldGenerator.ruinTracker.astralRuin.getRuinPos();
			
			return chunkX == pos.getX() >> 4 && chunkZ == pos.getZ() >> 4 && !WorldGenerator.ruinTracker.astralRuin.isGenerated();
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
	
	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ)
	{
		return new Start(world, rand, chunkX, chunkZ);
	}
	
	public static class Start extends StructureStart
	{
		public Start()
		{
		}
		
		public Start(World worldIn, Random random, int chunkX, int chunkZ)
		{
			super(chunkX, chunkZ);
			int ypos = random.nextInt(10) + 20;
			ComponentSurfaceRuin ruin = new ComponentSurfaceRuin(WorldGenerator.ruinTracker.astralRuin, chunkX, chunkZ, ypos, random);
			components.add(ruin);
			updateBoundingBox();
		}
	}
}