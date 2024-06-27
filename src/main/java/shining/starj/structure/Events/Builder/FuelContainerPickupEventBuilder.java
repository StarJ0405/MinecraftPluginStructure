package shining.starj.structure.Events.Builder;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Prework.FuelContainerPickupEvent;

import java.util.List;

public class FuelContainerPickupEventBuilder extends ContainerPickupEventBuilder {
    protected short burnTime;
    protected short cookTime;
    protected int cookTimeTotal;

    @Override
    public FuelContainerPickupEventBuilder player(Player player) {
        this.player = player;
        return this;
    }

    @Override
    public FuelContainerPickupEventBuilder block(Block block) {
        this.block = block;
        return this;
    }

    @Override
    public FuelContainerPickupEventBuilder stored(List<ItemStack> stored) {
        this.stored = stored;
        return this;
    }

    public FuelContainerPickupEventBuilder burnTime(short burnTime) {
        this.burnTime = burnTime;
        return this;
    }

    public FuelContainerPickupEventBuilder cookTime(short cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public FuelContainerPickupEventBuilder cookTimeTotal(int cookTimeTotal) {
        this.cookTimeTotal = cookTimeTotal;
        return this;
    }

    @Override
    public FuelContainerPickupEvent build() {
        return new FuelContainerPickupEvent(player, block, stored, burnTime, cookTime, cookTimeTotal);
    }
}
