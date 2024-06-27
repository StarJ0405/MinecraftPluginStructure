package shining.starj.structure.Events.Prework;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.AbstractCancelableEvent;

import java.util.List;

@Getter
public class InventorySortEvent extends AbstractCancelableEvent {
    private final Player player;
    private final InventoryView view;
    private final Inventory inventory;
    private final List<ItemStack> sorted;
    private final InventoryType inventoryType;
    private final int rawSlot;
    private final int slot;

    @Builder
    public InventorySortEvent(Player player, InventoryView view, Inventory inventory, List<ItemStack> sorted, InventoryType inventoryType, int rawSlot, int slot) {
        this.player = player;
        this.view = view;
        this.inventory = inventory;
        this.sorted = sorted;
        this.inventoryType = inventoryType;
        this.rawSlot = rawSlot;
        this.slot = slot;
    }
}
