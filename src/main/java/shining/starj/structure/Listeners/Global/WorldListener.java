package shining.starj.structure.Listeners.Global;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.event.world.*;
import shining.starj.structure.Listeners.AbstractEventListener;

public class WorldListener extends AbstractEventListener {
    // 월드가 생길 때 발생
    @EventHandler
    public void Events(WorldInitEvent e) {

    }

    // 월드가 저장될 때 발생
    @EventHandler
    public void Events(WorldSaveEvent e) {

    }

    // 월드가 로드될 때 발생
    @EventHandler
    public void Events(WorldLoadEvent e) {

    }

    // 월드가 언로드될 때 발생
    @EventHandler
    public void Events(WorldUnloadEvent e) {

    }

    // 날씨와 관련된 사건이 생기면 발생
    @EventHandler
    public void Events(WeatherEvent e) {

    }

    // 번개 생성시 발생
    @EventHandler
    public void Events(LightningStrikeEvent e) {

    }

    // 날씨가 폭풍우로 변경시 발생
    @EventHandler
    public void Events(ThunderChangeEvent e) {

    }

    // 날씨가 비 또는 맑음으로 바뀌면 발생
    @EventHandler
    public void Events(WeatherChangeEvent e) {

    }

    // 월드의 스폰이 변경됬을 때 발생
    @EventHandler
    public void Events(SpawnChangeEvent e) {

    }
}
