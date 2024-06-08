package shining.starj.structure.Listeners.Global;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class ChunkListener extends AbstractEventListener {
    // 청크와 관련된 사건이 생기면 발생
    @EventHandler
    public void Events(ChunkEvent e) {

    }

    // 청크가 로드될 때 발생
    @EventHandler
    public void Events(ChunkLoadEvent e) {

    }

    // 새롭게 생성된 쳥크내에 블럭이 채우기가 완료되면 발생
    @EventHandler
    public void Events(ChunkPopulateEvent e) {

    }

    // 쳥크가 언로드될 때 발생
    @EventHandler
    public void Events(ChunkUnloadEvent e) {

    }

    // 엔티티들이 로드될 때 발생
    @EventHandler
    public void Events(EntitiesLoadEvent e) {

    }

    // 엔티티들이 언로드될 때 발생
    @EventHandler
    public void Events(EntitiesUnloadEvent e) {

    }
}
