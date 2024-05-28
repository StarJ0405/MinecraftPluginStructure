package shining.starj.structure.Commands.Prework;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.*;
import shining.starj.structure.Systems.PermissionStore;

import java.util.*;

public class PermissionCommand extends AbstractCommand {
    public PermissionCommand() {
        super("permission", true, new AbstractCommandLine[]{new line1()}, PlayerTab.builder().isOp(true).slot(0).build(), new function(), new permission());
    }

    //permission [player] add [permission] (ticks)
    //permission [player] remove [permission]
    private static class line1 extends AbstractCommandLine {

        public line1() {
            super(SenderType.ops(), 3, 4);
        }

        @Override
        public boolean run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
            OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
            if (off.isOnline()) {
                Player player = off.getPlayer();
                if (args[1].equals("add"))
                    if (args.length == 3) {
                        PermissionStore.setPermission(player, args[2]);
                        return true;
                    } else
                        try {
                            PermissionStore.setTemporaryPermission(player, args[2], Integer.parseInt(args[3]));
                            return true;
                        } catch (Exception ignored) {

                        }
                else if (args[1].equals("remove")) {
                    PermissionStore.removePermission(player, args[2]);
                    return true;
                }
            } else
                try {
                    return Bukkit.getEntity(UUID.fromString(args[0])) != null;
                } catch (Exception ignored) {

                }
            return false;
        }
    }


    private static class permission extends AbstractTab {
        public permission() {
            super(2, true);
        }

        @Override
        public List<String> getString(CommandSender sender, String value, String[] args) {
            final Set<String> sets = new HashSet<>();
            OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
            if (args[1].equals("add")) {
                for (Player player : Bukkit.getOnlinePlayers())
                    if (off.getPlayer().equals(player)) {
                        for (PermissionAttachmentInfo info : player.getEffectivePermissions())
                            if (value.isBlank() || info.getPermission().toLowerCase().startsWith(value.toLowerCase()))
                                sets.remove(info.getPermission());
                    } else
                        for (PermissionAttachmentInfo info : player.getEffectivePermissions())
                            if (value.isBlank() || info.getPermission().toLowerCase().startsWith(value.toLowerCase()))
                                sets.add(info.getPermission());
            } else if (args[1].equals("remove")) {
                if (off.isOnline()) {
                    Player player = off.getPlayer();
                    for (PermissionAttachmentInfo info : player.getEffectivePermissions())
                        if (value.isBlank() || info.getPermission().toLowerCase().startsWith(value.toLowerCase()))
                            sets.add(info.getPermission());
                } else
                    for (Player player : Bukkit.getOnlinePlayers())
                        for (PermissionAttachmentInfo info : player.getEffectivePermissions())
                            if (value.isBlank() || info.getPermission().toLowerCase().startsWith(value.toLowerCase()))
                                sets.add(info.getPermission());
            }

            return sets.stream().toList();
        }
    }

    private static class function extends AbstractTab {

        public function() {
            super(1, true);
        }

        @Override
        public List<String> getString(CommandSender sender, String value, String[] args) {
            final List<String> list = new ArrayList<>();
            if (value.isBlank()) {
                list.add("add");
                list.add("remove");
            } else {
                if ("add".startsWith(value.toLowerCase()))
                    list.add("add");
                if ("remove".startsWith(value.toLowerCase()))
                    list.add("remove");
            }
            return list;
        }
    }
}
