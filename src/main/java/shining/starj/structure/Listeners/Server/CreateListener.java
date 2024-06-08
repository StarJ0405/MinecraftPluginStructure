package shining.starj.structure.Listeners.Server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BellResonateEvent;
import org.bukkit.event.block.BellRingEvent;
import org.bukkit.event.raid.*;
import org.bukkit.event.server.MapInitializeEvent;
import shining.starj.structure.Listeners.AbstractEventListener;

public class CreateListener extends AbstractEventListener {
    // 맵이 생성되면 발생
    @EventHandler
    public void Events(MapInitializeEvent e) {

    }

    // 레이드 관련 사건이 생기면 발생
    @EventHandler
    public void Events(RaidEvent e) {

    }

    // 레이드 종료시 발생
    @EventHandler
    public void Events(RaidFinishEvent e) {

    }

    // 레이드 웨이브 생성시 발생
    @EventHandler
    public void Events(RaidSpawnWaveEvent e) {

    }

    // 레이드가 멈추면 발생
    @EventHandler
    public void Events(RaidStopEvent e) {

    }

    // 레이드가 시작되면 발생
    @EventHandler
    public void Events(RaidTriggerEvent e) {

    }

    // 종이 울린 후 근처 약탈자를 강조하면서 발동
    @EventHandler
    public void Events(BellResonateEvent e) {

    }

    // 종 작동시 발동
    @EventHandler
    public void Events(BellRingEvent e) {

    }

}
