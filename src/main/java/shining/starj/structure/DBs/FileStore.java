package shining.starj.structure.DBs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import shining.starj.structure.Core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileStore {
    @SuppressWarnings("unchecked")
    public static <T> T getConfig(String preLoc, String fileName, String key) {
        File file = new File("plugins/" + Core.getCore().getName() + "/" + preLoc + fileName + ".yml");
        FileConfiguration fc = new YamlConfiguration();
        try {
            if (file.exists()) {
                fc.load(file);
                if (fc.contains(key)) return (T) fc.get(key);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getConfigList(String preLoc, String fileName, String... keys) {
        File file = new File("plugins/" + Core.getCore().getName() + "/" + preLoc + fileName + ".yml");
        FileConfiguration fc = new YamlConfiguration();
        List<T> list = new ArrayList<>();
        try {
            if (file.exists()) {
                fc.load(file);
                for (String key : keys)
                    if (fc.contains(key))
                        list.add((T) fc.get(key));
            }
        } catch (Exception ignored) {
        }
        return list;
    }

    public static boolean hasConfig(String preLoc, String fileName, String key) {
        File file = new File("plugins/" + Core.getCore().getName() + "/" + preLoc + fileName + ".yml");
        FileConfiguration fc = new YamlConfiguration();
        try {
            if (file.exists()) {
                fc.load(file);
                return fc.contains(key);
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public static <T> void setConfig(String preLoc, String fileName, Data<?>... data) {
        File file = new File("plugins/" + Core.getCore().getName() + "/" + preLoc + fileName + ".yml");
        FileConfiguration fc = new YamlConfiguration();
        try {
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
            fc.load(file);
            for (Data<?> datum : data)
                fc.set(datum.key, datum.value);
            fc.save(file);
        } catch (Exception ignored) {
        }
    }

    public record Data<T>(String key, T value) {

    }
}
