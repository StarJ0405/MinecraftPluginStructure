package shining.starj.structure.Listeners.Server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.TabCompleteEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class CommandListener extends AbstractEventListener {
    // 콘솔이나 플레이어가 명령어 사용시 탭을 통해 자동완성을 시도하는 경우 발생
    @EventHandler
    public void Events(TabCompleteEvent e){

    }
    // 서버에서 전체에게 메세지를 보낼 때 발생
    @EventHandler
    public void Events(BroadcastMessageEvent e){

    }
    // 서버에서 명령어가 호출되면 발생
    @EventHandler
    public void Events(ServerCommandEvent e){

    }
}
