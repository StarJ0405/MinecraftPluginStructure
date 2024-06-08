package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntityPortalListener extends AbstractEventListener {
    // 플레이어가 아닌 엔티티가 포탈에 접근하여 텔레포트하는 경우 발생
    @EventHandler
    public void Events(EntityPortalEvent e){

    }
    // 엔티티가 포탈에 접근하는 경우 발생
    @EventHandler
    public void Events(EntityPortalEnterEvent e){

    }
    // 엔티티가 포탈을 나가기 직전에 발생
    @EventHandler
    public void Events(EntityPortalExitEvent e){

    }
    @EventHandler
    public void Events(EntityTeleportEvent e){

    }

}
