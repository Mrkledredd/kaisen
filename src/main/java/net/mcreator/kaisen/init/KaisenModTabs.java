/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kaisen.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.kaisen.KaisenMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KaisenModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaisenMod.MODID);
	public static final RegistryObject<CreativeModeTab> KSN_ITEMS = REGISTRY.register("ksn_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.kaisen.ksn_items")).icon(() -> new ItemStack(KaisenModItems.WARDENS_CORE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KaisenModItems.WARDENS_CORE.get());
				tabData.accept(KaisenModItems.OMNIUS.get());
				tabData.accept(KaisenModItems.MOONDERS_HORN.get());
				tabData.accept(KaisenModItems.ENDERIUM.get());
			}).build());
	public static final RegistryObject<CreativeModeTab> KSN_BLOCKS = REGISTRY.register("ksn_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.kaisen.ksn_blocks")).icon(() -> new ItemStack(KaisenModBlocks.ENDER_GRASS_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KaisenModBlocks.KAI_BRICKS.get().asItem());
				tabData.accept(KaisenModBlocks.KAI_MOSSY_BRICKS.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_GRASS_BLOCK.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_OAK.get().asItem());
				tabData.accept(KaisenModBlocks.STRIPPED_ENDER_OAK.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_OAK_LEAVES.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_OAK_PLANKS.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_KALOYA.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_GRASS_TALL.get().asItem());
				tabData.accept(KaisenModBlocks.ENDERIUM_ORE.get().asItem());
				tabData.accept(KaisenModBlocks.ENDER_WORKBENCH.get().asItem());
			}).withTabsBefore(KSN_ITEMS.getId()).build());
	public static final RegistryObject<CreativeModeTab> KSN_FOOD = REGISTRY.register("ksn_food",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.kaisen.ksn_food")).icon(() -> new ItemStack(KaisenModItems.PAYO.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KaisenModItems.MOONDER_MEAT.get());
				tabData.accept(KaisenModItems.COOKED_MOONDER_MEAT.get());
			}).withTabsBefore(KSN_BLOCKS.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(KaisenModBlocks.ENDER_ANVIL.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(KaisenModItems.ENDERIUM_SWORD.get());
			tabData.accept(KaisenModItems.KILL.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(KaisenModItems.MOONDER_SPAWN_EGG.get());
		}
	}
}