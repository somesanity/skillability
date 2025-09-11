package net.somesanity.skillability.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.somesanity.skillability.ModCapabilities.ModCapabilities;

import java.util.function.Supplier;

public class SyncEvasionS2CPacket {
    private final int evasion;

    public SyncEvasionS2CPacket(int evasion) {
        this.evasion = evasion;
    }

    public SyncEvasionS2CPacket(FriendlyByteBuf buf) {
        this.evasion = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(evasion);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Мы уже на клиенте, обновляем Capability
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.getCapability(ModCapabilities.EVASION).ifPresent(evasionCap -> {
                    evasionCap.setEvasion(evasion);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
