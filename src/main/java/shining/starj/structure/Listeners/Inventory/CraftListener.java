package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class CraftListener extends AbstractEventListener {
    // 제작 계통 인벤토리에 아이템을 넣을 때 발생
    @EventHandler
    public void Events(PrepareItemCraftEvent e) {

    }

    // 결과 슬롯이 포함된 인벤토리에 아이템을 넣을 때 발생
    @EventHandler
    public void Events(PrepareInventoryResultEvent e) {

    }
    // 아이템이 만들어지면 발생
    @EventHandler
    public void Events(CraftItemEvent e) {

    }
    // 대장장이 작업대에서 아이템 레시피가 결정되면 발생
    @EventHandler
    public void Events(SmithItemEvent e){

    }
    // 플레이어가 크리에이티브 모드 전용창에서 아이템을 꺼내거나 제거하면 발생
    @EventHandler
    public void Events(InventoryCreativeEvent e){

    }
}
