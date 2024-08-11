package shining.starj.structure.Commands.Prework;


import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Commands.AbstractCommandLine;
import shining.starj.structure.Commands.AbstractTab;
import shining.starj.structure.Commands.SenderType;

import java.util.ArrayList;
import java.util.List;

public class WorldMoveCommand extends AbstractCommand {
    public WorldMoveCommand() {
        super("worldmove", true, new AbstractCommandLine[]{new Line1()}, PlayerTab.builder().isOp(true).slot(0).build(), new tab1());
    }

    private static class Line1 extends AbstractCommandLine {

        public Line1() {
            super(SenderType.ops(), 2);
        }

        @Override
        public boolean run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
            OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
            if (off.isOnline()) {
                Player player = off.getPlayer();
                World world = Bukkit.getWorld(args[1]);
                if (world != null) {
                    player.teleport(world.getSpawnLocation());
                    return true;
                }
            }
            return false;
        }
    }

    private static class tab1 extends AbstractTab {

        public tab1() {
            super(1, true);
        }

        @Override
        public List<String> getString(CommandSender sender, String value, String[] args) {
            final List<String> list = new ArrayList<>();
            for (World world : Bukkit.getWorlds())
                if (value.isBlank() || world.getName().toLowerCase().startsWith(value.toLowerCase()))
                    list.add(world.getName());
            return list;
        }
    }
}
