package org.aditya.epicmod.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.aditya.epicmod.Main;

public class BiomeInit {
    public static final DeferredRegister<Biome> MOD_BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Main.MODID);

    public static final RegistryObject<Biome> EPIC_BIOME = MOD_BIOMES.register("epic_biome", EpicBiome::new);

    private static void registerBiome(Biome biome, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, 100)); // only if you want your biome to spawn in the overworld
    }

    public static void registerBiomes() {
        registerBiome(EPIC_BIOME.get(), BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY);
    }
}
