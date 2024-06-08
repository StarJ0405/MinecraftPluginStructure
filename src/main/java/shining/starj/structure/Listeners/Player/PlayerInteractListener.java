package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerInteractListener extends AbstractEventListener {
    // 비동기적 플레이어가 채팅을 친 경우 발생
    @EventHandler
    public void Events(AsyncPlayerChatEvent e) {

    }

    // 플레이어가 급류 인챈트된 삼지창을 사용시 발생
    @EventHandler
    public void Events(PlayerRiptideEvent e) {

    }

    // 플레이어가 책을 수정하면 발생
    @EventHandler
    public void Events(PlayerEditBookEvent e) {

    }

    // 플레이어가 독서대에서 책을 가져가면 발생
    @EventHandler
    public void Events(PlayerTakeLecternBookEvent e) {

    }

    // 플레이어가 달걀을 던지면 발생
    @EventHandler
    public void Events(PlayerEggThrowEvent e) {

    }

    // 플레이어가 낚시 관련 행동을 할 때마다 발생
    @EventHandler
    public void Events(PlayerFishEvent e) {

    }

    // 플레이어가 양동이를 사용시 발생
    @EventHandler
    public void Events(PlayerBucketEvent e) {

    }

    // 플레어가 양동이를 비우면 발생
    @EventHandler
    public void Events(PlayerBucketEmptyEvent e) {

    }

    // 플레이어가 양동이를 채우면 발생
    @EventHandler
    public void Events(PlayerBucketFillEvent e) {

    }

    // 플레이어가 블럭과 상호작용시 발생
    @EventHandler
    public void Events(PlayerInteractEvent e) {

    }

    // 플레이어가 침대 들어가면 발생
    @EventHandler
    public void Events(PlayerBedEnterEvent e) {

    }

    // 플레이어가 침대에서 나오면 발생
    @EventHandler
    public void Events(PlayerBedLeaveEvent e) {

    }

    // 표지판이 열렸을 때 발생
    @EventHandler
    public void Events(PlayerSignOpenEvent e) {

    }

    // 플레이어가 부숴서 수확하지 않는 형태의 작물을 수확하면 발생
    @EventHandler
    public void Events(PlayerHarvestBlockEvent e) {

    }

}
