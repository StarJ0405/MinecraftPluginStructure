package shining.starj.structure.Exceptions;

import org.bukkit.ChatColor;

public class NotFoundPlayerException extends RuntimeException {
    public NotFoundPlayerException() {
        super(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
    }
}
