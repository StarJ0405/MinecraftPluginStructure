package shining.starj.structure.Events.Prework;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.AbstractCancelableEvent;

import java.util.List;

@Getter
public class ContainerPickupEvent extends AbstractCancelableEvent {
    private final Player player;
    private final Block block;
    private final List<ItemStack> stored;

    @Builder
    public ContainerPickupEvent(Player player, Block block, List<ItemStack> stored) {
        this.player = player;
        this.block = block;
        this.stored = stored;
    }
}
