package com.absorbedbarrel.firstmod.entities;

import com.absorbedbarrel.firstmod.init.FirstEntities;
import com.absorbedbarrel.firstmod.init.FirstItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreatheAirGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ZombieMiner extends ZombieEntity
{

	@SuppressWarnings("unchecked")
	public ZombieMiner(EntityType<? extends ZombieEntity> type, World worldIn) 
	{
		super((EntityType<? extends ZombieEntity>) FirstEntities.ZOMBIE_MINER, worldIn);
	}
	
	@SubscribeEvent
	public void spawnItems(EntityJoinWorldEvent event) 
	{
		if (!(event.getEntity() instanceof ZombieMiner)) 
		{
			return;
		}
		ZombieMiner entity = (ZombieMiner) event.getEntity();
		
		entity.setHeldItem(entity.getActiveHand(), new ItemStack(FirstItems.hammer));
		entity.replaceItemInInventory(4, new ItemStack(Items.GOLDEN_HELMET));
	}
	
	@Override
	protected void registerGoals() 
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new BreatheAirGoal(this));
		this.goalSelector.addGoal(1, new ZombieAttackGoal(this, 1.2d, false));
		this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1.2d));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		super.registerGoals();
	}
	
	@Override
	protected void registerAttributes() 
	{
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.2d);
		super.registerAttributes();
	}
	
}
