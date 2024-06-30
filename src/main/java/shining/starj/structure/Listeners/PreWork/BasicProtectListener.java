package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class BasicProtectListener extends AbstractEventListener {
    /*
     * 작물 보호
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.FARMLAND))
            e.setCancelled(true);
    }

    /*
     * 폭발 보호
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(BlockExplodeEvent e) {
        e.blockList().clear();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(EntityExplodeEvent e) {
        e.blockList().clear();
    }

    /*
     * 화염 보호
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(BlockIgniteEvent e) {
        if (e.getCause().equals(BlockIgniteEvent.IgniteCause.SPREAD)) e.setCancelled(true);
    }
}
