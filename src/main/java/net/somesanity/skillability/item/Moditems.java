package net.somesanity.skillability.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.somesanity.skillability.skillability;

public class Moditems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, skillability.MOD_ID);

    public  static final RegistryObject<Item> RedSphere = ITEMS.register("redsphere",
            () -> new Item(new Item.Properties()));

    public  static final RegistryObject<Item> GreenSphere = ITEMS.register("greensphere",
            () -> new Item(new Item.Properties()));

    public  static final RegistryObject<Item> BlueSphere = ITEMS.register("bluesphere",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}