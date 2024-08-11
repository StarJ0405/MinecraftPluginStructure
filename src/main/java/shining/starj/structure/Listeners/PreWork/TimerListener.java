package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Events.Prework.TimerEvent;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class TimerListener extends AbstractEventListener {
    /*
     * 시간 관련
     */
    private void refillItems(Block block) {
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().setFuel(new ItemStack(Material.LAVA_BUCKET));
        furnace.getInventory().setResult(Items.timer.getItemStack());
        ItemStack time = getTimer();
        time.setAmount(60);
        furnace.getInventory().setSmelting(time);
    }

    private Location getTimeLocation() {
        Location loc = Bukkit.getWorlds().getFirst().getSpawnLocation().getBlock().getLocation().clone();
        loc.setY(-64);
        return loc;
    }

    private boolean isCorrectLocation(Block block) {
        return block.getLocation().equals(getTimeLocation());
    }

    private void removeFurnace(Block block) {
        Location loc = block.getLocation();
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().clear();
        if (loc.getY() == -64) block.setType(Material.BEDROCK, true);
        else {
            block.setType(Material.AIR);
            for (int x = -1; x <= 1; x++)
                for (int y = -1; y <= 0; y++)
                    for (int z = -1; z < 1; z++)
                        if (x != 0 && y != 0 && z != 0) {
                            Location now = block.getLocation().clone().add(x, y, z);
                            if (now.getBlock().getType().equals(Material.BEDROCK))
                                now.getBlock().setType(Material.AIR, true);
                        }
        }
    }

    private ItemStack getTimer() {
        return Items.timer.getItemStack();
    }

    private boolean isItem(ItemStack item) {
        return item.isSimilar(getTimer());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Event(FurnaceSmeltEvent e) {
        Block block = e.getBlock();
        if (isItem(e.getSource())) if (isCorrectLocation(block)) {
            refillItems(block);
            Bukkit.getPluginManager().callEvent(TimerEvent.builder().block(block).build());
        } else removeFurnace(block);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Event(ServerLoadEvent e) {
        Location timeLocation = getTimeLocation();
        for (int x = -2; x <= 2; x++)
            for (int y = 0; y <= 2; y++)
                for (int z = -2; z < 2; z++)
                    if (x != 0 || y != 0 || z != 0)
                        timeLocation.clone().add(x, y, z).getBlock().setType(Material.BEDROCK, true);
        Block block = timeLocation.getBlock();
        block.setType(Material.FURNACE);
        block.getChunk().setForceLoaded(true);
        refillItems(block);
    }


    @EventHandler(priority = EventPriority.LOWEST)
    public void Event(FurnaceBurnEvent e) {
        Block block = e.getBlock();
        if (isCorrectLocation(block)) refillItems(block);
    }
}