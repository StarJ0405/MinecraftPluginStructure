package shining.starj.structure.Listeners.PreWork.Event;

import lombok.Builder;
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
import java.util.Random;

@Getter
public class HarvestEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean canceled;
    @Setter
    private boolean fortune;
    @Setter
    private boolean unbreaking;
    private final Player player;
    private final Block block;
    private final ItemStack hoe;
    @Setter
    private int exp;
    private final List<RangeItem> rangeItems;
    @Setter
    private boolean rePlant;

    @Builder
    public HarvestEvent(Player player, Block block, ItemStack hoe, int exp, List<RangeItem> rangeItems) {
        this.canceled = false;
        this.player = player;
        this.block = block;
        this.exp = exp;
        this.rangeItems = rangeItems;
        this.rePlant = false;
        this.hoe = hoe;
        this.fortune = true;
        this.unbreaking = true;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean canceled) {
        this.canceled = canceled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Setter
    public static class RangeItem {
        private final ItemStack item;
        private final int min;
        private final int max;
        private final boolean fortune;

        @Builder
        public RangeItem(ItemStack item, Integer min, Integer max, Integer length, boolean fortune) {
            this.item = item;
            length = length != null ? length : 0;
            this.min = min != null ? min : length;
            this.max = max != null ? max : length;
            this.fortune = fortune;
        }

        public ItemStack getItem(int fortune) {
            int dif = this.fortune ? (max + fortune) - min : max - min;
            int amount = min + (dif > 0 ? new Random().nextInt(dif) : 0);
            item.setAmount(amount);
            return item;
        }
    }
}
