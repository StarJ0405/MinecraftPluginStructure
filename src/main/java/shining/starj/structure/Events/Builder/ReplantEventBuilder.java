package shining.starj.structure.Events.Builder;

import org.bukkit.Material;
import org.bukkit.block.Block;
import shining.starj.structure.Events.Prework.ReplantEvent;

public class ReplantEventBuilder {
    protected Block block;
    protected Material result;

    public ReplantEventBuilder block(Block block) {
        this.block = block;
        return this;
    }

    public ReplantEventBuilder result(Material result) {
        this.result = result;
        return this;
    }

    public ReplantEvent build() {
        return new ReplantEvent(block, result);
    }
}
