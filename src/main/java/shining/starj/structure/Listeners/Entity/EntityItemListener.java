package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntityItemListener extends AbstractEventListener {
    // 엔티티가 아이템을 떨어뜨리면 발생
    @EventHandler
    public void Events(EntityDropItemEvent e) {

    }

    // 엔티티가 아이템을 주으면 발생
    @EventHandler
    public void Events(EntityPickupItemEvent e) {

    }
}
