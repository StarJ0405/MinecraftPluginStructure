package shining.starj.structure.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public abstract class AbstractTypedSingletonGUI extends AbstractTypedGUI {
    protected final Inventory inv;

    public AbstractTypedSingletonGUI(String key, String title, InventoryType inventoryType) {
        super(key, title, inventoryType);
        this.inv = Bukkit.createInventory(null, inventoryType, title);
    }

    @Override
    public Inventory openInv(Player player) {
        openGUI.put(player.getUniqueId(), this.key);
        player.openInventory(inv);
        return inv;
    }
}
