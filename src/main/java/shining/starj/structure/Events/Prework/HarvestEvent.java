package shining.starj.structure.Events.Prework;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.AbstractCancelableEvent;

import java.util.List;
import java.util.Random;

@Getter
public class HarvestEvent extends AbstractCancelableEvent {
    @Setter
    private boolean fortune; // 행운
    @Setter
    private boolean unbreaking; // 내구성
    private final Player player;
    private final Block block;
    private final ItemStack hoe; // 괭이
    @Setter
    private int exp;
    private final List<RangeItem> rangeItems;
    @Setter
    private boolean rePlant;
    private double damage; // 괭이데미지

    @Builder
    public HarvestEvent(Player player, Block block, ItemStack hoe, int exp, List<RangeItem> rangeItems) {
        this.player = player;
        this.block = block;
        this.exp = exp;
        this.rangeItems = rangeItems;
        this.rePlant = false;
        this.hoe = hoe;
        this.fortune = true;
        this.unbreaking = true;
    }

    @Setter
    public static class RangeItem {
        private final ItemStack item;
        private final int min;
        private final int max;
        private final boolean fortune; // 행운 여부

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
