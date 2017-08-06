package com.laton95.runemysteries.world.structureComponents;

import java.util.Random;

import com.laton95.runemysteries.init.BlockRegistry;
import com.laton95.runemysteries.util.WorldHelper;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class ComponentDeathTemple extends WorldHelper.ModFeature {

	public ComponentDeathTemple() {
	}

	public ComponentDeathTemple(Random rand, int x, int z) {
		super(rand, x, 83, z, 32, 10, 32);
	}

	@Override
	public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
		StructureBoundingBox structureboundingbox = getBoundingBox();
		BlockPos blockpos = new BlockPos(structureboundingbox.minX, structureboundingbox.minY,
				structureboundingbox.minZ);

		Template temple = WorldHelper.getTemplate(worldIn, "death_temple");
		PlacementSettings settings = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID)
				.setBoundingBox(structureboundingbox);
		WorldHelper.loadStructure(blockpos, worldIn, temple, settings);
		worldIn.setBlockState(new BlockPos(3, 86, 6), BlockRegistry.ALTAR_PORTAL.getDefaultState());
		return true;
	}
}