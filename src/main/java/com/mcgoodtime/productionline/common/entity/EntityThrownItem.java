/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 GoodTime Studio <https://github.com/GoodTimeStudio>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mcgoodtime.productionline.common.entity;

import com.google.common.base.Optional;
import com.mcgoodtime.productionline.common.event.EntityThrowableImpactEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by suhao on 2015.11.4.0004.
 *
 * @author BwstOwl
 */
public class EntityThrownItem extends net.minecraft.entity.projectile.EntityThrowable {

    public static final DataParameter<Optional<ItemStack>> PARAMETER = EntityDataManager
            .createKey(EntityThrownItem.class, DataSerializers.OPTIONAL_ITEM_STACK);

    public EntityThrownItem(World world) {
        super(world);
    }

    public EntityThrownItem(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public EntityThrownItem(World world, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super(world, entityLivingBase);
        this.setThrowItem(itemStack);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(PARAMETER, Optional.<ItemStack>absent());
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        Optional<ItemStack> item = getThrowItem();
        if (item.isPresent()) {
            nbt.setTag("throwItem", item.get().serializeNBT());
        }

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setThrowItem(ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("throwItem")));
    }

    public Optional<ItemStack> getThrowItem() {
        return this.dataManager.get(PARAMETER);
    }

    public void setThrowItem(ItemStack itemStack) {
        this.dataManager.set(PARAMETER, Optional.of(itemStack));
    }

    /**
     * Called when this EntityThrownItem hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult rayTraceResult) {
        MinecraftForge.EVENT_BUS.post(new EntityThrowableImpactEvent(this, rayTraceResult));
    }
}
