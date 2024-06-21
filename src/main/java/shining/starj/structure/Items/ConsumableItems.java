package shining.starj.structure.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.FoodComponent;
import shining.starj.structure.Items.Builder.ConsumableBuilder;

import java.util.List;

public class ConsumableItems extends Items {
    private final boolean canAlwaysEat;
    private final float eatSeconds;
    private final int nutrition;
    private final float saturation;
    private final List<FoodEffectInfo> foodEffectInfos;

    public ConsumableItems(String key, String displayName, Material material, int model, boolean interact, boolean fireResistant, boolean glint, boolean tooltip, boolean unbreakable, List<String> lores, int maxStackSize, boolean canAlwaysEat, Float eatSeconds, Integer nutrition, float saturation, List<FoodEffectInfo> foodEffectInfos) {
        super(key, displayName, material, model, interact, fireResistant, glint, tooltip, unbreakable, lores, maxStackSize);
        this.canAlwaysEat = canAlwaysEat;
        this.eatSeconds = eatSeconds != null ? eatSeconds : 1f;
        this.nutrition = nutrition != null ? nutrition : 1;
        this.saturation = saturation;
        this.foodEffectInfos = foodEffectInfos;
    }

    @Override
    public ItemStack getItemStack() {
        ItemStack item = super.getItemStack();
        ItemMeta meta = item.getItemMeta();
        FoodComponent foodComponent = meta.getFood();
        foodComponent.setCanAlwaysEat(canAlwaysEat);
        foodComponent.setEatSeconds(eatSeconds);
        foodComponent.setNutrition(nutrition);
        foodComponent.setSaturation(saturation);
        for (FoodEffectInfo info : foodEffectInfos)
            foodComponent.addEffect(info.getPotionEffect(), info.getProbability());
        item.setItemMeta(meta);
        return item;
    }

    public static ConsumableBuilder builder() {
        return new ConsumableBuilder();
    }

}
