package com.laton95.runemysteries.spells;

import com.google.common.collect.ImmutableList;
import com.laton95.runemysteries.entity.projectile.EntityProjectileSpellExplosive;
import com.laton95.runemysteries.reference.ModReference;
import com.laton95.runemysteries.reference.NamesReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;

public class ExplosionSpell extends SpellBase
{
	
	private final static List<SpellCost> costs = ImmutableList.of(
	
	);
	
	public ExplosionSpell()
	{
		super(costs, 20, NamesReference.Spells.EXPLOSION_SPELL_NAME, NamesReference.Spells.EXPLOSION_SPELL_DESCRIPTION, new ResourceLocation(ModReference.MOD_ID, "textures/spells/gui/explosion.png"));
	}
	
	@Override
	public boolean fireSpell(World world, EntityPlayer player)
	{
		EntityProjectileSpellExplosive projectile = new EntityProjectileSpellExplosive(world, player);
		projectile.setExplosivePower(2);
		putProjectileInWorld(world, player, projectile);
		
		return true;
	}
	
}
