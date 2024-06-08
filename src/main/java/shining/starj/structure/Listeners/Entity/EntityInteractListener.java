package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntityInteractListener extends AbstractEventListener {
    // 엔티티가 교배 성공시 발생
    @EventHandler
    public void Events(EntityBreedEvent e) {

    }

    // 엔티티가 상호작용시 발생
    @EventHandler
    public void Events(EntityInteractEvent e) {

    }

    // 엔티티가 타겟을 바꾸거나 타겟이 없어지면 발생
    @EventHandler
    public void Events(EntityTargetEvent e) {

    }

    // 엔티티가 리빙 엔티티를 타겟으로 삼으면 발생
    @EventHandler
    public void Events(EntityTargetLivingEntityEvent e) {

    }

    // 엔티티가 테이밍되면 발생
    @EventHandler
    public void Events(EntityTameEvent e) {

    }

    // 피글린 물물교환시 발생
    @EventHandler
    public void Events(PiglinBarterEvent e) {

    }

    // 주민이 새로운 거래를 얻을 때 발생
    @EventHandler
    public void Events(VillagerAcquireTradeEvent e) {

    }
}
