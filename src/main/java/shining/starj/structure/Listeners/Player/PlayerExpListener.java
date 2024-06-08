package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerExpListener extends AbstractEventListener {

    // 플레이어의 경험치가 바뀌면 발생
    @EventHandler
    public void Events(PlayerExpChangeEvent e) {

    }

    // 플레이어의 레벨이 변경되면 발생
    @EventHandler
    public void Events(PlayerLevelChangeEvent e) {

    }
}
