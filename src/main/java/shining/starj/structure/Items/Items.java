package shining.starj.structure.Items;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import shining.starj.structure.Core;
import shining.starj.structure.Items.Prework.BagItem;
import shining.starj.structure.GUIs.InventorySize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Items {
    private final static List<Items> list = new ArrayList<Items>();
    // 시간
    public final static Items timer = Items.builder().key("timer").displayName(ChatColor.WHITE + "타이머").material(Material.CLOCK).fireResistant(true).maxStackSize(60).build();
    // 가방
    public final static BagItem SmallAllBag = BagItem.builder().key("SmallAllBag").displayName(ChatColor.WHITE + "소형 잡화 주머니").bagColor(BagItem.BagColor.NONE).model(0).lores(new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 소형주머니"}).inventorySize(InventorySize.One).bans(RecipeChoiceCreator.fromMaterial(Arrays.stream(Material.values()).filter(material -> material.name().contains("SHULKER")).toArray(Material[]::new))).defaultValue(true).build();
    public final static BagItem MediumAllBag = BagItem.builder().key("MediumAllBag").displayName(ChatColor.WHITE + "중형 잡화 주머니").bagColor(BagItem.BagColor.NONE).model(1).lores(new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 중형주머니"}).inventorySize(InventorySize.Two).bans(RecipeChoiceCreator.fromMaterial(Arrays.stream(Material.values()).filter(material -> material.name().contains("SHULKER")).toArray(Material[]::new))).defaultValue(true).build();
    public final static BagItem BigAllBag = BagItem.builder().key("BigAllBag").displayName(ChatColor.WHITE + "대형 잡화 주머니").bagColor(BagItem.BagColor.NONE).model(2).lores(new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 대형주머니"}).inventorySize(InventorySize.Three).bans(RecipeChoiceCreator.fromMaterial(Arrays.stream(Material.values()).filter(material -> material.name().contains("SHULKER")).toArray(Material[]::new))).defaultValue(true).build();
    public final static BagItem SmallMiningBag = BagItem.builder().key("SmallMiningBag").displayName(ChatColor.WHITE + "소형 광부 주머니").bagColor(BagItem.BagColor.GRAY).model(0).lores(new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 소형주머니"}).inventorySize(InventorySize.One).allows(RecipeChoiceCreator.fromMaterial(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.COAL, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.RAW_COPPER, Material.COPPER_INGOT, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.RAW_IRON, Material.IRON_NUGGET, Material.IRON_INGOT, Material.NETHER_GOLD_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.RAW_GOLD, Material.GOLD_NUGGET, Material.GOLD_INGOT, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.LAPIS_LAZULI, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.REDSTONE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.DIAMOND, Material.DEEPSLATE_EMERALD_ORE, Material.EMERALD_ORE, Material.EMERALD, Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP, Material.NETHERITE_INGOT, Material.NETHER_QUARTZ_ORE, Material.QUARTZ)).build();
    public final static BagItem MediumMiningBag = BagItem.builder().key("MediumMiningBag").displayName(ChatColor.WHITE + "중형 광부 주머니").bagColor(BagItem.BagColor.GRAY).model(1).lores(new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 중형주머니"}).inventorySize(InventorySize.Two).allows(RecipeChoiceCreator.fromMaterial(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.COAL, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.RAW_COPPER, Material.COPPER_INGOT, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.RAW_IRON, Material.IRON_NUGGET, Material.IRON_INGOT, Material.NETHER_GOLD_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.RAW_GOLD, Material.GOLD_NUGGET, Material.GOLD_INGOT, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.LAPIS_LAZULI, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.REDSTONE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.DIAMOND, Material.DEEPSLATE_EMERALD_ORE, Material.EMERALD_ORE, Material.EMERALD, Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP, Material.NETHERITE_INGOT, Material.NETHER_QUARTZ_ORE, Material.QUARTZ)).build();
    public final static BagItem BigMiningBag = BagItem.builder().key("BigMiningBag").displayName(ChatColor.WHITE + "대형 광부 주머니").bagColor(BagItem.BagColor.GRAY).model(2).lores(new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 대형주머니"}).inventorySize(InventorySize.Three).allows(RecipeChoiceCreator.fromMaterial(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.COAL, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.RAW_COPPER, Material.COPPER_INGOT, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.RAW_IRON, Material.IRON_NUGGET, Material.IRON_INGOT, Material.NETHER_GOLD_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.RAW_GOLD, Material.GOLD_NUGGET, Material.GOLD_INGOT, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.LAPIS_LAZULI, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.REDSTONE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.DIAMOND, Material.DEEPSLATE_EMERALD_ORE, Material.EMERALD_ORE, Material.EMERALD, Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP, Material.NETHERITE_INGOT, Material.NETHER_QUARTZ_ORE, Material.QUARTZ)).build();
    public final static BagItem SmallFishingBag = BagItem.builder().key("SmallFishingBag").displayName(ChatColor.WHITE + "소형 낚시꾼 주머니").bagColor(BagItem.BagColor.GRAY).model(0).lores(new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 소형주머니"}).inventorySize(InventorySize.One).allows(RecipeChoiceCreator.fromMaterial(Material.TROPICAL_FISH, Material.COD, Material.SALMON, Material.PUFFERFISH)).build();
    public final static BagItem MediumFishingBag = BagItem.builder().key("MediumFishingBag").displayName(ChatColor.WHITE + "중형 낚시꾼 주머니").bagColor(BagItem.BagColor.GRAY).model(1).lores(new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 중형주머니"}).inventorySize(InventorySize.Two).allows(RecipeChoiceCreator.fromMaterial(Material.TROPICAL_FISH, Material.COD, Material.SALMON, Material.PUFFERFISH)).build();
    public final static BagItem BigFishingBag = BagItem.builder().key("BigFishingBag").displayName(ChatColor.WHITE + "대형 낚시꾼 주머니").bagColor(BagItem.BagColor.GRAY).model(2).lores(new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 대형주머니"}).inventorySize(InventorySize.Three).allows(RecipeChoiceCreator.fromMaterial(Material.TROPICAL_FISH, Material.COD, Material.SALMON, Material.PUFFERFISH)).build();
    public final static BagItem SmallHuntingBag = BagItem.builder().key("SmallHuntingBag").displayName(ChatColor.WHITE + "소형 사냥꾼 주머니").bagColor(BagItem.BagColor.GRAY).model(0).lores(new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 소형주머니"}).inventorySize(InventorySize.One).allows(RecipeChoiceCreator.fromMaterial(Material.BEEF, Material.COOKED_BEEF, Material.PORKCHOP, Material.COOKED_PORKCHOP, Material.CHICKEN, Material.COOKED_CHICKEN, Material.MUTTON, Material.COOKED_MUTTON, Material.RABBIT, Material.COOKED_RABBIT)).build();
    public final static BagItem MediumHuntingBag = BagItem.builder().key("MediumHuntingBag").displayName(ChatColor.WHITE + "중형 사냥꾼 주머니").bagColor(BagItem.BagColor.GRAY).model(1).lores(new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 중형주머니"}).inventorySize(InventorySize.Two).allows(RecipeChoiceCreator.fromMaterial(Material.BEEF, Material.COOKED_BEEF, Material.PORKCHOP, Material.COOKED_PORKCHOP, Material.CHICKEN, Material.COOKED_CHICKEN, Material.MUTTON, Material.COOKED_MUTTON, Material.RABBIT, Material.COOKED_RABBIT)).build();
    public final static BagItem BigHuntingBag = BagItem.builder().key("BigHuntingBag").displayName(ChatColor.WHITE + "대형 사냥꾼 주머니").bagColor(BagItem.BagColor.GRAY).model(2).lores(new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 대형주머니"}).inventorySize(InventorySize.Three).allows(RecipeChoiceCreator.fromMaterial(Material.BEEF, Material.COOKED_BEEF, Material.PORKCHOP, Material.COOKED_PORKCHOP, Material.CHICKEN, Material.COOKED_CHICKEN, Material.MUTTON, Material.COOKED_MUTTON, Material.RABBIT, Material.COOKED_RABBIT)).build();
    //
    protected static final NamespacedKey typeNamespaceKey = new NamespacedKey(Core.getCore(), "itemType");
    protected final String key;
    protected final String displayName;
    protected final Material material;
    protected String[] lores;
    protected Integer model;
    protected final boolean interact;
    protected final boolean fireResistant;
    protected final boolean hideGlint;
    protected final boolean hideTooltip;
    protected final boolean unbreakable;
    protected int maxStackSize;

    public Items(String key, String displayName, Material material, String[] lores, Integer model, boolean interact, boolean fireResistant, boolean hideGlint, boolean hideTooltip, boolean unbreakable, int maxStackSize) {
        this.key = key;
        this.displayName = displayName;
        this.material = material;
        this.lores = lores;
        this.model = model != null ? 1000000 + model * 1000 : null;
        this.interact = interact;
        this.fireResistant = fireResistant;
        this.hideGlint = hideGlint;
        this.hideTooltip = hideTooltip;
        this.unbreakable = unbreakable;
        this.maxStackSize = Math.min(99, Math.max(1, maxStackSize));
        //
        list.add(this);
    }

    public static ItemsBuilder builder() {
        return new ItemsBuilder();
    }

    public static class ItemsBuilder {
        protected String key;
        protected String displayName;
        protected Material material;
        protected String[] lores;
        protected Integer model;
        protected boolean interact;
        protected boolean fireResistant;
        protected boolean hideGlint;
        protected boolean hideTooltip;
        protected boolean unbreakable;
        protected int maxStackSize;

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

        public ItemsBuilder lores(String[] lores) {
            this.lores = lores;
            return this;
        }

        public ItemsBuilder model(Integer model) {
            this.model = model;
            return this;
        }

        public ItemsBuilder interact(boolean interact) {
            this.interact = interact;
            return this;
        }

        public ItemsBuilder fireResistant(boolean fireResistant) {
            this.fireResistant = fireResistant;
            return this;
        }

        public ItemsBuilder glint(boolean glint) {
            this.hideGlint = glint;
            return this;
        }

        public ItemsBuilder tooltip(boolean tooltip) {
            this.hideTooltip = tooltip;
            return this;
        }

        public ItemsBuilder unbreakable(boolean unbreakable) {
            this.unbreakable = unbreakable;
            return this;
        }

        public ItemsBuilder maxStackSize(int maxStackSize) {
            this.maxStackSize = maxStackSize;
            return this;
        }

        public Items build() {
            return new Items(key, displayName, material, lores, model, interact, fireResistant, hideGlint, hideTooltip, unbreakable, maxStackSize);
        }
    }

    public ItemStack getItemStack() {
        ItemStack item = new ItemStack(this.material);
        ItemMeta meta = item.getItemMeta();
        if (this.model != null) meta.setCustomModelData(this.model);
        meta.setDisplayName(this.displayName);
        meta.getPersistentDataContainer().set(typeNamespaceKey, PersistentDataType.STRING, this.key);
        meta.setFireResistant(fireResistant);
        meta.setEnchantmentGlintOverride(!hideGlint);
        meta.setHideTooltip(hideTooltip);
        meta.setUnbreakable(unbreakable);
        if (lores != null)
            meta.setLore(Arrays.stream(lores).toList());
        meta.setMaxStackSize(maxStackSize);
        item.setItemMeta(meta);
        return item;
    }


    public ItemStack getItemStack(Player player) {
        return getItemStack();
    }

    public static Items valueOf(ItemStack item) {
        if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(typeNamespaceKey, PersistentDataType.STRING))
            return valueOf(item.getItemMeta().getPersistentDataContainer().get(typeNamespaceKey, PersistentDataType.STRING));
        return null;
    }

    public static Items valueOf(String key) {
        for (Items item : list)
            if (item.key.equals(key)) return item;
        return null;
    }

    public static List<Items> values() {
        return new ArrayList<>(Items.list);
    }

    public static void initial() {
        ConsumableItems.initial();
        DurableItems.initial();
    }
}
