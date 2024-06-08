package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareGrindstoneEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PrepareInventoryListener extends AbstractEventListener {
    // 모루에 아이템을 넣을 시 작동
    @EventHandler
    public void Events(PrepareAnvilEvent e) {

    }

    // 숫돌에 아이템을 넣을 시 작동
    @EventHandler
    public void Events(PrepareGrindstoneEvent e) {

    }

    // 대장장이 작업대에 아이템을 넣을시 발생
    @EventHandler
    public void Events(PrepareSmithingEvent e) {

    }
}
