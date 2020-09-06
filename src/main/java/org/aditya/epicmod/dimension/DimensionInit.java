package org.aditya.epicmod.dimension;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.aditya.epicmod.Main;

public class DimensionInit {
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Main.MODID);

    public static final RegistryObject<ModDimension> EPIC_DIMENSION = MOD_DIMENSIONS.register("epic_dimension", () -> ModDimension.withFactory(EpicDimension::new));
    public static final ResourceLocation EPIC_DIMENSION_TYPE = new ResourceLocation(Main.MODID, "epic_dimension");
}
