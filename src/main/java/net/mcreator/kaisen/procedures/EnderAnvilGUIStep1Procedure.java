package net.mcreator.kaisen.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.kaisen.init.KaisenModMenus;
import net.mcreator.kaisen.init.KaisenModItems;

public class EnderAnvilGUIStep1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof KaisenModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == KaisenModItems.WARDENS_CORE.get()) {
			return true;
		} else {
			return false;
		}
	}
}