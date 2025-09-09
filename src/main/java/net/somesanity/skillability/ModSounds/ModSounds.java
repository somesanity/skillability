package net.somesanity.skillability.ModSounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.somesanity.skillability.skillability;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, skillability.MOD_ID);

    public static final RegistryObject<SoundEvent> USE_SPHERE =
            SOUND_EVENTS.register("use_sphere",
                    () -> SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath(skillability.MOD_ID, "use_sphere")));
}

