package shining.starj.structure.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {

    //
    private final List<AbstractCommandLine> lines;
    private final List<AbstractTab> tabs;

    protected AbstractCommand(String cmd, AbstractCommandLine[] lines, AbstractTab... tabs) {
        Objects.requireNonNull(Core.getCore().getCommand(cmd)).setExecutor(this);
        this.lines = Arrays.asList(lines);
        this.tabs = Arrays.asList(tabs);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        for (AbstractCommandLine commandLine : lines)
            if (commandLine.check(sender, cmd, label, args)) {
                commandLine.run(sender, cmd, label, args);
                return true;
            }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();
        for (AbstractTab tab : tabs)
            if (tab.isSlot(args))
                list.addAll(tab.getString(args[args.length - 1], args));
        return list;
    }

    public static void initial(){

    }
}
