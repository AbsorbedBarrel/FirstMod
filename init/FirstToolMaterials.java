package com.absorbedbarrel.firstmod.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum FirstToolMaterials implements IItemTier
{
	obsidian(10, 15, 30, 5, 3000, FirstItems.obsidian_shard);
	
	private float attackDamage, efficiency;
	private int enchantability, harvestLevel, durability;
	private Item repairMaterial;
	
	private FirstToolMaterials(float attackDamage, float efficiency, int enchantability, int harvestLevel, int durability, Item repairMaterial) 
	{
		this.attackDamage = attackDamage;
		this.durability = durability;
		this.efficiency = efficiency;
		this.enchantability = enchantability;
		this.harvestLevel = harvestLevel;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() {

		return this.efficiency;
	}

	@Override
	public int getEnchantability() {

		return this.enchantability;
	}

	@Override
	public int getHarvestLevel() {

		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() {

		return this.durability;
	}

	@Override
	public Ingredient getRepairMaterial() {

		return Ingredient.fromItems(this.repairMaterial);
	}
}
