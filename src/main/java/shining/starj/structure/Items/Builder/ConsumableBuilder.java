package shining.starj.structure.Items.Builder;

import org.bukkit.Material;
import shining.starj.structure.Items.ConsumableItems;
import shining.starj.structure.Items.FoodEffectInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsumableBuilder extends ItemsBuilder {
    protected boolean canAlwaysEat;
    protected float eatSeconds;
    protected int nutrition;
    protected float saturation;
    protected List<FoodEffectInfo> foodEffectInfos = new ArrayList<>();

    @Override
    public ConsumableBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @Override
    public ConsumableBuilder material(Material material) {
        this.material = material;
        return this;
    }

    @Override
    public ConsumableBuilder setLores(String... lores) {
        this.lores = Arrays.stream(lores).toList();
        return this;
    }

    @Override
    public ConsumableBuilder addLores(String... lores) {
        this.lores.addAll(List.of(lores));
        return this;
    }

    @Override
    public ConsumableBuilder addLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    @Override
    public ConsumableBuilder getModel(int model) {
        this.model = model;
        return this;
    }

    @Override
    public ConsumableBuilder isInteract(boolean interact) {
        this.interact = interact;
        return this;
    }

    @Override
    public ConsumableBuilder isFireResistant(boolean fireResistant) {
        this.fireResistant = fireResistant;
        return this;
    }

    @Override
    public ConsumableBuilder isGlint(boolean glint) {
        this.glint = glint;
        return this;
    }

    @Override
    public ConsumableBuilder isTooltip(boolean tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public ConsumableBuilder isCanAlwaysEat(boolean canAlwaysEat) {
        this.canAlwaysEat = canAlwaysEat;
        return this;
    }

    public ConsumableBuilder eatSeconds(float eatSeconds) {
        this.eatSeconds = eatSeconds;
        return this;
    }

    public ConsumableBuilder nutrition(int nutrition) {
        this.nutrition = nutrition;
        return this;
    }

    public ConsumableBuilder saturation(float saturation) {
        this.saturation = saturation;
        return this;
    }

    public ConsumableBuilder setFoodEffectInfos(FoodEffectInfo... foodEffectInfos) {
        this.foodEffectInfos = Arrays.stream(foodEffectInfos).toList();
        return this;
    }

    public ConsumableBuilder addFoodEffectInfos(FoodEffectInfo... foodEffectInfos) {
        this.foodEffectInfos.addAll(List.of(foodEffectInfos));
        return this;
    }

    public ConsumableBuilder addFoodEffectInfo(FoodEffectInfo foodEffectInfo) {
        this.foodEffectInfos.add(foodEffectInfo);
        return this;
    }

    @Override
    public ConsumableItems build() {
        return new ConsumableItems(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize, canAlwaysEat, eatSeconds, nutrition, saturation, foodEffectInfos);
    }
}