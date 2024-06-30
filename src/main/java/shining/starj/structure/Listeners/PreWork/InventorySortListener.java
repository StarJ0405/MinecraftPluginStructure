package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Prework.InventorySortEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

import java.util.*;

@Builder
public class InventorySortListener extends AbstractEventListener {
    /*
     * 인벤토리 정리
     */
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void Events(InventoryClickEvent e) {
        Inventory inventory = e.getClickedInventory();
        int slot = e.getSlot();
        if (e.getClick().equals(ClickType.DOUBLE_CLICK) && (e.getCursor() == null || e.getCursor().getType().equals(Material.AIR)) && (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR))) {
            List<ItemStack> itemStacks = null;
            InventoryType inventoryType = e.getClickedInventory().getType();
            switch (inventoryType) {
                case PLAYER -> {
                    if (slot < 9)
                        itemStacks = new ArrayList<>(Arrays.stream(inventory.getContents()).toList().subList(0, 9).stream().filter(Objects::nonNull).toList());
                    else if (slot < 36)
                        itemStacks = new ArrayList<>(Arrays.stream(inventory.getContents()).toList().subList(9, 36).stream().filter(Objects::nonNull).toList());
                }
                case CHEST, ENDER_CHEST, SHULKER_BOX, BARREL ->
                        itemStacks = new ArrayList<>(Arrays.stream(inventory.getContents()).filter(Objects::nonNull).toList());
            }
            if (itemStacks == null) return;
            InventorySortEvent event = InventorySortEvent.builder().player((Player) e.getWhoClicked()).view(e.getView()).inventory(inventory).sorted(itemStacks).inventoryType(inventoryType).rawSlot(e.getRawSlot()).slot(e.getSlot()).build();
            Bukkit.getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
                HashMap<ItemStack, Integer> map = new HashMap<>();
                a:
                for (ItemStack item : itemStacks) {
                    List<ItemStack> keys = new ArrayList<>(map.keySet());
                    for (ItemStack key : keys)
                        if (key.isSimilar(item)) {
                            int value = map.get(key);
                            map.put(key, value + item.getAmount());
                            continue a;
                        }
                    map.put(item, item.getAmount());
                }
                ItemStack[] content = inventory.getContents();
                if (event.getInventoryType().equals(InventoryType.PLAYER)) {
                    if (slot < 9) {
                        for (int i = 0; i < 9; i++)
                            content[i] = null;
                        int i = 0;
                        for (ItemStack key : map.keySet()) {
                            int value = map.get(key);
                            final int max = key.getMaxStackSize();
                            while (value > 0) {
                                if (value > max) {
                                    value -= max;
                                    key.setAmount(max);
                                    content[i] = key.clone();
                                    i++;
                                } else {
                                    key.setAmount(value);
                                    content[i] = key.clone();
                                    value = 0;
                                    i++;
                                }
                            }
                        }
                    } else if (slot < 36) {
                        for (int i = 9; i < 36; i++)
                            content[i] = null;
                        int i = 0;
                        for (ItemStack key : map.keySet()) {
                            int value = map.get(key);
                            final int max = key.getMaxStackSize();
                            while (value > 0) {
                                if (value > max) {
                                    value -= max;
                                    key.setAmount(max);
                                    content[9 + i] = key.clone();
                                    i++;
                                } else {
                                    key.setAmount(value);
                                    content[9 + i] = key.clone();
                                    value = 0;
                                    i++;
                                }
                            }
                        }
                    }
                } else {
                    content = new ItemStack[content.length];
                    int i = 0;
                    for (ItemStack key : map.keySet()) {
                        int value = map.get(key);
                        final int max = key.getMaxStackSize();
                        while (value > 0) {
                            if (value > max) {
                                value -= max;
                                key.setAmount(max);
                                content[i] = key.clone();
                                i++;
                            } else {
                                key.setAmount(value);
                                content[i] = key.clone();
                                value = 0;
                                i++;
                            }
                        }
                    }
                }
                inventory.setContents(content);
            }
        }
    }
}
