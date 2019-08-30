package com.absorbedbarrel.firstmod.init;

import com.absorbedbarrel.firstmod.Main;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum FirstArmorMaterials implements IArmorMaterial
{
	obsdian("obsidian", 500, new int[] {16, 20, 18, 14}, 30, FirstItems.obsidian_shard, "block.stone.hit", 5.0f);
	
	private static final int[] max_damage_array = new int[] {15, 15, 15, 9};
	private String name, equipSound;
	private int durability, enchantability;
	private int[] damageReductionAmount;
	private float toughness;
	private Item repairItem;
	
	private FirstArmorMaterials(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		this.damageReductionAmount = damageReductionAmount;
		this.durability = durability;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.name = name;
		this.repairItem = repairItem;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmount[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return Main.MODID + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(this.equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}
