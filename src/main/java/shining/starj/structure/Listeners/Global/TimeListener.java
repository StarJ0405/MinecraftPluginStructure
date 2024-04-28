package shining.starj.structure.Listeners.Global;

import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.checkerframework.common.value.qual.EnumVal;
import shining.starj.structure.Listeners.AbstractEventListener;

public class TimeListener extends AbstractEventListener {
    static TimeListener timeListener = new TimeListener();
    @EventHandler
    public void Events(FurnaceBurnEvent e){

    }
    @EventHandler
    public void Events(ServerLoadEvent e){


    }
}
