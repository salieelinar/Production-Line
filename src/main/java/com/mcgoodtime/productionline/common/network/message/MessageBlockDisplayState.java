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
package com.mcgoodtime.productionline.common.network.message;

import com.mcgoodtime.productionline.common.tiles.TilePL;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by BestOwl on 2015.10.18.0018.
 *
 * @author BestOwl
 */
public class MessageBlockDisplayState extends MessageBase {

    public MessageBlockDisplayState() {}

    public MessageBlockDisplayState(TilePL tile) {
        super(tile);
        nbt.setBoolean("active", tile.active);
        nbt.setShort("facing", (short) tile.facing.ordinal());
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IMessage handlerMessage(MessageBase message, MessageContext ctx) {
        WorldClient world = Minecraft.getMinecraft().world;
        BlockPos pos = BlockPos.fromLong(message.nbt.getLong("pos"));
        TilePL tilePL = (TilePL) world.getTileEntity(pos);
        if (tilePL != null) {
            tilePL.active = message.nbt.getBoolean("active");
            tilePL.facing = EnumFacing.VALUES[message.nbt.getShort("facing")];
            world.scheduleUpdate(pos, world.getBlockState(pos).getBlock(), 0);
            world.notifyBlockOfStateChange(pos, world.getBlockState(pos).getBlock());
        }
        return null;
    }
}
