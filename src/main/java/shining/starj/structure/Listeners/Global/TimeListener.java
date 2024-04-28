package shining.starj.structure.Listeners.Global;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Listeners.AbstractEventListener;

public class TimeListener extends AbstractEventListener {
    private final Location timeLocation = getTimeLocation();

    @EventHandler
    public void Events(FurnaceSmeltEvent e) {
        ItemStack item = e.getResult();
        Items i = Items.valueOf(item);
        Block block = e.getBlock();
        if (true) {// i.getKey().equals(Items.time.getKey())) {
            Furnace furnace = (Furnace) block.getState();
            if (block.getLocation().equals(timeLocation)) {
                furnace.getInventory().setFuel(new ItemStack(Material.LAVA_BUCKET));
                furnace.getInventory().setResult(new ItemStack(Material.AIR));
//                    ItemStack time = Items.time.getItemStack();
                ItemStack time = new ItemStack(Material.PORKCHOP);
                time.setAmount(64);
                furnace.getInventory().setSmelting(time);
            }
        }
    }

    @EventHandler
    public void Events(ServerLoadEvent e) {
        Block block = timeLocation.getBlock();
        block.setType(Material.FURNACE);
        block.getChunk().setForceLoaded(true);
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().setFuel(new ItemStack(Material.LAVA_BUCKET));
        furnace.getInventory().setResult(new ItemStack(Material.AIR));
//        ItemStack time = Items.time.getItemStack();
        ItemStack time = new ItemStack(Material.PORKCHOP);
        time.setAmount(64);
        furnace.getInventory().setSmelting(time);
    }

    public Location getTimeLocation() {
        Location loc = Bukkit.getWorlds().getFirst().getSpawnLocation().getBlock().getLocation().clone();
        loc.setY(-64);
        return loc;
    }

    @EventHandler
    public void Events(FurnaceBurnEvent e) {
        Block block = e.getBlock();
        if (block.getLocation().equals(timeLocation)) {
            Furnace furnace = (Furnace) block.getState();
            furnace.getInventory().setFuel(new ItemStack(Material.LAVA_BUCKET));
        }
    }
}
