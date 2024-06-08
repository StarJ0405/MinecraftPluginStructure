package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class HangingEntityListener extends AbstractEventListener {
    // 행잉 엔티티가 파괴되면 발생
    @EventHandler
    public void Events(HangingBreakEvent e){

    }
    // 엔티티에 의해 행잉 엔티티가 파괴되면 발생
    @EventHandler
    public void Events(HangingBreakByEntityEvent e){

    }
    // 행잉 엔티티가 설치되면 발생
    @EventHandler
    public void Events(HangingPlaceEvent e){

    }
}
