package com.absorbedbarrel.firstmod.client.render;

import com.absorbedbarrel.firstmod.entities.ZombieMiner;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;


@OnlyIn(Dist.CLIENT)
public class FirstRenderRegistry 
{
	public static void registerEntityRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(ZombieMiner.class, new ZombieMinerRender.RenderFactory());
	}
}
