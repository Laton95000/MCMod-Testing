package com.laton95.runemysteries.utility;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class WorldTeleporter extends Teleporter {

	BlockPos pos;
	BlockPos exit;
	WorldServer world;

	public WorldTeleporter(WorldServer worldIn, BlockPos pos, BlockPos exit) {
		super(worldIn);
		this.pos = pos;
		this.exit = exit;
		world = worldIn;
	}

	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
		entityIn.setLocationAndAngles(exit.getX(), exit.getY(), exit.getZ(), entityIn.rotationYaw, 0.0F);
		entityIn.motionX = 0.0D;
		entityIn.motionY = 0.0D;
		entityIn.motionZ = 0.0D;

	}
}