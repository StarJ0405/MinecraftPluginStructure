package shining.starj.structure.Commands.Custom;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Commands.AbstractCommandLine;
import shining.starj.structure.Commands.SenderType;

import java.util.Arrays;
import java.util.Objects;

public class SudoCommand extends AbstractCommand {
    public SudoCommand() {
        super("sudo", new AbstractCommandLine[]{new Line1()});
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
                for(int i=1;i<args.length;i++)
                    builder.append(args[i]);
                Objects.requireNonNull(player).performCommand(builder.toString());
            }
            return false;
        }
    }
}
