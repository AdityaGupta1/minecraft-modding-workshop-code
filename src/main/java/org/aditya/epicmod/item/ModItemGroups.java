package org.aditya.epicmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.aditya.epicmod.Main;

import java.util.function.Supplier;

public class ModItemGroups {
    public static final ItemGroup EPIC_ITEM_GROUP = new ModItemGroup(Main.MODID, () -> new ItemStack(ModItems.EPIC_INGOT));

    public static class ModItemGroup extends ItemGroup {
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(String name, Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }
    }
}