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
import shining.starj.structure.Items.Builders.ItemsBuilder;
import shining.starj.structure.Items.Prework.Bags.*;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Items {
    private final static List<Items> list = new ArrayList<Items>();
    // 시간
    public final static Items timer = Items.builder().key("timer").displayName(ChatColor.WHITE + "타이머").material(Material.CLOCK).isInteract(false).isFireResistant(true).isGlint(false).isTooltip(false).isUnbreakable(false).setMaxStackSize(60).build();
    // 가방
    public final static AllBagItem SmallestAllBag = new AllBagItem("SmallestAllBag", ChatColor.WHITE + "초소형 주머니", BagColor.NONE, 0, new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 초소형주머니"}, InventorySize.One);
    public final static AllBagItem SmallAllBag = new AllBagItem("SmallAllBag", ChatColor.WHITE + "소형 주머니", BagColor.NONE, 0, new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 소형주머니"}, InventorySize.Two);
    public final static AllBagItem MediumAllBag = new AllBagItem("MediumAllBag", ChatColor.WHITE + "중형 주머니", BagColor.NONE, 0, new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 중형주머니"}, InventorySize.Three);
    public final static AllBagItem BigAllBag = new AllBagItem("BigAllBag", ChatColor.WHITE + "대형 주머니", BagColor.NONE, 0, new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 대형주머니"}, InventorySize.Four);
    public final static AllBagItem BiggestAllBag = new AllBagItem("BiggestAllBag", ChatColor.WHITE + "중형 주머니", BagColor.NONE, 0, new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 초대형주머니"}, InventorySize.Five);
    public final static AllBagItem HugeAllBag = new AllBagItem("HugeAllBag", ChatColor.WHITE + "초거대 주머니", BagColor.NONE, 0, new String[]{ChatColor.WHITE + "거의 모든 종류를 담을 수 있는 초거대주머니"}, InventorySize.Six);

    public final static MiningBagItem SmallestMiningBag = new MiningBagItem("SmallestMiningBag", ChatColor.WHITE + "초소형 광부 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 초소형주머니"}, InventorySize.One);
    public final static MiningBagItem SmallMiningBag = new MiningBagItem("SmallMiningBag", ChatColor.WHITE + "소형 광부 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 소형주머니"}, InventorySize.Two);
    public final static MiningBagItem MediumMiningBag = new MiningBagItem("MediumMiningBag", ChatColor.WHITE + "중형 광부 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 중형주머니"}, InventorySize.Three);
    public final static MiningBagItem BigMiningBag = new MiningBagItem("BigMiningBag", ChatColor.WHITE + "대형 광부 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 대형주머니"}, InventorySize.Four);
    public final static MiningBagItem BiggestMiningBag = new MiningBagItem("BiggestMiningBag", ChatColor.WHITE + "중형 광부 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 초대형주머니"}, InventorySize.Five);
    public final static MiningBagItem HugeMiningBag = new MiningBagItem("HugeMiningBag", ChatColor.WHITE + "초거대 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "광석 종류를 담을 수 있는 초거대주머니"}, InventorySize.Six);

    public final static FishingBagItem SmallestFishingBag = new FishingBagItem("SmallestFishingBag", ChatColor.WHITE + "초소형 낚시꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 초소형주머니"}, InventorySize.One);
    public final static FishingBagItem SmallFishingBag = new FishingBagItem("SmallFishingBag", ChatColor.WHITE + "소형 낚시꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 소형주머니"}, InventorySize.Two);
    public final static FishingBagItem MediumFishingBag = new FishingBagItem("MediumFishingBag", ChatColor.WHITE + "중형 낚시꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 중형주머니"}, InventorySize.Three);
    public final static FishingBagItem BigFishingBag = new FishingBagItem("BigFishingBag", ChatColor.WHITE + "대형 낚시꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 대형주머니"}, InventorySize.Four);
    public final static FishingBagItem BiggestFishingBag = new FishingBagItem("BiggestFishingBag", ChatColor.WHITE + "중형 낚시꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 초대형주머니"}, InventorySize.Five);
    public final static FishingBagItem HugeFishingBag = new FishingBagItem("HugeFishingBag", ChatColor.WHITE + "초거대 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "물고기 종류를 담을 수 있는 초거대주머니"}, InventorySize.Six);

    public final static HuntingBagItem SmallestHuntingBag = new HuntingBagItem("SmallestHuntingBag", ChatColor.WHITE + "초소형 사냥꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 초소형주머니"}, InventorySize.One);
    public final static HuntingBagItem SmallHuntingBag = new HuntingBagItem("SmallHuntingBag", ChatColor.WHITE + "소형 사냥꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 소형주머니"}, InventorySize.Two);
    public final static HuntingBagItem MediumHuntingBag = new HuntingBagItem("MediumHuntingBag", ChatColor.WHITE + "중형 사냥꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 중형주머니"}, InventorySize.Three);
    public final static HuntingBagItem BigHuntingBag = new HuntingBagItem("BigHuntingBag", ChatColor.WHITE + "대형 사냥꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 대형주머니"}, InventorySize.Four);
    public final static HuntingBagItem BiggestHuntingBag = new HuntingBagItem("BiggestHuntingBag", ChatColor.WHITE + "중형 사냥꾼 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 초대형주머니"}, InventorySize.Five);
    public final static HuntingBagItem HugeHuntingBag = new HuntingBagItem("HugeHuntingBag", ChatColor.WHITE + "초거대 주머니", BagColor.GRAY, 0, new String[]{ChatColor.WHITE + "사냥 종류를 담을 수 있는 초거대주머니"}, InventorySize.Six);
    //
    protected static final NamespacedKey typeNamespaceKey = new NamespacedKey(Core.getCore(), "itemType");
    protected final String key;
    protected final String displayName;
    protected final Material material;
    protected final List<String> lores;
    protected final int model;
    protected final boolean interact;
    protected final boolean fireResistant;
    protected final boolean glint;
    protected final boolean tooltip;
    protected final boolean unbreakable;
    protected final int maxStackSize;
    protected final NamespacedKey namespacedKey;

    public Items(String key, String displayName, Material material, int model, boolean interact, boolean fireResistant, boolean glint, boolean tooltip, boolean unbreakable, List<String> lores, int maxStackSize) {
        this.key = key;
        this.displayName = displayName;
        this.material = material;
        this.lores = lores;
        this.model = model;
        this.interact = interact;
        this.fireResistant = fireResistant;
        this.glint = glint;
        this.tooltip = tooltip;
        this.unbreakable = unbreakable;
        this.maxStackSize = Math.min(99, Math.max(1, maxStackSize));
        this.namespacedKey = new NamespacedKey(Core.getCore(), this.key);
        //
        list.add(this);
    }


    public ItemStack getItemStack() {
        ItemStack item = new ItemStack(this.material);
        ItemMeta meta = item.getItemMeta();
        if (this.model > 0) meta.setCustomModelData(1000000 + this.model);
        meta.setDisplayName(this.displayName);
        meta.getPersistentDataContainer().set(typeNamespaceKey, PersistentDataType.STRING, this.key);
        meta.setFireResistant(fireResistant);
        meta.setEnchantmentGlintOverride(glint);
        meta.setUnbreakable(unbreakable);
        meta.setLore(lores);
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

    public static ItemsBuilder builder() {
        return new ItemsBuilder();
    }

}
