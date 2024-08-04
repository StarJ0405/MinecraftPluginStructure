package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import shining.starj.structure.Core;
import shining.starj.structure.Events.Prework.TimerEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

@Builder
public class EntityListener extends AbstractEventListener {
    @EventHandler
    public void Events(TimerEvent e) {
        for (World world : Bukkit.getWorlds())
            for (Entity et : world.getEntities()) {
                if (et.hasMetadata("live")) for (MetadataValue value : et.getMetadata("live"))
                    if (value.getOwningPlugin().equals(Core.getCore())) {
                        int second = value.asInt() - 1;
                        if (second > 0) et.setMetadata("live", new FixedMetadataValue(Core.getCore(), second));
                        else et.remove();
                        break;
                    }

                if (et.hasMetadata("life")) for (MetadataValue value : et.getMetadata("life"))
                    if (value.getOwningPlugin().equals(Core.getCore()) && System.currentTimeMillis() > value.asLong()) {
                        et.remove();
                        break;
                    }
            }
    }

    @EventHandler
    public void Events(ServerLoadEvent e) {
        for (World world : Bukkit.getWorlds())
            for (Entity et : world.getEntities())
                if (et.hasMetadata("remove")) for (MetadataValue value : et.getMetadata("remove"))
                    if (value.getOwningPlugin().equals(Core.getCore()) && value.asBoolean()) {
                        et.remove();
                        break;
                    }
    }

    @EventHandler
    public void Events(ChunkLoadEvent e) {
        for (Entity et : e.getChunk().getEntities())
            if (et.hasMetadata("remove")) for (MetadataValue value : et.getMetadata("remove"))
                if (value.getOwningPlugin().equals(Core.getCore()) && value.asBoolean()) {
                    et.remove();
                    break;
                }

    }

    @EventHandler
    public void Events(VehicleExitEvent e) {
        Vehicle vehicle = e.getVehicle();
        if (vehicle.hasMetadata("remove")) for (MetadataValue value : vehicle.getMetadata("remove"))
            if (value.getOwningPlugin().equals(Core.getCore()) && value.asBoolean()) {
                vehicle.remove();
                break;
            }
    }
}
