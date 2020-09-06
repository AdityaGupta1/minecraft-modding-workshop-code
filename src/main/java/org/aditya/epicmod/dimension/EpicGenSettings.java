package org.aditya.epicmod.dimension;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class EpicGenSettings extends GenerationSettings {
    public EpicGenSettings() {
        this.setDefaultBlock(Blocks.PACKED_ICE.getDefaultState());
        this.setDefaultFluid(Blocks.ICE.getDefaultState());
    }
}
