package com.absorbedbarrel.firstmod.init;

import com.absorbedbarrel.firstmod.Main;
import com.absorbedbarrel.firstmod.Main.MainRegistries;
import com.absorbedbarrel.firstmod.entities.ZombieMiner;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class FirstEntities 
{
	public static EntityType<?> ZOMBIE_MINER = EntityType.Builder.create(ZombieMiner::new, EntityClassification.MONSTER).build(Main.MODID + ":zombie_miner").setRegistryName(MainRegistries.location("zombie_miner"));
	
	public static void registerEntityWorldSpawns() 
	{
		registerEntityWorldSpawn(ZOMBIE_MINER, Biomes.PLAINS, Biomes.BEACH, Biomes.STONE_SHORE);
	}
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll
		(
				FirstItems.zombie_miner_egg = registerEntitySpawnEgg(ZOMBIE_MINER, 0x42f5b6, 0x659483, "zombie_miner_entity_egg")
		);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) 
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(Main.FIRSTMOD));
		item.setRegistryName(MainRegistries.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes) 
	{
		for(Biome biome : biomes) 
		{
			if (biome != null) 
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}
