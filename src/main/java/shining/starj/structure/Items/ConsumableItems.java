package shining.starj.structure.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.potion.PotionEffectType;

public class ConsumableItems extends Items {
    //
    public static ConsumableItems test0 = ConsumableItems.builder().key("test0").material(Material.IRON_NUGGET).eatDelay(0.1f).nutrition(2).saturation(6f).foodEffectInfos(FoodEffectInfo.builder().potionEffectType(PotionEffectType.HASTE).tick(200).probability(0.75f).amplifier(1).build()).build();
    public static ConsumableItems test1 = ConsumableItems.builder().key("test1").material(Material.IRON_INGOT).eatDelay(1f).nutrition(4).saturation(4f).foodEffectInfos(FoodEffectInfo.builder().potionEffectType(PotionEffectType.HASTE).tick(200).probability(0.5f).amplifier(2).build()).build();
    public static ConsumableItems test2 = ConsumableItems.builder().key("test2").material(Material.IRON_BLOCK).eatDelay(2f).nutrition(6).saturation(2f).foodEffectInfos(FoodEffectInfo.builder().potionEffectType(PotionEffectType.HASTE).tick(200).probability(0.25f).amplifier(3).build()).build();
    //
    protected final boolean canAlwaysEat;
    protected Float eatDelay;
    protected Integer nutrition;
    protected final float saturation;
    protected final FoodEffectInfo[] foodEffectInfos;

    public ConsumableItems(String key, String displayName, Material material, String[] lores, Integer model, boolean interact, boolean fireResistant, boolean glint, boolean tooltip, boolean unbreakable, int maxStackSize, boolean canAlwaysEat, Float eatDelay, Integer nutrition, float saturation, FoodEffectInfo... foodEffectInfos) {
        super(key, displayName, material, lores, model, interact, fireResistant, glint, tooltip, unbreakable, maxStackSize);
        this.canAlwaysEat = canAlwaysEat;
        this.eatDelay = eatDelay != null ? eatDelay : 1f;
        this.nutrition = nutrition != null ? nutrition : 1;
        this.saturation = saturation;
        this.foodEffectInfos = foodEffectInfos;
    }

    public static ConsumableItemsBuilder builder() {
        return new ConsumableItemsBuilder();
    }

    public static class ConsumableItemsBuilder extends Items.ItemsBuilder {
        protected boolean canAlwaysEat;
        protected Float eatSeconds;
        protected Integer nutrition;
        protected float saturation;
        protected FoodEffectInfo[] foodEffectInfos;

        @Override
        public ConsumableItemsBuilder key(String key) {
            return (ConsumableItemsBuilder) super.key(key);
        }

        @Override
        public ConsumableItemsBuilder displayName(String displayName) {
            return (ConsumableItemsBuilder) super.displayName(displayName);
        }

        @Override
        public ConsumableItemsBuilder material(Material material) {
            return (ConsumableItemsBuilder) super.material(material);
        }

        @Override
        public ConsumableItemsBuilder lores(String[] lores) {
            return (ConsumableItemsBuilder) super.lores(lores);
        }

        @Override
        public ConsumableItemsBuilder model(Integer model) {
            return (ConsumableItemsBuilder) super.model(model);
        }

        @Override
        public ConsumableItemsBuilder interact(boolean interact) {
            return (ConsumableItemsBuilder) super.interact(interact);
        }

        @Override
        public ConsumableItemsBuilder fireResistant(boolean fireResistant) {
            return (ConsumableItemsBuilder) super.fireResistant(fireResistant);
        }

        @Override
        public ConsumableItemsBuilder glint(boolean glint) {
            return (ConsumableItemsBuilder) super.glint(glint);
        }

        @Override
        public ConsumableItemsBuilder tooltip(boolean tooltip) {
            return (ConsumableItemsBuilder) super.tooltip(tooltip);
        }

        @Override
        public ConsumableItemsBuilder unbreakable(boolean unbreakable) {
            return (ConsumableItemsBuilder) super.unbreakable(unbreakable);
        }

        @Override
        public ConsumableItemsBuilder maxStackSize(int maxStackSize) {
            return (ConsumableItemsBuilder) super.maxStackSize(maxStackSize);
        }

        public ConsumableItemsBuilder canAlwaysEat(boolean canAlwaysEat) {
            this.canAlwaysEat = canAlwaysEat;
            return this;
        }

        public ConsumableItemsBuilder eatDelay(Float eatSeconds) {
            this.eatSeconds = eatSeconds;
            return this;
        }

        public ConsumableItemsBuilder nutrition(Integer nutrition) {
            this.nutrition = nutrition;
            return this;
        }

        public ConsumableItemsBuilder saturation(float saturation) {
            this.saturation = saturation;
            return this;
        }

        public ConsumableItemsBuilder foodEffectInfos(FoodEffectInfo... foodEffectInfos) {
            this.foodEffectInfos = foodEffectInfos;
            return this;
        }

        @Override
        public ConsumableItems build() {
            return new ConsumableItems(key, displayName, material, lores, model, interact, fireResistant, hideGlint, hideTooltip, unbreakable, maxStackSize, canAlwaysEat, eatSeconds, nutrition, saturation, foodEffectInfos);
        }
    }

    @Override
    public ItemStack getItemStack() {
        ItemStack item = super.getItemStack();
        ItemMeta meta = item.getItemMeta();
        FoodComponent foodComponent = meta.getFood();
        foodComponent.setCanAlwaysEat(canAlwaysEat);
        foodComponent.setEatSeconds(eatDelay);
        foodComponent.setNutrition(nutrition);
        foodComponent.setSaturation(saturation);
        for (FoodEffectInfo info : foodEffectInfos)
            foodComponent.addEffect(info.getPotionEffect(), info.getProbability());
        meta.setFood(foodComponent);
        item.setItemMeta(meta);
        return item;
    }

    public static void initial() {

    }

}
