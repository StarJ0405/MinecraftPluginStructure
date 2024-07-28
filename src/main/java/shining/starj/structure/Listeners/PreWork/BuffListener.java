package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.event.EventHandler;
import shining.starj.structure.Buffs.BuffStore;
import shining.starj.structure.Events.Prework.TimerEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class BuffListener extends AbstractEventListener {

    @EventHandler
    public void Events(TimerEvent e) {
        for (BuffStore buff : BuffStore.getList()) buff.tickAll();
    }
}
