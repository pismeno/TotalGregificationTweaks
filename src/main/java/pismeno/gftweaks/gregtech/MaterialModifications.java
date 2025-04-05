package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import pismeno.gftweaks.GfTweaks;

import static gregtech.api.unification.material.Materials.*;
import static pismeno.gregstinkering.unification.GTCGregtechMaterials.*;

public class MaterialModifications {
    public static void init() {
        Ardite.setProperty(PropertyKey.BLAST, new BlastProperty(1780));
        Flint.setMaterialRGB(0x565656);

        GfTweaks.LOGGER.info("Material modifications initialized");
    }

    private MaterialModifications() {}
}
