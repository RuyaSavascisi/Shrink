package net.gigabit101.shrink.network;


import dev.architectury.networking.simple.MessageType;
import dev.architectury.networking.simple.SimpleNetworkManager;
import net.gigabit101.shrink.Shrink;
import net.gigabit101.shrink.network.packets.PacketShrinkDevice;

public class PacketHandler
{
    public static SimpleNetworkManager NET = SimpleNetworkManager.create(Shrink.MOD_ID);

    public static MessageType SHRINK_DEVICE = NET.registerC2S("shrink_device", PacketShrinkDevice::new);

    public static void init() {}
}
