package shining.starj.structure.Commands;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.CommandMinecart;

public enum SenderType {
    Player {
        @Override
        public boolean iSame(CommandSender sender) {
            return sender instanceof Player;
        }
    },
    OP_PLayer {
        @Override
        public boolean iSame(CommandSender sender) {
            return sender instanceof Player && sender.isOp();
        }
    }, Console {
        @Override
        public boolean iSame(CommandSender sender) {
            return sender instanceof ConsoleCommandSender;
        }
    }, Block {
        @Override
        public boolean iSame(CommandSender sender) {
            return sender instanceof BlockCommandSender;
        }
    }, Minecart {
        @Override
        public boolean iSame(CommandSender sender) {
            return sender instanceof CommandMinecart;
        }
    }
    //
    ;

    public abstract boolean iSame(CommandSender sender);

    public static SenderType[] ops() {
        return new SenderType[]{OP_PLayer, Console, Block, Minecart};
    }
//    public static SenderType valueOf(CommandSender sender){
//        if(sender instanceof org.bukkit.entity.Player)
//            return SenderType.Player;
//        else if ( sender instanceof BukkitCommand)
//            return SenderType.Bukkit;
//        else if( sender instanceof BlockCommandSender)
//            return SenderType.Block;
//        return null;
//    }
}
