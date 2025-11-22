// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 5.0.4 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class ender_anvilAnimation {
	public static final AnimationDefinition an_idle_ender_anvil = AnimationDefinition.Builder.withLength(4.0F).looping()
			.addAnimation("Effect",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Effect",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.2F, 1.0F, 1.2F),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.build();
}