package com.laton95.runemysteries.world.structureComponents;

import java.util.Random;

import com.laton95.runemysteries.utility.WorldHelper;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class ComponentNetherAltar extends WorldHelper.ModFeature {
	private String name;

	public ComponentNetherAltar() {
	}

	public ComponentNetherAltar(Random rand, int x, int z, String name) {
		super(rand, x, 45, z, 10, 3, 10);
		this.name = name;
	}

	@Override
	public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
		StructureBoundingBox structureboundingbox = getBoundingBox();
		BlockPos blockpos = new BlockPos(structureboundingbox.minX, structureboundingbox.minY,
				structureboundingbox.minZ);
		BlockPos blockpos2 = new BlockPos(blockpos.getX() - 1, blockpos.getY() - 6, blockpos.getZ() - 1);

		Template island = WorldHelper.getTemplate(worldIn, "nether_island");
		Template circle = WorldHelper.getTemplate(worldIn, "stone_circle");
		Template altar = WorldHelper.getTemplate(worldIn, name);
		PlacementSettings settings = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID)
				.setBoundingBox(structureboundingbox);
		WorldHelper.loadStructure(blockpos2, worldIn, island);
		WorldHelper.loadStructure(blockpos, worldIn, circle, settings);
		WorldHelper.loadStructure(blockpos, worldIn, altar, settings);
		return true;
	}
}