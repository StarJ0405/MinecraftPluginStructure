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
}
