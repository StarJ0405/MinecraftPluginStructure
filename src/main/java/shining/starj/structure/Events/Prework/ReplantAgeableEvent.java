package shining.starj.structure.Events.Prework;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import shining.starj.structure.Events.Builder.ReplantAgeableEventBuilder;

@Setter
@Getter
public class ReplantAgeableEvent extends ReplantEvent {
    private int age;

    public ReplantAgeableEvent(Block block, Material type) {
        super(block, type);
        this.age = 0;
    }

    public static final ReplantAgeableEventBuilder ReplantAgeableEventBuilder = new ReplantAgeableEventBuilder();

    public static ReplantAgeableEventBuilder builder() {
        return ReplantAgeableEventBuilder;
    }
}
