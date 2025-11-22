/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.kaisen.block.*;
import net.mcreator.kaisen.KaisenMod;

public class KaisenModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, KaisenMod.MODID);
	public static final RegistryObject<Block> ENDER_ANVIL;
	public static final RegistryObject<Block> KAI_BRICKS;
	public static final RegistryObject<Block> KAI_MOSSY_BRICKS;
	public static final RegistryObject<Block> ENDER_GRASS_BLOCK;
	public static final RegistryObject<Block> ENDER_OAK;
	public static final RegistryObject<Block> STRIPPED_ENDER_OAK;
	public static final RegistryObject<Block> ENDER_OAK_LEAVES;
	public static final RegistryObject<Block> ENDER_OAK_PLANKS;
	public static final RegistryObject<Block> ENDER_KALOYA;
	public static final RegistryObject<Block> ENDER_GRASS_TALL;
	public static final RegistryObject<Block> ENDERIUM_ORE;
	public static final RegistryObject<Block> ENDER_WORKBENCH;
	static {
		ENDER_ANVIL = REGISTRY.register("ender_anvil", EnderAnvilBlock::new);
		KAI_BRICKS = REGISTRY.register("kai_bricks", KaiBricksBlock::new);
		KAI_MOSSY_BRICKS = REGISTRY.register("kai_mossy_bricks", KaiMossyBricksBlock::new);
		ENDER_GRASS_BLOCK = REGISTRY.register("ender_grass_block", EnderGrassBlockBlock::new);
		ENDER_OAK = REGISTRY.register("ender_oak", EnderOakBlock::new);
		STRIPPED_ENDER_OAK = REGISTRY.register("stripped_ender_oak", StrippedEnderOakBlock::new);
		ENDER_OAK_LEAVES = REGISTRY.register("ender_oak_leaves", EnderOakLeavesBlock::new);
		ENDER_OAK_PLANKS = REGISTRY.register("ender_oak_planks", EnderOakPlanksBlock::new);
		ENDER_KALOYA = REGISTRY.register("ender_kaloya", EnderKaloyaBlock::new);
		ENDER_GRASS_TALL = REGISTRY.register("ender_grass_tall", EnderGrassTallBlock::new);
		ENDERIUM_ORE = REGISTRY.register("enderium_ore", EnderiumOreBlock::new);
		ENDER_WORKBENCH = REGISTRY.register("ender_workbench", EnderWorkbenchBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}