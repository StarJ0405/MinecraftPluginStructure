package shining.starj.structure.Events.Prework;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
@Setter
public class FuelContainerPlaceEvent extends ContainerPlaceEvent {
    private short burnTime;
    private short cookTime;
    private int cookTimeTotal;

    public FuelContainerPlaceEvent(Player player, ItemStack item, Block placedBlock, List<ItemStack> stored, short burnTime, short cookTime, int cookTimeTotal) {
        super(player, item, placedBlock, stored);
        this.burnTime = burnTime;
        this.cookTime = cookTime;
        this.cookTimeTotal = cookTimeTotal;
    }

    public static FuelContainerPlaceEventBuilder builder() {
        return new FuelContainerPlaceEventBuilder();
    }

    public static class FuelContainerPlaceEventBuilder extends ContainerPlaceEvent.ContainerPlaceEventBuilder {
        private Player player;
        private ItemStack item;
        private Block placedBlock;
        private List<ItemStack> stored;
        private short burnTime;
        private short cookTime;
        private int cookTimeTotal;

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

        @Override
        public FuelContainerPlaceEvent build() {
            return new FuelContainerPlaceEvent(player, item, placedBlock, stored, burnTime, cookTime, cookTimeTotal);
        }
    }

}
