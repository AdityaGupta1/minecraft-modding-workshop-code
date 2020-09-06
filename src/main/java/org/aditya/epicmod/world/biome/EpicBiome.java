package org.aditya.epicmod.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureRadiusConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import static net.minecraft.world.biome.DefaultBiomeFeatures.*;

public class EpicBiome extends Biome {
    protected EpicBiome() {
        super(new Biome.Builder().precipitation(RainType.SNOW)
                .temperature(-1.0F)
                .waterColor(0x949EFF)
                .waterFogColor(0xC4D8FF)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(Blocks.SNOW_BLOCK.getDefaultState(),
                                Blocks.ICE.getDefaultState(),
                                Blocks.IRON_BLOCK.getDefaultState()))
                .category(Category.ICY)
                .downfall(0.5F)
                .depth(0.125F)
                .scale(0.45000002F)
                .parent(null));

        addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ILLUSIONER, 100, 1, 2));
        addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.VEX, 100, 10, 20));
        addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SNOW_GOLEM, 200, 3, 5));

        addCarvers(this);
        addOres(this);
        addIcebergs(this);
        addBlueIce(this);
        addFreezeTopLayer(this);

        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.ICE_SPIKE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(3))));
        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.ICE_PATCH.withConfiguration(new FeatureRadiusConfig(2)).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(2))));
    }
}
