package net.mcreator.kaisen.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class OmniusItem extends Item {
	public OmniusItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.kaisen.omnius.description_0"));
		list.add(Component.translatable("item.kaisen.omnius.description_1"));
		list.add(Component.translatable("item.kaisen.omnius.description_2"));
		list.add(Component.translatable("item.kaisen.omnius.description_3"));
	}
}