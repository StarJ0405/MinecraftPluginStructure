package shining.starj.structure.Exceptions;

import org.bukkit.ChatColor;

public class InvalidPermission extends  RuntimeException{
    public InvalidPermission(String message) {
        super("퍼미션 이름이 잘못된 형식입니다.\n"+ChatColor.GRAY+message+ ChatColor.RED+ "<--[여기]");
    }
}
