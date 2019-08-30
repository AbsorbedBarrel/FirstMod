package com.absorbedbarrel.firstmod.config;

import java.io.File;

import com.absorbedbarrel.firstmod.Main;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config 
{
	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SERVER_CONFIG;
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CLIENT_CONFIG;
	
	static 
	{
		OreGenConfig.init(SERVER_BUILDER, CLIENT_BUILDER);
		
		SERVER_CONFIG = SERVER_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path) 
	{
		Main.LOGGER.info("loading config: " + path);
		final CommentedFileConfig FILE = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		Main.LOGGER.info("built config: " + path);
		FILE.load();
		Main.LOGGER.info("loaded config: " + path);
		config.setConfig(FILE);
	}
}
