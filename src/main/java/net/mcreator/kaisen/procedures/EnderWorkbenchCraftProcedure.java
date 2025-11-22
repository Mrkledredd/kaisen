package net.mcreator.kaisen.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.kaisen.init.KaisenModMenus;

public class EnderWorkbenchCraftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof KaisenModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(1).set(ItemStack.EMPTY);
			_menu.getSlots().get(2).set(ItemStack.EMPTY);
			_menu.getSlots().get(3).set(ItemStack.EMPTY);
			_menu.getSlots().get(4).set(ItemStack.EMPTY);
			_menu.getSlots().get(5).set(ItemStack.EMPTY);
			_menu.getSlots().get(6).set(ItemStack.EMPTY);
			_menu.getSlots().get(7).set(ItemStack.EMPTY);
			_menu.getSlots().get(8).set(ItemStack.EMPTY);
			_menu.getSlots().get(9).set(ItemStack.EMPTY);
			_menu.getSlots().get(31).set(ItemStack.EMPTY);
			_menu.getSlots().get(32).set(ItemStack.EMPTY);
			_menu.getSlots().get(33).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
	}
}