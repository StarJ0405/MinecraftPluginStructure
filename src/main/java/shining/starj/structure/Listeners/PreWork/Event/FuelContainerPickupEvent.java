package shining.starj.structure.Listeners.PreWork.Event;

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

}
