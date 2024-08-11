package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import shining.starj.structure.Core;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class ChairListener extends AbstractEventListener {
    @EventHandler
    public void Events(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block != null && block.getType().name().contains("STAIRS")) {
            Location location = block.getLocation().clone().add(0.5,0.25,0.5);
            ArmorStand chair = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            chair.setInvisible(true);
            chair.addPassenger(player);
            chair.setSmall(true);
            chair.setInvulnerable(true);
            chair.setMetadata("remove", new FixedMetadataValue(Core.getCore(), true));
        }
    }
}
