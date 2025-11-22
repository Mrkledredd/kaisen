package net.mcreator.kaisen.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelmoonder_Converted_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kaisen", "modelmoonder_converted_converted"), "main");
	public final ModelPart Body;
	public final ModelPart Head;
	public final ModelPart HornR;
	public final ModelPart HornL;
	public final ModelPart LegFL;
	public final ModelPart LegFR;
	public final ModelPart LegBR;
	public final ModelPart LegBL;

	public Modelmoonder_Converted_Converted(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = this.Body.getChild("Head");
		this.HornR = this.Head.getChild("HornR");
		this.HornL = this.Head.getChild("HornL");
		this.LegFL = root.getChild("LegFL");
		this.LegFR = root.getChild("LegFR");
		this.LegBR = root.getChild("LegBR");
		this.LegBL = root.getChild("LegBL");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 34).addBox(-6.0F, -4.0F, -10.0F, 12.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(30, 62).addBox(-4.0F, -4.0F, -6.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -10.5F));
		PartDefinition HornR = Head.addOrReplaceChild("HornR", CubeListBuilder.create(), PartPose.offset(-4.0F, -3.0F, -5.0F));
		PartDefinition cube_r1 = HornR.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(64, 45).addBox(-0.5F, -4.0F, -2.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.0F, 3.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition HornL = Head.addOrReplaceChild("HornL", CubeListBuilder.create(), PartPose.offset(4.0F, -3.0F, -5.0F));
		PartDefinition cube_r2 = HornL.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 45).addBox(-0.5F, -4.0F, -2.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, 3.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition LegFL = partdefinition.addOrReplaceChild("LegFL", CubeListBuilder.create().texOffs(60, 62).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.5F, -8.0F));
		PartDefinition LegFR = partdefinition.addOrReplaceChild("LegFR", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.5F, -8.0F));
		PartDefinition LegBR = partdefinition.addOrReplaceChild("LegBR", CubeListBuilder.create().texOffs(64, 15).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.5F, 8.0F));
		PartDefinition LegBL = partdefinition.addOrReplaceChild("LegBL", CubeListBuilder.create().texOffs(64, 30).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.5F, 8.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegBR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegBL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}