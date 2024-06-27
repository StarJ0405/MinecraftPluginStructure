package shining.starj.structure.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public abstract class AbstractTypedGUI extends AbstractGUI {
    protected InventoryType inventoryType;

    public AbstractTypedGUI(String key, String title, InventoryType inventoryType) {
        super(key, title, null);
        this.inventoryType = inventoryType;
    }

    @Override
    public Inventory openInv(Player player) {
        Inventory inv = Bukkit.createInventory(player, inventoryType, title);
        openGUI.put(player.getUniqueId(), this.key);
        player.openInventory(inv);
        return inv;
    }

}
