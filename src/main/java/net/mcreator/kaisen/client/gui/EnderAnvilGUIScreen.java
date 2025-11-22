package net.mcreator.kaisen.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.kaisen.world.inventory.EnderAnvilGUIMenu;
import net.mcreator.kaisen.procedures.EnderAnvilGUIStep2Procedure;
import net.mcreator.kaisen.procedures.EnderAnvilGUIStep1Procedure;
import net.mcreator.kaisen.procedures.EnderAnvilGUIOutcomeProcedure;
import net.mcreator.kaisen.network.EnderAnvilGUIButtonMessage;
import net.mcreator.kaisen.init.KaisenModScreens;
import net.mcreator.kaisen.KaisenMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class EnderAnvilGUIScreen extends AbstractContainerScreen<EnderAnvilGUIMenu> implements KaisenModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_ender_ancil_gui_outcome_empty_im;

	public EnderAnvilGUIScreen(EnderAnvilGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("kaisen:textures/screens/ender_anvil_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_anvil_gui_wardens_core_slot.png"), this.leftPos + 9, this.topPos + 33, 0, 0, 18, 18, 18, 18);
		guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_anvil_gui_nether_star_slot.png"), this.leftPos + 53, this.topPos + 33, 0, 0, 18, 18, 18, 18);
		guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_anvil_gui_ender_dragon_egg_slot.png"), this.leftPos + 99, this.topPos + 33, 0, 0, 18, 18, 18, 18);
		guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_ancil_gui_outcome_empty_img.png"), this.leftPos + 115, this.topPos + 27, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_ancil_gui_step2_empty_img.png"), this.leftPos + 70, this.topPos + 27, 0, 0, 32, 32, 32, 32);
		if (EnderAnvilGUIStep2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_ancil_gui_step2_ready_img.png"), this.leftPos + 70, this.topPos + 27, 0, 0, 32, 32, 32, 32);
		}
		guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_ancil_gui_step1_empty_img.png"), this.leftPos + 24, this.topPos + 27, 0, 0, 32, 32, 32, 32);
		if (EnderAnvilGUIStep1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("kaisen:textures/screens/ender_ancil_gui_step1_ready_img.png"), this.leftPos + 24, this.topPos + 27, 0, 0, 32, 32, 32, 32);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.kaisen.ender_anvil_gui.label_ender_anvil"), 4, 4, -6750055, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_ender_ancil_gui_outcome_empty_im = new ImageButton(this.leftPos + 115, this.topPos + 27, 32, 32, 0, 0, 32, ResourceLocation.parse("kaisen:textures/screens/atlas/imagebutton_ender_ancil_gui_outcome_empty_im.png"), 32, 64, e -> {
			int x = EnderAnvilGUIScreen.this.x;
			int y = EnderAnvilGUIScreen.this.y;
			if (EnderAnvilGUIOutcomeProcedure.execute(entity)) {
				KaisenMod.PACKET_HANDLER.sendToServer(new EnderAnvilGUIButtonMessage(0, x, y, z));
				EnderAnvilGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_ender_ancil_gui_outcome_empty_im);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_ender_ancil_gui_outcome_empty_im.visible = EnderAnvilGUIOutcomeProcedure.execute(entity);
	}
}