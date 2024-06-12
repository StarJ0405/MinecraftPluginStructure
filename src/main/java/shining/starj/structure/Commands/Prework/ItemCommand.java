package shining.starj.structure.Commands.Prework;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Commands.AbstractCommandLine;
import shining.starj.structure.Commands.AbstractTab;
import shining.starj.structure.Commands.SenderType;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Systems.MessageStore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemCommand extends AbstractCommand {
    public ItemCommand() {
        super("item", true, new AbstractCommandLine[]{new line1()}, PlayerTab.builder().isOp(true).build(), new items());
    }

    // item [player] [item] (count)
    private static class line1 extends AbstractCommandLine {
        public line1() {
            super(SenderType.ops(), 2, 3);
        }

        @Override
        public boolean run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
            OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
            if (off.isOnline()) {
                Player player = off.getPlayer();
                Items i = Items.valueOf(args[1]);
                if (i != null) {
                    int count = 1;
                    if (args.length == 3)
                        try {
                            count = Integer.parseInt(args[2]);
                        } catch (Exception ignored) {

                        }
                    player.getInventory().addItem(i.getItemStack(player));
                    return true;
                } else
                    MessageStore.sendMessage(sender, ChatColor.RED + "없는 아이템입니다.");
            } else try {
                return Bukkit.getEntity(UUID.fromString(args[0])) != null;
            } catch (Exception ignored) {

            }

            return false;
        }
    }

    private static class items extends AbstractTab {
        public items() {
            super(2, true);
        }

        @Override
        public List<String> getString(CommandSender sender, String value, String[] args) {
            final List<String> list = new ArrayList<>();
            for (Items item : Items.values())
                list.add(item.getKey());
            return list;
        }
    }
}
