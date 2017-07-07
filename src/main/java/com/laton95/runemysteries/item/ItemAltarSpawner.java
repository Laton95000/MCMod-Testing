package com.laton95.runemysteries.item;

import com.laton95.runemysteries.utility.WorldHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.Template;

public class ItemAltarSpawner extends RMModItem {

	public ItemAltarSpawner() {
		super("altar_Spawner", true);
		setMaxStackSize(1);
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack spawner = playerIn.getHeldItem(handIn);

		Template structure = WorldHelper.getTemplate(worldIn, "runealtar");
		if (structure != null)
			WorldHelper.loadStructure(playerIn.getPosition(), worldIn, structure);

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, spawner);
	}
}