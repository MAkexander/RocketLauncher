package com.makexander.tutorialmod.item.custom;

import com.makexander.tutorialmod.TutorialMod;
import com.makexander.tutorialmod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class RocketLauncher extends Item {

    public RocketLauncher(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        // optional debug message
        TutorialMod.LOGGER.info("Right clicked Rocket Launcher!");
        // users inventory
        Inventory userInventory = pPlayer.getInventory();
        // item to search for
        ItemStack ammunition = new ItemStack(ModItems.ROCKET_LAUNCHER_AMMUNITION.get());
        // possible index for ammunition items (else -1)
        int ammunition_index = userInventory.findSlotMatchingItem(ammunition);
        if (ammunition_index >= 0) {
            userInventory.removeItem(ammunition_index, 1);
            // ToDo RocketLauncher takes damage
            TutorialMod.LOGGER.info("-> Right click success!");
            // ToDo: implement a cooldown !!!
        } else {
            TutorialMod.LOGGER.info("-> Right click failed!");
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
