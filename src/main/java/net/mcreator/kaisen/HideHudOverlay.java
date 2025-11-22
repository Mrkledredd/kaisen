package net.mcreator.kaisen;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "kaisen", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class HideHudOverlay {

    @SubscribeEvent
    public static void onRenderGuiOverlayPre(RenderGuiOverlayEvent.Pre event) {

        // Скрываем ванильные сердца
        if (event.getOverlay() == VanillaGuiOverlay.PLAYER_HEALTH.type()) {
            event.setCanceled(true);
        }

        // Скрываем ванильную броню
        if (event.getOverlay() == VanillaGuiOverlay.ARMOR_LEVEL.type()) {
            event.setCanceled(true);
        }
    }
}
