package com.absorbedbarrel.firstmod.client.render;

import com.absorbedbarrel.firstmod.Main.MainRegistries;
import com.absorbedbarrel.firstmod.client.models.ZombieMinerModel;
import com.absorbedbarrel.firstmod.entities.ZombieMiner;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ZombieMinerRender extends LivingRenderer<ZombieMiner, ZombieMinerModel>
{
	public ZombieMinerRender(EntityRendererManager manager) 
	{
		super(manager, new ZombieMinerModel(), 2.f);
	}

	@Override
	protected ResourceLocation getEntityTexture(ZombieMiner entity) 
	{
		return MainRegistries.location("textures/entity/zombie_miner.png");
	}
	
	public static class RenderFactory implements IRenderFactory<ZombieMiner>
	{

		@Override
		public EntityRenderer<? super ZombieMiner> createRenderFor(EntityRendererManager manager) 
		{
			return new ZombieMinerRender(manager);
		}
		
	}
}
