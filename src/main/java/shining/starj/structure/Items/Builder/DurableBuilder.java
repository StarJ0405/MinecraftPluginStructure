package shining.starj.structure.Items.Builder;

import org.bukkit.Material;
import shining.starj.structure.Items.DurableItems;

import java.util.Arrays;
import java.util.List;

public class DurableBuilder extends ItemsBuilder {
    protected int maxDurability;
    protected int durability;

    @Override
    public DurableBuilder key(String key) {
        this.key = key;
        return this;
    }

    @Override
    public DurableBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @Override
    public DurableBuilder material(Material material) {
        this.material = material;
        return this;
    }

    @Override
    public DurableBuilder setLores(String... lores) {
        this.lores = Arrays.stream(lores).toList();
        return this;
    }

    @Override
    public DurableBuilder addLores(String... lores) {
        this.lores.addAll(List.of(lores));
        return this;
    }

    @Override
    public DurableBuilder addLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    @Override
    public DurableBuilder getModel(int model) {
        this.model = model;
        return this;
    }

    @Override
    public DurableBuilder isInteract(boolean interact) {
        this.interact = interact;
        return this;
    }

    @Override
    public DurableBuilder isFireResistant(boolean fireResistant) {
        this.fireResistant = fireResistant;
        return this;
    }

    @Override
    public DurableBuilder isGlint(boolean glint) {
        this.glint = glint;
        return this;
    }

    @Override
    public DurableBuilder isTooltip(boolean tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    @Override
    public DurableBuilder isUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    @Override
    public DurableBuilder setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }

    @Override
    public DurableItems build() {
        return new DurableItems(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize, maxDurability, durability);
    }
}