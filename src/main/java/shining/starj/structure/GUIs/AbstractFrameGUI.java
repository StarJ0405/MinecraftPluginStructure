package shining.starj.structure.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import shining.starj.structure.Systems.InventorySize;

public abstract class AbstractFrameGUI extends AbstractGUI {
    public AbstractFrameGUI(String key) {
        super(key, "", null);
    }

    @Deprecated
    @Override
    public Inventory openInv(Player player) {
        return null;
    }

    public Inventory openInv(Player player, String title, InventorySize inventorySize) {
        openGUI.put(player.getUniqueId(), this.key);
        Inventory inv = Bukkit.createInventory(player, inventorySize.getSize(), title);
        player.openInventory(inv);
        return inv;
    }
}
