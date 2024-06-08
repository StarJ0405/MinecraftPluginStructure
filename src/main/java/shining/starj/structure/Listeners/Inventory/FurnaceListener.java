package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class FurnaceListener extends AbstractEventListener {
    // 화로 안에 연료가 타서 연료 레벨이 증가하면 발생
    @EventHandler
    public void Events(FurnaceBurnEvent e) {

    }

    // 플레이어가 화로에서 물건을 꺼내면 발생
    @EventHandler
    public void Events(FurnaceExtractEvent e) {

    }
    // 화로 안에 물건이 녹으면 발생
    @EventHandler
    public void Events(FurnaceSmeltEvent e){

    }
    // 화로안에 물건이 녹기 시작하면 발생
    @EventHandler
    public void Event(FurnaceStartSmeltEvent e){

    }
}
