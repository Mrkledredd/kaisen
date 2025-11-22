/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.kaisen.item.*;
import net.mcreator.kaisen.KaisenMod;

public class KaisenModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, KaisenMod.MODID);
	public static final RegistryObject<Item> WARDENS_CORE;
	public static final RegistryObject<Item> OMNIUS;
	public static final RegistryObject<Item> ENDER_ANVIL;
	public static final RegistryObject<Item> KAI_BRICKS;
	public static final RegistryObject<Item> KAI_MOSSY_BRICKS;
	public static final RegistryObject<Item> ENDER_GRASS_BLOCK;
	public static final RegistryObject<Item> ENDER_OAK;
	public static final RegistryObject<Item> STRIPPED_ENDER_OAK;
	public static final RegistryObject<Item> ENDER_OAK_LEAVES;
	public static final RegistryObject<Item> PAYO;
	public static final RegistryObject<Item> ENDER_OAK_PLANKS;
	public static final RegistryObject<Item> ENDER_KALOYA;
	public static final RegistryObject<Item> ENDER_GRASS_TALL;
	public static final RegistryObject<Item> ENDERIUM_ORE;
	public static final RegistryObject<Item> ENDERIUM_SWORD;
	public static final RegistryObject<Item> MOONDER_SPAWN_EGG;
	public static final RegistryObject<Item> MOONDER_MEAT;
	public static final RegistryObject<Item> COOKED_MOONDER_MEAT;
	public static final RegistryObject<Item> MOONDERS_HORN;
	public static final RegistryObject<Item> ENDER_WORKBENCH;
	public static final RegistryObject<Item> ENDERIUM;
	static {
		WARDENS_CORE = REGISTRY.register("wardens_core", WardensCoreItem::new);
		OMNIUS = REGISTRY.register("omnius", OmniusItem::new);
		ENDER_ANVIL = block(KaisenModBlocks.ENDER_ANVIL, new Item.Properties().fireResistant());
		KAI_BRICKS = block(KaisenModBlocks.KAI_BRICKS);
		KAI_MOSSY_BRICKS = block(KaisenModBlocks.KAI_MOSSY_BRICKS);
		ENDER_GRASS_BLOCK = block(KaisenModBlocks.ENDER_GRASS_BLOCK);
		ENDER_OAK = block(KaisenModBlocks.ENDER_OAK);
		STRIPPED_ENDER_OAK = block(KaisenModBlocks.STRIPPED_ENDER_OAK);
		ENDER_OAK_LEAVES = block(KaisenModBlocks.ENDER_OAK_LEAVES);
		PAYO = REGISTRY.register("payo", PayoItem::new);
		ENDER_OAK_PLANKS = block(KaisenModBlocks.ENDER_OAK_PLANKS);
		ENDER_KALOYA = block(KaisenModBlocks.ENDER_KALOYA);
		ENDER_GRASS_TALL = block(KaisenModBlocks.ENDER_GRASS_TALL);
		ENDERIUM_ORE = block(KaisenModBlocks.ENDERIUM_ORE);
		ENDERIUM_SWORD = REGISTRY.register("enderium_sword", EnderiumSwordItem::new);
		MOONDER_SPAWN_EGG = REGISTRY.register("moonder_spawn_egg", () -> new ForgeSpawnEggItem(KaisenModEntities.MOONDER, -16777216, -6710785, new Item.Properties()));
		MOONDER_MEAT = REGISTRY.register("moonder_meat", MoonderMeatItem::new);
		COOKED_MOONDER_MEAT = REGISTRY.register("cooked_moonder_meat", CookedMoonderMeatItem::new);
		MOONDERS_HORN = REGISTRY.register("moonders_horn", MoondersHornItem::new);
		ENDER_WORKBENCH = block(KaisenModBlocks.ENDER_WORKBENCH);
		ENDERIUM = REGISTRY.register("enderium", EnderiumItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}