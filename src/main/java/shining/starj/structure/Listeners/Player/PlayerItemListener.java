package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerItemListener extends AbstractEventListener {
    // 플레이어가 아이템을 떨어뜨리면 발생
    @EventHandler
    public void Events(PlayerDropItemEvent e) {

    }

    // 플레이어의 아이템이 파괴될시 발생
    @EventHandler
    public void Events(PlayerItemBreakEvent e) {

    }

    // 플레이어가 소모성 아이템을 사용할 때 발생
    @EventHandler
    public void Events(PlayerItemConsumeEvent e) {

    }

    // 플레이어의 아이템 내구도에 피해를 입으면 발생
    @EventHandler
    public void Events(PlayerItemDamageEvent e) {

    }

    // 플레이어가 핫바 슬롯을 바꾸면 발생
    @EventHandler
    public void Events(PlayerItemHeldEvent e) {

    }

    // 플레이어가 수선을 통해 아이템을 수리한 경우 발생
    @EventHandler
    public void Events(PlayerItemMendEvent e) {

    }

    //플레이어가 화살을 주우면 발생
    @EventHandler
    public void Events(PlayerPickupArrowEvent e) {

    }

    // 플레이어가 주손과 보조손의 아이템을 교환하면 발생
    @EventHandler
    public void Events(PlayerSwapHandItemsEvent e) {

    }
}
