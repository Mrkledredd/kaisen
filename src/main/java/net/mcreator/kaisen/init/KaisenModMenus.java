/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.kaisen.world.inventory.EnderWorkbenchGUIMenu;
import net.mcreator.kaisen.world.inventory.EnderAnvilGUIMenu;
import net.mcreator.kaisen.network.MenuStateUpdateMessage;
import net.mcreator.kaisen.KaisenMod;

import java.util.Map;

public class KaisenModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, KaisenMod.MODID);
	public static final RegistryObject<MenuType<EnderAnvilGUIMenu>> ENDER_ANVIL_GUI = REGISTRY.register("ender_anvil_gui", () -> IForgeMenuType.create(EnderAnvilGUIMenu::new));
	public static final RegistryObject<MenuType<EnderWorkbenchGUIMenu>> ENDER_WORKBENCH_GUI = REGISTRY.register("ender_workbench_gui", () -> IForgeMenuType.create(EnderWorkbenchGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				KaisenMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof KaisenModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				KaisenMod.PACKET_HANDLER.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}