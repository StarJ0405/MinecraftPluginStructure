package shining.starj.structure.Events.Builder;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Prework.FuelContainerPlaceEvent;

import java.util.List;

public class FuelContainerPlaceEventBuilder extends ContainerPlaceEventBuilder {
    protected short burnTime;
    protected short cookTime;
    protected int cookTimeTotal;

    @Override
    public FuelContainerPlaceEventBuilder player(Player player) {
        this.player = player;
        return this;
    }

    @Override
    public FuelContainerPlaceEventBuilder item(ItemStack item) {
        this.item = item;
        return this;
    }

    @Override
    public FuelContainerPlaceEventBuilder placedBlock(Block placedBlock) {
        this.placedBlock = placedBlock;
        return this;
    }

    @Override
    public FuelContainerPlaceEventBuilder stored(List<ItemStack> stored) {
        this.stored = stored;
        return this;
    }

    public FuelContainerPlaceEventBuilder burnTime(short burnTime) {
        this.burnTime = burnTime;
        return this;
    }

    public FuelContainerPlaceEventBuilder cookTime(short cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public FuelContainerPlaceEventBuilder cookTimeTotal(int cookTimeTotal) {
        this.cookTimeTotal = cookTimeTotal;
        return this;
    }

    public FuelContainerPlaceEvent build() {
        return new FuelContainerPlaceEvent(player, item, placedBlock, stored, burnTime, cookTime, cookTimeTotal);
    }
}
