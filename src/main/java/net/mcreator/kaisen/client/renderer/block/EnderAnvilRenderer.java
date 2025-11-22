package net.mcreator.kaisen.client.renderer.block;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.kaisen.init.KaisenModBlockEntities;
import net.mcreator.kaisen.client.model.animations.ender_anvilAnimation;
import net.mcreator.kaisen.client.model.Modelender_anvil;
import net.mcreator.kaisen.block.entity.EnderAnvilBlockEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnderAnvilRenderer implements BlockEntityRenderer<EnderAnvilBlockEntity> {
	private final CustomHierarchicalModel model;
	private final ResourceLocation texture;

	EnderAnvilRenderer(BlockEntityRendererProvider.Context context) {
		this.model = new CustomHierarchicalModel(context.bakeLayer(Modelender_anvil.LAYER_LOCATION));
		this.texture = ResourceLocation.parse("kaisen:textures/block/ender_anvil_texture.png");
	}

	private void updateRenderState(EnderAnvilBlockEntity blockEntity) {
		int tickCount = (int) blockEntity.getLevel().getGameTime();
		blockEntity.animationState0.animateWhen(true, tickCount);
	}

	@Override
	public void render(EnderAnvilBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource renderer, int light, int overlayLight) {
		updateRenderState(blockEntity);
		poseStack.pushPose();
		poseStack.scale(-1, -1, 1);
		poseStack.translate(-0.5, -0.5, 0.5);
		poseStack.translate(0, -1, 0);
		VertexConsumer builder = renderer.getBuffer(RenderType.entityCutout(texture));
		model.setupBlockEntityAnim(blockEntity, blockEntity.getLevel().getGameTime() + partialTick);
		model.renderToBuffer(poseStack, builder, light, overlayLight, 1, 1, 1, 1);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(KaisenModBlockEntities.ENDER_ANVIL.get(), EnderAnvilRenderer::new);
	}

	private static final class CustomHierarchicalModel extends Modelender_anvil {
		private final ModelPart root;
		private final BlockEntityHierarchicalModel animator = new BlockEntityHierarchicalModel();

		public CustomHierarchicalModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		public void setupBlockEntityAnim(EnderAnvilBlockEntity blockEntity, float ageInTicks) {
			animator.setupBlockEntityAnim(blockEntity, ageInTicks);
			super.setupAnim(null, 0, 0, ageInTicks, 0, 0);
		}

		private class BlockEntityHierarchicalModel extends HierarchicalModel<Entity> {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			}

			public void setupBlockEntityAnim(EnderAnvilBlockEntity blockEntity, float ageInTicks) {
				animator.root().getAllParts().forEach(ModelPart::resetPose);
				animator.animate(blockEntity.animationState0, ender_anvilAnimation.an_idle_ender_anvil, ageInTicks, 1f);
			}
		}
	}
}