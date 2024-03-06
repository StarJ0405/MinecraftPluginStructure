package shining.starj.structure.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TestCommand implements CommandExecutor, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// sender 종류
		if (sender instanceof Player){
			// 플레이어
		} else if (sender instanceof BlockCommandSender){
			// 커맨드 블럭
		}else if ( sender instanceof ConsoleCommandSender){
			// 콘솔
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		final List<String> list = new ArrayList<String>();
		// list 목록 추가시 인 게임에서 탭으로 추가 가능
		return list;
	}
}
