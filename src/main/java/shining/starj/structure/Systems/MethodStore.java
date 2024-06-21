package shining.starj.structure.Systems;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class MethodStore {
    public static String LocationToStringKey(Location location) {
        return location.getWorld().getName() + "_" + location.getBlockX() + "_" + location.getBlockY() + "_" + location.getBlockZ();
    }

    public static String LocationToString(Location location) {
        return location.getWorld().getName() + "_" + location.getX() + "_" + location.getY() + "_" + location.getZ() + "_" + location.getYaw() + "_" + location.getPitch();
    }

    public static Location StringToLocation(String key) {
        try {
            String[] splits = key.split("_");
            World world = Bukkit.getWorld(splits[0]);
            double x = Double.parseDouble(splits[1]);
            double y = Double.parseDouble(splits[2]);
            double z = Double.parseDouble(splits[3]);
            float yaw = Float.parseFloat(splits[4]);
            float pitch = Float.parseFloat(splits[5]);
            return new Location(world, x, y, z, yaw, pitch);
        } catch (Exception ex) {
            return null;
        }
    }
}