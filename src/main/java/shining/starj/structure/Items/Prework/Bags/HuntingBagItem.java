package shining.starj.structure.Items.Prework.Bags;

import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Items.Prework.AbstractBagItem;

import java.util.Arrays;

public class HuntingBagItem extends AbstractBagItem {
    public HuntingBagItem(String key, String displayName, BagColor bagColor, int model, String[] lores, InventorySize inventorySize) {
        super(key, displayName, bagColor, model, Arrays.stream(lores).toList(), inventorySize);
    }

    @Override
    public boolean isAllow(ItemStack item) {
        if (item != null) {
            switch (item.getType()) {
                case BEEF, COOKED_BEEF, PORKCHOP, COOKED_PORKCHOP, CHICKEN, COOKED_CHICKEN, MUTTON, COOKED_MUTTON, RABBIT, COOKED_RABBIT -> {
                    return true;
                }
            }
        }
        return false;
    }
}
