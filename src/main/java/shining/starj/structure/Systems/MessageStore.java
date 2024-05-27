package shining.starj.structure.Systems;

import org.bukkit.command.CommandSender;

public class MessageStore {
    public static void sendMessage(CommandSender sender,String msg){
        sender.sendMessage(msg);
    }
}
