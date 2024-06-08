package shining.starj.structure.Listeners.Server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class ServerListener extends AbstractEventListener {
    // 서버리스트에 핑이 들어올 때 발생
    @EventHandler
    public void Events(ServerListPingEvent e) {

    }

    // 서버 로드가 완료되거나 Reload 이후 발생
    @EventHandler
    public void Events(ServerLoadEvent e) {

    }

    // 플러그인이 활성화되거니 비활성화되면 발생
    @EventHandler
    public void Events(PluginEvent e) {

    }

    // 플러그인이 비활성화되면 발생
    @EventHandler
    public void Events(PluginDisableEvent e) {

    }

    // 플러그인이 활성화되면 발생
    @EventHandler
    public void Events(PluginEnableEvent e) {

    }
}
