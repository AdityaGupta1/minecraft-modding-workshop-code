package org.aditya.epicmod.world.gen.feature;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import org.aditya.epicmod.block.ModBlocks;

import java.util.ArrayList;

public class ModOreGen {
    private static final ArrayList<ModOreGenerator> generators = new ArrayList<>();

    private static class ModOreGenerator {
        private final GenerationStage.Decoration stage;
        private final ConfiguredFeature<?, ?> feature;

        private ModOreGenerator(GenerationStage.Decoration stage, ConfiguredFeature<?, ?> feature) {
            this.stage = stage;
            this.feature = feature;
            generators.add(this);
        }
    }

    public static void generate() {
        new ModOreGenerator(GenerationStage.Decoration.UNDERGROUND_ORES, stoneConfig(ModBlocks.EPIC_ORE.getDefaultState(), 4, 2, 0, 0, 24));

        for (ModOreGenerator generator : generators) {
            ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(generator.stage, generator.feature));
        }
    }

    private static ConfiguredFeature<?, ?> stoneConfig(BlockState oreBlockState, int size, int countPerChunk, int bottomOffset, int topOffset, int maxHeight) {
        return nonStoneConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, oreBlockState, size, countPerChunk, bottomOffset, topOffset, maxHeight);
    }

    private static ConfiguredFeature<?, ?> nonStoneConfig(OreFeatureConfig.FillerBlockType replaceBlock, BlockState oreBlockState, int size, int countPerChunk, int bottomOffset, int topOffset, int maxHeight) {
        return Feature.ORE.withConfiguration(new OreFeatureConfig(replaceBlock, oreBlockState, size))
                .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(countPerChunk, bottomOffset, topOffset, maxHeight)));
    }
}