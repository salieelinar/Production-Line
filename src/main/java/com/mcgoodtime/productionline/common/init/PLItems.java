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

import com.mcgoodtime.productionline.common.core.PLConfig;
import com.mcgoodtime.productionline.common.core.ProductionLine;
import com.mcgoodtime.productionline.common.entity.EntityThrownItem;
import com.mcgoodtime.productionline.common.items.ItemCEU;
import com.mcgoodtime.productionline.common.items.ItemCrafting;
import com.mcgoodtime.productionline.common.items.ItemDiamondApple;
import com.mcgoodtime.productionline.common.items.ItemDryFood;
import com.mcgoodtime.productionline.common.items.ItemOre;
import com.mcgoodtime.productionline.common.items.ItemPL;
import com.mcgoodtime.productionline.common.items.ItemPLFood;
import com.mcgoodtime.productionline.common.items.ItemPLRecord;
import com.mcgoodtime.productionline.common.items.tools.ItemGravityRay;
import com.mcgoodtime.productionline.common.items.tools.ItemPLTreetap;
import com.mcgoodtime.productionline.common.items.tools.PLToolMaterial;
import com.mcgoodtime.productionline.common.items.tools.ToolPL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.mcgoodtime.productionline.common.core.ProductionLine.MOD_ID;

//import coreom.mcgoodtime.productionline.common.entity.EntityThrownItem;
//import com.mcgoodtime.productionline.common.items.tools.ItemGravityRay;
//import com.mcgoodtime.productionline.common.items.tools.ItemPLTreetap;
//import com.mcgoodtime.productionline.common.items.tools.ToolPL;

/**
 * The list of all those items in GoodTime-Industrial.
 */
public class PLItems implements IFuelHandler {

    public static Item diamondApple;
    public static Item packagedSalt;
    public static Item iridiumAxe;
    public static Item iridiumSpade;
    public static Item iridiumSword;
    public static Item iridiumPickaxe;
    public static Item salt;
    public static Item saltWaterBucket;
    public static Item hammer;

    public static Item ironTreetap;
    public static Item bronzeTreetap;
    public static Item leadTreetap;
    public static Item refinedIronTreetap;
    public static Item advancedAlloyTreetap;
    public static Item carbonTreetap;
    public static Item woodenHammer;
    public static Item tupid;
    public static Item ironCone;
    public static Item steelCone;

    public static Item ceu;
    public static Item gravityRay;

    public static Item record_MusicSpring;

    public static Item itemCrafting;
    public static Item itemOre;
    //--------------------------------------
    public static ItemStack crushedIridium;
    public static ItemStack cleanedCrushedIridium;
    public static ItemStack dustIridium;
    public static ItemStack smallDustIridium;
    public static ItemStack ingotIridium;
    public static ItemStack denseDiamondPlate;
    public static ItemStack diamondPlate;

    public static ItemStack yourHouseBombed;
    public static ItemStack heatInsulationPlate;
    public static ItemStack roller;
    public static ItemStack heatInsulationMaterial;
    public static ItemStack smallCompressedWaterHyacinth;
    public static ItemStack airBrakeUnit;
    public static ItemStack bambooCharcoal;
    public static ItemStack carbonTube;
    public static ItemStack redstoneModule;
    public static ItemStack lazuliModule;
    public static ItemStack obsidianPlateGravityField;
    public static ItemStack electronicCircuitControl;
    public static ItemStack electronicCircuitCore;
    public static ItemStack pulseElectronicCircuitControl;
    public static ItemStack pulseElectronicCircuitCore;
    public static ItemStack cyclotronParticleAccelerator;
    public static ItemStack calculateUnit;
    public static ItemStack calculateChunk;
    public static ItemStack calculateArray;
    public static ItemStack floatPointCalculationsRegion;
    public static ItemStack parallelSpaceConverter;
    public static ItemStack uuMatterCore;
    public static ItemStack obsidianMechanicalFrame;
    public static ItemStack obsidianMechanicalCasing;
    public static ItemStack carbonCrystal;
    public static ItemStack enderCalculationCrystal;
    public static ItemStack millTeeth;
    public static ItemStack millWheel;
    public static ItemStack rigidPaper;
    public static ItemStack rigidPaperPack;
    public static ItemStack advSolarLensUnit;
    public static ItemStack advSolarLensGroup;
    public static ItemStack advSolarLensCluster;
    public static ItemStack tiles;
    public static ItemStack paperBag;
    public static ItemStack corrugatedPaper;
    public static ItemStack woodPulp;
    public static ItemStack sawdust;
    public static ItemStack faggot;

    public static ItemStack firewood;
    public static ItemStack coarseBatten;
    public static ItemStack heatResistantTiles;
    public static Item chain;
    public static ItemStack crudeWood;
    public static ItemStack batten;
    public static ItemStack chainPiece;
    public static ItemStack sprocket;
    public static ItemStack ironChain;
    public static ItemStack steelChain;
    public static ItemStack toothedChain;
    public static ItemStack heatResistantBrick;

    public static void init() {
        diamondApple = new ItemDiamondApple();

        ironTreetap = new ItemPLTreetap("treetap_iron", 32);
        bronzeTreetap = new ItemPLTreetap("treetap_bronze", 32);
        leadTreetap = new ItemPLTreetap("treetap_lead", 48);
        refinedIronTreetap = new ItemPLTreetap("treetap_steel", 64);
        advancedAlloyTreetap = new ItemPLTreetap("treetap_alloy", 64);
        carbonTreetap = new ItemPLTreetap("treetap_carbon", 128);

        record_MusicSpring = new ItemPLRecord("record_musicspring", PLSounds.recordMusicSpring);
        salt = new ItemPLFood("salt", 0, 10F, true);
        ceu = new ItemCEU();
        gravityRay = new ItemGravityRay();

        //MultiMetaItem registry
        itemOre = new ItemOre();
        itemCrafting = new ItemCrafting();

		new ItemDryFood();

        // special registry TODO: Better registry system

        packagedSalt = new ItemPL("packaged_salt") {
            /**
             * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
             */
            @Override
            public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
                if (PLConfig.instance.throwablePackagedSalt) {
                    if (!player.capabilities.isCreativeMode) {
                        --itemStack.stackSize;
                    }
                    world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                    if (!world.isRemote) {
                        world.spawnEntity(new EntityThrownItem(world, player, itemStack));
                    }
                }

                return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
            }

        };

        saltWaterBucket = new ItemBucket(Blocks.WATER);
        saltWaterBucket.setCreativeTab(ProductionLine.creativeTabPL)
                .setUnlocalizedName(MOD_ID + ".saltwater_bucket");

        iridiumPickaxe = ToolPL.registerPickaxe(PLToolMaterial.iridium, "iridium_pickaxe");
        iridiumAxe = ToolPL.registerAxe(PLToolMaterial.iridium, "iridium_axe");
        iridiumSpade = ToolPL.registerSpade(PLToolMaterial.iridium, "iridium_spade");
        iridiumSword = ToolPL.registerSword(PLToolMaterial.iridium, "iridium_sword");

        // TODO: Better registry system
        GameRegistry.<Item>register(saltWaterBucket, new ResourceLocation(MOD_ID, "saltwater_bucket"));
        GameRegistry.registerFuelHandler(new PLItems());
    }

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.isItemEqual(sawdust)) {
            return 50;
        }
        if (fuel.isItemEqual(faggot)) {
            return 1200;
        }
        if (fuel.isItemEqual(crudeWood)) {
            return 100;
        }
        if (fuel.isItemEqual(batten)) {
            return 100;
        }
        if (fuel.isItemEqual(bambooCharcoal)) {
            return 800;
        }
        if (fuel.isItemEqual(smallCompressedWaterHyacinth)) {
            return 400;
        }
        if (fuel.getItem().equals(
                Item.getItemFromBlock(PLBlocks.waterHyacinth))) {
            return 100;
        }
        if (fuel.getItem().equals(
                Item.getItemFromBlock(PLBlocks.dryLog))) {
            return 300;
        }
        if (fuel.isItemEqual(PLBlocks.compressedWaterHyacinth)) {
            return 800;
        }
        if (fuel.isItemEqual(PLBlocks.dehydratedWaterHyacinthblock)) {
            return 1000;
        }
        return 0;
    }

    public static ItemStack getItems(ItemStack itemStack, int count) {
        ItemStack ret = itemStack.copy();
        ret.stackSize = count;
        return ret;
    }
}
