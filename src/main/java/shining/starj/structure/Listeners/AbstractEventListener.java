package shining.starj.structure.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.PluginManager;
import shining.starj.structure.Core;
import shining.starj.structure.Listeners.Global.TimeListener;

public abstract class AbstractEventListener implements Listener {
    private static final PluginManager plugin_manager = Bukkit.getPluginManager();
    protected AbstractEventListener() {
        plugin_manager.registerEvents(this, Core.getCore());
    }
    public static void initial(){
        new TimeListener();
    }
}
