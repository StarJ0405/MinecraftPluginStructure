package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.BrewingStandFuelEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class BrewListener extends AbstractEventListener {
    // 양조기가 양조를 완성하면 발생
    @EventHandler
    public void Events(BrewEvent e) {

    }

    // 양조기의 연료 레벨이 바뀌면 발생
    @EventHandler
    public void Events(BrewingStandFuelEvent e) {

    }
}
