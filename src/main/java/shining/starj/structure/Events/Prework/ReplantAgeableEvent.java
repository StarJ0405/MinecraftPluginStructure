package shining.starj.structure.Events.Prework;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.Block;

@Setter
@Getter
public class ReplantAgeableEvent extends ReplantEvent {
    private int age;

    public ReplantAgeableEvent(Block block, Material result, int age) {
        super(block, result);
        this.age = age;
    }

    public static class ReplantAgeableEventBuilder extends ReplantEvent.ReplantEventBuilder {
        private Block block;
        private Material result;
        private int age;

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

        public ReplantAgeableEventBuilder age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public ReplantAgeableEvent build() {
            return new ReplantAgeableEvent(block, result, age);
        }
    }
}
