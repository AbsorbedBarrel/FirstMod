package com.absorbedbarrel.firstmod.client.models;

import com.absorbedbarrel.firstmod.entities.ZombieMiner;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public class ZombieMinerModel extends EntityModel<ZombieMiner> {
		private final RendererModel head;
		private final RendererModel body;
		private final RendererModel rightarm;
		private final RendererModel leftarm;
		private final RendererModel leftleg;
		private final RendererModel rightleg;

		public ZombieMinerModel() {
			textureWidth = 64;
			textureHeight = 32;

			head = new RendererModel(this);
			((RendererModel) head).setRotationPoint(0.0F, 24.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -32.0F, -4.0F, 8, 8, 8, 0.0F, false));

			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, -24.0F, -2.0F, 8, 12, 4, 0.0F, false));

			rightarm = new RendererModel(this);
			rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(rightarm);
			rightarm.cubeList.add(new ModelBox(rightarm, 40, 16, -8.0F, -24.0F, -2.0F, 4, 12, 4, 0.0F, true));

			leftarm = new RendererModel(this);
			leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(leftarm);
			leftarm.cubeList.add(new ModelBox(leftarm, 40, 16, 4.0F, -24.0F, -2.0F, 4, 12, 4, 0.0F, false));

			leftleg = new RendererModel(this);
			leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
			leftleg.cubeList.add(new ModelBox(leftleg, 0, 16, 0.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));

			rightleg = new RendererModel(this);
			rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg.cubeList.add(new ModelBox(rightleg, 0, 16, -4.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F, true));
		}
		public void render(EntityModel<?> entity, float f, float f1, float f2, float f3, float f4, float f5) 
		{
			head.render(f5);
			body.render(f5);
			leftleg.render(f5);
			rightleg.render(f5);
		}
		public void setRotationAngle(RendererModel rendererModel, float x, float y, float z) {
			rendererModel.rotateAngleX = x;
			rendererModel.rotateAngleY = y;
			rendererModel.rotateAngleZ = z;
		}
	}

