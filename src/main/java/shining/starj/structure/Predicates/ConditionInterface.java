package shining.starj.structure.Predicates;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface ConditionInterface {
    boolean is(@NotNull Entity entity);
}
