package shining.starj.structure.Items.Prework.Bags;

import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Items.Prework.AbstractBagItem;

import java.util.Arrays;

public class AllBagItem extends AbstractBagItem {
    public AllBagItem(String key, String displayName, BagColor bagColor, int model, String[] lores, InventorySize inventorySize) {
        super(key, displayName, bagColor, model, Arrays.stream(lores).toList(), inventorySize);
    }

    @Override
    public boolean isAllow(ItemStack item) {
        if (item != null) {
            switch (item.getType()) {
                case SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, BROWN_SHULKER_BOX, LIME_SHULKER_BOX, MAGENTA_SHULKER_BOX, ORANGE_SHULKER_BOX, PINK_SHULKER_BOX, RED_SHULKER_BOX, PURPLE_SHULKER_BOX, WHITE_SHULKER_BOX, YELLOW_SHULKER_BOX, CYAN_SHULKER_BOX, GRAY_SHULKER_BOX, GREEN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX -> {
                    return false;
                }
            }
        }
        return true;
    }
}
