package com.mcgoodtime.gti.common.tiles;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.info.Info;
import ic2.api.item.ElectricItem;
import ic2.core.item.ItemBatterySU;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BestOwl on 2015.10.26.0026.
 *
 * @author BestOwl
 */
public abstract class TileElectricContainer extends TileContainer implements IEnergySink {

    public final int energyPerTick;
    /** The number of remaining battery */
    public double energy;
    /** The number of that can storage battery */
    public final int maxEnergy;
    /** Determine the tier of this energy sink */
    public int tier;
    public final int dischargeSlotIndex;

    public TileElectricContainer (int energyPerTick, int maxEnergy, int sinkTier, int dischargeSlotIndex) {
        this.energyPerTick = energyPerTick;
        this.maxEnergy = maxEnergy;
        this.tier = sinkTier;
        this.dischargeSlotIndex = dischargeSlotIndex;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if((double)this.maxEnergy - this.energy >= 1.0D) {
            double amount = discharge(dischargeSlotIndex, (double) this.maxEnergy - this.energy, false);
            if(amount > 0.0D) {
                this.energy += amount;
                this.markDirty();
            }
        }
    }

    public double discharge(int index, double amount, boolean ignoreLimit) {
        if(amount <= 0.0D) {
            throw new IllegalArgumentException("Amount must be > 0.");
        } else {
            ItemStack stack = this.containerItemsList.get(index);
            if(stack == null) {
                return 0.0D;
            } else {
                double realAmount = ElectricItem.manager.discharge(stack, amount, this.tier, ignoreLimit, true, false);
                if(realAmount <= 0.0D) {
                    realAmount = Info.itemEnergy.getEnergyValue(stack);
                    if(realAmount <= 0.0D) {
                        return 0.0D;
                    }

                    --stack.stackSize;
                    if(stack.stackSize <= 0) {
                        this.containerItemsList.set(index, null);
                    }
                }

                return realAmount;
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.energy = nbt.getDouble("energy");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setDouble("energy", this.energy);
    }

    /**
     * Determine if this acceptor can accept current from an adjacent emitter in a direction.
     *
     * The TileEntity in the emitter parameter is what was originally added to the energy net,
     * which may be normal in-world TileEntity, a delegate or an IMetaDelegate.
     *
     * @param emitter energy emitter, may also be null or an IMetaDelegate
     * @param direction direction the energy is being received from
     */
    @Override
    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
        return true;
    }

    /**
     * Determine how much energy the sink accepts.
     * Make sure that injectEnergy() does accepts energy if demandsEnergy() returns anything > 0.
     *
     * @note Modifying the energy net from this method is disallowed.
     * @return max accepted input in eu
     */
    @Override
    public double getDemandedEnergy() {
        return (double) this.maxEnergy - this.energy;
    }

    /**
     * Determine the tier of this energy sink.
     * 1 = LV, 2 = MV, 3 = HV, 4 = EV etc.
     *
     * @note Modifying the energy net from this method is disallowed.
     * @note Return Integer.MAX_VALUE to allow any voltage.
     * @return tier of this energy sink
     */
    @Override
    public int getSinkTier() {
        return this.tier;
    }

    /**
     * Transfer energy to the sink.
     *
     * It's highly recommended to accept all energy by letting the internal buffer overflow to
     * increase the performance and accuracy of the distribution simulation.
     *
     * @param directionFrom direction from which the energy comes from
     * @param amount energy to be transferred
     * @return Energy not consumed (leftover)
     */
    @Override
    public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
        if(this.energy >= (double) this.maxEnergy) {
            return amount;
        } else {
            this.energy += amount;
            return 0.0D;
        }
    }

    /**
     * Called when the chunk this TileEntity is on is Unloaded.
     */
    @Override
    public void onChunkUnload() {
        super.onChunkUnload();
        MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
    }

    /**
     * validates a tile entity
     */
    @Override
    public void validate() {
        super.validate();
        MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
    }

    /**
     * Check whether the items can provide energy
     * @param stack item.
     */
    public boolean isDischargeItem(ItemStack stack) {
        return stack != null && (!(stack.getItem() != Items.redstone && !(stack.getItem() instanceof ItemBatterySU)) || ElectricItem.manager.discharge(stack, 1.0D / 0.0, this.tier, true, true, true) > 0.0D);
    }

}