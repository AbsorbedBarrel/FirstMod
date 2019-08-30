package com.absorbedbarrel.firstmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig 
{
	public static ForgeConfigSpec.BooleanValue genOres;
	public static ForgeConfigSpec.IntValue oreChance_ruby;
	public static ForgeConfigSpec.IntValue oreChance_gold;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) 
	{
		server.comment("OreGen config");
		
		genOres = server
				.comment("Decides if new Ores will generate or not")
				.define("oreGen.genOres", true);
		oreChance_ruby = server
				.comment("The chances of ruby ore veins spawning in your world")
				.defineInRange("oreGen.oreChance_ruby", 20, 1, 1000);
		oreChance_gold = server
				.comment("The chances of gold ore spawning in the nether")
				.defineInRange("oreGen.oreChance_gold", 20, 1, 1000);
		
	}
}
