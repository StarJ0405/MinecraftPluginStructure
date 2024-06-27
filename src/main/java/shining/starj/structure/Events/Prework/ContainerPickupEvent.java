package shining.starj.structure.Events.Prework;

import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.AbstractCancelableEvent;
import shining.starj.structure.Events.Builder.ContainerPickupEventBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ContainerPickupEvent extends AbstractCancelableEvent {
    private final Player player;
    private final Block block;
    private final List<ItemStack> stored;

    public ContainerPickupEvent(Player player, Block block, List<ItemStack> stored) {
        this.player = player;
        this.block = block;
        this.stored = stored != null ? stored : new ArrayList<>();
    }

    public final static ContainerPickupEventBuilder ContainerPickupEventBuilder = new ContainerPickupEventBuilder();

    public static ContainerPickupEventBuilder builder() {
        return ContainerPickupEventBuilder;
    }
}
