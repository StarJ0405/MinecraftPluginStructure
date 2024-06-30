package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Items.Interactable;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class ItemInteractListener extends AbstractEventListener {
    /*
     * 아이템 사용
     */
    @EventHandler(priority = EventPriority.NORMAL)
    public void Events(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack mainItem = player.getInventory().getItemInMainHand();
        Items main = Items.valueOf(mainItem);
        ItemStack offItem = player.getInventory().getItemInOffHand();
        Items off = Items.valueOf(offItem);
        if (e.getClickedBlock() == null || !e.isCancelled())
            if (e.getHand() != null) if (e.getHand().equals(EquipmentSlot.HAND)) {
                if (main instanceof Interactable interactable) {
                    if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK))
                        e.setCancelled(interactable.left(player, mainItem, e.getClickedBlock()));
                    else if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                        e.setCancelled(interactable.right(player, mainItem, e.getClickedBlock()));
                } else if (off instanceof Interactable interactable)
                    if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK))
                        e.setCancelled(interactable.left(player, mainItem, e.getClickedBlock()));
                    else if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                        e.setCancelled(interactable.right(player, mainItem, e.getClickedBlock()));
            } else if (e.getHand().equals(EquipmentSlot.OFF_HAND) && (main instanceof Interactable || off instanceof Interactable))
                e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void Events(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();
        ItemStack mainItem = e.getOffHandItem();
        Items main = Items.valueOf(mainItem);
        ItemStack offItem = e.getMainHandItem();
        Items off = Items.valueOf(offItem);
        if (main instanceof Interactable interactable) e.setCancelled(interactable.swap(player, mainItem));
        else if (off instanceof Interactable interactable) e.setCancelled(interactable.swap(player, offItem));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = e.getItemDrop().getItemStack();
        Items item = Items.valueOf(itemStack);
        if (item instanceof Interactable interactable) e.setCancelled(interactable.drop(player, itemStack));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(EntityPickupItemEvent e) {
        if (e.getEntityType().equals(EntityType.PLAYER)) {
            Player player = (Player) e.getEntity();
            Inventory inv = player.getInventory();
            ItemStack[] contents = inv.getContents();
            for (int slot = 0; slot < contents.length; slot++) {
                ItemStack itemStack = contents[slot];
                Items item = Items.valueOf(itemStack);
                if (item instanceof Interactable interactable)
                    e.setCancelled(interactable.pickup(player, itemStack, e.getItem(), slot));
            }
        }
    }
}
