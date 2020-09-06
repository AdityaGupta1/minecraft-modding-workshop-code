package org.aditya.epicmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.aditya.epicmod.item.ModItemGroups;
import org.aditya.epicmod.item.gear.*;
import org.aditya.epicmod.world.biome.BiomeInit;

import java.util.ArrayList;
import java.util.Arrays;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetupEventSubscriber {
    private static final ArrayList<Block> allBlocks = new ArrayList<>();

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.registerAll(
                setup(new Item(getModItemProperties()), "epic_ingot"),

                setup(new ModSwordItem(ModToolMaterial.EPIC, getModItemProperties()), "epic_sword"),
                setup(new ModAxeItem(ModToolMaterial.EPIC, getModItemProperties()), "epic_axe"),
                setup(new ModPickaxeItem(ModToolMaterial.EPIC, getModItemProperties()), "epic_pickaxe"),
                setup(new ModShovelItem(ModToolMaterial.EPIC, getModItemProperties()), "epic_shovel"),
                setup(new ModHoeItem(ModToolMaterial.EPIC, getModItemProperties()), "epic_hoe"),

                setup(new ModArmorItem(ModArmorMaterial.EPIC, EquipmentSlotType.HEAD, getModItemProperties()), "epic_helmet"),
                setup(new ModArmorItem(ModArmorMaterial.EPIC, EquipmentSlotType.CHEST, getModItemProperties()), "epic_chestplate"),
                setup(new ModArmorItem(ModArmorMaterial.EPIC, EquipmentSlotType.LEGS, getModItemProperties()), "epic_leggings"),
                setup(new ModArmorItem(ModArmorMaterial.EPIC, EquipmentSlotType.FEET, getModItemProperties()), "epic_boots")
        );

        for (Block block : allBlocks) {
            BlockItem blockItem = new BlockItem(block, getModItemProperties());
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        }
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        allBlocks.addAll(Arrays.asList(
               setup(new Block(Block.Properties.create(Material.ROCK)
                       .hardnessAndResistance(5.0F, 5.0F)
                       .harvestLevel(3)), "epic_ore")
        ));

        allBlocks.forEach(registry::register);
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(Main.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

    public static Item.Properties getModItemProperties() {
        return new Item.Properties().group(ModItemGroups.EPIC_ITEM_GROUP);
    }

    @SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
        BiomeInit.registerBiomes();
    }
}
