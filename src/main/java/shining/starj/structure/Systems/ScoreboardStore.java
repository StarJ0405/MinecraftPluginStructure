package shining.starj.structure.Systems;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardStore {
    private static final ScoreboardManager scoreboardManager= Bukkit.getScoreboardManager();
    @Getter
    private static final Scoreboard scoreboard = scoreboardManager.getMainScoreboard();

}
