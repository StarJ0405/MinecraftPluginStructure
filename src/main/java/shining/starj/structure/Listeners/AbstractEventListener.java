package shining.starj.structure.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import shining.starj.structure.Core;
import shining.starj.structure.Listeners.PreWork.PreWorkListener;
public abstract class AbstractEventListener implements Listener {

    private static final PluginManager plugin_manager = Bukkit.getPluginManager();
    public AbstractEventListener() {
        plugin_manager.registerEvents(this, Core.getCore());
    }

    public static void initial() {
        // 이벤트 선언

        // 글로벌
        // 플레이어

        // 사전 작업용
        PreWorkListener.builder().build();
    }
}
