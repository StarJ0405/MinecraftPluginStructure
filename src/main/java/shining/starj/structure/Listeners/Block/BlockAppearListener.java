package shining.starj.structure.Listeners.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class BlockAppearListener extends AbstractEventListener {
    // 블럭 설치 시도시 발생
    @EventHandler
    public void Events(BlockCanBuildEvent e) {

    }
    // 뼛가루로 비료를 뿌렸을 때 발생
    @EventHandler
    public void Events(BlockFertilizeEvent e) {

    }

    // 세계 설정 조건으로 눈, 얼음, 흑요석, 조약돌, 콘크리트 등이 형성되면 발생
    @EventHandler
    public void Events(BlockFormEvent e) {

    }

    // 버섯, 불, 균사체 등이 퍼질 때 발생
    @EventHandler
    public void Events(BlockSpreadEvent e) {

    }
    // 눈사람, 차가운 발걸음 인챈트에 의해 블럭 생성시 발생
    @EventHandler
    public void Events(EntityBlockFormEvent e){

    }
    // 밀, 사탕수수, 선인장, 수박, 호박, 거북알 등이 성장하는 경우 발생
    @EventHandler
    public void Events(BlockGrowEvent e){

    }
    // 스컬크 촉매로 인해 새로운 스컬크 생성시 발생
    @EventHandler
    public void Events(SculkBloomEvent e){

    }

}