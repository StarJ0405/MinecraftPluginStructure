package shining.starj.structure.Systems;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ConfigStore {
    // Player
    @SuppressWarnings("unchecked")
    public static <T> T getPlayerConfig(Player player, String key) {
        File file = new File("plugins/HalfSurvival/players/" + player.getUniqueId().toString() + ".yml");
        File dir = new File("plugins/HalfSurvival/players");
        FileConfiguration fc = new YamlConfiguration();
        try {
            if (!file.exists()) {
                dir.mkdirs();
                file.createNewFile();
            }
            fc.load(file);
            if (fc.contains(key))
                return (T) fc.get(key);
        } catch (Exception ex) {
        }
        return null;
    }

    public static boolean hasPlayerConfig(Player player, String key) {
        File file = new File("plugins/HalfSurvival/players/" + player.getUniqueId().toString() + ".yml");
        FileConfiguration fc = new YamlConfiguration();
        try {
            if (file.exists()) {
                fc.load(file);
                return fc.contains(key);
            }
        } catch (Exception ex) {
        }
        return false;
    }

    public static <T> void setPlayerConfig(Player player, String key, T value) {
        File file = new File("plugins/HalfSurvival/players/" + player.getUniqueId().toString() + ".yml");
        File dir = new File("plugins/HalfSurvival/players");
        FileConfiguration fc = new YamlConfiguration();
        try {
            if (!file.exists()) {
                dir.mkdirs();
                file.createNewFile();
            }
            fc.load(file);
            fc.set("name", player.getName());
            fc.set(key, value);
            fc.save(file);
        } catch (Exception ex) {
        }
    }
}
