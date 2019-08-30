package com.absorbedbarrel.firstmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.absorbedbarrel.firstmod.client.render.FirstRenderRegistry;
import com.absorbedbarrel.firstmod.config.Config;
import com.absorbedbarrel.firstmod.init.FirstArmorMaterials;
import com.absorbedbarrel.firstmod.init.FirstBlocks;
import com.absorbedbarrel.firstmod.init.FirstEntities;
import com.absorbedbarrel.firstmod.init.FirstItems;
import com.absorbedbarrel.firstmod.init.FirstToolMaterials;
import com.absorbedbarrel.firstmod.items.CustomAxeItem;
import com.absorbedbarrel.firstmod.items.CustomPickaxeItem;
import com.absorbedbarrel.firstmod.world.ModOreGen;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("firstmod")
public class Main 
{
	public static Main instance;
	public static final String MODID = "firstmod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup FIRSTMOD = new ModItemGroup();
	
	public Main() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG, "firstmod-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG, "firstmod-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("firstmod-client.toml").toString());
		Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("firstmod-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		ModOreGen.setupOreGen();
		LOGGER.info("Setup Method Registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		FirstRenderRegistry.registerEntityRenderers();
		LOGGER.info("clientRegestries Method Registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class MainRegistries 
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll
			(
					//Items
					FirstItems.ruby = new Item(new Item.Properties().group(FIRSTMOD)).setRegistryName(location("ruby")),
					FirstItems.obsidian_shard = new Item(new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_shard")),
					//Blocks
					FirstItems.ruby_block = new BlockItem(FirstBlocks.ruby_block, new Item.Properties().group(FIRSTMOD)).setRegistryName(FirstBlocks.ruby_block.getRegistryName()),
					FirstItems.ruby_ore = new BlockItem(FirstBlocks.ruby_ore, new Item.Properties().group(FIRSTMOD)).setRegistryName(FirstBlocks.ruby_ore.getRegistryName()),
					FirstItems.ruby_ore = new BlockItem(FirstBlocks.nether_gold_ore, new Item.Properties().group(FIRSTMOD)).setRegistryName(FirstBlocks.nether_gold_ore.getRegistryName()),
					//Tools
					FirstItems.obsidian_axe = new CustomAxeItem(FirstToolMaterials.obsidian, 2.0f, 1.25f, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_axe")),
					FirstItems.obsidian_pickaxe = new CustomPickaxeItem(FirstToolMaterials.obsidian, -1, 2.0f, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_pickaxe")),
					FirstItems.obsidian_sword = new SwordItem(FirstToolMaterials.obsidian, 1, 1.75f, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_sword")),
					FirstItems.obsidian_shovel = new ShovelItem(FirstToolMaterials.obsidian, -2, 2.25f, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_shovel")),
					FirstItems.obsidian_hoe = new HoeItem(FirstToolMaterials.obsidian, 3.f, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_hoe")),
					FirstItems.hammer = new CustomPickaxeItem(ItemTier.IRON, 5,-1.f, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("hammer")),
					//Armor
					FirstItems.obsidian_helmet = new ArmorItem(FirstArmorMaterials.obsdian, EquipmentSlotType.HEAD, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_helmet")),
					FirstItems.obsidian_chestplate = new ArmorItem(FirstArmorMaterials.obsdian, EquipmentSlotType.CHEST, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_chestplate")),
					FirstItems.obsidian_leggings = new ArmorItem(FirstArmorMaterials.obsdian, EquipmentSlotType.LEGS, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_leggings")),
					FirstItems.obsidian_boots = new ArmorItem(FirstArmorMaterials.obsdian, EquipmentSlotType.FEET, new Item.Properties().group(FIRSTMOD)).setRegistryName(location("obsidian_boots"))
			);
			
			FirstEntities.registerEntitySpawnEggs(event);
			LOGGER.info("Items Registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll
			(
					FirstBlocks.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 30.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("ruby_block")),
					FirstBlocks.ruby_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("ruby_ore")),
					FirstBlocks.nether_gold_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("nether_gold_ore"))
			);
			LOGGER.info("Blocks Registered");
		}
		
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) 
		{
			event.getRegistry().registerAll
			(
				FirstEntities.ZOMBIE_MINER
			);
			
			FirstEntities.registerEntityWorldSpawns();
		}
		
		public static ResourceLocation location(String name) 
		{
			return new ResourceLocation(MODID, name);
		}
	}
	
}