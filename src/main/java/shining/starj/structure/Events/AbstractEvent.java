package shining.starj.structure.Events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Events.Prework.*;

public abstract class AbstractEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public static void initial() {
        ContainerPickupEvent.builder().build();
        ContainerPlaceEvent.builder().build();
        FuelContainerPickupEvent.builder().build();
        FuelContainerPlaceEvent.builder().build();
        HarvestEvent.builder().build();
        InventorySortEvent.builder().build();
        ReplantAgeableEvent.builder().build();
        ReplantEvent.builder().build();
        TimerEvent.builder().build();
    }


}
