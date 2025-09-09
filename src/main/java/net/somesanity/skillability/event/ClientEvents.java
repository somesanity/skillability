package net.somesanity.skillability.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.somesanity.skillability.packets.ModMessages;
import net.somesanity.skillability.packets.UseSphereC2SPacket;
import net.somesanity.skillability.skillability;
import net.somesanity.skillability.util.keyBinding;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = skillability.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(keyBinding.USESPELL_KEY);
        }
    }

    @Mod.EventBusSubscriber(modid = skillability.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (keyBinding.USESPELL_KEY.consumeClick()) {
                ModMessages.sendToServer(new UseSphereC2SPacket());
                }
            }
        }
    }
