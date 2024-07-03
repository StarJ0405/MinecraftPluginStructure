package shining.starj.structure.GUIs;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
public enum GUIPresetItem {
    PPRE(ChatColor.GRAY + "첫 페이지") {
        @Override
        public ItemStack getItemStack(int nowPage, int maxPage) {
            ItemStack item = super.getItemStack(nowPage, maxPage);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            if (nowPage > 0) lore.add(ChatColor.RED + "첫 페이지입니다.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }, PRE(ChatColor.GRAY + "이전 페이지") {
        @Override
        public ItemStack getItemStack(int nowPage, int maxPage) {
            ItemStack item = super.getItemStack(nowPage, maxPage);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            if (nowPage > 0) lore.add(ChatColor.RED + "첫 페이지입니다.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }, NOW(ChatColor.GRAY + "현재 페이지") {
        @Override
        public ItemStack getItemStack(int nowPage, int maxPage) {
            ItemStack item = super.getItemStack(nowPage, maxPage);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            lore.add(ChatColor.WHITE + "페이지 : " + nowPage + " / " + maxPage);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }, NEXT(ChatColor.GRAY + "다음 페이지") {
        @Override
        public ItemStack getItemStack(int nowPage, int maxPage) {
            ItemStack item = super.getItemStack(nowPage, maxPage);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            if (nowPage == maxPage) lore.add(ChatColor.RED + "마지막 페이지입니다.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }, NNEXT(ChatColor.GRAY + "마지막 페이지") {
        @Override
        public ItemStack getItemStack(int nowPage, int maxPage) {
            ItemStack item = super.getItemStack(nowPage, maxPage);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            if (nowPage == maxPage) lore.add(ChatColor.RED + "마지막 페이지입니다.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }, Empty(ChatColor.DARK_GRAY + "") {
        @Override
        public ItemStack getItemStack() {
            ItemStack item = super.getItemStack();
            ItemMeta meta = item.getItemMeta();
            meta.setHideTooltip(true);
            item.setItemMeta(meta);
            return item;
        }
    }

    //
    ;
    protected final ItemStack itemStack;


    GUIPresetItem(String displayName, String... lores) {
        this(displayName, Material.LIGHT_GRAY_STAINED_GLASS_PANE, null, lores);
    }

    GUIPresetItem(String displayName, Material material, String... lores) {
        this(displayName, material, null, lores);
    }

    GUIPresetItem(String displayName, Integer model, String... lores) {
        this(displayName, Material.LIGHT_GRAY_STAINED_GLASS_PANE, model, lores);
    }

    GUIPresetItem(String displayName, Material material, Integer model, String... lores) {
        this.itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(displayName);
        if (model != null) meta.setCustomModelData(model);
        meta.setLore(Arrays.stream(lores).toList());
        itemStack.setItemMeta(meta);
    }

    public ItemStack getItemStack(int nowPage, int maxPage) {
        return this.itemStack.clone();
    }
}
