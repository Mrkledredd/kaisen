package net.mcreator.kaisen.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.kaisen.entity.MoonderEntity;
import net.mcreator.kaisen.client.model.animations.moonder_Converted_ConvertedAnimation;
import net.mcreator.kaisen.client.model.Modelmoonder_Converted_Converted;

public class MoonderRenderer extends MobRenderer<MoonderEntity, Modelmoonder_Converted_Converted<MoonderEntity>> {
	public MoonderRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelmoonder_Converted_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MoonderEntity entity) {
		return ResourceLocation.parse("kaisen:textures/entities/moonder.png");
	}

	private static final class AnimatedModel extends Modelmoonder_Converted_Converted<MoonderEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MoonderEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MoonderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, moonder_Converted_ConvertedAnimation.moonder_idle, ageInTicks, 1f);
				this.animateWalk(moonder_Converted_ConvertedAnimation.moonder_walk, limbSwing, limbSwingAmount, 3f, 10f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MoonderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}