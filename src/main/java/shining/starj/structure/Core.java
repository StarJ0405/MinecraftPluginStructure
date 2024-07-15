package shining.starj.structure;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.DBs.AbstractTableInstance;
import shining.starj.structure.Events.AbstractEvent;
import shining.starj.structure.GUIs.AbstractGUI;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Recipes.CustomRecipe;
import shining.starj.structure.Systems.MessageStore;

public class Core extends JavaPlugin {


    @Getter
    private static Core core;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 시작되었습니다.");
        core = this;
        //
        AbstractEvent.initial(); // 이벤트
        AbstractCommand.initial(); // 명령어
        Items.initial(); // 아이템
        CustomRecipe.initial(); // 레시피
        AbstractGUI.initial(); // GUI
        AbstractEventListener.initial(); // 이벤트 리스너
        AbstractTableInstance.connect(); // DB
        //
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 정상적으로 불러와졌습니다.");
    }


    public void onDisable() {
        // 초기화
        for (MessageStore.BoosBarInfo info : MessageStore.getBars())
            info.bar().removeAll();
        // DB연결 종료
        AbstractTableInstance.disconnect();
        //
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + this.getName() + "이 종료되었습니다.");
    }

}
