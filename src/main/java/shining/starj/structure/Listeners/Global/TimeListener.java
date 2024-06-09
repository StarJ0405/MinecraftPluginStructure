package shining.starj.structure.Listeners.Global;

import lombok.Builder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.TimeSkipEvent;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Listeners.PreWork.Event.TimerEvent;

@Builder
public class TimeListener extends AbstractEventListener {
    // 20tick 마다 발동하는 시간 이벤트
    @EventHandler
    public void Events(TimerEvent e){

    }

    // 시간이 스킵이 일어났을때 발생
    @EventHandler
    public void Events(TimeSkipEvent e) {

    }
}
