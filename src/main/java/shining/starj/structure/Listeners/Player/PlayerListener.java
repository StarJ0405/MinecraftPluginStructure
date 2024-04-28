package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void Events(PlayerJoinEvent e) {
        // 플레이어 접속시 발생하는 이벤트
    }

    @EventHandler
    public void Events(PlayerQuitEvent e){
        // 플레이어가 서버에서 나갈시 발생
    }
}
