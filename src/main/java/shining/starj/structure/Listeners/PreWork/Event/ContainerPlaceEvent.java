package shining.starj.structure.Listeners.PreWork.Event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
@Setter
public class ContainerPlaceEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean canceled;
    private final Player player;
    private ItemStack item;
    private Block placedBlock;
    private List<ItemStack> stored;

    public ContainerPlaceEvent(Player player, ItemStack item, Block placedBlock, List<ItemStack> stored) {
        this.player = player;
        this.item = item;
        this.placedBlock = placedBlock;
        this.stored = stored;
        this.canceled = false;
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
