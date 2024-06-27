package shining.starj.structure.Items.Builders;

import org.bukkit.Material;
import shining.starj.structure.Items.ConsumableItems;
import shining.starj.structure.Items.FoodEffectInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsumableItemsBuilder extends ItemsBuilder {
    protected boolean canAlwaysEat;
    protected float eatSeconds;
    protected int nutrition;
    protected float saturation;
    protected List<FoodEffectInfo> foodEffectInfos = new ArrayList<>();

    @Override
    public ConsumableItemsBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @Override
    public ConsumableItemsBuilder material(Material material) {
        this.material = material;
        return this;
    }

    @Override
    public ConsumableItemsBuilder setLores(String... lores) {
        this.lores = Arrays.stream(lores).toList();
        return this;
    }

    @Override
    public ConsumableItemsBuilder addLores(String... lores) {
        this.lores.addAll(List.of(lores));
        return this;
    }

    @Override
    public ConsumableItemsBuilder addLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    @Override
    public ConsumableItemsBuilder getModel(int model) {
        this.model = model;
        return this;
    }

    @Override
    public ConsumableItemsBuilder isInteract(boolean interact) {
        this.interact = interact;
        return this;
    }

    @Override
    public ConsumableItemsBuilder isFireResistant(boolean fireResistant) {
        this.fireResistant = fireResistant;
        return this;
    }

    @Override
    public ConsumableItemsBuilder isGlint(boolean glint) {
        this.glint = glint;
        return this;
    }

    @Override
    public ConsumableItemsBuilder isTooltip(boolean tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public ConsumableItemsBuilder isCanAlwaysEat(boolean canAlwaysEat) {
        this.canAlwaysEat = canAlwaysEat;
        return this;
    }

    public ConsumableItemsBuilder eatSeconds(float eatSeconds) {
        this.eatSeconds = eatSeconds;
        return this;
    }

    public ConsumableItemsBuilder nutrition(int nutrition) {
        this.nutrition = nutrition;
        return this;
    }

    public ConsumableItemsBuilder saturation(float saturation) {
        this.saturation = saturation;
        return this;
    }

    public ConsumableItemsBuilder setFoodEffectInfos(FoodEffectInfo... foodEffectInfos) {
        this.foodEffectInfos = Arrays.stream(foodEffectInfos).toList();
        return this;
    }

    public ConsumableItemsBuilder addFoodEffectInfos(FoodEffectInfo... foodEffectInfos) {
        this.foodEffectInfos.addAll(List.of(foodEffectInfos));
        return this;
    }

    public ConsumableItemsBuilder addFoodEffectInfo(FoodEffectInfo foodEffectInfo) {
        this.foodEffectInfos.add(foodEffectInfo);
        return this;
    }

    @Override
    public ConsumableItems build() {
        return new ConsumableItems(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize, canAlwaysEat, eatSeconds, nutrition, saturation, foodEffectInfos);
    }
}