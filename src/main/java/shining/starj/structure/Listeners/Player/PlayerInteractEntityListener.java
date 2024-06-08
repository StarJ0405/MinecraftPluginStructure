package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerInteractEntityListener extends AbstractEventListener {
    // 플레이어가 양동이로 엔티티를 잡으면 발생
    @EventHandler
    public void Events(PlayerBucketEntityEvent e) {

    }

    // 플레이어가 양동이로 물고기를 잡으면 발생
    @EventHandler
    public void Events(PlayerBucketFishEvent e) {

    }

    // 플레이어가 엔티티를 끈으로 묶으면 발생
    @EventHandler
    public void Events(PlayerLeashEntityEvent e) {

    }

    // 플레이어가 끈으로 묶인 엔티티를 풀어주면 발생
    @EventHandler
    public void Events(PlayerUnleashEntityEvent e) {

    }

    // 플레이어가 엔티티와 상호작용시 발생
    @EventHandler
    public void Events(PlayerInteractEntityEvent e) {

    }

    // 클릭한 위치를 포함하는 엔티티와 상호작용시 발생
    @EventHandler
    public void Events(PlayerInteractAtEntityEvent e) {

    }

    // 아머스탠드를 조정시 발생
    @EventHandler
    public void Events(PlayerArmorStandManipulateEvent e) {

    }

    // 플레이어가 양털을 깍을 시 발생
    @EventHandler
    public void Events(PlayerShearEntityEvent e) {

    }
}
