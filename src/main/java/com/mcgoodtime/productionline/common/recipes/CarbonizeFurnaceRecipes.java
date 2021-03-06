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
package com.mcgoodtime.productionline.common.recipes;

import com.mcgoodtime.productionline.common.init.PLItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * List of CarbonizeFurnace's Recipes
 *
 * @author BestOwl
 */
public class CarbonizeFurnaceRecipes extends RecipeBase {

    public static final CarbonizeFurnaceRecipes instance = new CarbonizeFurnaceRecipes();

    private CarbonizeFurnaceRecipes() {
        register(new ItemStack(Blocks.LOG), new ItemStack(Items.COAL, 2, 1), 2000);
        register(new ItemStack(Blocks.LOG2), new ItemStack(Items.COAL, 2, 1), 2000);
        register(new ItemStack(Blocks.PLANKS, 2), new ItemStack(Items.COAL, 1, 1), 1500);
        register(new ItemStack(Items.REEDS, 4), PLItems.bambooCharcoal, 1500);
        register(new ItemStack(PLItems.saltWaterBucket), new ItemStack(PLItems.salt), 1100);
    }

    public void register(ItemStack input, ItemStack output, double requireEnergy) {
        this.processList.add(new RecipePartCarbonizeFurnace(input, output, requireEnergy));
    }

    public class RecipePartCarbonizeFurnace extends RecipePart {
        /** Value of EU consumption */
        public double requiresEnergy;

        private RecipePartCarbonizeFurnace(ItemStack input, ItemStack output, double requiresEnergy) {
            super(input, output);
            this.requiresEnergy = requiresEnergy;
        }
    }
}