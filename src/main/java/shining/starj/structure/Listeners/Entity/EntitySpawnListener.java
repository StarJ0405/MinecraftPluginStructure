package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EntitySpawnListener extends AbstractEventListener {
    // 엔티티가 생기면 발생
    @EventHandler
    public void Events(EntitySpawnEvent e) {

    }

    // 생물 생성시 발생
    @EventHandler
    public void Events(CreatureSpawnEvent e) {

    }

    // 슬라임 분할 이벤트
    @EventHandler
    public void Events(SlimeSplitEvent e) {

    }

    // 피그맨, 호글린, 스케렐톤, 좀비, 주민 등이 다른 엔티티로 대체(변형)될 때 발생
    @EventHandler
    public void Events(EntityTransformEvent e) {

    }

    // 돼지가 번개를 맞아 피글린이 되면 발생
    @EventHandler
    public void Events(PigZapEvent e) {

    }
    // 스포너에 의해 엔티티가 소환되면 발생
    @EventHandler
    public void Events(SpawnerSpawnEvent e){

    }
}
