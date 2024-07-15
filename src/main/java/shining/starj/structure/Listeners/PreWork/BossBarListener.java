package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.metadata.MetadataValue;
import shining.starj.structure.Core;
import shining.starj.structure.Events.Prework.TimerEvent;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Systems.MessageStore;

import java.util.List;

@Builder
public class BossBarListener extends AbstractEventListener {
    @EventHandler
    public void Events(TimerEvent e) {
        List<MessageStore.BoosBarInfo> list = MessageStore.getBars();
        for (int i = list.size() - 1; i >= 0; i--) {
            MessageStore.BoosBarInfo info = list.get(i);
            BossBar bar = info.bar();
            if (System.currentTimeMillis() >= info.endTime()) {
                bar.removeAll();
                list.remove(i);
            } else
                bar.setProgress(1 - (System.currentTimeMillis() - info.startTime()) * 1.0D / (info.endTime() - info.startTime()));
        }
        for (World world : Bukkit.getWorlds())
            for (Entity entity : world.getEntities())
                if (entity instanceof TextDisplay && entity.hasMetadata("remove"))
                    for (MetadataValue value : entity.getMetadata("remove"))
                        if (value.getOwningPlugin().equals(Core.getCore()) && System.currentTimeMillis() >= value.asLong())
                            entity.remove();
    }

    @EventHandler
    public void Events(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        for (MessageStore.BoosBarInfo info : MessageStore.getBars())
            if (info.every()) info.bar().addPlayer(player);
            else {
                BossBar bar = info.bar();
                if (info.players().contains(player.getUniqueId())) bar.addPlayer(player);
            }
    }

    @EventHandler
    public void Test(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        if (e.isSneaking())
            MessageStore.getMessageStore().sendBroadcastBossBar(20, "TEST", BarColor.GREEN, BarStyle.SOLID, null);

    }
}
