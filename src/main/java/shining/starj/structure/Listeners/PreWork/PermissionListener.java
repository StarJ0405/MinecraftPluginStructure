package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerCommandSendEvent;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class PermissionListener extends AbstractEventListener {
    /*
     * 플레이어 명령어 권한여부에따른 지급
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void Events(PlayerCommandSendEvent e) {
        Player player = e.getPlayer();
        e.getCommands().removeIf(cmd -> !AbstractCommand.isOp(cmd, player) || !AbstractCommand.hasPermission(cmd, player));
    }
}
