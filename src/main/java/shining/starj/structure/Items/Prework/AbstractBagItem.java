package shining.starj.structure.Items.Prework;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import shining.starj.structure.Core;
import shining.starj.structure.GUIs.AbstractGUI;
import shining.starj.structure.Items.Interactable;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Items.Prework.Bags.BagColor;
import shining.starj.structure.Items.Prework.Bags.InventorySize;

import java.util.List;

public abstract class AbstractBagItem extends Items implements Interactable {
    protected final InventorySize inventorySize;
    protected final BagColor bagColor;

    public AbstractBagItem(String key, String displayName, BagColor bagColor, int model, List<String> lores, InventorySize inventorySize) {
        super(key, displayName, bagColor.getMaterial(), model, false, false, true, true, false, lores, 1);
        this.inventorySize = inventorySize;
        this.bagColor = bagColor;
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

    public abstract boolean isAllow(ItemStack item);

    @Override
    public boolean pickup(Player player, ItemStack item, Item entity) {
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
                                entity.remove();
                                renew(item, box);
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
                        entity.remove();
                        renew(item, box);
                        return true;
                    }
                }
                inv.setContents(contents);
                meta.setBlockState(box);
                item.setItemMeta(meta);
                renew(item, box);
            }
            return false;
        }
        return Interactable.super.pickup(player, item, entity);
    }

    public void renew(ItemStack item, ShulkerBox box) {
        Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            ItemMeta meta = item.getItemMeta();
            Items items = Items.valueOf(item);
            if (items != null) {
                int model = 0;
                for (ItemStack test : box.getInventory().getContents())
                    if (test != null)
                        model++;
                Bukkit.broadcastMessage(model + "");
                meta.setCustomModelData(items.getModel() + model);
            }
            item.setItemMeta(meta);
            Bukkit.broadcastMessage(item.getType().name());
        }, 1);
    }

    @Override
    public boolean right(Player player, ItemStack item, Block block) {
        Inventory inv = AbstractGUI.bagGUI.openInv(player, this.displayName, inventorySize);
        if (item.getItemMeta() instanceof BlockStateMeta meta && meta.getBlockState() instanceof ShulkerBox box) {
            ItemStack[] contents = inv.getContents();
            ItemStack[] pre = box.getInventory().getContents();
            System.arraycopy(pre, 0, contents, 0, contents.length);
            inv.setContents(contents);
        }
        return true;
    }
}
