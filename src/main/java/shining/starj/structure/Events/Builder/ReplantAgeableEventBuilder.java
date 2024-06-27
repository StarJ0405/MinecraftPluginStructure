package shining.starj.structure.Events.Builder;

import org.bukkit.Material;
import org.bukkit.block.Block;
import shining.starj.structure.Events.Prework.ReplantAgeableEvent;

public class ReplantAgeableEventBuilder extends ReplantEventBuilder {
    protected int age;

    @Override
    public ReplantAgeableEventBuilder block(Block block) {
        this.block = block;
        return this;
    }

    @Override
    public ReplantAgeableEventBuilder result(Material result) {
        this.result = result;
        return this;
    }


    public ReplantAgeableEvent build() {
        return new ReplantAgeableEvent(block, result);
    }
}
