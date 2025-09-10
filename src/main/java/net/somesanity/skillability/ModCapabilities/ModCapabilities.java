package net.somesanity.skillability.ModCapabilities;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.somesanity.skillability.Attributes.Evasion.IEvasion;

public class ModCapabilities {
    public static final Capability<IEvasion> EVASION = CapabilityManager.get(new CapabilityToken<>() {});
}
