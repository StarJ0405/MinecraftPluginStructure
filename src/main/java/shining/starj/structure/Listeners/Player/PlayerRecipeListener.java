package shining.starj.structure.Listeners.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRecipeBookClickEvent;
import org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class PlayerRecipeListener extends AbstractEventListener {
    // 플레이어 레시피북에서 레시피를 클릭하면 발생
    @EventHandler
    public void Events(PlayerRecipeBookClickEvent e) {

    }

    // 플레이어의 레시피북 설정이 바뀌면 발생
    @EventHandler
    public void Events(PlayerRecipeBookSettingsChangeEvent e) {

    }
    // 플레이어가 레시피를 발견하면 발생
    @EventHandler
    public void Events(PlayerRecipeDiscoverEvent e){

    }

}
