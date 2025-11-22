package net.mcreator.kaisen.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.kaisen.procedures.EnderWorkbenchCraftProcedure;
import net.mcreator.kaisen.KaisenMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record EnderWorkbenchGUISlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
	public EnderWorkbenchGUISlotMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void buffer(EnderWorkbenchGUISlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(EnderWorkbenchGUISlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> handleSlotAction(context.getSender(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z));
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 12 && changeType == 1) {
			int amount = meta;

			EnderWorkbenchCraftProcedure.execute(entity);
		}
		if (slot == 12 && changeType == 2) {
			int amount = meta;

			EnderWorkbenchCraftProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		KaisenMod.addNetworkMessage(EnderWorkbenchGUISlotMessage.class, EnderWorkbenchGUISlotMessage::buffer, EnderWorkbenchGUISlotMessage::new, EnderWorkbenchGUISlotMessage::handler);
	}
}