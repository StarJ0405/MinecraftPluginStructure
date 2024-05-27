package shining.starj.structure.Exceptions;

import org.bukkit.ChatColor;

public class InvalidCommandArgsException extends RuntimeException {
    public InvalidCommandArgsException(String message) {
        super(ChatColor.RED + "명령어에 잘못된 인수가 있습니다.\n" + ChatColor.GRAY + message + ChatColor.RED + "<--[여기]");
    }
}
