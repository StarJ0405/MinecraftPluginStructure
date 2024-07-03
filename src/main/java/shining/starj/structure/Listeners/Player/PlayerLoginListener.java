package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerLoginListener extends AbstractEventListener {
    // 비동기적 로그인 시도시 발생
    @EventHandler
    public void Events(AsyncPlayerPreLoginEvent e) {

    }

    // 플레이어가 로그인 시도시 발생
    @EventHandler
    public void Events(PlayerLoginEvent e) {

    }

    // 플레이어가 접속시 발생
    @EventHandler
    public void Events(PlayerJoinEvent e) {

    }

    // 플레이어가 로그아웃시 발생
    @EventHandler
    public void Events(PlayerQuitEvent e) {

    }

    // 플레이어가 쫓겨나면 발생
    @EventHandler
    public void Events(PlayerKickEvent e) {

    }
}

