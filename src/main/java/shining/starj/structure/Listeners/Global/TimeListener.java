package shining.starj.structure.Listeners.Global;

import lombok.Builder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.TimeSkipEvent;
import shining.starj.structure.Listeners.Global.Abstract.AbstractTimeListener;

@Builder
public class TimeListener extends AbstractTimeListener {
    // 20tick 마다 발동하는 시간 이벤트
    @Override
    public void TimePassEvent() {

    }

    // 시간이 스킵이 일어났을때 발생
    @EventHandler
    public void Events(TimeSkipEvent e) {

    }
}
