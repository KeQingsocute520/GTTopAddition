package keqing.gttopaddition.integration.theoneprobe;

import gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities;
import gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityAlloyBlastSmelter;
import gregicality.multiblocks.common.metatileentities.multiblock.standard.MetaTileEntityMegaBlastFurnace;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityCrackingUnit;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityElectricBlastFurnace;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityPyrolyseOven;
import keqing.gttopaddition.api.utils.Mods;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MultiblockTemperatureProvider implements IProbeInfoProvider {

    @Override
    public String getID() {
        return "gtqt:temperature";
    }

    @Override
    public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, EntityPlayer entityPlayer, World world, IBlockState iBlockState, IProbeHitData iProbeHitData) {
        if (iBlockState.getBlock().hasTileEntity(iBlockState)) {
            TileEntity te = world.getTileEntity(iProbeHitData.getPos());
            IProbeInfo horizontalPane = iProbeInfo.horizontal(iProbeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
            if (te instanceof IGregTechTileEntity) {
                IGregTechTileEntity ignite = (IGregTechTileEntity) te;
                MetaTileEntity mte = ignite.getMetaTileEntity();
                if (mte instanceof MetaTileEntityElectricBlastFurnace) {
                    int Temperature = ((MetaTileEntityElectricBlastFurnace) mte).getCurrentTemperature();

                    horizontalPane.text(TextStyleClass.INFO + "{*gtqt.top.temperature*}");
                    horizontalPane.text(TextStyleClass.INFO + " " + TextFormatting.RED + Temperature + " K");
                }
                if(Mods.GregicalityMultiblocks.isModLoaded()) {
                    if (mte instanceof MetaTileEntityAlloyBlastSmelter) {
                        int Temperature = ((MetaTileEntityAlloyBlastSmelter) mte).getCurrentTemperature();

                        horizontalPane.text(TextStyleClass.INFO + "{*gtqt.top.temperature*}");
                        horizontalPane.text(TextStyleClass.INFO + " " + TextFormatting.RED + Temperature + " K");
                    }
                    if (mte instanceof MetaTileEntityMegaBlastFurnace) {
                        int Temperature = ((MetaTileEntityMegaBlastFurnace) mte).getCurrentTemperature();

                        horizontalPane.text(TextStyleClass.INFO + "{*gtqt.top.temperature*}");
                        horizontalPane.text(TextStyleClass.INFO + " " + TextFormatting.RED + Temperature + " K");
                    }
                }
            }
        }
    }
}