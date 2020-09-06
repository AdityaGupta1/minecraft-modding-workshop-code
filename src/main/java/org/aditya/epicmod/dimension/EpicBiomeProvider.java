package org.aditya.epicmod.dimension;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import org.aditya.epicmod.world.biome.BiomeInit;

import java.util.Set;

public class EpicBiomeProvider extends BiomeProvider {
    private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.EPIC_BIOME.get());

    protected EpicBiomeProvider() {
        super(biomeList);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return BiomeInit.EPIC_BIOME.get();
    }
}
