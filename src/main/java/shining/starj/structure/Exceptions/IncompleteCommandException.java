package shining.starj.structure.Exceptions;

import org.bukkit.ChatColor;

public class IncompleteCommandException extends RuntimeException {
    public IncompleteCommandException(String message) {
        super(ChatColor.RED + "알 수 없거나 불완전한 명령어입니다. 아래의 오류를 확인하세요.\n" + ChatColor.GRAY + message + ChatColor.RED + "<--[여기]");
    }
}
