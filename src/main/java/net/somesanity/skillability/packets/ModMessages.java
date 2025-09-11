package net.somesanity.skillability.packets;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.somesanity.skillability.skillability;

public class ModMessages {

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(ResourceLocation.fromNamespaceAndPath(skillability.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(UseSphereC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UseSphereC2SPacket::new)
                .encoder(UseSphereC2SPacket::toBytes)
                .consumerMainThread(UseSphereC2SPacket::handle)
                .add();

        net.messageBuilder(SyncEvasionS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SyncEvasionS2CPacket::new)
                .encoder(SyncEvasionS2CPacket::toBytes)
                .consumerMainThread(SyncEvasionS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
