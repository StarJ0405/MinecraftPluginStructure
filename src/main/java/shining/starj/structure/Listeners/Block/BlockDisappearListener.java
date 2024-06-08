package shining.starj.structure.Listeners.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class BlockDisappearListener extends AbstractEventListener {
    // 블럭이 불타면 발생
    @EventHandler
    public void Event(BlockBurnEvent e) {

    }

    // 블럭 폭발시 발생
    @EventHandler
    public void Events(BlockExplodeEvent e) {

    }

    // 세계 설정 조건으로 눈, 얼음, 산호, 불, 거북알 등이 사라지면 발생
    @EventHandler
    public void Events(BlockFadeEvent e) {

    }

    // 잎이 부식되는 경우 발생
    @EventHandler
    public void Events(LeavesDecayEvent e) {

    }
    // TNT가 불이 붙은 경우 발생
    @EventHandler
    public void Events(TNTPrimeEvent e){

    }
}
