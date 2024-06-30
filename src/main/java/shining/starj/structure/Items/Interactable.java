package shining.starj.structure.Items;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Interactable {
    // false = 기본 이벤트 캔슬, true = 기본 이벤트 발생
    default boolean left(Player player, ItemStack item, Block block) {
        return false;
    }

    default boolean right(Player player, ItemStack item, Block block) {
        return false;
    }

    default boolean swap(Player player, ItemStack item) {
        return false;
    }

    default boolean entity(Player player, ItemStack item, Entity target) {
        return false;
    }

    default boolean drop(Player player, ItemStack item) {
        return false;
    }

    default boolean pickup(Player player, ItemStack item, Item entity, int slot) {
        return false;
    }
}
