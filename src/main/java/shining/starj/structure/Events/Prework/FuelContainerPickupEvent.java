package shining.starj.structure.Events.Prework;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
@Setter
public class FuelContainerPickupEvent extends ContainerPickupEvent {
    private short burnTime;
    private short cookTime;
    private int cookTimeTotal;

    public FuelContainerPickupEvent(Player player, Block block, List<ItemStack> stored, short burnTime, short cookTime, int cookTimeTotal) {
        super(player, block, stored);
        this.burnTime = burnTime;
        this.cookTime = cookTime;
        this.cookTimeTotal = cookTimeTotal;
    }

    public static FuelContainerPickupEventBuilder builder() {
        return new FuelContainerPickupEventBuilder();
    }

    public static class FuelContainerPickupEventBuilder extends ContainerPickupEvent.ContainerPickupEventBuilder {
        private Player player;
        private Block block;
        private List<ItemStack> stored;
        private short burnTime;
        private short cookTime;
        private int cookTimeTotal;

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
}
