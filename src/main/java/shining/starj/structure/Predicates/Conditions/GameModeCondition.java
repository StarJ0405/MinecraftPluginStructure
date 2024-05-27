package shining.starj.structure.Predicates.Conditions;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Predicates.ConditionInterface;

import java.util.List;

@Builder
public record GameModeCondition(@NotNull List<GameMode> gameModes) implements ConditionInterface {
    @Override
    public boolean is(@NotNull Entity entity) {
        if (gameModes.isEmpty()) return true;
        if (entity instanceof Player player)
            return gameModes.stream().anyMatch(mode -> mode.equals(player.getGameMode()));
        return false;
    }
}
