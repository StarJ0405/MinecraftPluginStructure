package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import shining.starj.structure.Core;
import shining.starj.structure.Events.Prework.HarvestEvent;
import shining.starj.structure.Events.Prework.ReplantAgeableEvent;
import shining.starj.structure.Events.Prework.ReplantEvent;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Systems.MethodStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Builder
public class HarvestListener extends AbstractEventListener {
    /*
     * 작물캐기
     */
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void Events(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && item != null && item.getType().name().contains("HOE")) {
            Block clickedBlock = e.getClickedBlock();
            if (clickedBlock != null) {
                HarvestEvent event = null;


                switch (clickedBlock.getType()) {
                    case WHEAT -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.WHEAT)).length(1).fortune(true).build());
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.WHEAT_SEEDS)).min(0).max(3).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case CARROTS -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.CARROT)).min(1).max(4).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case POTATOES -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.POTATO)).min(1).max(4).fortune(true).build());
                            if (new Random().nextDouble() < 0.02d)
                                rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.POISONOUS_POTATO)).length(1).fortune(false).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case BEETROOTS -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.BEETROOT)).length(1).fortune(true).build());
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.BEETROOT_SEEDS)).min(1).max(4).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case NETHER_WART -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.NETHER_WART)).min(2).max(4).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case COCOA -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.COCOA_BEANS)).min(2).max(3).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case MELON -> {
                        List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                        rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.MELON_SLICE)).min(3).max(7).fortune(true).build());
                        event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                    }
                    case PUMPKIN -> {
                        List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                        PersistentDataContainer container = clickedBlock.getChunk().getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(Core.getCore(), MethodStore.LocationToStringKey(clickedBlock.getLocation()));
                        boolean fortune = container.has(key, PersistentDataType.BOOLEAN) ? container.get(key, PersistentDataType.BOOLEAN) : false;
                        rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.PUMPKIN)).length(1).fortune(fortune).build());
                        event = HarvestEvent.builder().player(e.getPlayer()).exp(fortune ? 1 : 0).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                    }
                    case SUGAR_CANE -> {
                        List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                        PersistentDataContainer container = clickedBlock.getChunk().getPersistentDataContainer();
                        NamespacedKey key = new NamespacedKey(Core.getCore(), MethodStore.LocationToStringKey(clickedBlock.getLocation()));
                        boolean fortune = container.has(key, PersistentDataType.BOOLEAN) ? container.get(key, PersistentDataType.BOOLEAN) : false;
                        rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.SUGAR_CANE)).length(1).fortune(fortune).build());
                        event = HarvestEvent.builder().player(e.getPlayer()).exp(fortune ? 1 : 0).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                    }
                }
                if (event == null) return;
                Bukkit.getPluginManager().callEvent(event);
                if (!event.isCancelled()) {
                    ItemStack hoe = event.getHoe();
                    Block block = event.getBlock();
                    Material type = block.getType();
                    Location loc = block.getLocation().clone().add(0.5, 0.25, 0.5);
                    int exp = event.getExp();
                    if (exp > 0) {
                        ExperienceOrb experienceOrb = (ExperienceOrb) loc.getWorld().spawnEntity(loc, EntityType.EXPERIENCE_ORB);
                        experienceOrb.setExperience(exp);
                    }
                    block.getChunk().getPersistentDataContainer().remove(new NamespacedKey(Core.getCore(), MethodStore.LocationToStringKey(block.getLocation())));
                    int max = event.isFortune() ? hoe.getEnchantmentLevel(Enchantment.FORTUNE) : 0;
                    for (HarvestEvent.RangeItem rangeItem : event.getRangeItems())
                        loc.getWorld().dropItem(loc, rangeItem.getItem(max));
                    block.setType(Material.AIR, true);

                    PlayerItemDamageEvent playerItemDamageEvent = new PlayerItemDamageEvent(event.getPlayer(), hoe, 1);
                    Bukkit.getPluginManager().callEvent(playerItemDamageEvent);
                    if (!playerItemDamageEvent.isCancelled()) {
                        Damageable damageable = (Damageable) hoe.getItemMeta();
                        int level = event.isUnbreaking() ? hoe.getEnchantmentLevel(Enchantment.UNBREAKING) : 0;
                        double chance = new Random().nextDouble();
                        if (chance < 1d / (1 + level) && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                            damageable.setDamage(damageable.getDamage() + 1);
                            int maxDurability = damageable.hasMaxDamage() ? damageable.getMaxDamage() : hoe.getType().getMaxDurability();
                            if (damageable.getDamage() >= maxDurability) hoe.setAmount(0);
                        }
                        hoe.setItemMeta(damageable);
                    }
                    if (event.isRePlant()) {
                        ReplantEvent replantEvent = null;
                        switch (event.getBlock().getType()) {
                            case WHEAT, CARROTS, POTATOES, BEETROOTS, COCOA, NETHER_WART ->
                                    replantEvent = ReplantAgeableEvent.builder().block(event.getBlock()).result(type).build();
                            case MELON, SUGAR_CANE, PUMPKIN ->
                                    replantEvent = ReplantEvent.builder().block(event.getBlock()).result(type).build();
                        }
                        if (replantEvent == null) return;
                        Bukkit.getPluginManager().callEvent(replantEvent);
                        if (!replantEvent.isCancelled()) {
                            Block replantBlock = replantEvent.getBlock();
                            replantBlock.setType(replantEvent.getResult(), true);
                            if (replantEvent instanceof ReplantAgeableEvent) {
                                Ageable ageable = (Ageable) block.getBlockData();
                                ageable.setAge(((ReplantAgeableEvent) replantEvent).getAge());
                                block.setBlockData(ageable);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(BlockGrowEvent e) {
        Block block = e.getBlock();
        PersistentDataContainer container = block.getChunk().getPersistentDataContainer();
        container.set(new NamespacedKey(Core.getCore(), MethodStore.LocationToStringKey(block.getLocation())), PersistentDataType.BOOLEAN, true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(BlockBreakEvent e) {
        Block block = e.getBlock();
        PersistentDataContainer container = block.getChunk().getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Core.getCore(), MethodStore.LocationToStringKey(block.getLocation()));
        if (container.has(key, PersistentDataType.BOOLEAN)) container.remove(key);
    }
}
