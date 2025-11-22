package net.mcreator.kaisen.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.kaisen.init.KaisenModItems;

import java.util.List;

public class EnderiumSwordItem extends SwordItem {
	public EnderiumSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2222;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KaisenModItems.RAW_ENDERIUM.get()));
			}
		}, 3, -2.4f, new Item.Properties().fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.kaisen.enderium_sword.description_0"));
		list.add(Component.translatable("item.kaisen.enderium_sword.description_1"));
		list.add(Component.translatable("item.kaisen.enderium_sword.description_2"));
		list.add(Component.translatable("item.kaisen.enderium_sword.description_3"));
		list.add(Component.translatable("item.kaisen.enderium_sword.description_4"));
	}
}