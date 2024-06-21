package shining.starj.structure.Listeners.PreWork.Event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;

@Setter
@Getter
public class ReplantAgeableEvent extends ReplantEvent {
    private int age;

    public ReplantAgeableEvent(Block block, Material type) {
        super(block, type);
        this.age = 0;
    }
}
