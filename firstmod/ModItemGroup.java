package com.absorbedbarrel.firstmod;

import com.absorbedbarrel.firstmod.init.FirstItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup
{

	public ModItemGroup()
	{
		super("firstMod");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(FirstItems.ruby);
		//return new ItemStack(Item.BLOCK_TO_ITEM.get(Blocklists.ruby_block))
	}

}
