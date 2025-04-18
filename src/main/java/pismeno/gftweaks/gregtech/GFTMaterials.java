package pismeno.gftweaks.gregtech;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.util.ResourceLocation;
import pismeno.gftweaks.Tags;

import java.util.*;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialIconSet.DIAMOND;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static pismeno.gftweaks.gregtech.GFTMaterialFlags.GENERATE_CHIPS;

public class GFTMaterials {

    public static Material EnhancedGlue;
    public static Material Wyrmwood;
    public static Material Enori;
    public static Material Diamatine;
    public static Material Emeradic;
    public static Material Palis;
    public static Material Restonia;
    public static Material Void;
    public static Material CornFlour;
    public static Material QuartzBlack;
    public static Material Inconel;

    public static final List<Material> AAMaterials = new ArrayList<>();

    private static final Map<Material, OrePrefix[]> ignoredItems = new HashMap<>();

    public static void init() {

        EnhancedGlue = new Material.Builder(32001, new ResourceLocation(Tags.MODID,"enhanced_glue"))
                .fluid()
                .color(0xFCBC65).flags(STICKY).build();

        Wyrmwood = new Material.Builder(32002, new ResourceLocation(Tags.MODID, "wyrmwood"))
                .dust(3)
                .color(0x82335e).iconSet(FINE)
                .flags(GENERATE_PLATE, GENERATE_ROD, NO_SMELTING, FLAMMABLE)
                .build();

        Enori = new Material.Builder(32003, new ResourceLocation(Tags.MODID, "enori"))
                .gem()
                .color(0xfefffa).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Diamatine = new Material.Builder(32004, new ResourceLocation(Tags.MODID, "diamatine"))
                .gem()
                .color(0x6861ed).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Emeradic = new Material.Builder(32005, new ResourceLocation(Tags.MODID, "emeradic"))
                .gem()
                .color(0x15bf20).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Palis = new Material.Builder(32006, new ResourceLocation(Tags.MODID, "palis"))
                .gem()
                .color(0x1911b8).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Restonia = new Material.Builder(32007, new ResourceLocation(Tags.MODID, "restonia"))
                .gem()
                .color(0xe60202).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Void = new Material.Builder(32008, new ResourceLocation(Tags.MODID, "void"))
                .gem()
                .color(0xe000000).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        CornFlour = new Material.Builder(32009, new ResourceLocation(Tags.MODID, "corn_flour"))
                .dust()
                .color(0xd6bf0d).iconSet(FINE)
                .build();

        QuartzBlack = new Material.Builder(32010, new ResourceLocation(Tags.MODID, "quartz_black"))
                .gem()
                .ore()
                .color(0x121212).iconSet(QUARTZ)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, NO_SMELTING)
                .build();

        Inconel = new Material.Builder(32011, new ResourceLocation(Tags.MODID, "inconel"))
                .ingot()
                .color(0xa0a6a8).iconSet(METALLIC)
                .flags(GENERATE_PLATE, EXCLUDE_PLATE_COMPRESSOR_RECIPE, NO_SMELTING, GENERATE_DOUBLE_PLATE)
                //.blast(2849)
                .components(Materials.Nickel, 6, Materials.Chrome, 2, Materials.Cobalt, 1, Materials.Molybdenum, 1)
                .build();

        AAMaterials.addAll(Arrays.asList(Restonia, Palis, Diamatine, Void, Emeradic, Enori));

        ignoredItems.put(Enori, new OrePrefix[]{gem, block});
        ignoredItems.put(Diamatine, new OrePrefix[]{gem, block});
        ignoredItems.put(Emeradic, new OrePrefix[]{gem, block});
        ignoredItems.put(Palis, new OrePrefix[]{gem, block});
        ignoredItems.put(Restonia, new OrePrefix[]{gem, block});
        ignoredItems.put(Void, new OrePrefix[]{gem, block});

        for (Map.Entry<Material, OrePrefix[]> entry : ignoredItems.entrySet()) {
            Material material = entry.getKey();
            OrePrefix[] prefixes = entry.getValue();

            for (OrePrefix prefix : prefixes) {
                prefix.setIgnored(material);
            }
        }
    }
}
