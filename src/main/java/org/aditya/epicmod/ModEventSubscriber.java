package org.aditya.epicmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.aditya.epicmod.dimension.DimensionInit;

import java.util.Collection;

@Mod.EventBusSubscriber
public class ModEventSubscriber {
    // @SubscribeEvent
    // public static void onEntityDeath(LivingDeathEvent event) {
    //     Entity entity = event.getEntity();
    //     World world = entity.getEntityWorld();
    //     world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), 10, Explosion.Mode.DESTROY);
    // }
    //
    // @SubscribeEvent
    // public static void onItemDrop(LivingDropsEvent event) {
    //     Collection<ItemEntity> itemDropList = event.getDrops();
    //     for (ItemEntity item : itemDropList) {
    //         ItemStack stack = item.getItem();
    //         stack.setCount(stack.getCount() * 4);
    //         item.setItem(stack);
    //     }
    // }
    //
    // @SubscribeEvent
    // public static void turnItemsToDiamonds(LivingDropsEvent event) {
    //     Collection<ItemEntity> itemDropList = event.getDrops();
    //     for (ItemEntity item : itemDropList) {
    //         ItemStack stack = item.getItem();
    //         ItemStack newStack = new ItemStack(Items.DIAMOND, stack.getCount());
    //         item.setItem(newStack);
    //     }
    // }

    @SubscribeEvent
    public static void registerDimensions(RegisterDimensionsEvent event) {
        if (DimensionType.byName(DimensionInit.EPIC_DIMENSION_TYPE) == null) {
            DimensionManager.registerDimension(DimensionInit.EPIC_DIMENSION_TYPE, DimensionInit.EPIC_DIMENSION.get(), null, true);
        }
    }
}
