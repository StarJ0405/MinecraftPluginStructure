package shining.starj.structure.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import shining.starj.structure.Items.Builders.DurableItemsBuilder;

import java.util.List;

public class DurableItems extends Items {
    protected final int maxDurability;
    protected final int durability;

    public DurableItems(String key, String displayName, Material material, int model, boolean interact, boolean fireResistant, boolean glint, boolean tooltip, boolean unbreakable, List<String> lores, int maxStackSize, int maxDurability, int durability) {
        super(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize);
        this.maxDurability = Math.max(1, maxDurability);
        this.durability = Math.min(durability, material.getMaxDurability() - 1);
    }

    @Override
    public ItemStack getItemStack() {
        ItemStack item = super.getItemStack();
        ItemMeta meta = item.getItemMeta();
        if (meta instanceof Damageable damageable) {
            damageable.setMaxDamage(maxDurability);
            damageable.setDamage(durability);
            item.setItemMeta(meta);
        }
        return item;
    }

    public static DurableItemsBuilder builder() {
        return new DurableItemsBuilder();
    }
}
