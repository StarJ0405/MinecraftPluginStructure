package shining.starj.structure;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Listeners.AbstractEventListener;

import java.util.Iterator;

public class Core extends JavaPlugin {
    @Getter
    private static Core core;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 시작되었습니다.");
        core = this;
        //
        AbstractCommand.intial(); // 명령어
        AbstractEventListener.initial(); // 이벤트
        //
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 정상적으로 불러와졌습니다.");
    }


    public void onDisable() {
        //
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 종료되었습니다.");
    }

}
