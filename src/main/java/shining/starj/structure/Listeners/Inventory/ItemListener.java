package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.HopperInventorySearchEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class ItemListener extends AbstractEventListener {
    // 호퍼가 연결된 상자를 탐색할 때 발생
    @EventHandler
    public void Events(HopperInventorySearchEvent e) {

    }

    // 호퍼 등 일부 엔티티나 블럭이 아이템을 옮기면 발생
    @EventHandler
    public void Events(InventoryMoveItemEvent e) {

    }

    // 호퍼나 호퍼가 실린 수레가 아이템을 주울 시 발생
    @EventHandler
    public void Events(InventoryPickupItemEvent e) {

    }
}
