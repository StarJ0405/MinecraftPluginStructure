package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerMoveListener extends AbstractEventListener {
    // 플레이어가 직접 움직이면 발생
    @EventHandler
    public void Events(PlayerMoveEvent e){

    }
    // 플레이어가 텔레포트시 발생
    @EventHandler
    public void Events(PlayerTeleportEvent e){

    }
    // 플레이어가 포탈을 타려고할 때 발생(포탈 생성 포함)
    @EventHandler
    public void Events(PlayerPortalEvent e){

    }
    // 플레이어의 가속도가 변경되면 발생
    @EventHandler
    public void Events(PlayerVelocityEvent e){

    }
    // 플레이어가 월드를 바꾸면 발생
    @EventHandler
    public void Events(PlayerChangedWorldEvent e){

    }
}
