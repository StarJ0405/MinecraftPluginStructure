package shining.starj.structure.Listeners.Global;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class GenerateListener extends AbstractEventListener {
    @EventHandler
    public void Events(PortalCreateEvent e) {

    }

    // 비동기적 인위적으로 구조물이 생성됬을 때 발생
    @EventHandler
    public void Events(AsyncStructureGenerateEvent e) {

    }

    // 비동기적 자연적으로 구조물이 생성됬을 때 발생
    @EventHandler
    public void Events(AsyncStructureSpawnEvent e) {

    }

    // 유기 구조물(묘목, 버섯 등)이 성장하여 생성 됬을 때 발생
    @EventHandler
    public void Events(StructureGrowEvent e) {

    }

    // 루트 테이블에 맞춰서 루트가 생성될 때 발생
    @EventHandler
    public void Events(LootGenerateEvent e) {

    }
}
