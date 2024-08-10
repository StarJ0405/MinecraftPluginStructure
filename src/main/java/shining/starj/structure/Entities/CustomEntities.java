package shining.starj.structure.Entities;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Entities.Animal.CustomWolf;


public abstract class CustomEntities {
    public static final CustomWolf customWolf = new CustomWolf();

    // 소환 명령어 엔티티를 반환
    public abstract Entity Spawn(@NotNull Location loc);

}
