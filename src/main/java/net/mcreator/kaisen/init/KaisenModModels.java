/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.kaisen.client.model.Modelmoonder_Converted_Converted;
import net.mcreator.kaisen.client.model.Modelender_anvil;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KaisenModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmoonder_Converted_Converted.LAYER_LOCATION, Modelmoonder_Converted_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelender_anvil.LAYER_LOCATION, Modelender_anvil::createBodyLayer);
	}
}