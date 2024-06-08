package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntityBattleListener extends AbstractEventListener {
    // 엔티티가 피해를 입는 경우 발생
    @EventHandler
    public void Events(EntityDamageEvent e) {

    }

    // 엔티티가 블럭에 의해 피해를 입는 경우 발생
    @EventHandler
    public void Events(EntityDamageByBlockEvent e) {

    }

    // 엔티티가 엔티티에 의해 피해를 입는 경우 발생
    @EventHandler
    public void Events(EntityDamageByEntityEvent e) {

    }

    // 엔티티가 사망하면 발생
    @EventHandler
    public void Events(EntityDeathEvent e) {

    }

    // 엔티티가 넉백을 받을 시 발생
    @EventHandler
    public void Events(EntityKnockbackEvent e) {

    }

    // 엔티티가 다른 엔티티에게 넉백을 받으면 발생
    @EventHandler
    public void Events(EntityKnockbackByEntityEvent e) {

    }

    // 엔티티가 체력을 회복하면 발생
    @EventHandler
    public void Events(EntityRegainHealthEvent e) {

    }

    // 엔티티가 죽어서 부활기회가 있을 때 발생
    @EventHandler
    public void Events(EntityResurrectEvent e) {

    }

    // 몸에 박힌 화살의 개수가 변하면 발생
    @EventHandler
    public void Events(ArrowBodyCountChangeEvent e) {

    }

    // 크리퍼가 충전시 발생
    @EventHandler
    public void Events(CreeperPowerEvent e) {

    }

    // 엔티티가 활을 발사하면 발생
    @EventHandler
    public void Events(EntityShootBowEvent e) {

    }

    // 소환사가 스펠을 시전하면 발생
    @EventHandler
    public void Events(EntitySpellCastEvent e) {

    }

}
