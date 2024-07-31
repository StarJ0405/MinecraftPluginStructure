package shining.starj.structure.Systems;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;

public class ScoreboardStore {
    private static final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    @Getter
    private static final Scoreboard scoreboard = scoreboardManager.getMainScoreboard();

    public ScoreboardStore setObjective(String name, String displayName, DisplaySlot slot) {
        return setObjective(name, displayName, slot, RenderType.INTEGER);
    }

    public ScoreboardStore setObjective(String name, String displayName, DisplaySlot slot, RenderType type) {
        Objective objective = scoreboard.getObjective(name);
        objective.setDisplayName(displayName);
        if (slot != null)
            objective.setDisplaySlot(slot);
        objective.setRenderType(type);
        return this;
    }

    public ScoreboardStore removeObjective(String name) {
        scoreboard.getObjective(name).unregister();
        return this;
    }
}
