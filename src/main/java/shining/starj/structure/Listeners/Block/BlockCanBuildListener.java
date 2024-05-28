package shining.starj.structure.Listeners.Block;

import lombok.Builder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockCanBuildEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class BlockCanBuildListener extends AbstractEventListener {
    // block - 기존 블럭
    // player - 설치 시도 플레이어
    // type - 새롭게 설치하려는 블럭 데이터
    // boolean canBuild - 설치 가능 여부
    @EventHandler
    public void Events(BlockCanBuildEvent e) {

    }
}
