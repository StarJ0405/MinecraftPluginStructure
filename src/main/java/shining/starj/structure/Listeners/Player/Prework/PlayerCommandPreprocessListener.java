package shining.starj.structure.Listeners.Player.Prework;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerCommandPreprocessListener extends AbstractEventListener {
    @EventHandler
    public void Events(PlayerCommandPreprocessEvent e) {
        String msg = e.getMessage();
        if(msg.contains("@p")){
            Player player = e.getPlayer();
            String[] sp = e.getMessage().split(" ");
            StringBuilder builder= new StringBuilder();
            for(int i=0; i<sp.length;i++) {
                if(!builder.isEmpty())
                    builder.append(" ");
                if (sp[i].equals("@p"))
                    builder.append(player.getName());
                else if (sp[i].contains("@p")){
                // 이어서
                }else
                    builder.append(sp[i]);
            }

            e.setMessage(builder.toString());
        }

        if(msg.contains("@a")){
            e.setCancelled(true);

        }
    }


}
