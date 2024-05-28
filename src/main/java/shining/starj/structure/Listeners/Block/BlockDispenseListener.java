package shining.starj.structure.Listeners.Block;

import lombok.Builder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class BlockDispenseListener extends AbstractEventListener {
    // block 디스펜서 위치
    // dispensed 발사된 아이템
    // velocity 아이템 속도
    @EventHandler
    public void Events(BlockDispenseEvent e) {

    }
}
