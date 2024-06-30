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
@Setter
public class HarvestEvent extends AbstractCancelableEvent {
    private boolean fortune; // 행운
    private boolean unbreaking; // 내구성
    private final Player player;
    private final Block block;
    private final ItemStack hoe; // 괭이
    private int exp;
    private final List<RangeItem> rangeItems;
    private boolean rePlant;
    private double damage; // 괭이데미지
    @Builder
    public HarvestEvent(boolean fortune, boolean unbreaking, Player player, Block block, ItemStack hoe, int exp, List<RangeItem> rangeItems, boolean rePlant, double damage) {
        this.fortune = fortune;
        this.unbreaking = unbreaking;
        this.player = player;
        this.block = block;
        this.hoe = hoe;
        this.exp = exp;
        this.rangeItems = rangeItems;
        this.rePlant = rePlant;
        this.damage = damage;
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
