package com.makexander.tutorialmod.item;

import com.makexander.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Custom class to define all items added by the mod.
 */
public class ModItems {
    // "List" to gather the items for registration
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // Create the item alexandrite
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite", () -> new Item(new Item.Properties()));

    // Create raw alexandrite
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite", () -> new Item(new Item.Properties()));

    // Create rocket launcher ammunition
    public static final RegistryObject<Item> ROCKET_LAUNCHER_AMMUNITION = ITEMS.register("rocket_launcher_ammunition", () -> new Item(new Item.Properties()));

    // Create rocket launcher
    public static final RegistryObject<Item> ROCKET_LAUNCHER = ITEMS.register("rocket_launcher", () -> new Item(new Item.Properties()));

    // Smth ... idk (Register the items on the event bus?)
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
