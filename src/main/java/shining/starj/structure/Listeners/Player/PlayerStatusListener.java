package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExhaustionEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerStatusListener extends AbstractEventListener {
    // 플레이어의 통계가 증가했을 때 발생
    @EventHandler
    public void Events(PlayerStatisticIncrementEvent e) {

    }

    // 플레이어가 서버 리소스팩에 관한 응답을 했을 때 발생
    @EventHandler
    public void Events(PlayerResourcePackStatusEvent e) {

    }

    // 플레이어가 로컬설정을 바꾸면 발생
    @EventHandler
    public void Events(PlayerLocaleChangeEvent e) {

    }

    // 플레이어가 클라이언트 설정에서 주손을 바꾸면 발생
    @EventHandler
    public void Events(PlayerChangedMainHandEvent e) {

    }

    // 플레이어의 게임모드가 변경되면 발생
    @EventHandler
    public void Events(PlayerGameModeChangeEvent e) {

    }

    // 플레이어의 배고픔이 변경되면 발생
    @EventHandler
    public void Events(FoodLevelChangeEvent e) {

    }

    // 플레이어가 기진맥진을 쌓을 때마다 발생
    @EventHandler
    public void Events(EntityExhaustionEvent e) {

    }

    // 업적 달성시 발생
    @EventHandler
    public void Events(PlayerAdvancementDoneEvent e) {

    }

    // 플레이어 애니메이션이 변경되면 발생
    @EventHandler
    public void Events(PlayerAnimationEvent e) {

    }

    // 플레이어의 플라이 상태가 변경시 발생
    @EventHandler
    public void Events(PlayerToggleFlightEvent e) {

    }

    // 플레이어의 앉기 상태가 변경시 발생
    @EventHandler
    public void Events(PlayerToggleSneakEvent e) {

    }

    // 플레이어의 달리기 상태가 변경시 발생
    @EventHandler
    public void Events(PlayerToggleSprintEvent e) {

    }

    // 엔티티의 겉날개 상태가 변경시 발생
    @EventHandler
    public void Events(EntityToggleGlideEvent e) {

    }

    // 엔티티가 수영상태로 변경하면 발생
    @EventHandler
    public void Events(EntityToggleSwimEvent e) {

    }

    // 플레이어로부터 엔티티를 숨기면 발생
    @EventHandler
    public void Events(PlayerHideEntityEvent e) {

    }

    // 플레이어가 숨겨진 엔티티가 다시 보이게 됬을 때 발생
    @EventHandler
    public void Events(PlayerShowEntityEvent e) {

    }
}
