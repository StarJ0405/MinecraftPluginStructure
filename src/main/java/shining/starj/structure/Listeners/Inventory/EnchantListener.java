package shining.starj.structure.Listeners.Inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class EnchantListener extends AbstractEventListener {
    // 인챈트가 성공적으로 추가됬을 때 발생
    @EventHandler
    public void Events(EnchantItemEvent e){

    }
    // 아이템이 인챈트 테이블에 추가 됬을 때 발생
    @EventHandler
    public void Events(PrepareItemEnchantEvent e){

    }
}
