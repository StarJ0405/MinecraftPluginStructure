package shining.starj.structure.Events.Prework;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.block.Block;
import shining.starj.structure.Events.AbstractEvent;

@Getter
public class TimerEvent extends AbstractEvent {
    private final Block block;

    @Builder
    public TimerEvent(Block block) {
        this.block = block;
    }
}
