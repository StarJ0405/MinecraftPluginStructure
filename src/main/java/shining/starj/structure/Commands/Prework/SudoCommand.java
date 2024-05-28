package shining.starj.structure.Commands.Prework;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Commands.AbstractCommandLine;
import shining.starj.structure.Commands.SenderType;

import java.util.UUID;

public class SudoCommand extends AbstractCommand {
    public SudoCommand() {
        super("sudo", true, new AbstractCommandLine[]{new Line1()}, PlayerTab.builder().isOp(true).slot(0).build());
    }

    private static class Line1 extends AbstractCommandLine {
        public Line1() {
            super(SenderType.ops(), 2, Integer.MAX_VALUE);
        }


        @Override
        public boolean run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
            OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
            if (off.isOnline()) {
                Player player = off.getPlayer();
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    if (!builder.isEmpty())
                        builder.append(" ");
                    builder.append(args[i]);
                }
                boolean isOp = player.isOp();
                player.setOp(true);
                player.performCommand(builder.toString());
                player.setOp(isOp);
                return true;
            } else
                try {
                    return Bukkit.getEntity(UUID.fromString(args[0])) != null;
                } catch (Exception ignored) {

                }

            return false;
        }
    }
}
