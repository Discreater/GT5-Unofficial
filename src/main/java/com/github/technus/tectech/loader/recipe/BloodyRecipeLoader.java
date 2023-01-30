package com.github.technus.tectech.loader.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.github.technus.tectech.mechanics.elementalMatter.core.transformations.EMTransformationRegistry;
import com.github.technus.tectech.recipe.TT_recipeAdder;
import com.github.technus.tectech.thing.CustomItemList;
import com.github.technus.tectech.thing.block.QuantumGlassBlock;
import com.github.technus.tectech.thing.metaTileEntity.multi.em_machine.Behaviour_Centrifuge;
import com.github.technus.tectech.thing.metaTileEntity.multi.em_machine.Behaviour_ElectromagneticSeparator;
import com.github.technus.tectech.thing.metaTileEntity.multi.em_machine.Behaviour_Recycler;
import com.github.technus.tectech.thing.metaTileEntity.multi.em_machine.GT_MetaTileEntity_EM_machine;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

/**
 * Created by Tec on 06.08.2017.
 */
public class BloodyRecipeLoader {

    public void run(EMTransformationRegistry transformationInfo) {
        // Quantum Glass
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Containment.get(1),
                        GT_ModHandler.getIC2Item("reinforcedGlass", 1L) },
                Materials.Osmium.getMolten(576),
                new ItemStack(QuantumGlassBlock.INSTANCE, 1),
                200,
                500000);

        // region pipes

        // Data
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Parts_GlassFiber.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 6) },
                Materials.Polytetrafluoroethylene.getMolten(144),
                CustomItemList.DATApipe.get(1),
                200,
                30720);

        // Tunnel
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.DATApipe.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Osmiridium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Osmium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 2),
                        ItemList.Field_Generator_MV.get(1), ItemList.Circuit_Quantummainframe.get(1) },
                Materials.Osmium.getMolten(288),
                CustomItemList.EMpipe.get(1),
                400,
                491520);

        // Laser
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.DATApipe.get(1), GT_ModHandler.getIC2Item("reinforcedGlass", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Osmium, 2) },
                null,
                CustomItemList.LASERpipe.get(1),
                100,
                500000);

        // endregion

        // region casing

        // High Power Casing
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iridium, 6),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Cobalt, 16),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NiobiumTitanium, 2) },
                Materials.TungstenSteel.getMolten(576),
                CustomItemList.eM_Power.get(1),
                100,
                30720);

        // Computer Casing
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Power.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NiobiumTitanium, 2) },
                Materials.Aluminium.getMolten(1296),
                CustomItemList.eM_Computer_Casing.get(1),
                200,
                122880);
        // Computer Vent Casing
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
                        ItemList.Electric_Motor_IV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.StainlessSteel, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 1) },
                Materials.SolderingAlloy.getMolten(1296),
                CustomItemList.eM_Computer_Vent.get(1),
                100,
                1920);
        // Advanced Computer Casing
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Computer_Casing.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Cobalt, 32),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 4) },
                Materials.Iridium.getMolten(1296),
                CustomItemList.eM_Computer_Bus.get(1),
                200,
                122880);

        // Molecular Casing
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Power.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Osmiridium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Osmium, 12),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 24),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 24),
                        ItemList.Field_Generator_IV.get(1) },
                Materials.Osmium.getMolten(1296),
                CustomItemList.eM_Containment.get(1),
                800,
                500000);

        // Hollow Casing
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.eM_Containment.get(1),
                12000,
                32,
                500000,
                6,
                new ItemStack[] { CustomItemList.eM_Containment.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Plutonium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lead, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Americium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Neutronium, 16), },
                new FluidStack[] { Materials.Americium.getMolten(1296), Materials.Osmium.getMolten(1296),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.Argon.getGas(576), },
                CustomItemList.eM_Hollow.get(2),
                200,
                2000000);

        // EM Coil
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.eM_Hollow.get(1),
                48000,
                128,
                1000000,
                16,
                new ItemStack[] { CustomItemList.eM_Hollow.get(1), ItemList.Casing_Fusion_Coil.get(4),
                        ItemList.Casing_Coil_NaquadahAlloy.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Americium, 16), },
                new FluidStack[] { Materials.Glass.getMolten(2304), Materials.Silicone.getMolten(1872),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
                        Materials.Americium.getMolten(1296), },
                CustomItemList.eM_Coil.get(4),
                800,
                2000000);

        // Tesla Base
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 6),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.NickelZincFerrite, 1) },
                null,
                CustomItemList.tM_TeslaBase.get(1),
                50,
                16);
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaBase.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "PhP", "PFP", "PwP", 'P', OrePrefixes.plate.get(Materials.NickelZincFerrite), 'F',
                        OrePrefixes.frameGt.get(Materials.NickelZincFerrite) });
        // Tesla Toroid
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 6),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1) },
                null,
                CustomItemList.tM_TeslaToroid.get(1),
                50,
                16);
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaToroid.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "PhP", "PFP", "PwP", 'P', OrePrefixes.foil.get(Materials.Aluminium), 'F',
                        OrePrefixes.frameGt.get(Materials.Aluminium) });
        // Tesla Secondary Windings
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaSecondary.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', CustomItemList.teslaComponent.getWithDamage(1, 0) });
        // Tesla Primary Coils T0
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaPrimary_0.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', OrePrefixes.wireGt02.get(Materials.Tin) });
        // Tesla Primary Coils T1
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaPrimary_1.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', OrePrefixes.wireGt02.get(Materials.Copper) });
        // Tesla Primary Coils T2
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaPrimary_2.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', OrePrefixes.wireGt02.get(Materials.Silver) });
        // Tesla Primary Coils T3
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaPrimary_3.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', OrePrefixes.wireGt02.get(Materials.Aluminium) });
        // Tesla Primary Coils T4
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaPrimary_4.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', OrePrefixes.wireGt02.get(Materials.Platinum) });
        // Tesla Primary Coils T5
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.tM_TeslaPrimary_5.get(1),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "WWW", "WwW", "WWW", 'W', OrePrefixes.wireGt02.get(Materials.Superconductor) });
        // TODO Add Tesla Primary Coils T6

        // endregion

        // region hatches

        // Dynamo Hatches IV-UIV
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Dynamo_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2) },
                Materials.Silver.getMolten(144),
                CustomItemList.eM_dynamoMulti4_IV.get(1),
                100,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti4_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4) },
                Materials.Electrum.getMolten(144),
                CustomItemList.eM_dynamoMulti16_IV.get(1),
                200,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti16_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6) },
                Materials.Tungsten.getMolten(144),
                CustomItemList.eM_dynamoMulti64_IV.get(1),
                400,
                1920);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Dynamo_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2) },
                Materials.Silver.getMolten(288),
                CustomItemList.eM_dynamoMulti4_LuV.get(1),
                100,
                7860);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti4_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 4) },
                Materials.Electrum.getMolten(288),
                CustomItemList.eM_dynamoMulti16_LuV.get(1),
                200,
                7860);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti16_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 6) },
                Materials.Tungsten.getMolten(288),
                CustomItemList.eM_dynamoMulti64_LuV.get(1),
                400,
                7860);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Dynamo_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2) },
                Materials.Silver.getMolten(576),
                CustomItemList.eM_dynamoMulti4_ZPM.get(1),
                100,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti4_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 4) },
                Materials.Electrum.getMolten(576),
                CustomItemList.eM_dynamoMulti16_ZPM.get(1),
                200,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti16_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 6) },
                Materials.Tungsten.getMolten(576),
                CustomItemList.eM_dynamoMulti64_ZPM.get(1),
                400,
                30720);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Dynamo_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 2) },
                Materials.Silver.getMolten(1152),
                CustomItemList.eM_dynamoMulti4_UV.get(1),
                100,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti4_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 4) },
                Materials.Electrum.getMolten(1152),
                CustomItemList.eM_dynamoMulti16_UV.get(1),
                200,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti16_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.NaquadahAlloy, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 6) },
                Materials.Tungsten.getMolten(1152),
                CustomItemList.eM_dynamoMulti64_UV.get(1),
                400,
                122880);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Dynamo_MAX.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2) },
                Materials.Silver.getMolten(2304),
                CustomItemList.eM_dynamoMulti4_UHV.get(1),
                100,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti4_UHV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4) },
                Materials.Electrum.getMolten(2304),
                CustomItemList.eM_dynamoMulti16_UHV.get(1),
                200,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti16_UHV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Superconductor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6) },
                Materials.Tungsten.getMolten(2304),
                CustomItemList.eM_dynamoMulti64_UHV.get(1),
                400,
                500000);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Dynamo_MAX.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8) },
                Materials.Silver.getMolten(4608),
                CustomItemList.eM_dynamoMulti4_UEV.get(1),
                500,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti4_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 16) },
                Materials.Electrum.getMolten(4608),
                CustomItemList.eM_dynamoMulti16_UEV.get(1),
                1000,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_dynamoMulti16_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 24) },
                Materials.Tungsten.getMolten(4608),
                CustomItemList.eM_dynamoMulti64_UEV.get(1),
                2000,
                500000);

        // Energy Hatches 4A-64A IV-UIV
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Energy_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2) },
                Materials.Silver.getMolten(144),
                CustomItemList.eM_energyMulti4_IV.get(1),
                100,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti4_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4) },
                Materials.Electrum.getMolten(144),
                CustomItemList.eM_energyMulti16_IV.get(1),
                200,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti16_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6) },
                Materials.Tungsten.getMolten(144),
                CustomItemList.eM_energyMulti64_IV.get(1),
                400,
                7680);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Energy_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2) },
                Materials.Silver.getMolten(288),
                CustomItemList.eM_energyMulti4_LuV.get(1),
                100,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti4_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 4) },
                Materials.Electrum.getMolten(288),
                CustomItemList.eM_energyMulti16_LuV.get(1),
                200,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti16_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 6) },
                Materials.Tungsten.getMolten(288),
                CustomItemList.eM_energyMulti64_LuV.get(1),
                400,
                30720);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Energy_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2) },
                Materials.Silver.getMolten(576),
                CustomItemList.eM_energyMulti4_ZPM.get(1),
                100,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti4_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 4) },
                Materials.Electrum.getMolten(576),
                CustomItemList.eM_energyMulti16_ZPM.get(1),
                200,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti16_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 6) },
                Materials.Tungsten.getMolten(576),
                CustomItemList.eM_energyMulti64_ZPM.get(1),
                400,
                122880);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Energy_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 2) },
                Materials.Silver.getMolten(1152),
                CustomItemList.eM_energyMulti4_UV.get(1),
                100,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti4_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 4) },
                Materials.Electrum.getMolten(1152),
                CustomItemList.eM_energyMulti16_UV.get(1),
                200,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti16_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.NaquadahAlloy, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 6) },
                Materials.Tungsten.getMolten(1152),
                CustomItemList.eM_energyMulti64_UV.get(1),
                400,
                500000);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Energy_MAX.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2) },
                Materials.Silver.getMolten(2304),
                CustomItemList.eM_energyMulti4_UHV.get(1),
                100,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti4_UHV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4) },
                Materials.Electrum.getMolten(2304),
                CustomItemList.eM_energyMulti16_UHV.get(1),
                200,
                500000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti16_UHV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Superconductor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6) },
                Materials.Tungsten.getMolten(2304),
                CustomItemList.eM_energyMulti64_UHV.get(1),
                400,
                500000);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Energy_MAX.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8) },
                Materials.Silver.getMolten(4608),
                CustomItemList.eM_energyMulti4_UEV.get(1),
                100,
                2000000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti4_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 16) },
                Materials.Electrum.getMolten(4608),
                CustomItemList.eM_energyMulti16_UEV.get(1),
                200,
                2000000);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_energyMulti16_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 24) },
                Materials.Tungsten.getMolten(4608),
                CustomItemList.eM_energyMulti64_UEV.get(1),
                400,
                2000000);

        // Laser Dynamo IV-UV 256/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Emitter_IV.get(1),
                        ItemList.Electric_Pump_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_dynamoTunnel1_IV.get(1),
                1000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Emitter_LuV.get(1),
                        ItemList.Electric_Pump_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.VanadiumGallium, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_dynamoTunnel1_LuV.get(1),
                1000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Emitter_ZPM.get(1),
                        ItemList.Electric_Pump_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Naquadah, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_dynamoTunnel1_ZPM.get(1),
                1000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Emitter_UV.get(1),
                        ItemList.Electric_Pump_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NaquadahAlloy, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_dynamoTunnel1_UV.get(1),
                1000,
                500000);

        // Laser Dynamo IV-UV 1024/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Emitter_IV.get(2),
                        ItemList.Electric_Pump_IV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_dynamoTunnel2_IV.get(1),
                2000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Emitter_LuV.get(2),
                        ItemList.Electric_Pump_LuV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.VanadiumGallium, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_dynamoTunnel2_LuV.get(1),
                2000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Emitter_ZPM.get(2),
                        ItemList.Electric_Pump_ZPM.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_dynamoTunnel2_ZPM.get(1),
                2000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Emitter_UV.get(2),
                        ItemList.Electric_Pump_UV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_dynamoTunnel2_UV.get(1),
                2000,
                500000);

        // Laser Dynamo IV-UV 4096/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Emitter_IV.get(4),
                        ItemList.Electric_Pump_IV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_dynamoTunnel3_IV.get(1),
                4000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Emitter_LuV.get(4),
                        ItemList.Electric_Pump_LuV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_dynamoTunnel3_LuV.get(1),
                4000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Emitter_ZPM.get(4),
                        ItemList.Electric_Pump_ZPM.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_dynamoTunnel3_ZPM.get(1),
                4000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Emitter_UV.get(4),
                        ItemList.Electric_Pump_UV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_dynamoTunnel3_UV.get(1),
                4000,
                500000);

        // Laser Dynamo IV-UV 16384/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Emitter_IV.get(8),
                        ItemList.Electric_Pump_IV.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_dynamoTunnel4_IV.get(1),
                8000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Emitter_LuV.get(8),
                        ItemList.Electric_Pump_LuV.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_dynamoTunnel4_LuV.get(1),
                8000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Emitter_ZPM.get(8),
                        ItemList.Electric_Pump_ZPM.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_dynamoTunnel4_ZPM.get(1),
                8000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Emitter_UV.get(8),
                        ItemList.Electric_Pump_UV.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_dynamoTunnel4_UV.get(1),
                8000,
                500000);

        // Laser Dynamo IV-UV 65536/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Emitter_IV.get(16),
                        ItemList.Electric_Pump_IV.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_dynamoTunnel5_IV.get(1),
                16000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Emitter_LuV.get(16),
                        ItemList.Electric_Pump_LuV.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_dynamoTunnel5_LuV.get(1),
                16000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Emitter_ZPM.get(16),
                        ItemList.Electric_Pump_ZPM.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_dynamoTunnel5_ZPM.get(1),
                16000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Emitter_UV.get(16),
                        ItemList.Electric_Pump_UV.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_dynamoTunnel5_UV.get(1),
                16000,
                500000);

        // Laser Dynamo IV-UV 262144/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Emitter_IV.get(32),
                        ItemList.Electric_Pump_IV.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_dynamoTunnel6_IV.get(1),
                32000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Emitter_LuV.get(32),
                        ItemList.Electric_Pump_LuV.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_dynamoTunnel6_LuV.get(1),
                32000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Emitter_ZPM.get(32),
                        ItemList.Electric_Pump_ZPM.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_dynamoTunnel6_ZPM.get(1),
                32000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Emitter_UV.get(32),
                        ItemList.Electric_Pump_UV.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_dynamoTunnel6_UV.get(1),
                32000,
                500000);

        // Laser Dynamo IV-UV 1048576/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Emitter_IV.get(64),
                        ItemList.Electric_Pump_IV.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.TungstenSteel, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_dynamoTunnel7_IV.get(1),
                64000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Emitter_LuV.get(64),
                        ItemList.Electric_Pump_LuV.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.VanadiumGallium, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_dynamoTunnel7_LuV.get(1),
                64000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Emitter_ZPM.get(64),
                        ItemList.Electric_Pump_ZPM.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Naquadah, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_dynamoTunnel7_ZPM.get(1),
                64000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Emitter_UV.get(64),
                        ItemList.Electric_Pump_UV.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.NaquadahAlloy, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_dynamoTunnel7_UV.get(1),
                64000,
                500000);

        // Laser Target IV-UV 256/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Sensor_IV.get(1),
                        ItemList.Electric_Pump_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_energyTunnel1_IV.get(1),
                1000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Sensor_LuV.get(1),
                        ItemList.Electric_Pump_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.VanadiumGallium, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_energyTunnel1_LuV.get(1),
                1000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Sensor_ZPM.get(1),
                        ItemList.Electric_Pump_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Naquadah, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_energyTunnel1_ZPM.get(1),
                1000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Sensor_UV.get(1),
                        ItemList.Electric_Pump_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NaquadahAlloy, 2),
                        GT_Utility.getIntegratedCircuit(1) },
                null,
                CustomItemList.eM_energyTunnel1_UV.get(1),
                1000,
                500000);

        // Laser Target IV-UV 1024/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Sensor_IV.get(2),
                        ItemList.Electric_Pump_IV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_energyTunnel2_IV.get(1),
                2000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Sensor_LuV.get(2),
                        ItemList.Electric_Pump_LuV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.VanadiumGallium, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_energyTunnel2_LuV.get(1),
                2000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Sensor_ZPM.get(2),
                        ItemList.Electric_Pump_ZPM.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_energyTunnel2_ZPM.get(1),
                2000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Sensor_UV.get(2),
                        ItemList.Electric_Pump_UV.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 4),
                        GT_Utility.getIntegratedCircuit(2) },
                null,
                CustomItemList.eM_energyTunnel2_UV.get(1),
                2000,
                500000);

        // Laser Target IV-UV 4096/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Sensor_IV.get(4),
                        ItemList.Electric_Pump_IV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_energyTunnel3_IV.get(1),
                4000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Sensor_LuV.get(4),
                        ItemList.Electric_Pump_LuV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_energyTunnel3_LuV.get(1),
                4000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Sensor_ZPM.get(4),
                        ItemList.Electric_Pump_ZPM.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_energyTunnel3_ZPM.get(1),
                4000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Sensor_UV.get(4),
                        ItemList.Electric_Pump_UV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 4),
                        GT_Utility.getIntegratedCircuit(3) },
                null,
                CustomItemList.eM_energyTunnel3_UV.get(1),
                4000,
                500000);

        // Laser Target IV-UV 16384/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Sensor_IV.get(8),
                        ItemList.Electric_Pump_IV.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_energyTunnel4_IV.get(1),
                8000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Sensor_LuV.get(8),
                        ItemList.Electric_Pump_LuV.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_energyTunnel4_LuV.get(1),
                8000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Sensor_ZPM.get(8),
                        ItemList.Electric_Pump_ZPM.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_energyTunnel4_ZPM.get(1),
                8000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Sensor_UV.get(8),
                        ItemList.Electric_Pump_UV.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 8),
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                CustomItemList.eM_energyTunnel4_UV.get(1),
                8000,
                500000);

        // Laser Target IV-UV 65536/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Sensor_IV.get(16),
                        ItemList.Electric_Pump_IV.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_energyTunnel5_IV.get(1),
                16000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Sensor_LuV.get(16),
                        ItemList.Electric_Pump_LuV.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_energyTunnel5_LuV.get(1),
                16000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Sensor_ZPM.get(16),
                        ItemList.Electric_Pump_ZPM.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_energyTunnel5_ZPM.get(1),
                16000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Sensor_UV.get(16),
                        ItemList.Electric_Pump_UV.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 8),
                        GT_Utility.getIntegratedCircuit(5) },
                null,
                CustomItemList.eM_energyTunnel5_UV.get(1),
                16000,
                500000);

        // Laser Target IV-UV 262144/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Sensor_IV.get(32),
                        ItemList.Electric_Pump_IV.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_energyTunnel6_IV.get(1),
                32000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Sensor_LuV.get(32),
                        ItemList.Electric_Pump_LuV.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_energyTunnel6_LuV.get(1),
                32000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Sensor_ZPM.get(32),
                        ItemList.Electric_Pump_ZPM.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_energyTunnel6_ZPM.get(1),
                32000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Sensor_UV.get(32),
                        ItemList.Electric_Pump_UV.get(32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 16),
                        GT_Utility.getIntegratedCircuit(6) },
                null,
                CustomItemList.eM_energyTunnel6_UV.get(1),
                32000,
                500000);

        // Laser Target IV-UV 1048576/t
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Sensor_IV.get(64),
                        ItemList.Electric_Pump_IV.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.TungstenSteel, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_energyTunnel7_IV.get(1),
                64000,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Sensor_LuV.get(64),
                        ItemList.Electric_Pump_LuV.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.VanadiumGallium, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_energyTunnel7_LuV.get(1),
                64000,
                30720);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_ZPM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Sensor_ZPM.get(64),
                        ItemList.Electric_Pump_ZPM.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Naquadah, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_energyTunnel7_ZPM.get(1),
                64000,
                122880);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hull_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Sensor_UV.get(64),
                        ItemList.Electric_Pump_UV.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.NaquadahAlloy, 16),
                        GT_Utility.getIntegratedCircuit(7) },
                null,
                CustomItemList.eM_energyTunnel7_UV.get(1),
                64000,
                500000);

        // Data Input
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Computer_Casing.get(1), ItemList.Hatch_Input_Bus_LuV.get(1),
                        ItemList.Circuit_Crystalcomputer.get(1), CustomItemList.DATApipe.get(2) },
                Materials.Iridium.getMolten(1296),
                CustomItemList.dataIn_Hatch.get(1),
                200,
                122880);
        // Data Output
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Computer_Casing.get(1), ItemList.Hatch_Output_Bus_LuV.get(1),
                        ItemList.Circuit_Crystalcomputer.get(1), CustomItemList.DATApipe.get(2) },
                Materials.Iridium.getMolten(1296),
                CustomItemList.dataOut_Hatch.get(1),
                200,
                122880);

        // Rack
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Computer_Bus.get(1), ItemList.Hatch_Input_Bus_ZPM.get(1),
                        ItemList.Circuit_Crystalcomputer.get(2), CustomItemList.DATApipe.get(4) },
                Materials.Iridium.getMolten(1296),
                CustomItemList.rack_Hatch.get(1),
                800,
                122880);

        // Object Holder
        GT_Values.RA.addAssemblylineRecipe(
                ItemList.Hatch_Input_Bus_ZPM.get(1),
                10000,
                new ItemStack[] { ItemList.Hatch_Input_Bus_ZPM.get(1), CustomItemList.eM_Computer_Bus.get(1),
                        ItemList.Emitter_ZPM.get(8), ItemList.Robot_Arm_ZPM.get(1), ItemList.Electric_Motor_ZPM.get(2),
                        ItemList.Circuit_Crystalmainframe.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Naquadah, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Naquadah, 16),
                        CustomItemList.DATApipe.get(2), },
                new FluidStack[] { Materials.UUMatter.getFluid(500), Materials.Iridium.getMolten(1152),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000) },
                CustomItemList.holder_Hatch.get(1),
                1200,
                100000);

        // Parameterizer
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Computer_Casing.get(1),
                        ItemList.Circuit_Masterquantumcomputer.get(1), CustomItemList.DATApipe.get(4),
                        ItemList.Cover_Screen.get(1), new ItemStack(Blocks.stone_button, 16), },
                Materials.Iridium.getMolten(2592),
                CustomItemList.Parametrizer_Hatch.get(1),
                800,
                122880);
        // Uncertainty
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Computer_Casing.get(1),
                        ItemList.Circuit_Ultimatecrystalcomputer.get(1), CustomItemList.DATApipe.get(16),
                        ItemList.Cover_Screen.get(1), new ItemStack(Blocks.stone_button, 16), },
                Materials.Iridium.getMolten(2592),
                CustomItemList.Uncertainty_Hatch.get(1),
                1200,
                122880);

        // Elemental Input
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Containment.get(1), ItemList.Hatch_Input_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 8), ItemList.Sensor_UV.get(1) },
                Materials.Osmiridium.getMolten(1296),
                CustomItemList.eM_in_UV.get(1),
                800,
                500000);
        // Elemental Output
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Containment.get(1), ItemList.Hatch_Output_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 8),
                        ItemList.Emitter_UV.get(1) },
                Materials.Osmiridium.getMolten(1296),
                CustomItemList.eM_out_UV.get(1),
                800,
                500000);
        // Overflow
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.eM_Containment.get(1), ItemList.Hatch_Muffler_UV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 4),
                        ItemList.Field_Generator_UV.get(1) },
                Materials.Osmiridium.getMolten(1296),
                CustomItemList.eM_muffler_UV.get(1),
                800,
                500000);

        // Capacitor Hatch
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Input_Bus_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Gold, 4), },
                Materials.Silver.getMolten(576),
                CustomItemList.capacitor_Hatch.get(1),
                800,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Output_Bus_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Gold, 4), },
                Materials.Silver.getMolten(576),
                CustomItemList.capacitor_Hatch.get(1),
                800,
                480);

        // endregion

        // region multiblocks

        // Tesla Coil
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_ModHandler.getIC2Item("teslaCoil", 1), CustomItemList.tM_TeslaSecondary.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        ItemList.Upgrade_Overclocker.get(4), },
                Materials.Silver.getMolten(576),
                CustomItemList.Machine_Multi_TeslaCoil.get(1),
                800,
                480);

        // Microwave Grinder
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Machine_HV_Microwave.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 16),
                        ItemList.Upgrade_Overclocker.get(4), },
                Materials.Copper.getMolten(576),
                CustomItemList.Machine_Multi_Microwave.get(1),
                800,
                480);

        // Active Transformer
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Transformer_ZPM_LuV.get(16), ItemList.Circuit_Board_Elite.get(1), // ?
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 16),
                        ItemList.Circuit_Chip_HPIC.get(2), },
                Materials.TungstenSteel.getMolten(576),
                CustomItemList.Machine_Multi_Transformer.get(1),
                400,
                30720);

        // Network Switch
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.Machine_Multi_Transformer.get(1),
                        ItemList.Circuit_Ultimatecrystalcomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Cobalt, 32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 32),
                        CustomItemList.DATApipe.get(4), },
                Materials.Iridium.getMolten(1296),
                CustomItemList.Machine_Multi_Switch.get(1),
                800,
                122880);

        // Quantum Computer
        GT_Values.RA.addAssemblylineRecipe(
                ItemList.Tool_DataOrb.get(1),
                20000,
                new ItemStack[] { CustomItemList.Machine_Multi_Switch.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 2),
                        ItemList.Tool_DataOrb.get(1), ItemList.Cover_Screen.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 8),
                        CustomItemList.DATApipe.get(8), },
                new FluidStack[] { Materials.UUMatter.getFluid(1000), Materials.Iridium.getMolten(1296),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.Hydrogen.getGas(1000), },
                CustomItemList.Machine_Multi_Computer.get(1),
                12000,
                100000);

        // Research Station
        GT_Values.RA.addAssemblylineRecipe(
                ItemList.Tool_Scanner.get(1),
                80000,
                new ItemStack[] { CustomItemList.Machine_Multi_Switch.get(1), ItemList.Sensor_ZPM.get(8),
                        ItemList.Circuit_Crystalmainframe.get(4), ItemList.Field_Generator_ZPM.get(1),
                        ItemList.Electric_Motor_ZPM.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Naquadah, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Naquadah, 32),
                        CustomItemList.DATApipe.get(16), },
                new FluidStack[] { Materials.UUMatter.getFluid(1000), Materials.Iridium.getMolten(1296),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.Osmium.getMolten(1296), },
                CustomItemList.Machine_Multi_Research.get(1),
                12000,
                100000);

        // Matter Junction
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.Machine_Multi_Switch.get(1),
                8000,
                32,
                500000,
                4,
                new ItemStack[] { CustomItemList.Machine_Multi_Transformer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Naquadah, 16),
                        ItemList.Robot_Arm_LuV.get(2), ItemList.Electric_Piston_LuV.get(2),
                        ItemList.Circuit_Wetwaresupercomputer.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 4), },
                new FluidStack[] { Materials.UUMatter.getFluid(1000), Materials.Naquadah.getMolten(1296),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.Osmium.getMolten(1296), },
                CustomItemList.Machine_Multi_EMjunction.get(1),
                12000,
                100000);

        // Matter Quantizer
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Hatch_Input_UV.get(1),
                12000,
                32,
                500000,
                6,
                new ItemStack[] { CustomItemList.Machine_Multi_Transformer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 16), ItemList.Emitter_UV.get(2),
                        ItemList.Circuit_Wetwaresupercomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 2), },
                new FluidStack[] { Materials.UUMatter.getFluid(1000), Materials.Naquadah.getMolten(1296),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.Osmium.getMolten(1296), },
                CustomItemList.Machine_Multi_MatterToEM.get(1),
                12000,
                100000);

        // Matter DeQuantizer
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Hatch_Output_UV.get(1),
                12000,
                32,
                500000,
                6,
                new ItemStack[] { CustomItemList.Machine_Multi_Transformer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 16), ItemList.Sensor_UV.get(2),
                        ItemList.Circuit_Wetwaresupercomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 2), },
                new FluidStack[] { Materials.UUMatter.getFluid(1000), Materials.Naquadah.getMolten(1296),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.Osmium.getMolten(1296), },
                CustomItemList.Machine_Multi_EMToMatter.get(1),
                12000,
                100000);

        // Essentia Quantizer
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.Machine_Multi_MatterToEM.get(1),
                15000,
                32,
                500000,
                8,
                new ItemStack[] { CustomItemList.Machine_Multi_MatterToEM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 8),
                        ItemList.Emitter_UV.get(2), ItemList.Circuit_Wetwaresupercomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8), },
                new FluidStack[] { Materials.UUMatter.getFluid(2000), Materials.Void.getMolten(2592),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000), Materials.Osmium.getMolten(1296), },
                CustomItemList.Machine_Multi_EssentiaToEM.get(1),
                24000,
                500000);

        // Essentia DeQuantizer
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.Machine_Multi_EMToMatter.get(1),
                15000,
                32,
                500000,
                8,
                new ItemStack[] { CustomItemList.Machine_Multi_EMToMatter.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 8),
                        ItemList.Sensor_UV.get(2), ItemList.Circuit_Wetwaresupercomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8), },
                new FluidStack[] { Materials.UUMatter.getFluid(2000), Materials.Void.getMolten(2592),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000), Materials.Osmium.getMolten(1296), },
                CustomItemList.Machine_Multi_EMToEssentia.get(1),
                24000,
                500000);

        // EM Scanner
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.Machine_Multi_Research.get(1),
                150000,
                128,
                500000,
                16,
                new ItemStack[] { CustomItemList.Machine_Multi_EMjunction.get(1), CustomItemList.eM_Computer_Bus.get(4),
                        ItemList.Field_Generator_UV.get(4), ItemList.Sensor_UV.get(4),
                        ItemList.Circuit_Wetwaresupercomputer.get(4), // ?
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 16), },
                new FluidStack[] { Materials.UUMatter.getFluid(2000), Materials.Neutronium.getMolten(2592),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                        Materials.Osmiridium.getMolten(1296), },
                CustomItemList.Machine_Multi_Scanner.get(1),
                24000,
                500000);

        // Multi Infuser
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.Machine_Multi_Transformer.get(1),
                192000,
                512,
                2000000,
                32,
                new ItemStack[] { CustomItemList.Machine_Multi_Transformer.get(1), CustomItemList.eM_Coil.get(8),
                        CustomItemList.eM_Power.get(8),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.NeodymiumMagnetic, 16), },
                new FluidStack[] { Materials.Electrum.getMolten(2592), Materials.Neutronium.getMolten(1872),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), },
                CustomItemList.Machine_Multi_Infuser.get(1),
                8000,
                2000000);

        // endregion

        // region singleblocks

        // Tesla Transceiver LV 1A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_1by1_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_1by1_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_1by1_LV.get(1),
                400,
                30);
        // Tesla Transceiver MV 1A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_1by1_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_1by1_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_1by1_MV.get(1),
                400,
                120);
        // Tesla Transceiver HV 1A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_1by1_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_1by1_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_1by1_HV.get(1),
                400,
                480);
        // Tesla Transceiver EV 1A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_1by1_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_1by1_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_1by1_EV.get(1),
                400,
                1920);
        // Tesla Transceiver IV 1A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_1by1_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_1by1_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_1by1_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_1by1_IV.get(1),
                400,
                7680);
        // Tesla Transceiver LV 4A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_2by2_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_2by2_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_2by2_LV.get(1),
                400,
                30);
        // Tesla Transceiver MV 4A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_2by2_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_2by2_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_2by2_MV.get(1),
                400,
                120);
        // Tesla Transceiver HV 4A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_2by2_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_2by2_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_2by2_HV.get(1),
                400,
                480);
        // Tesla Transceiver EV 4A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_2by2_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_2by2_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_2by2_EV.get(1),
                400,
                1920);
        // Tesla Transceiver IV 4A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_2by2_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_2by2_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_2by2_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_2by2_IV.get(1),
                400,
                7680);
        // Tesla Transceiver LV 9A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_3by3_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_3by3_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_3by3_LV.get(1),
                400,
                30);
        // Tesla Transceiver MV 9A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_3by3_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_3by3_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_3by3_MV.get(1),
                400,
                120);
        // Tesla Transceiver HV 9A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_3by3_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_3by3_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_3by3_HV.get(1),
                400,
                480);
        // Tesla Transceiver EV 9A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_3by3_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_3by3_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_3by3_EV.get(1),
                400,
                1920);
        // Tesla Transceiver IV 9A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_3by3_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_3by3_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_3by3_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_3by3_IV.get(1),
                400,
                7680);
        // Tesla Transceiver LV 16A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_4by4_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_4by4_LV.get(1),
                400,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_LV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_4by4_LV.get(1),
                400,
                30);
        // Tesla Transceiver MV 16A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_4by4_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_4by4_MV.get(1),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_MV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_4by4_MV.get(1),
                400,
                120);
        // Tesla Transceiver HV 16A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_4by4_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_4by4_HV.get(1),
                400,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_HV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_4by4_HV.get(1),
                400,
                480);
        // Tesla Transceiver EV 16A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_4by4_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_4by4_EV.get(1),
                400,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_EV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_4by4_EV.get(1),
                400,
                1920);
        // Tesla Transceiver IV 16A
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Lead.getMolten(576),
                CustomItemList.Machine_TeslaCoil_4by4_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.Tin.getMolten(288),
                CustomItemList.Machine_TeslaCoil_4by4_IV.get(1),
                400,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Battery_Buffer_4by4_IV.get(1),
                        CustomItemList.teslaCover.getWithDamage(1, 0) },
                Materials.SolderingAlloy.getMolten(144),
                CustomItemList.Machine_TeslaCoil_4by4_IV.get(1),
                400,
                7680);

        // endregion

        // region components

        // Tesla Winding Components
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 32),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 8), },
                Materials.Epoxid.getMolten(288),
                CustomItemList.teslaComponent.getWithDamage(1, 0),
                320,
                30);
        // Tesla Winding Components Ultimate
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 16),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 8), },
                Materials.Epoxid.getMolten(576),
                CustomItemList.teslaComponent.getWithDamage(1, 1),
                320,
                7680);

        // endregion

        // region items

        // LV Tesla Capacitor
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 8), },
                Materials.Epoxid.getMolten(72),
                CustomItemList.teslaCapacitor.getWithDamage(1, 0),
                320,
                30);
        // MV Tesla Capacitor
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 6),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 12),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 12), },
                Materials.Epoxid.getMolten(144),
                CustomItemList.teslaCapacitor.getWithDamage(1, 1),
                320,
                120);
        // HV Tesla Capacitor
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 16), },
                Materials.Epoxid.getMolten(216),
                CustomItemList.teslaCapacitor.getWithDamage(1, 2),
                320,
                480);
        // EV Tesla Capacitor
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 10),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 20),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 20), },
                Materials.Epoxid.getMolten(288),
                CustomItemList.teslaCapacitor.getWithDamage(1, 3),
                320,
                1920);
        // IV Tesla Capacitor
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 12),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 24),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 24), },
                Materials.Epoxid.getMolten(360),
                CustomItemList.teslaCapacitor.getWithDamage(1, 4),
                320,
                7680);
        // LuV Tesla Capacitor
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.HSSG, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 14),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 28),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 28), },
                Materials.Epoxid.getMolten(432),
                CustomItemList.teslaCapacitor.getWithDamage(1, 5),
                320,
                30720);
        // ZPM Tesla Capacitor
        // GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
        // GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Naquadah, 4),
        // GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 16),
        // GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 32),
        // GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 32),
        // }, Materials.Epoxid.getMolten(504), CustomItemList.teslaCapacitor.getWithDamage(1, 6), 320, 122880);
        // TODO Allow with the coils, useless alone and will only cause trouble
        // Tesla Cover
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.teslaComponent.getWithDamage(4, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8), },
                Materials.Lead.getMolten(288),
                CustomItemList.teslaCover.getWithDamage(1, 0),
                320,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.teslaComponent.getWithDamage(4, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8), },
                Materials.Tin.getMolten(144),
                CustomItemList.teslaCover.getWithDamage(1, 0),
                320,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.teslaComponent.getWithDamage(4, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8), },
                Materials.SolderingAlloy.getMolten(72),
                CustomItemList.teslaCover.getWithDamage(1, 0),
                320,
                480);
        // Ultimate Tesla Cover
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.teslaComponent.getWithDamage(4, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8), },
                Materials.Lead.getMolten(288),
                CustomItemList.teslaCover.getWithDamage(1, 1),
                320,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.teslaComponent.getWithDamage(4, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8), },
                Materials.Tin.getMolten(144),
                CustomItemList.teslaCover.getWithDamage(1, 1),
                320,
                7680);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CustomItemList.teslaComponent.getWithDamage(4, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8), },
                Materials.SolderingAlloy.getMolten(72),
                CustomItemList.teslaCover.getWithDamage(1, 1),
                320,
                7680);

        // endregion

        // region recycling

        // LV Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 4),
                300,
                2);
        // MV Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 6),
                300,
                2);
        // HV Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 8),
                300,
                2);
        // EV Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 10),
                300,
                2);
        // IV Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 12),
                300,
                2);
        // LuV Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 5),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 14),
                300,
                2);
        // ZPM Tesla Capacitor
        GT_Values.RA.addExtractorRecipe(
                CustomItemList.teslaCapacitor.getWithDamage(1, 6),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 16),
                300,
                2);

        register_machine_EM_behaviours();
    }

    private void register_machine_EM_behaviours() {
        GT_MetaTileEntity_EM_machine
                .registerBehaviour(() -> new Behaviour_Centrifuge(5), ItemList.Machine_IV_Centrifuge.get(1));
        try {
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(6),
                    ItemList.valueOf("Machine_LuV_Centrifuge").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(7),
                    ItemList.valueOf("Machine_ZPM_Centrifuge").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(8),
                    ItemList.valueOf("Machine_UV_Centrifuge").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(9),
                    ItemList.valueOf("Machine_UV_Centrifuge").get(4));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(10),
                    ItemList.valueOf("Machine_UV_Centrifuge").get(16));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(11),
                    ItemList.valueOf("Machine_UV_Centrifuge").get(40));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Centrifuge(12),
                    ItemList.valueOf("Machine_UV_Centrifuge").get(64));
        } catch (IllegalArgumentException | NullPointerException e) {
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(6), ItemList.Machine_IV_Centrifuge.get(2));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(7), ItemList.Machine_IV_Centrifuge.get(4));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(8), ItemList.Machine_IV_Centrifuge.get(8));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(9), ItemList.Machine_IV_Centrifuge.get(16));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(10), ItemList.Machine_IV_Centrifuge.get(32));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(11), ItemList.Machine_IV_Centrifuge.get(48));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Centrifuge(12), ItemList.Machine_IV_Centrifuge.get(64));
        }

        GT_MetaTileEntity_EM_machine.registerBehaviour(
                () -> new Behaviour_ElectromagneticSeparator(5),
                ItemList.Machine_IV_ElectromagneticSeparator.get(1));
        try {
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(6),
                    ItemList.valueOf("Machine_LuV_ElectromagneticSeparator").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(7),
                    ItemList.valueOf("Machine_ZPM_ElectromagneticSeparator").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(8),
                    ItemList.valueOf("Machine_UV_ElectromagneticSeparator").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(9),
                    ItemList.valueOf("Machine_UV_ElectromagneticSeparator").get(4));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(10),
                    ItemList.valueOf("Machine_UV_ElectromagneticSeparator").get(16));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(11),
                    ItemList.valueOf("Machine_UV_ElectromagneticSeparator").get(40));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(12),
                    ItemList.valueOf("Machine_UV_ElectromagneticSeparator").get(64));
        } catch (IllegalArgumentException | NullPointerException e) {
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(6),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(2));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(7),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(4));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(8),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(8));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(9),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(16));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(10),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(32));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(11),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(48));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_ElectromagneticSeparator(12),
                    ItemList.Machine_IV_ElectromagneticSeparator.get(64));
        }

        GT_MetaTileEntity_EM_machine
                .registerBehaviour(() -> new Behaviour_Recycler(5), ItemList.Machine_IV_Recycler.get(1));
        try {
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Recycler(6),
                    ItemList.valueOf("Machine_LuV_Recycler").get(1));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Recycler(7),
                    ItemList.valueOf("Machine_ZPM_Recycler").get(1));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(8), ItemList.valueOf("Machine_UV_Recycler").get(1));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(9), ItemList.valueOf("Machine_UV_Recycler").get(4));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Recycler(10),
                    ItemList.valueOf("Machine_UV_Recycler").get(16));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Recycler(11),
                    ItemList.valueOf("Machine_UV_Recycler").get(40));
            GT_MetaTileEntity_EM_machine.registerBehaviour(
                    () -> new Behaviour_Recycler(12),
                    ItemList.valueOf("Machine_UV_Recycler").get(64));
        } catch (IllegalArgumentException | NullPointerException e) {
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(6), ItemList.Machine_IV_Recycler.get(2));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(7), ItemList.Machine_IV_Recycler.get(4));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(8), ItemList.Machine_IV_Recycler.get(8));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(9), ItemList.Machine_IV_Recycler.get(16));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(10), ItemList.Machine_IV_Recycler.get(32));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(11), ItemList.Machine_IV_Recycler.get(48));
            GT_MetaTileEntity_EM_machine
                    .registerBehaviour(() -> new Behaviour_Recycler(12), ItemList.Machine_IV_Recycler.get(64));
        }
    }
}
