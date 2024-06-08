package shining.starj.structure.Listeners.Entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class ItemEntityListener extends AbstractEventListener {
    // 아이템이 사라질 때 발생
    @EventHandler
    public void Events(ItemDespawnEvent e){

    }
    // 아이템이 겹쳐서 합쳐질 때 발생
    @EventHandler
    public void Events(ItemMergeEvent e){

    }
    // 아이템이 소환되면 발생
    @EventHandler
    public void Events(ItemSpawnEvent e){

    }
}
