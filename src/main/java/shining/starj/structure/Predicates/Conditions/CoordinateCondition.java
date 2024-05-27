package shining.starj.structure.Predicates.Conditions;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shining.starj.structure.Predicates.ConditionInterface;


@Builder
public record CoordinateCondition(@Nullable World world, @Nullable Double x, @Nullable Double y, @Nullable Double z, //
                                  @Nullable Double dx, @Nullable Double dy,
                                  @Nullable Double dz) implements ConditionInterface {
    // x,y,z 지정좌표, dx,dy,dz 범위지정
    @Override
    public boolean is(@NotNull Entity entity) {
        Location confirm = entity.getLocation();
        if (world == null || !world.equals(confirm.getWorld()) || x == null || y == null || z == null || dx == null || dy == null || dz == null)
            return true;
        return isBetween(confirm.getX(), x, dx) && isBetween(confirm.getY(), y, dy) && isBetween(confirm.getZ(), z, dz);
    }

    private boolean isBetween(double position, double n, double dn) {
        double n1 = n + dn;
        double n2 = n - dn;
        if (n1 < n2) return n1 <= position && position <= n2;
        else return n2 <= position && position <= n1;
    }
}
