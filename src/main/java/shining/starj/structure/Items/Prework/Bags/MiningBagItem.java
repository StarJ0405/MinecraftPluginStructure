package shining.starj.structure.Items.Prework.Bags;

import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Items.Prework.AbstractBagItem;

import java.util.Arrays;

public class MiningBagItem extends AbstractBagItem {
    public MiningBagItem(String key, String displayName, BagColor bagColor, int model, String[] lores, InventorySize inventorySize) {
        super(key, displayName, bagColor, model, Arrays.stream(lores).toList(), inventorySize);
    }

    @Override
    public boolean isAllow(ItemStack item) {
        if (item != null) {
            switch (item.getType()) {
                case COAL_ORE, DEEPSLATE_COAL_ORE, COAL, COAL_BLOCK, COPPER_ORE, DEEPSLATE_COPPER_ORE, RAW_COPPER, RAW_COPPER_BLOCK, COPPER_INGOT, COPPER_BLOCK, IRON_ORE, DEEPSLATE_IRON_ORE, RAW_IRON, RAW_IRON_BLOCK, IRON_NUGGET, IRON_INGOT, IRON_BLOCK, NETHER_GOLD_ORE, GOLD_ORE, DEEPSLATE_GOLD_ORE, RAW_GOLD, RAW_GOLD_BLOCK, GOLD_NUGGET, GOLD_INGOT, GOLD_BLOCK, LAPIS_ORE, DEEPSLATE_LAPIS_ORE, LAPIS_LAZULI, LAPIS_BLOCK, REDSTONE_ORE, DEEPSLATE_REDSTONE_ORE, REDSTONE, REDSTONE_BLOCK, DIAMOND_ORE, DEEPSLATE_DIAMOND_ORE, DIAMOND, DIAMOND_BLOCK, DEEPSLATE_EMERALD_ORE, EMERALD_ORE, EMERALD, EMERALD_BLOCK, ANCIENT_DEBRIS, NETHERITE_SCRAP, NETHERITE_INGOT, NETHERITE_BLOCK, NETHER_QUARTZ_ORE, QUARTZ, QUARTZ_BLOCK -> {
                    return true;
                }
            }
        }
        return false;
    }
}
