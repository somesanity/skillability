package net.somesanity.skillability.Attributes.Evasion;

import net.minecraft.nbt.CompoundTag;

public class Evasion implements IEvasion {
    private double evasionChance;
    private final double MIN_EVASION = 0;
    private final double MAX_EVASION = 0.3;

    @Override
    public double getEvasion() {
        return this.evasionChance;
    }

    @Override
    public void setEvasion(double evasion) {
        this.evasionChance = evasion;
    }

    @Override
    public void addEvasion(double evasion) {
        this.evasionChance += evasion;
        this.evasionChance = Math.max(this.evasionChance, MIN_EVASION);
        this.evasionChance = Math.min(this.evasionChance, MAX_EVASION);
    }

    @Override
    public void removeEvasion(double evasion) {
        this.evasionChance -= evasion;
        this.evasionChance = Math.max(this.evasionChance, MIN_EVASION);
        this.evasionChance = Math.min(this.evasionChance, MAX_EVASION);
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("evasion", this.evasionChance);
        return tag;
    }

    public void deserializeNBT(CompoundTag nbt) {
        this.evasionChance = nbt.getDouble("evasion");
    }
}
