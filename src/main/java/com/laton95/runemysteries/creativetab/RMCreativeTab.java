package com.laton95.runemysteries.creativetab;

import com.laton95.runemysteries.init.ItemRegistry;
import com.laton95.runemysteries.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RMCreativeTab {
	public static final CreativeTabs RM_TAB = new CreativeTabs(Reference.MOD_ID) {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.fireRune);
		}
	};
}