package net.mcreator.kaisen.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class MoonderEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("x", Math.round(Mth.nextInt(RandomSource.create(), (int) (x - 8), (int) (x + 8))));
		entity.getPersistentData().putDouble("y", Math.round(Mth.nextInt(RandomSource.create(), (int) (y + 0), (int) (y + 1))));
		entity.getPersistentData().putDouble("z", Math.round(Mth.nextInt(RandomSource.create(), (int) (z - 8), (int) (z + 8))));
		if ((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x"), entity.getPersistentData().getDouble("y"), entity.getPersistentData().getDouble("z")))).getBlock() == Blocks.AIR
				|| (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x"), entity.getPersistentData().getDouble("y"), entity.getPersistentData().getDouble("z")))).getBlock() == Blocks.VOID_AIR
				|| (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x"), entity.getPersistentData().getDouble("y"), entity.getPersistentData().getDouble("z")))).getBlock() == Blocks.CAVE_AIR) {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z")), _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.MASTER, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.MASTER, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 1, 1, 1, 2);
		}
	}
}