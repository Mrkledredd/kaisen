// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelender_anvil<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ender_anvil"), "main");
	private final ModelPart Effect;
	private final ModelPart Top;
	private final ModelPart Body;

	public Modelender_anvil(ModelPart root) {
		this.Effect = root.getChild("Effect");
		this.Top = root.getChild("Top");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Effect = partdefinition.addOrReplaceChild("Effect",
				CubeListBuilder.create().texOffs(-16, 112).addBox(-8.0F, -3.0F, -8.0F, 16.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, -2.0358F, 0.0F));

		PartDefinition Top = partdefinition.addOrReplaceChild("Top", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-8.0F, -2.0F, -8.0F, 16.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 20)
						.addBox(-16.0F, -3.0F, 0.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 39)
						.addBox(-15.0F, -6.0F, 1.0F, 14.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
						.addBox(-15.0F, -12.0F, 1.0F, 14.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(56, 39)
						.addBox(-14.0F, -9.0F, 2.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Effect.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}