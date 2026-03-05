package com.makexander.tutorialmod.block;

import com.makexander.tutorialmod.TutorialMod;
import com.makexander.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Custom class to define all new blocks added by the mod.
 * Needs to register the block (placable object) as well
 * as the block item.
 * Needs to have a model in block, items and a texture as
 * well as a loottable to drop items.
 */
public class ModBlocks {
    // create a new register for the custom blocks of the mod
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    // Alexandrite Block
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    // Raw Alexandrite Block
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));

    // Alexandrite Ore
    public static final RegistryObject<Block> ALEXANDRITE_ORE= registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4) , BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    // Alexandrite Deepslate Ore
    public static final RegistryObject<Block> ALEXANDRITE_DEEPSLATE_ORE = registerBlock("alexandrite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 5), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    // helper method to register the block and the block item for a custom block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, registeredBlock);
        return registeredBlock;
    }

    // helper methods to register the block item for a custom block
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
