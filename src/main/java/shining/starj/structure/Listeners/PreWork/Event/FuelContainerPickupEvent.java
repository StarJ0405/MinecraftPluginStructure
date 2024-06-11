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
public class ContainerPickupEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean canceled;
    private final Player player;
    private final Block block;
    private final List<ItemStack> stored;
    @Setter
    private ItemStack result;


    public ContainerPickupEvent(Player player, Block block, List<ItemStack> stored, ItemStack result) {
        this.player = player;
        this.block = block;
        this.stored = stored;
        this.canceled = false;
        this.result = result;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.canceled = cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
