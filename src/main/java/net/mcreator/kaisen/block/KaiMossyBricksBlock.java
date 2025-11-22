package net.mcreator.kaisen.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.List;

public class KaiMossyBricksBlock extends Block {
	public KaiMossyBricksBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000).pushReaction(PushReaction.IGNORE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("block.kaisen.kai_mossy_bricks.description_0"));
		list.add(Component.translatable("block.kaisen.kai_mossy_bricks.description_1"));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}