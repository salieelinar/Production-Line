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
package com.mcgoodtime.productionline.common.init;

import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by BestOwl on 2015.11.7.0007.
 *
 * @author BestOwl
 */
public class PLOreDictionary {

    public static void init() {
        OreDictionary.registerOre("paper", Items.PAPER);
        OreDictionary.registerOre("paper", PLItems.rigidPaper);

        OreDictionary.registerOre("advTreetap", PLItems.ironTreetap);
        OreDictionary.registerOre("advTreetap", PLItems.bronzeTreetap);
        OreDictionary.registerOre("advTreetap", PLItems.leadTreetap);
        OreDictionary.registerOre("advTreetap", PLItems.refinedIronTreetap);
        OreDictionary.registerOre("advTreetap", PLItems.advancedAlloyTreetap);
        OreDictionary.registerOre("advTreetap", PLItems.carbonTreetap);

        OreDictionary.registerOre("advSolarLens", PLItems.advSolarLensUnit);
        OreDictionary.registerOre("advSolarLens", PLItems.advSolarLensGroup);
        OreDictionary.registerOre("advSolarLens", PLItems.advSolarLensCluster);
    }
}
