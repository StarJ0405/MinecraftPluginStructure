package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.jetbrains.annotations.Nullable;
import shining.starj.structure.Core;
import shining.starj.structure.Events.Prework.ContainerPickupEvent;
import shining.starj.structure.Events.Prework.ContainerPlaceEvent;
import shining.starj.structure.Events.Prework.FuelContainerPickupEvent;
import shining.starj.structure.Events.Prework.FuelContainerPlaceEvent;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Atrributes.AttributeModifiers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class BlockPickupListener extends AbstractEventListener {
    /*
     * 상자 및 블럭 들기
     */
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void Events(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR) && block != null && e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && player.isSneaking()) {
            ContainerPickupEvent event = getMoveContainerEvent(block, player);
            if (event == null) return;
            Bukkit.getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
                ItemStack result = new ItemStack(event.getBlock().getType());
                ItemMeta meta = result.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                List<ItemStack> stored = event.getStored();
                for (int i = 0; i < stored.size(); i++) {
                    ItemStack now = stored.get(i);
                    if (now == null) continue;
//                    container.set(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.STRING, now.getType().name() + "," + now.getAmount());
                    try {
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
                        dataOutput.writeObject(now);
                        dataOutput.close();
                        container.set(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.BYTE_ARRAY, outputStream.toByteArray());
                    } catch (Exception ignored) {

                    }
                }

                container.set(new NamespacedKey(Core.getCore(), "inventory"), PersistentDataType.STRING, "");
                container.set(new NamespacedKey(Core.getCore(), "size"), PersistentDataType.INTEGER, stored.size());
                if (event instanceof FuelContainerPickupEvent fuelEvent) {
                    container.set(new NamespacedKey(Core.getCore(), "burnTime"), PersistentDataType.SHORT, fuelEvent.getBurnTime());
                    container.set(new NamespacedKey(Core.getCore(), "cookTime"), PersistentDataType.SHORT, fuelEvent.getCookTime());
                    container.set(new NamespacedKey(Core.getCore(), "cookTimeTotal"), PersistentDataType.INTEGER, fuelEvent.getCookTimeTotal());
                }
                result.setItemMeta(meta);
                event.getPlayer().getInventory().setItemInMainHand(result);
                event.getBlock().setType(Material.AIR, true);
                AttributeModifiers.builder().uuid(player.getUniqueId()).name(player.getName()).amount(-0.75).operation(AttributeModifier.Operation.ADD_SCALAR).attribute(Attribute.GENERIC_MOVEMENT_SPEED).build().apply(player);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void Events(PlayerDeathEvent e) {
        Player player = e.getEntity();

        AttributeModifiers.builder().uuid(player.getUniqueId()).name(player.getName()).amount(0).operation(AttributeModifier.Operation.ADD_SCALAR).attribute(Attribute.GENERIC_MOVEMENT_SPEED).build().apply(player);
        ItemStack held = player.getInventory().getItemInMainHand();
        if (held.hasItemMeta()) {
            ItemMeta meta = held.getItemMeta();
            PersistentDataContainer container = meta.getPersistentDataContainer();
            if (container.has(new NamespacedKey(Core.getCore(), "size"))) {
                e.getDrops().remove(held);
                player.getInventory().removeItem(held);
                final int size = container.get(new NamespacedKey(Core.getCore(), "size"), PersistentDataType.INTEGER);
                Block placed = player.getLocation().getBlock();
                if (!placed.getType().isAir()) do {
                    placed = placed.getLocation().add(0, 1, 0).getBlock();
                } while (!placed.getType().isAir());
                placed.setType(held.getType(), true);
                switch (held.getType()) {
                    case CHEST, BARREL, SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX -> {
                        List<ItemStack> stored = new ArrayList<>();
                        for (int i = 0; i < size; i++)
                            if (container.has(new NamespacedKey(Core.getCore(), "inventory." + i))) try {
                                ByteArrayInputStream inputStream = new ByteArrayInputStream(container.get(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.BYTE_ARRAY));
                                BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
                                stored.add((ItemStack) dataInput.readObject());
                                dataInput.close();
                            } catch (ClassNotFoundException | IOException ignored) {

                            }
                            else stored.add(new ItemStack(Material.AIR));

                        if (held.getType().equals(Material.CHEST)) {
                            Chest chest = (Chest) placed.getState();
                            chest.getInventory().setContents(stored.toArray(ItemStack[]::new));
                        } else if (held.getType().equals(Material.BARREL)) {
                            Barrel barrel = (Barrel) placed.getState();
                            barrel.getInventory().setContents(stored.toArray(ItemStack[]::new));
                        } else {
                            ShulkerBox shulkerBox = (ShulkerBox) placed.getState();
                            shulkerBox.getInventory().setContents(stored.toArray(ItemStack[]::new));
                        }

                    }

                    case FURNACE, BLAST_FURNACE, SMOKER -> {
                        List<ItemStack> stored = new ArrayList<>();
                        for (int i = 0; i < size; i++)
                            if (container.has(new NamespacedKey(Core.getCore(), "inventory." + i))) try {
                                ByteArrayInputStream inputStream = new ByteArrayInputStream(container.get(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.BYTE_ARRAY));
                                BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
                                stored.add((ItemStack) dataInput.readObject());
                                dataInput.close();
                            } catch (ClassNotFoundException | IOException ignored) {

                            }
                            else stored.add(new ItemStack(Material.AIR));
                        short burnTime = container.has(new NamespacedKey(Core.getCore(), "burnTime")) ? burnTime = container.get(new NamespacedKey(Core.getCore(), "burnTime"), PersistentDataType.SHORT) : 0;
                        short cookTime = container.has(new NamespacedKey(Core.getCore(), "cookTime")) ? container.get(new NamespacedKey(Core.getCore(), "cookTime"), PersistentDataType.SHORT) : 0;
                        int cookTimeTotal = container.has(new NamespacedKey(Core.getCore(), "cookTimeTotal")) ? container.get(new NamespacedKey(Core.getCore(), "cookTimeTotal"), PersistentDataType.INTEGER) : 0;
                        if (held.getType().equals(Material.FURNACE)) {
                            Furnace furnace = (Furnace) placed.getState();
                            furnace.getSnapshotInventory().setContents(stored.toArray(ItemStack[]::new));
                            furnace.setBurnTime(burnTime);
                            furnace.setCookTime(cookTime);
                            furnace.setCookTimeTotal(cookTimeTotal);
                            furnace.update(true, true);
                        } else if (held.getType().equals(Material.BLAST_FURNACE)) {
                            BlastFurnace blastFurnace = (BlastFurnace) placed.getState();
                            blastFurnace.getSnapshotInventory().setContents(stored.toArray(ItemStack[]::new));
                            blastFurnace.setBurnTime(burnTime);
                            blastFurnace.setCookTime(cookTime);
                            blastFurnace.setCookTimeTotal(cookTimeTotal);
                            blastFurnace.update(true, true);
                        } else {
                            Smoker smoker = (Smoker) placed.getState();
                            smoker.getSnapshotInventory().setContents(stored.toArray(ItemStack[]::new));
                            smoker.setBurnTime(burnTime);
                            smoker.setCookTime(cookTime);
                            smoker.setCookTimeTotal(cookTimeTotal);
                            smoker.update(true, true);
                        }
                    }
                }
            }
        }
    }


    @Nullable
    private static ContainerPickupEvent getMoveContainerEvent(Block block, Player player) {
        ContainerPickupEvent event = null;
        switch (block.getType()) {
            case CHEST ->
                    event = ContainerPickupEvent.builder().player(player).block(block).stored(Arrays.asList(((Chest) block.getState()).getInventory().getContents())).build();
            case BARREL ->
                    event = ContainerPickupEvent.builder().player(player).block(block).stored(Arrays.asList(((Barrel) block.getState()).getInventory().getContents())).build();
            case SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX ->
                    event = ContainerPickupEvent.builder().player(player).block(block).stored(Arrays.asList(((ShulkerBox) block.getState()).getInventory().getContents())).build();
            case CRAFTING_TABLE, ENDER_CHEST ->
                    event = ContainerPickupEvent.builder().player(player).block(block).build();
            case FURNACE -> {
                Furnace furnace = (Furnace) block.getState();
                event = FuelContainerPickupEvent.builder().player(player).block(block).stored(Arrays.asList(furnace.getInventory().getContents())).burnTime(furnace.getBurnTime()).cookTime(furnace.getCookTime()).cookTimeTotal(furnace.getCookTimeTotal()).build();
            }
            case BLAST_FURNACE -> {
                BlastFurnace blastFurnace = (BlastFurnace) block.getState();
                event = FuelContainerPickupEvent.builder().player(player).block(block).stored(Arrays.asList(blastFurnace.getInventory().getContents())).burnTime(blastFurnace.getBurnTime()).cookTime(blastFurnace.getCookTime()).cookTimeTotal(blastFurnace.getCookTimeTotal()).build();
            }
            case SMOKER -> {
                Smoker smoker = (Smoker) block.getState();
                event = FuelContainerPickupEvent.builder().player(player).block(block).stored(Arrays.asList(smoker.getInventory().getContents())).burnTime(smoker.getBurnTime()).cookTime(smoker.getCookTime()).cookTimeTotal(smoker.getCookTimeTotal()).build();
            }

        }
        return event;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        if (container.has(new NamespacedKey(Core.getCore(), "size"))) {
            final int size = container.get(new NamespacedKey(Core.getCore(), "size"), PersistentDataType.INTEGER);
            ContainerPlaceEvent event = null;
            switch (item.getType()) {
                case CHEST, BARREL, SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX -> {
                    List<ItemStack> stored = new ArrayList<>();
                    for (int i = 0; i < size; i++)
                        if (container.has(new NamespacedKey(Core.getCore(), "inventory." + i))) try {
                            ByteArrayInputStream inputStream = new ByteArrayInputStream(container.get(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.BYTE_ARRAY));
                            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
                            stored.add((ItemStack) dataInput.readObject());
                            dataInput.close();
                        } catch (ClassNotFoundException | IOException ignored) {

                        }
                        else stored.add(new ItemStack(Material.AIR));
                    event = ContainerPlaceEvent.builder().player(player).item(item).placedBlock(e.getBlockPlaced()).stored(stored).build();
                }
                case ENDER_CHEST, CRAFTING_TABLE ->
                        event = ContainerPlaceEvent.builder().player(player).item(item).placedBlock(e.getBlockPlaced()).stored(new ArrayList<>()).build();
                case FURNACE, BLAST_FURNACE, SMOKER -> {
                    List<ItemStack> stored = new ArrayList<>();
                    for (int i = 0; i < size; i++)
                        if (container.has(new NamespacedKey(Core.getCore(), "inventory." + i))) try {
                            ByteArrayInputStream inputStream = new ByteArrayInputStream(container.get(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.BYTE_ARRAY));
                            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
                            stored.add((ItemStack) dataInput.readObject());
                            dataInput.close();
                        } catch (ClassNotFoundException | IOException ignored) {

                        }
                        else stored.add(new ItemStack(Material.AIR));
                    short burnTime = container.has(new NamespacedKey(Core.getCore(), "burnTime")) ? burnTime = container.get(new NamespacedKey(Core.getCore(), "burnTime"), PersistentDataType.SHORT) : 0;
                    short cookTime = container.has(new NamespacedKey(Core.getCore(), "cookTime")) ? container.get(new NamespacedKey(Core.getCore(), "cookTime"), PersistentDataType.SHORT) : 0;
                    int cookTimeTotal = container.has(new NamespacedKey(Core.getCore(), "cookTimeTotal")) ? container.get(new NamespacedKey(Core.getCore(), "cookTimeTotal"), PersistentDataType.INTEGER) : 0;
                    event = FuelContainerPlaceEvent.builder().player(player).item(item).placedBlock(e.getBlockPlaced()).stored(stored).burnTime(burnTime).cookTime(cookTime).cookTimeTotal(cookTimeTotal).build();
                }
            }
            if (!event.isCancelled()) {
                Block placed = event.getPlacedBlock();
                switch (placed.getType()) {
                    case CHEST -> {
                        Chest chest = (Chest) placed.getState();
                        chest.getInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                    }
                    case BARREL -> {
                        Barrel barrel = (Barrel) placed.getState();
                        barrel.getInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                    }
                    case SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX -> {
                        ShulkerBox shulkerBox = (ShulkerBox) placed.getState();
                        shulkerBox.getInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                    }
                    case FURNACE -> {
                        Furnace furnace = (Furnace) placed.getState();
                        furnace.getSnapshotInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                        if (event instanceof FuelContainerPlaceEvent fuelEvent) {
                            furnace.setBurnTime(fuelEvent.getBurnTime());
                            furnace.setCookTime(fuelEvent.getCookTime());
                            furnace.setCookTimeTotal(fuelEvent.getCookTimeTotal());
                            furnace.update(true, true);
                        }
                    }
                    case BLAST_FURNACE -> {
                        BlastFurnace blastFurnace = (BlastFurnace) placed.getState();
                        blastFurnace.getSnapshotInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                        if (event instanceof FuelContainerPlaceEvent fuelEvent) {
                            blastFurnace.setBurnTime(fuelEvent.getBurnTime());
                            blastFurnace.setCookTime(fuelEvent.getCookTime());
                            blastFurnace.setCookTimeTotal(fuelEvent.getCookTimeTotal());
                            blastFurnace.update(true, true);
                        }
                    }
                    case SMOKER -> {
                        Smoker smoker = (Smoker) placed.getState();
                        smoker.getSnapshotInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                        if (event instanceof FuelContainerPlaceEvent fuelEvent) {
                            smoker.setBurnTime(fuelEvent.getBurnTime());
                            smoker.setCookTime(fuelEvent.getCookTime());
                            smoker.setCookTimeTotal(fuelEvent.getCookTimeTotal());
                            smoker.update(true, true);
                        }
                    }
                    case ENDER_CHEST, CRAFTING_TABLE -> {
                    }
                }
                AttributeModifiers.builder().uuid(player.getUniqueId()).name(player.getName()).amount(0).operation(AttributeModifier.Operation.ADD_SCALAR).attribute(Attribute.GENERIC_MOVEMENT_SPEED).build().apply(player);
            } else e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(PlayerItemHeldEvent e) {
        Player player = e.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        ItemMeta meta = heldItem.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(PlayerSwapHandItemsEvent e) {
        ItemStack mainHandItem = e.getOffHandItem();
        if (!mainHandItem.getType().equals(Material.AIR)) {
            ItemMeta meta = mainHandItem.getItemMeta();
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(InventoryClickEvent e) {
        ItemStack current = e.getCurrentItem();
        if (current != null) {
            ItemMeta currentItemMeta = current.getItemMeta();
            if (currentItemMeta != null) {
                PersistentDataContainer persistentDataContainer = currentItemMeta.getPersistentDataContainer();
                if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
            }
            if (e.getClick().equals(ClickType.NUMBER_KEY)) {
                Player player = (Player) e.getWhoClicked();
                ItemStack hotBar = player.getInventory().getItem(e.getHotbarButton());
                if (hotBar != null) {
                    ItemMeta hotBarItemMeta = hotBar.getItemMeta();
                    if (hotBarItemMeta != null) {
                        PersistentDataContainer persistentDataContainer = hotBarItemMeta.getPersistentDataContainer();
                        if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size")))
                            e.setCancelled(true);
                    }
                }
            }
        }
    }
}
