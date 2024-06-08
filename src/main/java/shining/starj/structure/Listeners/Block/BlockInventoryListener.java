package shining.starj.structure.Listeners.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BrewingStartEvent;
import org.bukkit.event.block.CampfireStartEvent;
import org.bukkit.event.block.InventoryBlockStartEvent;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class BlockInventoryListener extends AbstractEventListener {
    // 블럭이 인벤토리 사용시 발생(용광로 재련, 양조, 캠프파이어 요리)
    @EventHandler
    public void Events(InventoryBlockStartEvent e){

    }
    // 화로 시작시 발생
    @EventHandler
    public void Events(FurnaceStartSmeltEvent e){

    }
    // 양조기 시작시 발생
    @EventHandler
    public void Events(BrewingStartEvent e){

    }
    // 캠프파이어가 요리 시작시 발생
    @EventHandler
    public void Events(CampfireStartEvent e){

    }
}
