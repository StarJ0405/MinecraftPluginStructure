package shining.starj.structure.Predicates.Conditions;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shining.starj.structure.Predicates.ConditionInterface;
import shining.starj.structure.Systems.ScoreboardStore;

@Builder
public record ScoreCondition(@NotNull String name, @Nullable Integer min,
                             @Nullable Integer max) implements ConditionInterface {
    @Override
    public boolean is(@NotNull Entity entity) {
        if (min == null && max == null) return true;
        if (entity instanceof Player player) {
            Objective objective = player.getScoreboard().getObjective(name);
            int value = objective.getScore(player.getName()).getScore();
            return (min == null || value >= min) && (max == null || value <= max);
        } else {
            Objective objective = ScoreboardStore.getScoreboard().getObjective(name);
            int value = objective.getScore(entity.getUniqueId().toString()).getScore();
            return (min == null || value >= min) && (max == null || value <= max);
        }
    }
}
