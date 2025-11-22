package net.mcreator.kaisen.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import java.util.List;

public class PayoItem extends Item {
	public PayoItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.kaisen.payo.description_0"));
		list.add(Component.translatable("item.kaisen.payo.description_1"));
		list.add(Component.translatable("item.kaisen.payo.description_2"));
	}
}