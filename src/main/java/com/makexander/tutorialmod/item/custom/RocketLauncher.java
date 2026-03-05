package com.makexander.tutorialmod.item.custom;

import com.makexander.tutorialmod.TutorialMod;
import com.makexander.tutorialmod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class RocketLauncher extends ProjectileWeaponItem {

    private boolean isLoaded = false;

    public RocketLauncher(Properties pProperties) {
        super(pProperties);
    }

    /**
     * Returns the correct use animation, here hopefully always none
     * @param pStack Item for the Animation
     * @return UseAnim.None to disable animation
     */
    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        // ToDo: make custom when using custom animation with gecko lib and block bench
        return UseAnim.NONE;
    }

    /**
     * ? No Explanation available? for Bow its 15
     * @return defaultProjectileRange (unit/...?)
     */
    @Override
    public int getDefaultProjectileRange() {
        return 9999;
    }

    /**
     * Returns a function that can determine which classes objects can be used as ammunition
     * @return Predicate of ItemStack that checks if itemStack is Rocket Launcher Ammunition
     */
    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return (itemStack) -> itemStack.is(ModItems.ROCKET_LAUNCHER_AMMUNITION.get());
    }



    @Override
    protected void shootProjectile(@NotNull LivingEntity pShooter, @NotNull Projectile pProjectile, int pIndex, float pVelocity, float pInaccuracy, float pAngle, @Nullable LivingEntity pTarget) {
        // I don't know what's supposed to happen here look at BowItem
        this.isLoaded = false;
        TutorialMod.LOGGER.info("--- Rocket Launcher fired! ---");
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        //
        return true;  // cancel damage
    }

    /**
     * Loads the Rocket Launcher with a Rocket Launcher Ammunition.
     * @param pLevel level
     * @param pPlayer player
     * @param pUsedHand usedHand
     * @return super.use()
     */
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if (!this.isLoaded) {
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
                this.isLoaded = true;
                TutorialMod.LOGGER.info("-> Right click success!");
            } else {
                TutorialMod.LOGGER.info("-> Right click failed!");
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
