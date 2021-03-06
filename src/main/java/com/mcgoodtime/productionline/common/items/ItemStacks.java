package com.mcgoodtime.productionline.common.items;

import ic2.core.util.ItemComparableItemStack;
import net.minecraft.item.ItemStack;

/**
 * Utilities
 */
public final class ItemStacks {

    public static ItemComparableItemStack viewOf(ItemStack stack) {
        return new ItemComparableItemStack(stack, true);
    }

    public static ItemComparableItemStack typeOf(ItemStack stack) {
        return new ItemComparableItemStack(stack, false);
    }

    private ItemStacks() {}
}
