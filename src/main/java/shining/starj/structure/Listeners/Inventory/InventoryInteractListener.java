package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class InventoryInteractListener extends AbstractEventListener {
    // 인벤토리가 열리면 발생
    @EventHandler
    public void Events(InventoryOpenEvent e) {

    }

    // 인벤토리 닫을시 발생
    @EventHandler
    public void Events(InventoryCloseEvent e) {

    }

    // 인벤토리 클릭시 발생
    @EventHandler
    public void Events(InventoryClickEvent e) {

    }

    // 드래그로 아이템을 흩뿌리거나하면 발생
    @EventHandler
    public void Events(InventoryDragEvent e) {

    }

    // 거래창에서 사이드바에서 새로운 거래 품목을 골랐을 때 발생
    @EventHandler
    public void Events(TradeSelectEvent e) {

    }
}
