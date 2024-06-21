package shining.starj.structure.Listeners.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class BlockStatusListener extends AbstractEventListener {
    // 블럭에 불이 붙은 경우 발생
    @EventHandler
    public void Events(BlockIgniteEvent e){

    }
    // 물, 용암, 드래곤 알 등이 원천 블럭과 대상 블럭이 있는 이벤트를 나타내는 경우 발생
    @EventHandler
    public void Events(BlockFromToEvent e){

    }
    // 레드스톤 상태 변경시 발생
    @EventHandler
    public  void Events(BlockRedstoneEvent e){

    }
    // 블럭의 액체 레벨이 변경시 발생
    @EventHandler
    public void Events(FluidLevelChangeEvent e){

    }
    // 고체 블럭의 수분 변경시 발생
    @EventHandler
    public void Events(MoistureChangeEvent e){

    }
    // 표지판 변경시 발생
    @EventHandler
    public void Events(SignChangeEvent e){

    }
    // 스폰지가 물을 빨아들인 경우 발생
    @EventHandler
    public void Events(SpongeAbsorbEvent e){

    }
}
