package shining.starj.structure.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.DragType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Core;
import shining.starj.structure.GUIs.Prework.BagGUI;
import shining.starj.structure.Systems.InventorySize;

import java.util.*;

public abstract class AbstractGUI {
    private static final List<AbstractGUI> guis = new ArrayList<>();
    protected static final HashMap<UUID, String> openGUI = new HashMap<>();
    public static final NamespacedKey prevent = new NamespacedKey(Core.getCore(), "prevent");
    /*
     * 선언부
     */
    public static BagGUI bagGUI = new BagGUI("bag");
    //
    protected final String key;
    protected final String title;
    protected final InventorySize inventorySize;

    public AbstractGUI(String key, String title, InventorySize inventorySize) {
        this.key = key;
        this.title = title;
        this.inventorySize = inventorySize;
        guis.add(this);
    }

    public Inventory openInv(Player player) {
        openGUI.put(player.getUniqueId(), this.key);
        Inventory inv = Bukkit.createInventory(player, inventorySize.getSize(), title);
        player.openInventory(inv);
        return inv;
    }

    public abstract boolean clickInventory(Player player, InventoryView view, Inventory clicked, ItemStack currentItemStack, ItemStack cursorItemstack, ClickType type, InventoryAction action, int slot, int rawSlot, int hotbarButton, InventoryType.SlotType slotType);

    public abstract boolean dragInventory(Player player, InventoryView view, ItemStack oldCursorItemStack, ItemStack cursorItemstack, DragType type, Set<Integer> slot, Set<Integer> rawSlot, Map<Integer, ItemStack> newItems);

    public abstract boolean sortInventory(Player player, InventoryView view, Inventory inventory, List<ItemStack> sorted, InventoryType inventoryType, int rawSlot, int slot);

    public void closeInv(Player player) {
        openGUI.remove(player.getUniqueId());
    }

    public static AbstractGUI getGUI(Player player) {
        UUID uuid = player.getUniqueId();
        String key = openGUI.getOrDefault(uuid, "");
        for (AbstractGUI gui : guis)
            if (gui.key.equals(key)) return gui;
        return null;
    }

    public static void initial() {

    }
}
