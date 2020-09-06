package org.aditya.epicmod.item.gear;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ModArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }
}
