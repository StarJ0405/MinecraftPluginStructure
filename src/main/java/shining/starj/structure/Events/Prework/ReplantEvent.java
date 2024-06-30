package shining.starj.structure.Events.Prework;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import shining.starj.structure.Events.AbstractCancelableEvent;

@Getter
@Setter
public class ReplantEvent extends AbstractCancelableEvent {
    private final Block block;
    private Material result;

    @Builder
    public ReplantEvent(Block block, Material result) {
        this.block = block;
        this.result = result;
    }
}
