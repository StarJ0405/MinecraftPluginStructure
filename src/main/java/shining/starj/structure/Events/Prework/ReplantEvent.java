package shining.starj.structure.Events.Prework;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import shining.starj.structure.Events.AbstractCancelableEvent;
import shining.starj.structure.Events.Builder.ReplantEventBuilder;

@Getter
public class ReplantEvent extends AbstractCancelableEvent {
    private final Block block;
    @Setter
    private Material result;

    public ReplantEvent(Block block, Material result) {
        this.block = block;
        this.result = result;
    }

    public static final ReplantEventBuilder ReplantEventBuilder = new ReplantEventBuilder();

    public static ReplantEventBuilder builder() {
        return ReplantEventBuilder;
    }
}
