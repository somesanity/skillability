package net.somesanity.skillability.packets;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.somesanity.skillability.ModSounds.ModSounds;
import net.somesanity.skillability.item.Moditems;

import java.util.function.Supplier;

public class UseSphereC2SPacket {

    public UseSphereC2SPacket() {
    }

    public UseSphereC2SPacket(FriendlyByteBuf buf) {
        // Нет данных — пусто
    }

    public void toBytes(FriendlyByteBuf buf) {
        // Нет данных — пусто
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                if (player.getMainHandItem().getItem() == Moditems.RedSphere.get()) {
                    player.getMainHandItem().shrink(1);
                    player.displayClientMessage(Component.literal("Сфера использована!"), true);

                    player.level().playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            ModSounds.USE_SPHERE.get(),
                            player.getSoundSource(),
                            1.0F,
                            1.0F
                            );
                }

                if (player.level() instanceof ServerLevel level) {
                    // звук
                    level.playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            ModSounds.USE_SPHERE.get(),
                            player.getSoundSource(),
                            1.0F,
                            1.0F
                    );
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
