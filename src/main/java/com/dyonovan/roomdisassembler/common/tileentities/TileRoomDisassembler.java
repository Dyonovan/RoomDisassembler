package com.dyonovan.roomdisassembler.common.tileentities;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import com.dyonovan.roomdisassembler.util.Location;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileRoomDisassembler extends TileEntity implements IEnergyHandler {

    protected EnergyStorage storage = new EnergyStorage(32000);
    public Location loc1;
    public Location loc2;

    public TileRoomDisassembler() {
        loc1 = new Location(xCoord + 5, yCoord, zCoord + 5);
        loc2 = new Location(xCoord - 5, yCoord + 5, zCoord - 5);
    }


    /**
     * Energy Functions
     */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return storage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    /**
     * Tile Functions
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {

        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
        loc1.readFromNBT(nbt);
        loc2.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {

        super.writeToNBT(nbt);
        storage.writeToNBT(nbt);
        loc1.writeToNBT(nbt);
        loc2.writeToNBT(nbt);
    }
}