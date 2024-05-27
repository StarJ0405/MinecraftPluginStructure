package shining.starj.structure.Predicates.Conditions;

import lombok.Builder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shining.starj.structure.Predicates.ConditionInterface;
@Builder
public record LevelCondition(@Nullable Integer min, @Nullable Integer max) implements ConditionInterface {
    @Override
    public boolean is(@NotNull Entity entity) {
        if (min == null && max == null) return true;
        if (entity instanceof Player player) {
            int level = player.getLevel();
            return (min == null || min <= level) && (max == null || level <= max);
        }
        return false;
    }

}
