package com.laton95.runemysteries.world.structureComponents;

import java.util.Random;

import com.laton95.runemysteries.util.LogHelper;
import com.laton95.runemysteries.util.StructureHelper;
import com.laton95.runemysteries.world.AltarTracker;
import com.laton95.runemysteries.world.WorldGenerator;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class ComponentNetherAltar extends StructureComponent
{

	private String name;

	public ComponentNetherAltar()
	{}

	public ComponentNetherAltar(Random rand, int x, int z, String name)
	{
		LogHelper.info("tst3");
		boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(x, 64, z, 0, 0, 0, 10, 3, 10, EnumFacing.UP);
		this.name = name;
	}

	private boolean generated = false;
	
	@Override
	public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
	{
		AltarTracker.RuneAltar altar = WorldGenerator.altarTracker.getAltar(name);
		LogHelper.info("tst2");
		if (!generated && !altar.isGenerated()) 
		{
			LogHelper.info("Generating altar");
			StructureBoundingBox bBox = boundingBox;
			structureBoundingBoxIn = boundingBox;
			BlockPos pos = new BlockPos(bBox.minX, bBox.minY, bBox.minZ);
			BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY() - 6, pos.getZ() - 1);
			new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID).setBoundingBox(
					structureBoundingBoxIn).setChunk(new ChunkPos(pos)).setIgnoreEntities(false);
			StructureHelper structureHelper = new StructureHelper(worldIn, "nether_island", pos2);
			structureHelper.generate();
			
			structureHelper = new StructureHelper(worldIn, "stone_circle", pos);
			structureHelper.generate();
			structureHelper = new StructureHelper(worldIn, name, pos);
			structureHelper.generate();
			generated = true;
			
			altar.setPosition(new BlockPos(boundingBox.minX + 4, boundingBox.minY
					+ 1, boundingBox.minZ + 4));
			altar.setPlacementRadius(0);
			altar.setGenerated(true);
		}
		return true;
	}

	@Override
	protected void writeStructureToNBT(NBTTagCompound tagCompound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {
		// TODO Auto-generated method stub
		
	}
}
