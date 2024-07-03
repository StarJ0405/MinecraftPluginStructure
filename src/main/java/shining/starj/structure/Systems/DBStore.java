package shining.starj.structure.Systems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import shining.starj.structure.Core;

import java.io.File;
import java.sql.*;

public class DBStore {
    private static Connection conn;

    public static void setData(String name) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY auto_increment, name VARCHAR(255))";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
        }
        sql = "INSERT INTO users (name) VALUES (?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }

    public static void getDate(int id) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY auto_increment, name VARCHAR(255))";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
        }
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM users")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Bukkit.broadcastMessage(ChatColor.RED + rs.getString("id") + " " + rs.getString("name"));
            }
            rs.close();
        }
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where id = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Bukkit.broadcastMessage(rs.getString("id") + " " + rs.getString("name"));
            }
            rs.close();
        }
    }

    public static void connect() {
        try {
            Class.forName("org.h2.Driver");
            String jarPath = Core.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String fileLoc = jarPath.substring(0, jarPath.lastIndexOf("/")).substring(1).replaceAll("%20", " ") + "/" + Core.getCore().getName() + "/db";
            String url = "jdbc:h2:tcp://localhost/" + fileLoc;
            File file = new File(fileLoc);
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            conn = DriverManager.getConnection(url, "sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
