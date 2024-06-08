package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntityStatusListener extends AbstractEventListener {
    // 엔티티의 공기(호흡) 변경시 발생
    @EventHandler
    public void Events(EntityAirChangeEvent e) {

    }

    // 엔티티가 불타는 경우 발생
    @EventHandler
    public void Events(EntityCombustEvent e) {

    }

    // 엔티티가 블럭에 의해 불타는 경우 발생
    @EventHandler
    public void Events(EntityCombustByBlockEvent e) {

    }

    // 엔티티가 엔티티에 의해 불타는 경우 발생
    @EventHandler
    public void Events(EntityCombustByEntityEvent e) {

    }

    // 엔티티가 사랑 모드에 들어가면 발생
    @EventHandler
    public void Events(EntityEnterLoveModeEvent e) {

    }

    // 엔티티가 포즈를 바꾸면 발생
    @EventHandler
    public void Events(EntityPoseChangeEvent e) {

    }

    // 엔티티의 포션 효과가 바뀌면 발생
    @EventHandler
    public void Events(EntityPotionEffectEvent e) {

    }

    @EventHandler
    public void Events(EntityRemoveEvent e) {

    }

    // 엔티티가 끈에서 풀려나면 발생
    @EventHandler
    public void Events(EntityUnleashEvent e) {

    }

    // 엔티티가 폭발하는 경우 발생
    @EventHandler
    public void Events(EntityExplodeEvent e) {

    }

    // 엔티티가 폭발하기로 결정되면 발생
    @EventHandler
    public void Events(ExplosionPrimeEvent e) {

    }

    // 박쥐가 잠들면 발생
    @EventHandler
    public void Events(BatToggleSleepEvent e) {

    }

    // 엔더드래곤의 페이즈 변경시 발생
    @EventHandler
    public void Events(EnderDragonChangePhaseEvent e) {

    }

    // 돼지 좀비가 화가 나면 발생
    @EventHandler
    public void Events(PigZombieAngerEvent e) {

    }

    // 양의 털색깔이 변경되면 발생
    @EventHandler
    public void Events(SheepDyeWoolEvent e) {

    }

    // 양털이 다시 자라면 발생
    @EventHandler
    public void Events(SheepRegrowWoolEvent e) {

    }

    // 스트라이더가 온도로 바뀌면 발생
    @EventHandler
    public void Events(StriderTemperatureChangeEvent e) {

    }

    // 주민의 직업이 바뀔 때 발생
    @EventHandler
    public void Events(VillagerCareerChangeEvent e) {

    }

    // 주민의 물건이 재입고 될 때 발생
    @EventHandler
    public void Events(VillagerReplenishTradeEvent e) {

    }
}
