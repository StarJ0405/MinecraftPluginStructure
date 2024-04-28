package shining.starj.structure.Entities;

import net.minecraft.world.level.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Entities.animal.CustomWolf;

import java.util.Objects;


public class CustomEntities {

    // 소환 명령어 엔티티를 반환
    public Entity Spawn(@NotNull Location loc) {
        World world = ((CraftWorld) Objects.requireNonNull(loc.getWorld())).getHandle();
        CustomWolf entity = new CustomWolf(world);
        world.addFreshEntity(entity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        entity.a(loc.getX(), loc.getY(), loc.getZ());
        return entity.getBukkitEntity();
    }
}
