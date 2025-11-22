/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;

import net.mcreator.kaisen.block.entity.EnderAnvilBlockEntity;
import net.mcreator.kaisen.KaisenMod;

public class KaisenModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, KaisenMod.MODID);
	public static final RegistryObject<BlockEntityType<EnderAnvilBlockEntity>> ENDER_ANVIL = register("ender_anvil", KaisenModBlocks.ENDER_ANVIL, EnderAnvilBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}