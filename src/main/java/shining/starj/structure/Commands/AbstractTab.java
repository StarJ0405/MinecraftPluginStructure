package shining.starj.structure.Commands;

import org.bukkit.command.CommandSender;
import shining.starj.structure.Systems.PermissionStore;

import java.util.List;

public abstract class AbstractTab {
    private final int slot; // 0부터 게산, 알아서 1 더해줌
    private final String permission;
    private final boolean isOp;

    public AbstractTab(int slot) {
        this(slot, null, false);
    }

    public AbstractTab(int slot, boolean isOp) {
        this(slot, null, isOp);

    }

    public AbstractTab(int slot, String permission) {
        this(slot, permission, false);
    }

    public AbstractTab(int slot, String permission, boolean isOp) {
        this.slot = slot + 1;
        this.permission = permission;
        this.isOp = isOp;
    }

    public boolean isSlot(CommandSender sender, String[] args) {
        return isSlot(sender, args.length);
    }

    public boolean isSlot(CommandSender sender, int slot) {
        if ((!sender.isOp() && isOp) || (permission != null && !PermissionStore.hasPermission(sender, permission)))
            return false;
        return this.slot == slot;
    }

    public abstract List<String> getString(CommandSender sender, String value, String[] args);

}
