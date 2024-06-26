package net.gigabit101.shrink.network.packets;

import dev.architectury.networking.NetworkManager;
import dev.architectury.networking.simple.BaseC2SMessage;
import dev.architectury.networking.simple.MessageType;
import net.gigabit101.shrink.items.ItemShrinkDevice;
import net.gigabit101.shrink.network.PacketHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class PacketShrinkDevice extends BaseC2SMessage
{
    InteractionHand hand;
    double scale;

    public PacketShrinkDevice(InteractionHand hand, double scale)
    {
        this.hand = hand;
        this.scale = scale;
    }

    public PacketShrinkDevice(FriendlyByteBuf friendlyByteBuf)
    {
        hand = friendlyByteBuf.readInt() == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        scale = friendlyByteBuf.readDouble();
    }

    @Override
    public MessageType getType()
    {
        return PacketHandler.SHRINK_DEVICE;
    }

    @Override
    public void write(RegistryFriendlyByteBuf buf)
    {
        buf.writeInt(hand == InteractionHand.MAIN_HAND ? 0 : 1);
        buf.writeDouble(scale);
    }

    @Override
    public void handle(NetworkManager.PacketContext context)
    {
        context.queue(() ->
        {
            Player player = context.getPlayer();
            if(player == null) return;
            ItemStack stack = player.getItemInHand(hand);
            if(!stack.isEmpty() && stack.getItem() instanceof ItemShrinkDevice itemShrinkDevice)
            {
                itemShrinkDevice.writeScale(stack, scale);
            }
        });
    }
}
