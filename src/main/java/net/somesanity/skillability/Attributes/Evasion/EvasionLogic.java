package net.somesanity.skillability.Attributes.Evasion;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.somesanity.skillability.ModCapabilities.ModCapabilities;
import net.somesanity.skillability.skillability;

@Mod.EventBusSubscriber(modid = skillability.MOD_ID)
public class EvasionLogic {



    @SubscribeEvent
    public static void onAttack(LivingAttackEvent event) {

        if(event.getEntity() instanceof ServerPlayer player) {
            double evasionValue = player.getCapability(ModCapabilities.EVASION)
                    .map(evasion -> evasion.getEvasion())
                    .orElse(0.0);

            if (player.getRandom().nextDouble() < evasionValue) {
                event.setCanceled(true);

                player.level().playSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENDERMAN_TELEPORT,
                        player.getSoundSource(),
                        1.0F, 1.0F
                );

                ((ServerLevel) player.level()).sendParticles(
                        ParticleTypes.SMOKE,
                        player.getX(), player.getY() + 1.0, player.getZ(),
                        20, 0.5, 0.5, 0.5, 0.01
                );
                player.displayClientMessage(Component.literal("Уклонение!"), true);
            }
        }}}