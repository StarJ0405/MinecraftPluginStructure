package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class NotLivingEntityListener extends AbstractEventListener {
    // 잔류형 포션이 터지면 발생
    @EventHandler
    public void Events(LingeringPotionSplashEvent e) {

    }

    // 잔류형 포션에 영향을 받으면 발생
    @EventHandler
    public void Events(AreaEffectCloudApplyEvent e) {

    }

    // 폭죽이 터지면 발생
    @EventHandler
    public void Events(FireworkExplodeEvent e) {

    }

    // 투척용 포션이 부딪히면 발생
    @EventHandler
    public void Events(PotionSplashEvent e) {

    }

    // 투사체가 부딪히면 발생
    @EventHandler
    public void Events(ProjectileHitEvent e) {

    }

    // 투사체가 발사되면 발생
    @EventHandler
    public void Events(ProjectileLaunchEvent e) {

    }

    // 갑옷 거치대, 배, 카트, 엔드 수정 등의 엔티티가 설치에 의해 생성시 발생
    @EventHandler
    public void Events(EntityPlaceEvent e) {

    }
    // 던져진 경험치병이 부딪혀 경험치 구슬이 생길 때 발생
    @EventHandler
    public void Events(ExpBottleEvent e){

    }
}
