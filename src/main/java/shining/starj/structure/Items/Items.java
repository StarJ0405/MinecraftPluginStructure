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
import shining.starj.structure.Items.Builder.ItemsBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Items {
    private final static List<Items> list = new ArrayList<Items>();
    //
    public final static Items timer = Items.builder().key("timer").displayName(ChatColor.WHITE + "타이머").material(Material.CLOCK).isInteract(false).isFireResistant(true).isGlint(false).isTooltip(false).isUnbreakable(false).setMaxStackSize(60).build();
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
        meta.setCustomModelData(this.model);
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
