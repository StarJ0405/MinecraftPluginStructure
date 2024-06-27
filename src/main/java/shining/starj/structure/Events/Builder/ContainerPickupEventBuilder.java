package shining.starj.structure.Events.Builder;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Prework.ContainerPickupEvent;

import java.util.List;

public class ContainerPickupEventBuilder {
    protected Player player;
    protected Block block;
    protected List<ItemStack> stored;

    public ContainerPickupEventBuilder player(Player player) {
        this.player = player;
        return this;
    }

    public ContainerPickupEventBuilder block(Block block) {
        this.block = block;
        return this;
    }

    public ContainerPickupEventBuilder stored(List<ItemStack> stored) {
        this.stored = stored;
        return this;
    }

    public ContainerPickupEvent build() {
        return new ContainerPickupEvent(player, block, stored);
    }
}
