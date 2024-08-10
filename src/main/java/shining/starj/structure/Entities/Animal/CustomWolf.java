package shining.starj.structure.Entities.Animal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import shining.starj.structure.Entities.CustomEntities;

public class CustomWolf extends CustomEntities {

    @Override
    public Entity Spawn(@NotNull Location loc) {
        World world = loc.getWorld();
        ServerLevel level = ((CraftWorld) world).getHandle();
        CustomWolfEntity entity = new CustomWolfEntity(level);
        entity.setPos(loc.getX(), loc.getY(), loc.getZ());
        level.addFreshEntity(entity);
        return entity.getBukkitEntity();
    }

    class CustomWolfEntity extends Wolf {
        public CustomWolfEntity(ServerLevel world) {
            super(EntityType.WOLF, world);
        }

        @Override
        protected void registerGoals() {

        }
    }
}
