package shining.starj.structure.Events.Prework;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.AbstractCancelableEvent;

import java.util.List;

@Getter
@Setter

public class ContainerPlaceEvent extends AbstractCancelableEvent {
    private final Player player;
    private ItemStack item;
    private Block placedBlock;
    private List<ItemStack> stored;

    @Builder
    public ContainerPlaceEvent(Player player, ItemStack item, Block placedBlock, List<ItemStack> stored) {
        this.player = player;
        this.item = item;
        this.placedBlock = placedBlock;
        this.stored = stored;
    }
}
