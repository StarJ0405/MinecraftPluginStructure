package shining.starj.structure.Listeners.Block;

import lombok.Builder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class BlockActiveListener extends AbstractEventListener {
    // 디스펜서 발사 이벤트
    @EventHandler
    public void Events(BlockDispenseEvent e) {

    }

    // 디스펜서로 아이템 장착 이벤트
    @EventHandler
    public void Events(BlockDispenseArmorEvent e) {

    }

    // 블럭 피스톤이 작동할 때 발생
    @EventHandler
    public void Events(BlockPistonEvent e) {

    }

    // 블럭 피스톤이 확장할 때 발생
    @EventHandler
    public void Events(BlockPistonExtendEvent e) {

    }

    // 블럭 피스톤이 축소할 때 발생
    @EventHandler
    public void Events(BlockPistonRetractEvent e) {

    }

    // 스컬크 센서가 게임 이벤트를 수신하면 발생
    @EventHandler
    public void Events(BlockReceiveGameEvent e) {

    }

    // 디스펜서로 양털 깍을 때 발생
    @EventHandler
    public void Events(BlockShearEntityEvent e) {

    }

    // 블럭에서 음식이 구워지면 발생
    @EventHandler
    public void Events(BlockCookEvent e) {

    }
    // 노트 블럭 작동시 발생
    @EventHandler
    public void Events(NotePlayEvent e){

    }
}
