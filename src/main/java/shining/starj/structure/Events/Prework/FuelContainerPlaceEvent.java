package shining.starj.structure.Events.Prework;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Builder.FuelContainerPlaceEventBuilder;

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

    public static final FuelContainerPlaceEventBuilder FuelContainerPlaceEventBuilder = new FuelContainerPlaceEventBuilder();

    public static FuelContainerPlaceEventBuilder builder() {
        return FuelContainerPlaceEventBuilder;
    }

}
