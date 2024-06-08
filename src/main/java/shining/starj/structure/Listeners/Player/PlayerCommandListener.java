package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerCommandListener extends AbstractEventListener {
    // 플레이어가 명령어 호출시 발생
    @EventHandler
    public void Events(PlayerCommandPreprocessEvent e) {

    }

    // 플레이어가 사용가능한 명령어를 전달받으면 발생
    @EventHandler
    public void Events(PlayerCommandSendEvent e) {

    }
}
