package net.somesanity.skillability.Attributes.Evasion;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.somesanity.skillability.ModCapabilities.ModCapabilities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EvasionProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    private final Evasion evasion = new Evasion();
    private final LazyOptional<IEvasion> optional = LazyOptional.of(() -> evasion);

    @NotNull
    @Override

    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapabilities.EVASION) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return evasion.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        evasion.deserializeNBT(nbt);
    }
}
