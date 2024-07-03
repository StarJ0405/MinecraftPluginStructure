package shining.starj.structure.GUIs.Prework;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.DragType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import shining.starj.structure.Core;
import shining.starj.structure.GUIs.AbstractFrameGUI;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Items.Prework.BagItem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BagGUI extends AbstractFrameGUI {
    @Builder
    public BagGUI(String key) {
        super(key);
    }

    @Override
    public boolean clickInventory(Player player, InventoryView view, Inventory clicked, ItemStack currentItemStack, ItemStack cursorItemstack, ClickType type, InventoryAction action, int slot, int rawSlot, int hotbarButton, InventoryType.SlotType slotType) {
        ItemStack held = player.getInventory().getItemInMainHand();
        if (currentItemStack != null) {
            if (currentItemStack.hasItemMeta()) {
                ItemMeta meta = currentItemStack.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                if (container.has(prevent)) return true;
            }
            Items item = Items.valueOf(held);
            if (item instanceof BagItem bag && !bag.isAllow(currentItemStack)) return true;

        }
        if (type.equals(ClickType.NUMBER_KEY)) {
            ItemStack hotbar = player.getInventory().getItem(hotbarButton);
            if (hotbar != null) {
                if (hotbar.hasItemMeta()) {
                    ItemMeta meta = hotbar.getItemMeta();
                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(prevent)) return true;
                }

                Items item = Items.valueOf(held);
                if (item instanceof BagItem bag && !bag.isAllow(hotbar)) return true;
            }
        }
        if (held != null && held.getType().name().contains("SHULKER")) {
            if (held.getItemMeta() instanceof BlockStateMeta meta && meta.getBlockState() instanceof ShulkerBox box)
                Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
                    box.getInventory().setContents(view.getTopInventory().getContents());
                    meta.setBlockState(box);
                    Items items = Items.valueOf(held);
                    if (items != null) {
                        int model = 0;
                        for (ItemStack test : view.getTopInventory().getContents())
                            if (test != null)
                                model++;
                        meta.setCustomModelData(items.getModel() + model);
                    }
                    held.setItemMeta(meta);
                    player.getInventory().setItem(player.getInventory().getHeldItemSlot(), held);
                }, 1);
        }

        return false;
    }

    @Override
    public boolean dragInventory(Player player, InventoryView view, ItemStack oldCursorItemStack, ItemStack cursorItemstack, DragType type, Set<Integer> slot, Set<Integer> rawSlot, Map<Integer, ItemStack> newItems) {
        ItemStack held = player.getInventory().getItemInMainHand();
        if (held.getItemMeta() instanceof BlockStateMeta meta && meta.getBlockState() instanceof ShulkerBox box)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
                box.getInventory().setContents(view.getTopInventory().getContents());
                meta.setBlockState(box);
                Items items = Items.valueOf(held);
                if (items != null) {
                    int model = 0;
                    for (ItemStack test : view.getTopInventory().getContents())
                        if (test != null)
                            model++;
                    meta.setCustomModelData(items.getModel() + model);
                }
                held.setItemMeta(meta);
                player.getInventory().setItem(player.getInventory().getHeldItemSlot(), held);
            }, 1);

        return false;
    }

    @Override
    public boolean sortInventory(Player player, InventoryView view, Inventory inventory, List<ItemStack> sorted, InventoryType inventoryType, int rawSlot, int slot) {
        return inventoryType.equals(InventoryType.PLAYER) && rawSlot >= view.getTopInventory().getSize() && slot < 9;
    }
}
