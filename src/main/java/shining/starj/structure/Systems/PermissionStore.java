package shining.starj.structure.Systems;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionAttachmentInfo;
import shining.starj.structure.Core;
import shining.starj.structure.Exceptions.InvalidPermission;

public class PermissionStore {
    public static void setPermission(CommandSender sender, String permission) {
        if (permission.contains(".*") || permission.lastIndexOf("\\.") == permission.length() - 1)
            throw new InvalidPermission(permission);
        sender.addAttachment(Core.getCore()).setPermission(permission, true);
        sender.recalculatePermissions();
    }

    public static void setTemporaryPermission(CommandSender sender, String permission, int tick) {
        if (permission.contains(".*") || permission.lastIndexOf("\\.") == permission.length() - 1)
            throw new InvalidPermission(permission);
        sender.addAttachment(Core.getCore(), tick).setPermission(permission, true);
        sender.recalculatePermissions();
    }

    public static void removePermission(CommandSender sender, String permission) {
        if (permission.lastIndexOf("\\.") == permission.length() - 1)
            throw new InvalidPermission(permission);
        if (permission.contains(".*"))
            for (PermissionAttachmentInfo info : sender.getEffectivePermissions()) {
                if (info.getPermission().startsWith(permission.split("\\.\\*")[0]))
                    info.getAttachment().unsetPermission(info.getPermission());
            }
        else
            for (PermissionAttachmentInfo info : sender.getEffectivePermissions())
                if (info.getPermission().equals(permission))
                    info.getAttachment().unsetPermission(permission);
        sender.recalculatePermissions();
    }

    public static void removeOnlyPluginPermission(CommandSender sender, String permission) {
        if (permission.lastIndexOf("\\.") == permission.length() - 1)
            throw new InvalidPermission(permission);
        if (permission.contains(".*"))
            for (PermissionAttachmentInfo info : sender.getEffectivePermissions()) {
                if (info.getAttachment() != null && Core.getCore().equals(info.getAttachment().getPlugin()) && info.getPermission().startsWith(permission.split("\\.\\*")[0]))
                    info.getAttachment().unsetPermission(info.getPermission());
            }
        else
            for (PermissionAttachmentInfo info : sender.getEffectivePermissions())
                if (info.getAttachment() != null && Core.getCore().equals(info.getAttachment().getPlugin()) && info.getPermission().equals(permission))
                    info.getAttachment().unsetPermission(permission);
        sender.recalculatePermissions();
    }

    public static boolean hasPermission(CommandSender sender, String permission) {
        if (permission.lastIndexOf("\\.") == permission.length() - 1)
            throw new InvalidPermission(permission);
        if (permission.contains(".*"))
            for (PermissionAttachmentInfo info : sender.getEffectivePermissions()) {
                if (info.getPermission().startsWith(permission.split("\\.\\*")[0]))
                    return true;
            }
        else
            for (PermissionAttachmentInfo info : sender.getEffectivePermissions())
                if (info.getPermission().equals(permission))
                    return true;
        return false;
    }
}
