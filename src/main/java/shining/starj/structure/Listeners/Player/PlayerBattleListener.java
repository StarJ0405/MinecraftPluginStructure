package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerBattleListener extends AbstractEventListener {
    // 플레이어가 부활하면 발생
    @EventHandler
    public void Events(PlayerRespawnEvent e) {

    }

    // 플레이어가 사망하면 발생
    @EventHandler
    public void Events(PlayerDeathEvent e) {

    }
}
