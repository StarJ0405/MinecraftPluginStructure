package shining.starj.structure.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public abstract class AbstractSingletonGUI extends AbstractGUI {
    protected final Inventory inv;

    public AbstractSingletonGUI(String key, String title, InventorySize inventorySize) {
        super(key, title, inventorySize);
        this.inv = Bukkit.createInventory(null, inventorySize.getSize(), title);
    }

    @Override
    public Inventory openInv(Player player) {
        openGUI.put(player.getUniqueId(), this.key);
        player.openInventory(inv);
        return inv;
    }
}
