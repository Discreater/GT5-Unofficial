package com.github.technus.tectech.thing.metaTileEntity.multi;

import static com.github.technus.tectech.thing.casing.GT_Block_CasingsTT.textureOffset;
import static com.github.technus.tectech.thing.casing.GT_Block_CasingsTT.texturePage;
import static com.github.technus.tectech.thing.casing.TT_Container_Casings.sBlockCasingsTT;
import static com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_decay.URANIUM_INGOT_MASS_DIFF;
import static com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_decay.URANIUM_MASS_TO_EU_INSTANT;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.util.GT_StructureUtility.ofHatchAdderOptional;
import static net.minecraft.util.StatCollector.translateToLocal;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.github.technus.tectech.thing.block.QuantumGlassBlock;
import com.github.technus.tectech.thing.metaTileEntity.multi.base.GT_MetaTileEntity_MultiblockBase_EM;
import com.github.technus.tectech.thing.metaTileEntity.multi.base.render.TT_RenderedExtendedFacingTexture;
import com.github.technus.tectech.util.CommonValues;
import com.gtnewhorizon.structurelib.alignment.constructable.IConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;

/**
 * Created by danie_000 on 17.12.2016.
 */
public class GT_MetaTileEntity_EM_bhg extends GT_MetaTileEntity_MultiblockBase_EM implements IConstructable {

    // region variables
    private static Textures.BlockIcons.CustomIcon ScreenOFF;
    private static Textures.BlockIcons.CustomIcon ScreenON;

    // todo CHECK VALUES
    private static final double NEUTRONIUM_BLOCK_MASS = 4.1E17;
    private static final double NEUTRONIUM_BLOCK_ATOM_COUNT = 2.4478671E44;
    private static final double NEUTRONIUM_BLOCK_TO_EU_INSTANT = URANIUM_MASS_TO_EU_INSTANT * NEUTRONIUM_BLOCK_MASS
            / (URANIUM_INGOT_MASS_DIFF * 1.78266191e-36); // ~ 5.314e40
    private static final double NEUTRON_TO_EU_INSTANT = NEUTRONIUM_BLOCK_TO_EU_INSTANT / NEUTRONIUM_BLOCK_ATOM_COUNT; // ~
                                                                                                                      // 0.00021708694

    public boolean glassDome = false;
    // endregion

    // Time dillatation - to slow down the explosion thing but REALLY REDUCE POWER OUTPUT
    // Startcodes to startup
    // per dim disable thingies

    // region structure actual
    private static final IStructureDefinition<GT_MetaTileEntity_EM_bhg> STRUCTURE_DEFINITION = IStructureDefinition
            .<GT_MetaTileEntity_EM_bhg>builder()
            .addShape(
                    "main_t1",
                    transpose(
                            new String[][] {
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "              DDDDD              ",
                                            "             DDCDCDD             ", "         CCCCDCCDCCDCCCC         ",
                                            "             DDDDDDD             ", "         CCCCDCCDCCDCCCC         ",
                                            "             DDCDCDD             ", "              DDDDD              ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "                D                ",
                                            "             DDDDDDD             ", "            DD     DD            ",
                                            "            D  EEE  D            ", "       CCC  D EAAAE D  CCC       ",
                                            "          DDD EAAAE DDD          ", "       CCC  D EAAAE D  CCC       ",
                                            "            D  EEE  D            ", "            DD     DD            ",
                                            "             DDDDDDD             ", "                D                ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "                D                ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "      CC                 CC      ",
                                            "        DD             DD        ", "      CC                 CC      ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                D                ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "              CCCCC              ", "                D                ",
                                            "                B                ", "                B                ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "      C                   C      ", "     CC                   CC     ",
                                            "      CDBB             BBDC      ", "     CC                   CC     ",
                                            "      C                   C      ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                B                ",
                                            "                B                ", "                D                ",
                                            "              CCCCC              ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "             EEEBEEE             ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "       E                 E       ",
                                            "       E                 E       ", "    CC E                 E CC    ",
                                            "      DB                 BD      ", "    CC E                 E CC    ",
                                            "       E                 E       ", "       E                 E       ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "             EEEBEEE             ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "              CCCCC              ", "                D                ",
                                            "                B                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "    C                       C    ", "   CC                       CC   ",
                                            "    CDB                   BDC    ", "   CC                       CC   ",
                                            "    C                       C    ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                B                ", "                D                ",
                                            "              CCCCC              ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "             EEEBEEE             ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "     E                     E     ",
                                            "     E                     E     ", "  CC E                     E CC  ",
                                            "    DB                     BD    ", "  CC E                     E CC  ",
                                            "     E                     E     ", "     E                     E     ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "             EEEBEEE             ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "               C C               ", "                D                ",
                                            "                B                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "  C                           C  ",
                                            "   DB                       BD   ", "  C                           C  ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                B                ", "                D                ",
                                            "               C C               ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "               C C               ", "                D                ",
                                            "                B                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", " CC                           CC ",
                                            "   DB                       BD   ", " CC                           CC ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                B                ", "                D                ",
                                            "               C C               ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "                D                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                D                ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "                D                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                D                ", "               C C               ",
                                            "                                 " },
                                    { "             CCCCCCC             ", "               C C               ",
                                            "             DDDDDDD             ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "  D                           D  ",
                                            "  D                           D  ", "CCD                           DCC",
                                            "  D                           D  ", "CCD                           DCC",
                                            "  D                           D  ", "  D                           D  ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "             DDDDDDD             ", "               C C               ",
                                            "               C C               " },
                                    { "            CCHHHHHCC            ", "              DDDDD              ",
                                            "            DD     DD            ", "                                 ",
                                            "                                 ", "       E                 E       ",
                                            "                                 ", "     E                     E     ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "  D                           D  ", "  D                           D  ",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", "  D                           D  ",
                                            "  D                           D  ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "     E                     E     ",
                                            "                                 ", "       E                 E       ",
                                            "                                 ", "                                 ",
                                            "            DD     DD            ", "              DDDDD              ",
                                            "               C C               " },
                                    { "            CHHHHHHHC            ", "             DDCDCDD             ",
                                            "            D  EEE  D            ", "                                 ",
                                            "      C                   C      ", "       E                 E       ",
                                            "    C                       C    ", "     E                     E     ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "  D                           D  ", " D                             D ",
                                            " D                             D ", "CCE                           ECC",
                                            " DE                           ED ", "CCE                           ECC",
                                            " D                             D ", " D                             D ",
                                            "  D                           D  ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "     E                     E     ",
                                            "    C                       C    ", "       E                 E       ",
                                            "      C                   C      ", "                                 ",
                                            "            D  EEE  D            ", "             DDCDCDD             ",
                                            "               C C               " },
                                    { "            CHHFFFHHC            ", "         CCCCDCCDCCDCCCC         ",
                                            "       CCC  D EAAAE D  CCC       ", "      CC                 CC      ",
                                            "     CC                   CC     ", "    CC E                 E CC    ",
                                            "   CC                       CC   ", "  CC E                     E CC  ",
                                            "  C                           C  ", " CC                           CC ",
                                            " C                             C ", " C                             C ",
                                            "CCD                           DCC", "CD                             DC",
                                            "CCE                           ECC", "CCA                           ACC",
                                            "CDA                           ADC", "CCA                           ACC",
                                            "CCE                           ECC", "CD                             DC",
                                            "CCD                           DCC", " C                             C ",
                                            " C                             C ", " CC                           CC ",
                                            "  C                           C  ", "  CC E                     E CC  ",
                                            "   CC                       CC   ", "    CC E                 E CC    ",
                                            "     CC                   CC     ", "      CC                 CC      ",
                                            "       CCC  D EAAAE D  CCC       ", "         CCCCDCCDCCDCCCC         ",
                                            "            CCCCCCCCC            " },
                                    { "            CHHF~FHHC            ", "             DDDDDDD             ",
                                            "          DDD EAAAE DDD          ", "        DD             DD        ",
                                            "      CDBB             BBDC      ", "      DB                 BD      ",
                                            "    CDB                   BDC    ", "    DB                     BD    ",
                                            "   DB                       BD   ", "   DB                       BD   ",
                                            "  D                           D  ", "  D                           D  ",
                                            "  D                           D  ", " D                             D ",
                                            " DE                           ED ", "CDA                           ADC",
                                            " DA                           AD ", "CDA                           ADC",
                                            " DE                           ED ", " D                             D ",
                                            "  D                           D  ", "  D                           D  ",
                                            "  D                           D  ", "   DB                       BD   ",
                                            "   DB                       BD   ", "    DB                     BD    ",
                                            "    CDB                   BDC    ", "      DB                 BD      ",
                                            "      CDBB             BBDC      ", "        DD             DD        ",
                                            "          DDD EAAAE DDD          ", "             DDDDDDD             ",
                                            "               C C               " },
                                    { "            CHHFFFHHC            ", "         CCCCDCCDCCDCCCC         ",
                                            "       CCC  D EAAAE D  CCC       ", "      CC                 CC      ",
                                            "     CC                   CC     ", "    CC E                 E CC    ",
                                            "   CC                       CC   ", "  CC E                     E CC  ",
                                            "  C                           C  ", " CC                           CC ",
                                            " C                             C ", " C                             C ",
                                            "CCD                           DCC", "CD                             DC",
                                            "CCE                           ECC", "CCA                           ACC",
                                            "CDA                           ADC", "CCA                           ACC",
                                            "CCE                           ECC", "CD                             DC",
                                            "CCD                           DCC", " C                             C ",
                                            " C                             C ", " CC                           CC ",
                                            "  C                           C  ", "  CC E                     E CC  ",
                                            "   CC                       CC   ", "    CC E                 E CC    ",
                                            "     CC                   CC     ", "      CC                 CC      ",
                                            "       CCC  D EAAAE D  CCC       ", "         CCCCDCCDCCDCCCC         ",
                                            "            CCCCCCCCC            " },
                                    { "            CHHHHHHHC            ", "             DDCDCDD             ",
                                            "            D  EEE  D            ", "                                 ",
                                            "      C                   C      ", "       E                 E       ",
                                            "    C                       C    ", "     E                     E     ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "  D                           D  ", " D                             D ",
                                            " D                             D ", "CCE                           ECC",
                                            " DE                           ED ", "CCE                           ECC",
                                            " D                             D ", " D                             D ",
                                            "  D                           D  ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "     E                     E     ",
                                            "    C                       C    ", "       E                 E       ",
                                            "      C                   C      ", "                                 ",
                                            "            D  EEE  D            ", "             DDCDCDD             ",
                                            "               C C               " },
                                    { "            CCHHHHHCC            ", "              DDDDD              ",
                                            "            DD     DD            ", "                                 ",
                                            "                                 ", "       E                 E       ",
                                            "                                 ", "     E                     E     ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "  D                           D  ", "  D                           D  ",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", "  D                           D  ",
                                            "  D                           D  ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "     E                     E     ",
                                            "                                 ", "       E                 E       ",
                                            "                                 ", "                                 ",
                                            "            DD     DD            ", "              DDDDD              ",
                                            "               C C               " },
                                    { "             CCCCCCC             ", "               C C               ",
                                            "             DDDDDDD             ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "  D                           D  ",
                                            "  D                           D  ", "CCD                           DCC",
                                            "  D                           D  ", "CCD                           DCC",
                                            "  D                           D  ", "  D                           D  ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "             DDDDDDD             ", "               C C               ",
                                            "               C C               " },
                                    { "                                 ", "               C C               ",
                                            "                D                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                D                ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "                D                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                D                ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "               C C               ", "                D                ",
                                            "                B                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", " CC                           CC ",
                                            "   DB                       BD   ", " CC                           CC ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                B                ", "                D                ",
                                            "               C C               ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "               C C               ", "                D                ",
                                            "                B                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "  C                           C  ",
                                            "   DB                       BD   ", "  C                           C  ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                B                ", "                D                ",
                                            "               C C               ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "             EEEBEEE             ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "     E                     E     ",
                                            "     E                     E     ", "  CC E                     E CC  ",
                                            "    DB                     BD    ", "  CC E                     E CC  ",
                                            "     E                     E     ", "     E                     E     ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "             EEEBEEE             ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "              CCCCC              ", "                D                ",
                                            "                B                ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "    C                       C    ", "   CC                       CC   ",
                                            "    CDB                   BDC    ", "   CC                       CC   ",
                                            "    C                       C    ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                B                ", "                D                ",
                                            "              CCCCC              ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "             EEEBEEE             ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "       E                 E       ",
                                            "       E                 E       ", "    CC E                 E CC    ",
                                            "      DB                 BD      ", "    CC E                 E CC    ",
                                            "       E                 E       ", "       E                 E       ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "             EEEBEEE             ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "              CCCCC              ", "                D                ",
                                            "                B                ", "                B                ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "      C                   C      ", "     CC                   CC     ",
                                            "      CDBB             BBDC      ", "     CC                   CC     ",
                                            "      C                   C      ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                B                ",
                                            "                B                ", "                D                ",
                                            "              CCCCC              ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "                D                ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "      CC                 CC      ",
                                            "        DD             DD        ", "      CC                 CC      ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                D                ",
                                            "                D                ", "                D                ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "                D                ", "                D                ",
                                            "             DDDDDDD             ", "            DD     DD            ",
                                            "            D  EEE  D            ", "       CCC  D EAAAE D  CCC       ",
                                            "          DDD EAAAE DDD          ", "       CCC  D EAAAE D  CCC       ",
                                            "            D  EEE  D            ", "            DD     DD            ",
                                            "             DDDDDDD             ", "                D                ",
                                            "                D                ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "              DDDDD              ",
                                            "             DDCDCDD             ", "         CCCCDCCDCCDCCCC         ",
                                            "             DDDDDDD             ", "         CCCCDCCDCCDCCCC         ",
                                            "             DDCDCDD             ", "              DDDDD              ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " } }))
            .addShape(
                    "main_t2",
                    transpose(
                            new String[][] {
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "             GGC CGG             ", "            GGGC CGGG            ",
                                            "           GGGGC CGGGG           ", "          GGGGDDDDDGGGG          ",
                                            "          GGGDDCDCDDGGG          ", "         CCCCDCCDCCDCCCC         ",
                                            "             DDDDDDD             ", "         CCCCDCCDCCDCCCC         ",
                                            "          GGGDDCDCDDGGG          ", "          GGGGDDDDDGGGG          ",
                                            "           GGGGC CGGGG           ", "            GGGC CGGG            ",
                                            "             GGC CGG             ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "             GGC CGG             ", "           GGGGC CGGGG           ",
                                            "          GGG   D   GGG          ", "         GGG    D    GGG         ",
                                            "         GG  DDDDDDD  GG         ", "        GG  DD     DD  GG        ",
                                            "        GG  D  EEE  D  GG        ", "       CCC  D EAAAE D  CCC       ",
                                            "          DDD EAAAE DDD          ", "       CCC  D EAAAE D  CCC       ",
                                            "        GG  D  EEE  D  GG        ", "        GG  DD     DD  GG        ",
                                            "         GG  DDDDDDD  GG         ", "         GGG    D    GGG         ",
                                            "          GGG   D   GGG          ", "           GGGGC CGGGG           ",
                                            "             GGC CGG             ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "            GGGC CGGG            ",
                                            "          GGG   D   GGG          ", "         GG     D     GG         ",
                                            "        GG             GG        ", "        G               G        ",
                                            "       GG               GG       ", "       G                 G       ",
                                            "       G                 G       ", "      CC                 CC      ",
                                            "        DD             DD        ", "      CC                 CC      ",
                                            "       G                 G       ", "       G                 G       ",
                                            "       GG               GG       ", "        G               G        ",
                                            "        GG             GG        ", "         GG     D     GG         ",
                                            "          GGG   D   GGG          ", "            GGGC CGGG            ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "           GGGCCCCCGGG           ", "         GGG    D    GGG         ",
                                            "        GG      B      GG        ", "       GG       B       GG       ",
                                            "       G                 G       ", "      GG                 GG      ",
                                            "      G                   G      ", "      G                   G      ",
                                            "      C                   C      ", "     CC                   CC     ",
                                            "      CDBB             BBDC      ", "     CC                   CC     ",
                                            "      C                   C      ", "      G                   G      ",
                                            "      G                   G      ", "      GG                 GG      ",
                                            "       G                 G       ", "       GG       B       GG       ",
                                            "        GG      B      GG        ", "         GGG    D    GGG         ",
                                            "           GGGCCCCCGGG           ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "          GGGGGC CGGGGG          ",
                                            "        GGG     D     GGG        ", "       GG    EEEBEEE    GG       ",
                                            "      GG                 GG      ", "      G                   G      ",
                                            "     GG                   GG     ", "     G                     G     ",
                                            "     G                     G     ", "     G E                 E G     ",
                                            "     G E                 E G     ", "    CC E                 E CC    ",
                                            "      DB                 BD      ", "    CC E                 E CC    ",
                                            "     G E                 E G     ", "     G E                 E G     ",
                                            "     G                     G     ", "     G                     G     ",
                                            "     GG                   GG     ", "      G                   G      ",
                                            "      GG                 GG      ", "       GG    EEEBEEE    GG       ",
                                            "        GGG     D     GGG        ", "          GGGGGC CGGGGG          ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "           GGGCCCCCGGG           ", "        GGG     D     GGG        ",
                                            "       GG       B       GG       ", "      G                   G      ",
                                            "     GG                   GG     ", "     G                     G     ",
                                            "     G                     G     ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "    C                       C    ", "   CC                       CC   ",
                                            "    CDB                   BDC    ", "   CC                       CC   ",
                                            "    C                       C    ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "     G                     G     ", "     G                     G     ",
                                            "     GG                   GG     ", "      G                   G      ",
                                            "       GG       B       GG       ", "        GGG     D     GGG        ",
                                            "           GGGCCCCCGGG           ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "               C C               ", "            GGGC CGGG            ",
                                            "         GGG    D    GGG         ", "       GG    EEEBEEE    GG       ",
                                            "      G                   G      ", "     G                     G     ",
                                            "     G                     G     ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "   G                         G   ", "   G E                     E G   ",
                                            "   G E                     E G   ", "  CC E                     E CC  ",
                                            "    DB                     BD    ", "  CC E                     E CC  ",
                                            "   G E                     E G   ", "   G E                     E G   ",
                                            "   G                         G   ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "     G                     G     ", "     G                     G     ",
                                            "      G                   G      ", "       GG    EEEBEEE    GG       ",
                                            "         GGG    D    GGG         ", "            GGGC CGGG            ",
                                            "               C C               ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "             GGC CGG             ", "          GGG   D   GGG          ",
                                            "        GG      B      GG        ", "      GG                 GG      ",
                                            "     GG                   GG     ", "     G                     G     ",
                                            "    G                       G    ", "    G                       G    ",
                                            "   G                         G   ", "   G                         G   ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", "  C                           C  ",
                                            "   DB                       BD   ", "  C                           C  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "   G                         G   ",
                                            "   G                         G   ", "    G                       G    ",
                                            "    G                       G    ", "     G                     G     ",
                                            "     GG                   GG     ", "      GG                 GG      ",
                                            "        GG      B      GG        ", "          GGG   D   GGG          ",
                                            "             GGC CGG             ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "           GGGGC CGGGG           ", "         GG     D     GG         ",
                                            "       GG       B       GG       ", "      G                   G      ",
                                            "     G                     G     ", "    G                       G    ",
                                            "    G                       G    ", "   G                         G   ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", " CC                           CC ",
                                            "   DB                       BD   ", " CC                           CC ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "   G                         G   ",
                                            "    G                       G    ", "    G                       G    ",
                                            "     G                     G     ", "      G                   G      ",
                                            "       GG       B       GG       ", "         GG     D     GG         ",
                                            "           GGGGC CGGGG           ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "             GGC CGG             ",
                                            "          GGG   D   GGG          ", "        GG             GG        ",
                                            "       G                 G       ", "     GG                   GG     ",
                                            "     G                     G     ", "    G                       G    ",
                                            "   G                         G   ", "   G                         G   ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", " G                             G ",
                                            " G                             G ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            " G                             G ", " G                             G ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", "   G                         G   ",
                                            "   G                         G   ", "    G                       G    ",
                                            "     G                     G     ", "     GG                   GG     ",
                                            "       G                 G       ", "        GG             GG        ",
                                            "          GGG   D   GGG          ", "             GGC CGG             ",
                                            "                                 " },
                                    { "                                 ", "            GGGC CGGG            ",
                                            "         GGG    D    GGG         ", "        G               G        ",
                                            "      GG                 GG      ", "     G                     G     ",
                                            "    G                       G    ", "    G                       G    ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            " G                             G ", " G                             G ",
                                            " G                             G ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            " G                             G ", " G                             G ",
                                            " G                             G ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "    G                       G    ",
                                            "    G                       G    ", "     G                     G     ",
                                            "      GG                 GG      ", "        G               G        ",
                                            "         GGG    D    GGG         ", "            GGGC CGGG            ",
                                            "                                 " },
                                    { "             CCCCCCC             ", "           GGGGC CGGGG           ",
                                            "         GG  DDDDDDD  GG         ", "       GG               GG       ",
                                            "      G                   G      ", "     G                     G     ",
                                            "    G                       G    ", "   G                         G   ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", " G                             G ",
                                            " G                             G ", " GD                           DG ",
                                            " GD                           DG ", "CCD                           DCC",
                                            "  D                           D  ", "CCD                           DCC",
                                            " GD                           DG ", " GD                           DG ",
                                            " G                             G ", " G                             G ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "   G                         G   ",
                                            "    G                       G    ", "     G                     G     ",
                                            "      G                   G      ", "       GG               GG       ",
                                            "         GG  DDDDDDD  GG         ", "           GGGGC CGGGG           ",
                                            "               C C               " },
                                    { "            CCHHHHHCC            ", "          GGGGDDDDDGGGG          ",
                                            "        GG  DD     DD  GG        ", "       G                 G       ",
                                            "      G                   G      ", "     G E                 E G     ",
                                            "    G                       G    ", "   G E                     E G   ",
                                            "  G                           G  ", "  G                           G  ",
                                            " G                             G ", " G                             G ",
                                            " GD                           DG ", " GD                           DG ",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", " GD                           DG ",
                                            " GD                           DG ", " G                             G ",
                                            " G                             G ", "  G                           G  ",
                                            "  G                           G  ", "   G E                     E G   ",
                                            "    G                       G    ", "     G E                 E G     ",
                                            "      G                   G      ", "       G                 G       ",
                                            "        GG  DD     DD  GG        ", "          GGGGDDDDDGGGG          ",
                                            "               C C               " },
                                    { "            CHHHHHHHC            ", "          GGGDDCDCDDGGG          ",
                                            "        GG  D  EEE  D  GG        ", "       G                 G       ",
                                            "      C                   C      ", "     G E                 E G     ",
                                            "    C                       C    ", "   G E                     E G   ",
                                            "  G                           G  ", "  G                           G  ",
                                            " G                             G ", " G                             G ",
                                            " GD                           DG ", " D                             D ",
                                            " D                             D ", "CCE                           ECC",
                                            " DE                           ED ", "CCE                           ECC",
                                            " D                             D ", " D                             D ",
                                            " GD                           DG ", " G                             G ",
                                            " G                             G ", "  G                           G  ",
                                            "  G                           G  ", "   G E                     E G   ",
                                            "    C                       C    ", "     G E                 E G     ",
                                            "      C                   C      ", "       G                 G       ",
                                            "        GG  D  EEE  D  GG        ", "          GGGDDCDCDDGGG          ",
                                            "               C C               " },
                                    { "            CHHFFFHHC            ", "         CCCCDCCDCCDCCCC         ",
                                            "       CCC  D EAAAE D  CCC       ", "      CC                 CC      ",
                                            "     CC                   CC     ", "    CC E                 E CC    ",
                                            "   CC                       CC   ", "  CC E                     E CC  ",
                                            "  C                           C  ", " CC                           CC ",
                                            " C                             C ", " C                             C ",
                                            "CCD                           DCC", "CD                             DC",
                                            "CCE                           ECC", "CCA                           ACC",
                                            "CDA                           ADC", "CCA                           ACC",
                                            "CCE                           ECC", "CD                             DC",
                                            "CCD                           DCC", " C                             C ",
                                            " C                             C ", " CC                           CC ",
                                            "  C                           C  ", "  CC E                     E CC  ",
                                            "   CC                       CC   ", "    CC E                 E CC    ",
                                            "     CC                   CC     ", "      CC                 CC      ",
                                            "       CCC  D EAAAE D  CCC       ", "         CCCCDCCDCCDCCCC         ",
                                            "            CCCCCCCCC            " },
                                    { "            CHHF~FHHC            ", "             DDDDDDD             ",
                                            "          DDD EAAAE DDD          ", "        DD             DD        ",
                                            "      CDBB             BBDC      ", "      DB                 BD      ",
                                            "    CDB                   BDC    ", "    DB                     BD    ",
                                            "   DB                       BD   ", "   DB                       BD   ",
                                            "  D                           D  ", "  D                           D  ",
                                            "  D                           D  ", " D                             D ",
                                            " DE                           ED ", "CDA                           ADC",
                                            " DA                           AD ", "CDA                           ADC",
                                            " DE                           ED ", " D                             D ",
                                            "  D                           D  ", "  D                           D  ",
                                            "  D                           D  ", "   DB                       BD   ",
                                            "   DB                       BD   ", "    DB                     BD    ",
                                            "    CDB                   BDC    ", "      DB                 BD      ",
                                            "      CDBB             BBDC      ", "        DD             DD        ",
                                            "          DDD EAAAE DDD          ", "             DDDDDDD             ",
                                            "               C C               " },
                                    { "            CHHFFFHHC            ", "         CCCCDCCDCCDCCCC         ",
                                            "       CCC  D EAAAE D  CCC       ", "      CC                 CC      ",
                                            "     CC                   CC     ", "    CC E                 E CC    ",
                                            "   CC                       CC   ", "  CC E                     E CC  ",
                                            "  C                           C  ", " CC                           CC ",
                                            " C                             C ", " C                             C ",
                                            "CCD                           DCC", "CD                             DC",
                                            "CCE                           ECC", "CCA                           ACC",
                                            "CDA                           ADC", "CCA                           ACC",
                                            "CCE                           ECC", "CD                             DC",
                                            "CCD                           DCC", " C                             C ",
                                            " C                             C ", " CC                           CC ",
                                            "  C                           C  ", "  CC E                     E CC  ",
                                            "   CC                       CC   ", "    CC E                 E CC    ",
                                            "     CC                   CC     ", "      CC                 CC      ",
                                            "       CCC  D EAAAE D  CCC       ", "         CCCCDCCDCCDCCCC         ",
                                            "            CCCCCCCCC            " },
                                    { "            CHHHHHHHC            ", "          GGGDDCDCDDGGG          ",
                                            "        GG  D  EEE  D  GG        ", "       G                 G       ",
                                            "      C                   C      ", "     G E                 E G     ",
                                            "    C                       C    ", "   G E                     E G   ",
                                            "  G                           G  ", "  G                           G  ",
                                            " G                             G ", " G                             G ",
                                            " GD                           DG ", " D                             D ",
                                            " D                             D ", "CCE                           ECC",
                                            " DE                           ED ", "CCE                           ECC",
                                            " D                             D ", " D                             D ",
                                            " GD                           DG ", " G                             G ",
                                            " G                             G ", "  G                           G  ",
                                            "  G                           G  ", "   G E                     E G   ",
                                            "    C                       C    ", "     G E                 E G     ",
                                            "      C                   C      ", "       G                 G       ",
                                            "        GG  D  EEE  D  GG        ", "          GGGDDCDCDDGGG          ",
                                            "               C C               " },
                                    { "            CCHHHHHCC            ", "          GGGGDDDDDGGGG          ",
                                            "        GG  DD     DD  GG        ", "       G                 G       ",
                                            "      G                   G      ", "     G E                 E G     ",
                                            "    G                       G    ", "   G E                     E G   ",
                                            "  G                           G  ", "  G                           G  ",
                                            " G                             G ", " G                             G ",
                                            " GD                           DG ", " GD                           DG ",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", "CD                             DC",
                                            " D                             D ", " GD                           DG ",
                                            " GD                           DG ", " G                             G ",
                                            " G                             G ", "  G                           G  ",
                                            "  G                           G  ", "   G E                     E G   ",
                                            "    G                       G    ", "     G E                 E G     ",
                                            "      G                   G      ", "       G                 G       ",
                                            "        GG  DD     DD  GG        ", "          GGGGDDDDDGGGG          ",
                                            "               C C               " },
                                    { "             CCCCCCC             ", "           GGGGC CGGGG           ",
                                            "         GG  DDDDDDD  GG         ", "       GG               GG       ",
                                            "      G                   G      ", "     G                     G     ",
                                            "    G                       G    ", "   G                         G   ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", " G                             G ",
                                            " G                             G ", " GD                           DG ",
                                            " GD                           DG ", "CCD                           DCC",
                                            "  D                           D  ", "CCD                           DCC",
                                            " GD                           DG ", " GD                           DG ",
                                            " G                             G ", " G                             G ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "   G                         G   ",
                                            "    G                       G    ", "     G                     G     ",
                                            "      G                   G      ", "       GG               GG       ",
                                            "         GG  DDDDDDD  GG         ", "           GGGGC CGGGG           ",
                                            "               C C               " },
                                    { "                                 ", "            GGGC CGGG            ",
                                            "         GGG    D    GGG         ", "        G               G        ",
                                            "      GG                 GG      ", "     G                     G     ",
                                            "    G                       G    ", "    G                       G    ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            " G                             G ", " G                             G ",
                                            " G                             G ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            " G                             G ", " G                             G ",
                                            " G                             G ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "    G                       G    ",
                                            "    G                       G    ", "     G                     G     ",
                                            "      GG                 GG      ", "        G               G        ",
                                            "         GGG    D    GGG         ", "            GGGC CGGG            ",
                                            "                                 " },
                                    { "                                 ", "             GGC CGG             ",
                                            "          GGG   D   GGG          ", "        GG             GG        ",
                                            "       G                 G       ", "     GG                   GG     ",
                                            "     G                     G     ", "    G                       G    ",
                                            "   G                         G   ", "   G                         G   ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", " G                             G ",
                                            " G                             G ", " C                             C ",
                                            "  D                           D  ", " C                             C ",
                                            " G                             G ", " G                             G ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", "   G                         G   ",
                                            "   G                         G   ", "    G                       G    ",
                                            "     G                     G     ", "     GG                   GG     ",
                                            "       G                 G       ", "        GG             GG        ",
                                            "          GGG   D   GGG          ", "             GGC CGG             ",
                                            "                                 " },
                                    { "                                 ", "               C C               ",
                                            "           GGGGC CGGGG           ", "         GG     D     GG         ",
                                            "       GG       B       GG       ", "      G                   G      ",
                                            "     G                     G     ", "    G                       G    ",
                                            "    G                       G    ", "   G                         G   ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", " CC                           CC ",
                                            "   DB                       BD   ", " CC                           CC ",
                                            "  G                           G  ", "  G                           G  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "   G                         G   ",
                                            "    G                       G    ", "    G                       G    ",
                                            "     G                     G     ", "      G                   G      ",
                                            "       GG       B       GG       ", "         GG     D     GG         ",
                                            "           GGGGC CGGGG           ", "               C C               ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "             GGC CGG             ", "          GGG   D   GGG          ",
                                            "        GG      B      GG        ", "      GG                 GG      ",
                                            "     GG                   GG     ", "     G                     G     ",
                                            "    G                       G    ", "    G                       G    ",
                                            "   G                         G   ", "   G                         G   ",
                                            "   G                         G   ", "  G                           G  ",
                                            "  G                           G  ", "  C                           C  ",
                                            "   DB                       BD   ", "  C                           C  ",
                                            "  G                           G  ", "  G                           G  ",
                                            "   G                         G   ", "   G                         G   ",
                                            "   G                         G   ", "    G                       G    ",
                                            "    G                       G    ", "     G                     G     ",
                                            "     GG                   GG     ", "      GG                 GG      ",
                                            "        GG      B      GG        ", "          GGG   D   GGG          ",
                                            "             GGC CGG             ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "               C C               ", "            GGGC CGGG            ",
                                            "         GGG    D    GGG         ", "       GG    EEEBEEE    GG       ",
                                            "      G                   G      ", "     G                     G     ",
                                            "     G                     G     ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "   G                         G   ", "   G E                     E G   ",
                                            "   G E                     E G   ", "  CC E                     E CC  ",
                                            "    DB                     BD    ", "  CC E                     E CC  ",
                                            "   G E                     E G   ", "   G E                     E G   ",
                                            "   G                         G   ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "     G                     G     ", "     G                     G     ",
                                            "      G                   G      ", "       GG    EEEBEEE    GG       ",
                                            "         GGG    D    GGG         ", "            GGGC CGGG            ",
                                            "               C C               ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "           GGGCCCCCGGG           ", "        GGG     D     GGG        ",
                                            "       GG       B       GG       ", "      G                   G      ",
                                            "     GG                   GG     ", "     G                     G     ",
                                            "     G                     G     ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "    C                       C    ", "   CC                       CC   ",
                                            "    CDB                   BDC    ", "   CC                       CC   ",
                                            "    C                       C    ", "    G                       G    ",
                                            "    G                       G    ", "    G                       G    ",
                                            "     G                     G     ", "     G                     G     ",
                                            "     GG                   GG     ", "      G                   G      ",
                                            "       GG       B       GG       ", "        GGG     D     GGG        ",
                                            "           GGGCCCCCGGG           ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "          GGGGGC CGGGGG          ",
                                            "        GGG     D     GGG        ", "       GG    EEEBEEE    GG       ",
                                            "      GG                 GG      ", "      G                   G      ",
                                            "     GG                   GG     ", "     G                     G     ",
                                            "     G                     G     ", "     G E                 E G     ",
                                            "     G E                 E G     ", "    CC E                 E CC    ",
                                            "      DB                 BD      ", "    CC E                 E CC    ",
                                            "     G E                 E G     ", "     G E                 E G     ",
                                            "     G                     G     ", "     G                     G     ",
                                            "     GG                   GG     ", "      G                   G      ",
                                            "      GG                 GG      ", "       GG    EEEBEEE    GG       ",
                                            "        GGG     D     GGG        ", "          GGGGGC CGGGGG          ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "           GGGCCCCCGGG           ", "         GGG    D    GGG         ",
                                            "        GG      B      GG        ", "       GG       B       GG       ",
                                            "       G                 G       ", "      GG                 GG      ",
                                            "      G                   G      ", "      G                   G      ",
                                            "      C                   C      ", "     CC                   CC     ",
                                            "      CDBB             BBDC      ", "     CC                   CC     ",
                                            "      C                   C      ", "      G                   G      ",
                                            "      G                   G      ", "      GG                 GG      ",
                                            "       G                 G       ", "       GG       B       GG       ",
                                            "        GG      B      GG        ", "         GGG    D    GGG         ",
                                            "           GGGCCCCCGGG           ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "            GGGC CGGG            ",
                                            "          GGG   D   GGG          ", "         GG     D     GG         ",
                                            "        GG             GG        ", "        G               G        ",
                                            "       GG               GG       ", "       G                 G       ",
                                            "       G                 G       ", "      CC                 CC      ",
                                            "        DD             DD        ", "      CC                 CC      ",
                                            "       G                 G       ", "       G                 G       ",
                                            "       GG               GG       ", "        G       D       G        ",
                                            "        GG      D      GG        ", "         GG     D     GG         ",
                                            "          GGG   D   GGG          ", "            GGGC CGGG            ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "             GGC CGG             ", "           GGGGC CGGGG           ",
                                            "          GGG   D   GGG          ", "         GGG    D    GGG         ",
                                            "         GG  DDDDDDD  GG         ", "        GG  DD     DD  GG        ",
                                            "        GG  D  EEE  D  GG        ", "       CCC  D EAAAE D  CCC       ",
                                            "          DDD EAAAE DDD          ", "       CCC  D EAAAE D  CCC       ",
                                            "        GG  D  EEE  D  GG        ", "        GG  DD     DD  GG        ",
                                            "         GG  DDDDDDD  GG         ", "         GGG    D    GGG         ",
                                            "          GGG   D   GGG          ", "           GGGGC CGGGG           ",
                                            "             GGC CGG             ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "               C C               ",
                                            "             GGC CGG             ", "            GGGC CGGG            ",
                                            "           GGGGC CGGGG           ", "          GGGGDDDDDGGGG          ",
                                            "          GGGDDCDCDDGGG          ", "         CCCCDCCDCCDCCCC         ",
                                            "             DDDDDDD             ", "         CCCCDCCDCCDCCCC         ",
                                            "          GGGDDCDCDDGGG          ", "          GGGGDDDDDGGGG          ",
                                            "           GGGGC CGGGG           ", "            GGGC CGGG            ",
                                            "             GGC CGG             ", "               C C               ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " },
                                    { "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "            CCCCCCCCC            ",
                                            "               C C               ", "               C C               ",
                                            "               C C               ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 ", "                                 ",
                                            "                                 " } }))
            .addElement('A', ofBlock(sBlockCasingsTT, 10)).addElement('B', ofBlock(sBlockCasingsTT, 11))
            .addElement('C', ofBlock(sBlockCasingsTT, 12)).addElement('D', ofBlock(sBlockCasingsTT, 13))
            .addElement('E', ofBlock(sBlockCasingsTT, 14)).addElement('G', ofBlock(QuantumGlassBlock.INSTANCE, 0))
            .addElement(
                    'H',
                    ofHatchAdderOptional(
                            GT_MetaTileEntity_EM_bhg::addClassicToMachineList,
                            textureOffset,
                            1,
                            sBlockCasingsTT,
                            0))
            .addElement(
                    'F',
                    ofHatchAdderOptional(
                            GT_MetaTileEntity_EM_bhg::addElementalToMachineList,
                            textureOffset + 4,
                            2,
                            sBlockCasingsTT,
                            4))
            .build();

    @Override
    public IStructureDefinition<GT_MetaTileEntity_EM_bhg> getStructure_EM() {
        return STRUCTURE_DEFINITION;
    }

    private static final String[] description = new String[] {
            EnumChatFormatting.AQUA + translateToLocal("tt.keyphrase.Hint_Details") + ":",
            translateToLocal("gt.blockmachines.multimachine.em.blackholegenerator.hint.0"), // 1 - Classic Hatches or
                                                                                            // High Power
            // Casing
            translateToLocal("gt.blockmachines.multimachine.em.blackholegenerator.hint.1"), // 2 - Elemental Hatches or
                                                                                            // Molecular
            // Casing
    };
    // endregion

    public GT_MetaTileEntity_EM_bhg(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_EM_bhg(String aName) {
        super(aName);
    }

    /**
     * Black hole event horizon radius calculator
     *
     * @param massKg mass in kg
     * @return radius in meters
     */
    private static double getSchwarzschildRadius(double massKg) {
        return massKg * 1.48523238761875E-27;
    }

    /**
     * Black hole event horizon surface area calculator
     *
     * @param massKg mass in kg
     * @return area in meters^2
     */
    private static double getSchwarzschildArea(double massKg) {
        return Math.pow(getSchwarzschildRadius(massKg), 2) * 12.566370614359172;
    }

    /**
     * Black hole event horizon temperature calculator
     *
     * @param massKg mass in kg
     * @return temperature in K
     */
    private static double getTemperature(double massKg) {
        return 2.841438513199716E-9 / (2.3159488515170722E-32 * massKg);
    }

    /**
     * Black hole luminosity calculator
     *
     * @param massKg mass in kg
     * @return luminosity in watts
     */
    private static double getLuminosity(double massKg) {
        return getSchwarzschildArea(massKg) * 5.670373e-8 * Math.pow(getTemperature(massKg), 4);
    }

    /**
     * Black hole acretion disk luminosity calculator
     *
     * @param massKgPer1s mass injection kg per s
     * @return luminosity in watts
     */
    private static double getAcretionDiskLuminosity(double massKgPer1s) {
        return massKgPer1s * 7.48962648947348E15;
    }

    /**
     * Black hole gravity field calculator, should be used for gravity blasting
     *
     * @param massKg     mass in kg
     * @param distanceSq distance squared in meters
     * @return gravity field
     */
    private static double getGravityField(double massKg, double distanceSq) {
        return massKg * 6.6743015e-11 / distanceSq;
    }

    /**
     * Black hole containment force calculator
     *
     * @param massKg   mass in kg
     * @param radiusSq radius squared in meters
     * @return force in newtons
     */
    private static double getContainmentForce(double massKg, double radiusSq) {
        return Math.pow(massKg, 2) * 6.6743015e-11 / radiusSq;
    }

    /**
     * Black hole containment pressure calculator F/s, should be used for bhg initial release explosion?
     *
     * @param massKg   mass in kg
     * @param radiusSq radius squared in meters
     * @return pressure in pascals
     */
    private static double getContainmentPressure(double massKg, double radiusSq) {
        return getContainmentForce(massKg, radiusSq) / (12.566370614359172 * radiusSq);
    }

    /**
     * Black hole containment energy calculator, assuming F*s, and 100% efficient gravity force field
     *
     * @param massKg mass in kg
     * @return power in watts
     */
    private static double getContainmentPower(double massKg) {
        return Math.pow(massKg, 2) * 8.387174624097334E-10;
    }

    /**
     * Black hole power balance, zero at mass ~= 2.5525e10 (T~=4.8067e12)
     *
     * @param massKg      mass in kg
     * @param massKgPer1s mass injection kg per s
     * @return power in watts
     */
    @Deprecated
    private static double getContainmentPowerBalance(double massKg, double massKgPer1s) {
        return getLuminosity(massKg) + getAcretionDiskLuminosity(massKgPer1s) - getContainmentPower(massKg);
    }

    // todo compaction energy 8 * Long.MAx_VALUE?

    // todo neutronium decay gen? 0.0007186885 mass diff - actually compute hydrogen amount...

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_EM_bhg(mName);
    }

    @Override
    public boolean checkMachine_EM(IGregTechTileEntity iGregTechTileEntity, ItemStack itemStack) {
        if (structureCheck_EM("t2", 16, 16, 0)) {
            glassDome = true;
            return true;
        }
        if (structureCheck_EM("t1", 16, 16, 0)) {
            glassDome = false;
            return true;
        }
        // todo check tiers of hatches!!!!
        return false;
    }

    @Override
    public GT_Multiblock_Tooltip_Builder createTooltip() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType(translateToLocal("gt.blockmachines.multimachine.em.blackholegenerator.name")) // Machine Type:
                                                                                                        // Black Hole
                // Generator
                .addInfo(translateToLocal("gt.blockmachines.multimachine.em.blackholegenerator.desc.0")) // Controller
                                                                                                         // block of
                // the Black Hole
                // Generator
                .addInfo(translateToLocal("gt.blockmachines.multimachine.em.blackholegenerator.desc.1")) // Uses a black
                                                                                                         // hole to
                // generate power
                .addInfo(translateToLocal("tt.keyword.Structure.StructureTooComplex")) // The structure is too complex!
                .addSeparator().beginStructureBlock(33, 33, 33, false)
                .addEnergyHatch(translateToLocal("tt.keyword.Structure.AnyHighPowerCasing1D"), 1) // Energy Hatch: Any
                                                                                                  // High Power Casing
                                                                                                  // with 1 dot
                .addMaintenanceHatch(translateToLocal("tt.keyword.Structure.AnyHighPowerCasing1D"), 1) // Maintenance
                                                                                                       // Hatch: Any
                                                                                                       // High Power
                                                                                                       // Casing with 1
                                                                                                       // dot
                .toolTipFinisher(CommonValues.TEC_MARK_EM);
        return tt;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister aBlockIconRegister) {
        ScreenOFF = new Textures.BlockIcons.CustomIcon("iconsets/EM_BHG");
        ScreenON = new Textures.BlockIcons.CustomIcon("iconsets/EM_BHG_ACTIVE");
        super.registerIcons(aBlockIconRegister);
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex,
            boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            return new ITexture[] { Textures.BlockIcons.casingTexturePages[texturePage][12],
                    new TT_RenderedExtendedFacingTexture(aActive ? ScreenON : ScreenOFF) };
        }
        return new ITexture[] { Textures.BlockIcons.casingTexturePages[texturePage][12] };
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        try {
            structureBuild_EM((stackSize.stackSize & 1) == 1 ? "main_t1" : "main_t2", 16, 16, 0, stackSize, hintsOnly);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] getStructureDescription(ItemStack stackSize) {
        return description;
    }
}
