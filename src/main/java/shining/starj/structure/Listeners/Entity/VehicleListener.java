package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.entity.EntityMountEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.vehicle.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class VehicleListener extends AbstractEventListener {
    // 말이 점프하면 발생
    @EventHandler
    public void Events(HorseJumpEvent e) {

    }

    // 엔티티가 다른 엔티티에 탑승을 시도하면 발생
    @EventHandler
    public void Events(EntityMountEvent e) {

    }

    // 엔티티가 탈것을 타는 것을 멈추면 발생
    @EventHandler
    public void Events(EntityDismountEvent e) {

    }

    // 탈것과 관련된 사건이 생기면 발생
    @EventHandler
    public void Events(VehicleEvent e) {

    }

    // 탈것이 생성되면 발생
    @EventHandler
    public void Events(VehicleCreateEvent e) {

    }

    // 탈것이 피해를 입으면 발생
    @EventHandler
    public void Evetns(VehicleDamageEvent e) {

    }

    // 탈것이 파괴되면 발생
    @EventHandler
    public void Events(VehicleDestroyEvent e) {

    }

    // 엔티티가 탈것에 탑승하면 발생
    @EventHandler
    public void Events(VehicleEnterEvent e) {

    }

    // 엔티티가 탈것에서 내리면 발생
    @EventHandler
    public void Events(VehicleExitEvent e) {

    }

    // 탈것이 움직이면 발생
    @EventHandler
    public void Events(VehicleMoveEvent e) {

    }

    // 탈것이 업데이트되면 발생
    @EventHandler
    public void Events(VehicleUpdateEvent e) {

    }

    // 탈것이 충돌시 발생
    @EventHandler
    public void Events(VehicleCollisionEvent e) {

    }

    // 탈것이 블럭과 충돌시 발생
    @EventHandler
    public void Events(VehicleBlockCollisionEvent e) {

    }

    // 탈것이 엔티티와 충돌시 발생
    @EventHandler
    public void Events(VehicleEntityCollisionEvent e) {

    }
}
