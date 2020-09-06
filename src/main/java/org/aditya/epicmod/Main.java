package org.aditya.epicmod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.aditya.epicmod.dimension.DimensionInit;
import org.aditya.epicmod.world.biome.BiomeInit;
import org.aditya.epicmod.world.gen.feature.ModOreGen;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "epicmod";

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        DimensionInit.MOD_DIMENSIONS.register(modEventBus);
        BiomeInit.MOD_BIOMES.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ModOreGen.generate();
    }
}
