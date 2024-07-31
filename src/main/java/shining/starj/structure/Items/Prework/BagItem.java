package shining.starj.structure.Items.Prework;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import shining.starj.structure.GUIs.AbstractGUI;
import shining.starj.structure.Items.Interactable;
import shining.starj.structure.Items.Items;
import shining.starj.structure.GUIs.InventorySize;

public class BagItem extends Items implements Interactable {
    protected final InventorySize inventorySize;
    protected final BagColor bagColor;
    protected final RecipeChoice[] allows;
    protected final RecipeChoice[] bans;
    protected final boolean defaultValue;

    public BagItem(String key, String displayName, BagColor bagColor, Integer model, String[] lores, InventorySize inventorySize, RecipeChoice[] allows, RecipeChoice[] bans, boolean defaultValue) {
        super(key, displayName, bagColor.getMaterial(), lores, model, false, false, true, false, false, 1);
        this.inventorySize = inventorySize;
        this.bagColor = bagColor;
        this.allows = allows;
        this.bans = bans;
        this.defaultValue = defaultValue;
    }

    public static BagItemBuilder builder() {
        return new BagItemBuilder();
    }

    public static class BagItemBuilder extends Items.ItemsBuilder {
        protected InventorySize inventorySize;
        protected BagColor bagColor;
        protected RecipeChoice[] allows;
        protected RecipeChoice[] bans;
        protected boolean defaultValue;

        @Override
        public BagItemBuilder key(String key) {
            return (BagItemBuilder) super.key(key);
        }

        @Override
        public BagItemBuilder displayName(String displayName) {
            return (BagItemBuilder) super.displayName(displayName);
        }

        @Override
        public BagItemBuilder material(Material material) {
            return (BagItemBuilder) super.material(material);
        }

        @Override
        public BagItemBuilder lores(String[] lores) {
            return (BagItemBuilder) super.lores(lores);
        }

        @Override
        public BagItemBuilder model(Integer model) {
            return (BagItemBuilder) super.model(model);
        }

        @Override
        public BagItemBuilder interact(boolean interact) {
            return (BagItemBuilder) super.interact(interact);
        }

        @Override
        public BagItemBuilder fireResistant(boolean fireResistant) {
            return (BagItemBuilder) super.fireResistant(fireResistant);
        }

        @Override
        public BagItemBuilder glint(boolean glint) {
            return (BagItemBuilder) super.glint(glint);
        }

        @Override
        public BagItemBuilder tooltip(boolean tooltip) {
            return (BagItemBuilder) super.tooltip(tooltip);
        }

        @Override
        public BagItemBuilder unbreakable(boolean unbreakable) {
            return (BagItemBuilder) super.unbreakable(unbreakable);
        }

        @Override
        public BagItemBuilder maxStackSize(int maxStackSize) {
            return (BagItemBuilder) super.maxStackSize(maxStackSize);
        }

        public BagItemBuilder inventorySize(InventorySize inventorySize) {
            this.inventorySize = inventorySize;
            return this;
        }

        public BagItemBuilder bagColor(BagColor bagColor) {
            this.bagColor = bagColor;
            return this;
        }

        public BagItemBuilder allows(RecipeChoice... allows) {
            this.allows = allows;
            return this;
        }

        public BagItemBuilder bans(RecipeChoice... bans) {
            this.bans = bans;
            return this;
        }


        public BagItemBuilder defaultValue(boolean defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        @Override
        public BagItem build() {
            return new BagItem(this.key, displayName, bagColor, model, lores, inventorySize, allows, bans, defaultValue);
        }
    }

    @Getter
    public enum BagColor {
        NONE(Material.SHULKER_BOX), WHITE(Material.WHITE_SHULKER_BOX), LIGHT_GRAY(Material.LIGHT_GRAY_SHULKER_BOX), GRAY(Material.GRAY_SHULKER_BOX), BLACK(Material.BLACK_SHULKER_BOX), BROWN((Material.BROWN_SHULKER_BOX)), RED(Material.RED_SHULKER_BOX), ORANGE(Material.ORANGE_SHULKER_BOX), YELLOW(Material.YELLOW_SHULKER_BOX), LIME(Material.LIME_SHULKER_BOX), GREEN(Material.GREEN_SHULKER_BOX), CYAN((Material.CYAN_SHULKER_BOX)), LIGHT_BLUE(Material.LIGHT_BLUE_SHULKER_BOX), BLUE(Material.BLUE_SHULKER_BOX), PURPLE(Material.PURPLE_SHULKER_BOX), MAGENTA(Material.MAGENTA_SHULKER_BOX), PINK(Material.PINK_SHULKER_BOX)
        //
        ;
        private final Material material;

        BagColor(Material material) {
            this.material = material;
        }
    }

    @Override
    public ItemStack getItemStack() {
        ItemStack item = super.getItemStack();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(AbstractGUI.prevent, PersistentDataType.BOOLEAN, true);
        item.setItemMeta(meta);
        return item;
    }

    public boolean isAllow(ItemStack item) {
        for (RecipeChoice ban : bans)
            if (ban.test(item)) return false;
        for (RecipeChoice allow : allows)
            if (allow.test(item)) return true;
        return defaultValue;
    }


    @Override
    public boolean pickup(Player player, ItemStack item, Item entity, int slot) {
        ItemStack pickup = entity.getItemStack();
        if (isAllow(pickup)) {
            if (item.getItemMeta() instanceof BlockStateMeta meta && meta.getBlockState() instanceof ShulkerBox box) {
                Inventory inv = box.getInventory();
                ItemStack[] contents = inv.getContents();
                for (int i = 0; i < contents.length; i++) {
                    ItemStack now = contents[i];
                    if (pickup.isSimilar(now)) {
                        int nowAmount = now.getAmount();
                        int nowMax = now.getMaxStackSize();
                        if (nowAmount < nowMax) {
                            int pickupAmount = pickup.getAmount();
                            if (pickupAmount + nowAmount < nowMax) {
                                now.setAmount(pickupAmount + nowAmount);
                                contents[i] = now;
                                inv.setContents(contents);
                                meta.setBlockState(box);
                                item.setItemMeta(meta);
                                entity.setItemStack(new ItemStack(Material.AIR));
                                renew(item);
                                return true;
                            } else {
                                now.setAmount(nowMax);
                                contents[i] = now;
                                pickup.setAmount(pickupAmount + nowAmount - nowMax);
                                entity.setItemStack(pickup);
                            }
                        }
                    }
                }
                for (int i = 0; i < contents.length; i++) {
                    ItemStack now = contents[i];
                    if (now == null || now.getType().equals(Material.AIR)) {
                        contents[i] = pickup;
                        inv.setContents(contents);
                        meta.setBlockState(box);
                        item.setItemMeta(meta);
                        entity.setItemStack(new ItemStack(Material.AIR));
                        renew(item);
                        return true;
                    }
                }
                inv.setContents(contents);
                meta.setBlockState(box);
                item.setItemMeta(meta);
                renew(item);
            }
            return false;
        }
        return Interactable.super.pickup(player, item, entity, slot);
    }

    public void renew(ItemStack item) {
        if (item.getItemMeta() instanceof BlockStateMeta meta && meta.getBlockState() instanceof ShulkerBox box) {
            Items items = Items.valueOf(item);
            if (items != null) {
                int model = 0;
                for (ItemStack test : box.getInventory().getContents())
                    if (test != null) model++;
                meta.setCustomModelData(items.getModel() + model);
                item.setItemMeta(meta);
            }
        }
    }


    @Override
    public boolean right(Player player, ItemStack item, Block block) {
        Inventory inv = AbstractGUI.bagGUI.setInfo(player, AbstractGUI.VariableInfo.builder().title(this.displayName).inventorySize(this.inventorySize).build()).openInv(player);
        if (item.getItemMeta() instanceof BlockStateMeta meta && meta.getBlockState() instanceof ShulkerBox box) {
            ItemStack[] contents = inv.getContents();
            ItemStack[] pre = box.getInventory().getContents();
            System.arraycopy(pre, 0, contents, 0, contents.length);
            inv.setContents(contents);
        }
        return true;
    }
}
