package shining.starj.structure;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import shining.starj.structure.Commands.TestCommand;

public class Core extends JavaPlugin {
    private static Core core;

    public static Core getCore() {
        return core;
    }

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 시작되었습니다.");
        core = this;
        //
        PluginManager pm = Bukkit.getPluginManager();
        // pm.registerEvents(new EntityListener(), this);
        getCommand("test").setExecutor(new TestCommand());
        //
        //
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 정상적으로 불러와졌습니다.");
    }


    public void onDisable() {
        //
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 종료되었습니다.");
    }

}
