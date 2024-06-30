package shining.starj.structure.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;


public class DurableItems extends Items {
    //

    //
    protected int maxDurability;
    protected int durability;

    public DurableItems(String key, String displayName, Material material, Integer model, boolean interact, boolean fireResistant, boolean glint, boolean tooltip, boolean unbreakable, String[] lores, Integer maxDurability, int durability) {
        super(key, displayName, material, lores, model, interact, fireResistant, glint, tooltip, unbreakable, 1);
        this.maxDurability = Math.max(1, maxDurability != null ? maxDurability : material.getMaxDurability());
        this.durability = Math.min(durability, this.maxDurability - 1);
    }

    public static DurableItemsBuilder builder() {
        return new DurableItemsBuilder();
    }

    public static class DurableItemsBuilder extends Items.ItemsBuilder {
        protected int maxDurability;
        protected int durability;

        @Override
        public DurableItemsBuilder key(String key) {
            return (DurableItemsBuilder) super.key(key);
        }

        @Override
        public DurableItemsBuilder displayName(String displayName) {
            return (DurableItemsBuilder) super.displayName(displayName);
        }

        @Override
        public DurableItemsBuilder material(Material material) {
            return (DurableItemsBuilder) super.material(material);
        }

        @Override
        public DurableItemsBuilder lores(String[] lores) {
            return (DurableItemsBuilder) super.lores(lores);
        }

        @Override
        public DurableItemsBuilder model(Integer model) {
            return (DurableItemsBuilder) super.model(model);
        }

        @Override
        public DurableItemsBuilder interact(boolean interact) {
            return (DurableItemsBuilder) super.interact(interact);
        }

        @Override
        public DurableItemsBuilder fireResistant(boolean fireResistant) {
            return (DurableItemsBuilder) super.fireResistant(fireResistant);
        }

        @Override
        public DurableItemsBuilder glint(boolean glint) {
            return (DurableItemsBuilder) super.glint(glint);
        }

        @Override
        public DurableItemsBuilder tooltip(boolean tooltip) {
            return (DurableItemsBuilder) super.tooltip(tooltip);
        }

        @Override
        public DurableItemsBuilder unbreakable(boolean unbreakable) {
            return (DurableItemsBuilder) super.unbreakable(unbreakable);
        }

        @Override
        public DurableItemsBuilder maxStackSize(int maxStackSize) {
            return (DurableItemsBuilder) super.maxStackSize(maxStackSize);
        }

        public DurableItemsBuilder maxDurability(int maxDurability) {
            this.maxDurability = maxDurability;
            return this;
        }

        public DurableItemsBuilder durability(int durability) {
            this.durability = durability;
            return this;
        }

        @Override
        public DurableItems build() {
            return new DurableItems(key, displayName, material, model, interact, fireResistant, hideGlint, hideTooltip, unbreakable, lores, maxDurability, durability);
        }
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

    public static void initial() {

    }
}
