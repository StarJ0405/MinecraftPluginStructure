package shining.starj.structure.Commands.Custom;

import lombok.Builder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Commands.AbstractCommandLine;
import shining.starj.structure.Commands.SenderType;

public class TestCommand extends AbstractCommand {

    public TestCommand() {
        super("test",
                new AbstractCommandLine[]{FirstLine.builder().senderType(SenderType.Player).length(0).build()}
        );
    }

    static class FirstLine extends AbstractCommandLine {
        @Builder
        public FirstLine(SenderType senderType, SenderType[] senderTypes, Integer length, Integer min, Integer max) {
            super(senderType, senderTypes, length, min, max);
        }

        @Override
        public void run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
            sender.sendMessage(ChatColor.RED + "잘 작동합니다.");
        }
    }

}
