package shining.starj.structure.Items.Builders;

import org.bukkit.Material;
import shining.starj.structure.Items.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsBuilder {
    protected String key = null;
    protected String displayName = null;
    protected Material material = null;
    protected List<String> lores = new ArrayList<>();
    protected int model = 0;
    protected boolean interact = false;
    protected boolean fireResistant = false;
    protected boolean glint = false;
    protected boolean tooltip = false;
    protected boolean unbreakable = false;
    protected int maxStackSize = 1;

    public ItemsBuilder key(String key) {
        this.key = key;
        return this;
    }

    public ItemsBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemsBuilder material(Material material) {
        this.material = material;
        return this;
    }

    public ItemsBuilder setLores(String... lores) {
        this.lores = Arrays.stream(lores).toList();
        return this;
    }

    public ItemsBuilder addLores(String... lores) {
        this.lores.addAll(List.of(lores));
        return this;
    }

    public ItemsBuilder addLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    public ItemsBuilder getModel(int model) {
        this.model = model;
        return this;
    }

    public ItemsBuilder isInteract(boolean interact) {
        this.interact = interact;
        return this;
    }

    public ItemsBuilder isFireResistant(boolean fireResistant) {
        this.fireResistant = fireResistant;
        return this;
    }

    public ItemsBuilder isGlint(boolean glint) {
        this.glint = glint;
        return this;
    }

    public ItemsBuilder isTooltip(boolean tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public ItemsBuilder isUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public ItemsBuilder setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }

    public Items build() {
        return new Items(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize);
    }
}