package pismeno.gftweaks;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.api.unification.ore.StoneType;
import gregtech.common.items.MetaItems;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockBasicMoon;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockBasicMars;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pismeno.gftweaks.common.GFTBlocks;
import pismeno.gftweaks.common.GFTItems;
import pismeno.gftweaks.common.recipes.CraftingRecipes;
import pismeno.gftweaks.common.recipes.MetaItemHandler;
import pismeno.gftweaks.common.recipes.MachineRecipes;
import pismeno.gftweaks.galacticraft.TradeListEditor;
import pismeno.gftweaks.general.OreDict;
import pismeno.gftweaks.gregtech.GFTMaterials;
import pismeno.gftweaks.gregtech.GFTOrePrefix;
import pismeno.gftweaks.gregtech.GFTStoneTypes;
import pismeno.gftweaks.gregtech.MaterialModifications;
import pismeno.gftweaks.gregtech.metatileentities.MetaTileEntities;
import pismeno.gftweaks.tconstruct.TcMaterials;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        TcMaterials.preInit();
        GFTBlocks.init();
        GFTItems.init();
        TradeListEditor.init();
    }

    public void init(FMLInitializationEvent event) {
        OreDict.init();
        TcMaterials.init();
        MetaTileEntities.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        MachineRecipes.postInit();
    }

    @SubscribeEvent
    public static void onItemRegistration(RegistryEvent.Register<Item> event) {
        GFTBlocks.registerItems(event);
        GFTItems.registerItems(event);
    }

    @SubscribeEvent
    public static void onBlockRegistration(RegistryEvent.Register<Block> event) {
        GFTBlocks.registerBlocks(event);
    }

    @SubscribeEvent
    public static void onRecipeRegistration(RegistryEvent.Register<IRecipe> event) {
        MetaItemHandler.init();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onRecipeRegistrationLate(RegistryEvent.Register<IRecipe> event) {
        CraftingRecipes.init();
        MachineRecipes.init();
    }

    @SubscribeEvent
    public static void onMaterialRegistration(MaterialEvent event) {
        GFTMaterials.init();
        MaterialModifications.init();
    }

    @SubscribeEvent
    public static void onPostMaterialRegistration(PostMaterialEvent event) {
        GFTOrePrefix.PREFIXES.forEach(MetaItems::addOrePrefix);
        GFTStoneTypes.init();
    }
}