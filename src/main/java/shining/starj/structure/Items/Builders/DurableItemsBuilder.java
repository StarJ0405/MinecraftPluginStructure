package shining.starj.structure.Items.Builders;

import org.bukkit.Material;
import shining.starj.structure.Items.DurableItems;

import java.util.Arrays;
import java.util.List;

public class DurableItemsBuilder extends ItemsBuilder {
    protected int maxDurability;
    protected int durability;

    @Override
    public DurableItemsBuilder key(String key) {
        this.key = key;
        return this;
    }

    @Override
    public DurableItemsBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @Override
    public DurableItemsBuilder material(Material material) {
        this.material = material;
        return this;
    }

    @Override
    public DurableItemsBuilder setLores(String... lores) {
        this.lores = Arrays.stream(lores).toList();
        return this;
    }

    @Override
    public DurableItemsBuilder addLores(String... lores) {
        this.lores.addAll(List.of(lores));
        return this;
    }

    @Override
    public DurableItemsBuilder addLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    @Override
    public DurableItemsBuilder getModel(int model) {
        this.model = model;
        return this;
    }

    @Override
    public DurableItemsBuilder isInteract(boolean interact) {
        this.interact = interact;
        return this;
    }

    @Override
    public DurableItemsBuilder isFireResistant(boolean fireResistant) {
        this.fireResistant = fireResistant;
        return this;
    }

    @Override
    public DurableItemsBuilder isGlint(boolean glint) {
        this.glint = glint;
        return this;
    }

    @Override
    public DurableItemsBuilder isTooltip(boolean tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    @Override
    public DurableItemsBuilder isUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    @Override
    public DurableItemsBuilder setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }

    @Override
    public DurableItems build() {
        return new DurableItems(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize, maxDurability, durability);
    }
}