package net.mcreator.kaisen.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class KillItem extends SwordItem {
	public KillItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 102.5f;
			}

			public float getAttackDamageBonus() {
				return 2044f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 2048;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, 46f, new Item.Properties().fireResistant());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}