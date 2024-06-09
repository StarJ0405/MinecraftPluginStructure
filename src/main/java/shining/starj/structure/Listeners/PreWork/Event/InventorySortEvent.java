package shining.starj.structure.Listeners.PreWork.Event;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
public class InventorySortEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean canceled;
    private final Inventory inventory;
    private final List<ItemStack> sorted;
    private final InventoryType inventoryType;
    public InventorySortEvent(Inventory inventory, List<ItemStack> sorted, InventoryType inventoryType) {
        this.inventory = inventory;
        this.sorted = sorted;
        this.canceled=false;
        this.inventoryType= inventoryType;
    }
    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean canceled) {
        this.canceled = canceled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
