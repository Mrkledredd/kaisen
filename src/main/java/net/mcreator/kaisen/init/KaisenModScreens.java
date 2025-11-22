/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.kaisen.client.gui.EnderWorkbenchGUIScreen;
import net.mcreator.kaisen.client.gui.EnderAnvilGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KaisenModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(KaisenModMenus.ENDER_ANVIL_GUI.get(), EnderAnvilGUIScreen::new);
			MenuScreens.register(KaisenModMenus.ENDER_WORKBENCH_GUI.get(), EnderWorkbenchGUIScreen::new);
		});
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}