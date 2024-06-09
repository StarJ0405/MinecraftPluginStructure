package shining.starj.structure.Listeners.PreWork.Event;

import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
public class TimerEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Block block;

    public TimerEvent(Block block) {
        this.block = block;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }


}
