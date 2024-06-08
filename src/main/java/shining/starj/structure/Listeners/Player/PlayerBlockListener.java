package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerBlockListener extends AbstractEventListener {
    // 플레이어가 블럭 부수기를 멈추면 발생
    @EventHandler
    public void Events(BlockDamageAbortEvent e) {

    }

    // 플레이어에 의해 블럭이 데미지를 입으면 발생
    @EventHandler
    public void Events(BlockDamageEvent e) {

    }

    // 플레이어가 블럭 설치시 발생
    @EventHandler
    public void Events(BlockPlaceEvent e) {

    }

    // 침대, 문, 피스톤 등을 한번에 다중으로 설치하는 경우 발생
    @EventHandler
    public void Events(BlockMultiPlaceEvent e) {

    }

    // 블럭 파괴시 발동
    @EventHandler
    public void Events(BlockBreakEvent e) {

    }
}
