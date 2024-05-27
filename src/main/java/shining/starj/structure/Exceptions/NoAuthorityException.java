package shining.starj.structure.Exceptions;

import org.bukkit.ChatColor;

public class NoAuthorityException extends  RuntimeException{
    public NoAuthorityException(String message) {
        super(ChatColor.RED+"다음 권한이 없습니다.\n\n"+ ChatColor.GRAY+message+ChatColor.RED+"<= 여기");
    }
}
