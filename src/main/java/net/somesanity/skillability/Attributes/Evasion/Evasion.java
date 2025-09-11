package net.somesanity.skillability.Attributes.Evasion;

import net.minecraft.nbt.CompoundTag;

public class Evasion implements IEvasion {
    private int evasionChance;
    private final int MIN_EVASION = 0;
    private final int MAX_EVASION = 30;

    @Override
    public int getEvasion() {
        return this.evasionChance;
    }

    @Override
    public void setEvasion(int evasion) {
        this.evasionChance = evasion;
    }

    @Override
    public void addEvasion(int evasion) {
        this.evasionChance += evasion;
        this.evasionChance = Math.max(this.evasionChance, MIN_EVASION);
        this.evasionChance = Math.min(this.evasionChance, MAX_EVASION);
    }

    @Override
    public void removeEvasion(int evasion) {
        this.evasionChance -= evasion;
        this.evasionChance = Math.max(this.evasionChance, MIN_EVASION);
        this.evasionChance = Math.min(this.evasionChance, MAX_EVASION);
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("evasion", this.evasionChance);
        return tag;
    }

    public void deserializeNBT(CompoundTag nbt) {
        this.evasionChance = nbt.getInt("evasion");
    }
}
