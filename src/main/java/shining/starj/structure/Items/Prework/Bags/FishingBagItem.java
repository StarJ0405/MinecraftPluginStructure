package shining.starj.structure.Items.Prework.Bags;

import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Items.Prework.AbstractBagItem;

import java.util.Arrays;

public class FishingBagItem extends AbstractBagItem {
    public FishingBagItem(String key, String displayName, BagColor bagColor, int model, String[] lores, InventorySize inventorySize) {
        super(key, displayName, bagColor, model, Arrays.stream(lores).toList(), inventorySize);
    }

    @Override
    public boolean isAllow(ItemStack item) {
        if (item != null) {
            switch (item.getType()) {
                case TROPICAL_FISH, COD, SALMON, PUFFERFISH -> {
                    return true;
                }
            }
        }
        return false;
    }
}
