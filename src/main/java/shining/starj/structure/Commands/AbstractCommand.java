package shining.starj.structure.Commands;

import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Commands.Prework.Permission;
import shining.starj.structure.Commands.Prework.SudoCommand;
import shining.starj.structure.Core;
import shining.starj.structure.Exceptions.IncompleteCommandException;
import shining.starj.structure.Exceptions.NoAuthorityException;
import shining.starj.structure.Systems.MessageStore;
import shining.starj.structure.Systems.PermissionStore;

import java.util.*;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {
    private static final HashSet<String> ops = new HashSet<>();
    private static final HashMap<String, String> permissions = new HashMap<>();
    private final List<AbstractCommandLine> lines;
    private final List<AbstractTab> tabs;

    protected AbstractCommand(String cmd, AbstractCommandLine[] lines, AbstractTab... tabs) {
        this(cmd, null, false, lines, tabs);
    }

    protected AbstractCommand(String cmd, String permission, AbstractCommandLine[] lines, AbstractTab... tabs) {
        this(cmd, permission, false, lines, tabs);
    }

    protected AbstractCommand(String cmd, boolean isOp, AbstractCommandLine[] lines, AbstractTab... tabs) {
        this(cmd, null, isOp, lines, tabs);
    }

    protected AbstractCommand(String cmd, String permission, boolean isOp, AbstractCommandLine[] lines, AbstractTab... tabs) {
        PluginCommand command = Core.getCore().getCommand(cmd);
        command.setExecutor(this);
        this.lines = Arrays.asList(lines);
        this.tabs = Arrays.asList(tabs);
        if (permission != null) permissions.put(cmd, permission);
        if (isOp)
            ops.add(cmd);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        try {
            if (!hasPermission(cmd.getName(), sender))
                throw new NoAuthorityException(permissions.get(cmd.getName()));
            if (!isOp(cmd.getName(), sender))
                throw new NoAuthorityException("op");
            for (AbstractCommandLine commandLine : lines)
                if (commandLine.check(sender, cmd, label, args)) {
                    boolean pass = commandLine.run(sender, cmd, label, args);
                    if (pass) return true;
                }

            StringBuilder builder = new StringBuilder(label.replace("/", ""));
            for (String arg : args) {
                builder.append(" ");
                builder.append(arg);
            }
            throw new IncompleteCommandException(builder.toString());
        } catch (IncompleteCommandException | NoAuthorityException exception) {
            MessageStore.sendMessage(sender, exception.getMessage());
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();
        for (AbstractTab tab : tabs)
            if (tab.isSlot(sender, args)) list.addAll(tab.getString(sender, args[args.length - 1], args));
        return list;
    }

    public static boolean isOp(String cmd, CommandSender sender) {
        return sender.isOp() || !ops.contains(cmd);
    }

    public static boolean hasPermission(String cmd, CommandSender sender) {
        return !permissions.containsKey(cmd) || PermissionStore.hasPermission(sender, permissions.get(cmd));
    }

    public static void initial() {
        new SudoCommand();
        new Permission();
    }

}
