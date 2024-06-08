package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntityBlockListener extends AbstractEventListener {
    // 엔티티가 문을 부술시 발생
    @EventHandler
    public void Events(EntityBreakDoorEvent e) {

    }

    // 엔티티가 블럭 변경시 발생
    @EventHandler
    public void Events(EntityChangeBlockEvent e) {

    }
    // 좀벌레, 벌 등의 엔티티가 블럭에 들어가면 발생
    @EventHandler
    public void Events(EntityEnterBlockEvent e){

    }

}
