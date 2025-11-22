package net.mcreator.kaisen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CustomHeartsOverlay {

    private static final ResourceLocation HEART_TEXTURE = new ResourceLocation("kaisen:textures/gui/custom_hearts.png");
    private static final int HEART_SIZE = 9;
    private static final int OVERLAP = 1;
    private static final int HEARTS_PER_LAYER = 10;

    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        // ❗ Не рисовать кастомные сердца в креативе
        if (player.isCreative()) return;

        GuiGraphics guiGraphics = event.getGuiGraphics();
        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        int xStart = screenWidth / 2 - 91;
        int yStart = screenHeight - 39;

        int health = (int) Math.ceil(player.getHealth());
        int maxHealth = (int) player.getMaxHealth();

        int totalHearts = (maxHealth + 1) / 2;

        // 1️⃣ Пустые слоты сердец
        for (int i = 0; i < HEARTS_PER_LAYER; i++) {
            if (i >= totalHearts) break;
            guiGraphics.blit(HEART_TEXTURE, xStart + i * (HEART_SIZE - OVERLAP), yStart,
                    0, 0, HEART_SIZE, HEART_SIZE, 27, 27);
        }

        // 2️⃣ Цветные сердца по слоям (многоцветные)
        int numLayers = (int) Math.ceil((double) totalHearts / HEARTS_PER_LAYER);
        for (int layer = 0; layer < numLayers; layer++) {
            for (int i = 0; i < HEARTS_PER_LAYER; i++) {
                int heartIndex = layer * HEARTS_PER_LAYER + i;
                if (heartIndex >= totalHearts) break;

                int heartHealth = health - heartIndex * 2;
                if (heartHealth <= 0) continue;

                int full = heartHealth >= 2 ? 2 : 1;
                int u = full == 2 ? 9 : 18;
                int v = layer * HEART_SIZE;

                guiGraphics.blit(HEART_TEXTURE, xStart + i * (HEART_SIZE - OVERLAP), yStart,
                        u, v, HEART_SIZE, HEART_SIZE, 27, 27);
            }
        }
    }
}
