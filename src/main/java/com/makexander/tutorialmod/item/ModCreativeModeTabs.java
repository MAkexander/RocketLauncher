package com.makexander.tutorialmod.item;

import com.makexander.tutorialmod.TutorialMod;
import com.makexander.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


/**
 * Custom Creative Mode Tabs added by the mod.
 * Control over the order of the tabs use:
 * withTabsBefore() method
 */
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_items_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.alexandrite_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ALEXANDRITE.get());
                        pOutput.accept(ModItems.RAW_ALEXANDRITE.get());
                        pOutput.accept(ModItems.CHISEL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_blocks_tab", () -> CreativeModeTab.builder()
                    .withTabsBefore(ALEXANDRITE_ITEMS_TAB.getId())  // to ensure the correct order of the tabs
                    .icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.tutorialmod.alexandrite_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        pOutput.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> AMMUNITION_TAB =
            CREATIVE_MODE_TABS.register("ammunition_tab", () -> CreativeModeTab.builder()
                    .withTabsBefore(ALEXANDRITE_BLOCKS_TAB.getId())  // to ensure the correct order of the tabs
                    // ToDo: maybe change to rifle, hand gun ammunition later?
                    .icon(() -> new ItemStack(ModItems.ROCKET_LAUNCHER_AMMUNITION.get()))
                    .title(Component.translatable("creativetab.tutorialmod.ammunition"))
                    // ToDo: Can be replaced with expression lambda?
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ROCKET_LAUNCHER_AMMUNITION.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> WEAPONS_TAB =
            CREATIVE_MODE_TABS.register("weapons_tab", () -> CreativeModeTab.builder()
                    .withTabsBefore(AMMUNITION_TAB.getId())  // to ensure the correct order of the tabs
                    .icon(() -> new ItemStack(ModItems.ROCKET_LAUNCHER.get()))
                    .title(Component.translatable("creativetab.tutorialmod.weapons"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ROCKET_LAUNCHER.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
