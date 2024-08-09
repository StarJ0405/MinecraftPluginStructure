package shining.starj.structure.Effects;

import org.bukkit.Location;
import org.bukkit.util.Vector;

//RelativeLocation
public class RLocation {
    /*
     * 상대위치 구하기
     */
    public static Location getLocation(Location start, Vector dir, double front, double up, double dz) {
        dir = dir.clone().setY(0).normalize();
        //(x,y)
        // (y,-x)

        return start.clone().add(dir.getX() * front - dir.getZ() * dz, up, dir.getZ() * front + dir.getX() * dz);
    }

    public static Location getLocation(Location start, double dx, double dy, double dz) {
        return getLocation(start, start.getDirection(), dx, dy, dz);
    }

    /*
     * 계산된 벡터 구하기
     */
    public static Vector getRelativeVector(Location start, Vector dir, double dx, double dy, double dz) {
        dir = dir.clone().setY(0).normalize();
        return new Vector((dir.getX() - dir.getZ()) * dx, dy, (dir.getZ() - dir.getX()) * dz);
    }

    public static Vector getRelativeVector(Location start, double front, double dy, double dz) {
        return getRelativeVector(start, start.getDirection(), front, dy, dz);
    }

    /*
     * 계산된 벡터 사용
     */
    public static Location getLocation(Location start, float size, Vector dir) {
        return getLocation(start, size, size, size, dir);
    }

    public static Location getLocation(Location start, float sizeX, float sizeY, float sizeZ, Vector dir) {
        return start.clone().add(dir.getX() * sizeX, dir.getY() * sizeY, dir.getZ() * sizeZ);
    }
}
