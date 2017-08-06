package com.laton95.runemysteries.spells;

public class Spells {
	public enum EnumSpell {
		ENDERPEARL_SPELL, SNOWBALL_SPELL, EXPLOSION_SPELL, DEATH_SPELL, NONE
	}
	
	public static final EnderpearlSpell ENDERPEARL_SPELL = new EnderpearlSpell();
	public static final SnowballSpell SNOWBALL_SPELL = new SnowballSpell();
	public static final ExplosionSpell EXPLOSION_SPELL = new ExplosionSpell();
	public static final DeathSpell DEATH_SPELL = new DeathSpell();
	
	public static Spell getSpellFromEnum(EnumSpell enumSpell) {
		switch (enumSpell) {
		case ENDERPEARL_SPELL:
			return ENDERPEARL_SPELL;
		case SNOWBALL_SPELL:
			return SNOWBALL_SPELL;
		case EXPLOSION_SPELL:
			return EXPLOSION_SPELL;
		case DEATH_SPELL:
			return DEATH_SPELL;
		default:
			return null;
		}
	}
}