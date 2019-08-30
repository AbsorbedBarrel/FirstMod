package com.absorbedbarrel.firstmod.world;

import com.absorbedbarrel.firstmod.config.OreGenConfig;
import com.absorbedbarrel.firstmod.init.FirstBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen 
{
	public static void setupOreGen() 
	{
		if (OreGenConfig.genOres.get()) 
		{
				for(Biome biome : ForgeRegistries.BIOMES) 
			{
				biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, FirstBlocks.ruby_ore.getDefaultState(), OreGenConfig.oreChance_ruby.get())));//type of feature, minable_config(predicate, ore_default_state, max_vein_size), CountRange, CountRangeConfig
				
				biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, FirstBlocks.nether_gold_ore.getDefaultState(), OreGenConfig.oreChance_ruby.get())));//type of feature, minable_config(predicate, ore_default_state, max_vein_size), CountRange, CountRangeConfig
			}
		}
		
	}
}
