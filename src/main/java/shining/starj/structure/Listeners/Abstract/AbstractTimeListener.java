package shining.starj.structure.Listeners.Abstract;

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
import shining.starj.structure.Listeners.AbstractEventListener;

public abstract class AbstractTimeListener extends AbstractEventListener {
    private final Location timeLocation = getTimeLocation();

    public abstract void Events();


    private Location getTimeLocation() {
        Location loc = Bukkit.getWorlds().getFirst().getSpawnLocation().getBlock().getLocation().clone();
        loc.setY(-64);
        return loc;
    }

    private void refillItems(Block block) {
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().setFuel(new ItemStack(Material.LAVA_BUCKET));
        furnace.getInventory().setResult(new ItemStack(Material.AIR));
        ItemStack time = new ItemStack(Material.PORKCHOP, 64);
        furnace.getInventory().setSmelting(time);
    }

    private boolean isCorrectLocation(Block block) {
        return block.getLocation().equals(timeLocation);
    }

    private void removeFurnace(Block block) {
        Location loc = block.getLocation();
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().clear();
        if (loc.getY() == -64)
            block.setType(Material.BEDROCK, true);
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

    private boolean isItem(ItemStack item) {
        return true;
    }

    @EventHandler
    public void Events(FurnaceSmeltEvent e) {
        Block block = e.getBlock();
        if (isItem(e.getResult()))
            if (isCorrectLocation(block)) {
                refillItems(block);
                Events();
            } else
                removeFurnace(block);
    }

    @EventHandler
    public void Events(ServerLoadEvent e) {
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 0; y++)
                for (int z = -1; z < 1; z++)
                    if (x != 0 && y != 0 && z != 0)
                        timeLocation.clone().add(x, y, z).getBlock().setType(Material.BEDROCK, true);
        Block block = timeLocation.getBlock();
        block.setType(Material.FURNACE);
        block.getChunk().setForceLoaded(true);
        refillItems(block);
    }


    @EventHandler
    public void Events(FurnaceBurnEvent e) {
        Block block = e.getBlock();
        if (isCorrectLocation(block))
            refillItems(block);
    }
}
