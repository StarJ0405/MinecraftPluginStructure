package shining.starj.structure.Events.Builder;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Prework.ContainerPlaceEvent;

import java.util.List;

public class ContainerPlaceEventBuilder {
    protected Player player;
    protected ItemStack item;
    protected Block placedBlock;
    protected List<ItemStack> stored;

    public ContainerPlaceEventBuilder player(Player player) {
        this.player = player;
        return this;
    }

    public ContainerPlaceEventBuilder item(ItemStack item) {
        this.item = item;
        return this;
    }

    public ContainerPlaceEventBuilder placedBlock(Block placedBlock) {
        this.placedBlock = placedBlock;
        return this;
    }

    public ContainerPlaceEventBuilder stored(List<ItemStack> stored) {
        this.stored = stored;
        return this;
    }

    public ContainerPlaceEvent build() {
        return new ContainerPlaceEvent(player, item, placedBlock, stored);
    }
}
