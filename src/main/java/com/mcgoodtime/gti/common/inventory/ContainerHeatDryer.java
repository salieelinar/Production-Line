package com.mcgoodtime.gti.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/*
 * Created by suhao on 2015.7.10.
 */
public class ContainerHeatDryer extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return false;
    }
}
