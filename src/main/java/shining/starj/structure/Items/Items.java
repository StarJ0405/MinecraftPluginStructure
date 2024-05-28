package shining.starj.structure.Items;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
public class Items {
    private final static List<Items> list = new ArrayList<Items>();
    // 기타
    protected final String key;
    protected final String displayName;
    protected final Material material;
    protected final List<String> lores;
    protected final int model;
    protected final boolean interact;

    @Builder
    public Items(String key, String displayName, Material material, String[] lores, int model, boolean interact) {
        this.key = key;
        this.displayName = displayName;
        this.material = material;
        this.lores = lores != null ? Arrays.asList(lores) : new ArrayList<>();
        this.model = model;
        this.interact = interact;
        //
        list.add(this);
    }

   public ItemStack getItemStack() {
        ItemStack item = new ItemStack(this.material);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(this.model);
        meta.setDisplayName(this.displayName);
        meta.setLocalizedName(this.key);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getItemStack(Player player) {
        return getItemStack();
    }

    public static Items valueOf(ItemStack item) {
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName())
            return valueOf(item.getItemMeta().getLocalizedName());
        return null;
    }

    public static Items valueOf(String key) {
        for (Items item : list)
            if (item.key.equals(key))
                return item;
        return null;
    }

    public static List<Items> values() {
        final List<Items> list = new ArrayList<Items>();
        list.addAll(Items.list);
        return list;
    }

}
