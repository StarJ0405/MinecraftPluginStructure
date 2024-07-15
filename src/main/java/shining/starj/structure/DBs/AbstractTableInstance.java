package shining.starj.structure.DBs;


import org.bukkit.Bukkit;
import shining.starj.structure.Core;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class AbstractTableInstance {
    // 변수명 Column (String, Character, Integer, Double, Float, Boolean)
    // final 선언시 PK
    // 이름의 auto 포함시 자동으로 AUTO_INCREMENT
    protected static Connection conn;

    public static void connect() {
        try {
            Class.forName("org.h2.Driver");
            String jarPath = Core.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String fileLoc = jarPath.substring(0, jarPath.lastIndexOf("/")).substring(1).replaceAll("%20", " ") + "/" + Core.getCore().getName() + "/db";
            String url = "jdbc:h2:" + fileLoc;
            File file = new File(fileLoc);
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
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

    public AbstractTableInstance createTable() throws SQLException {
        if (conn == null) return this;
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields()) {
            if (!builder.isEmpty()) builder.append(", ");
            builder.append(getNameWithType(field));
            if (Modifier.isFinal(field.getModifiers())) builder.append(" PRIMARY KEY");
            if (field.getName().toLowerCase().contains("auto")) builder.append(" AUTO_INCREMENT");
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            if (!builder.isEmpty()) builder.append(", ");
            builder.append(getNameWithType(field)).append(" ");
            if (Modifier.isFinal(field.getModifiers())) builder.append(" PRIMARY KEY");
            if (field.getName().toLowerCase().contains("auto")) builder.append(" AUTO_INCREMENT");
        }
        try (PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS " + this.getClass().getSimpleName() + " (" + builder + ")")) {
            statement.executeUpdate();
        }
        return this;
    }

    public AbstractTableInstance dropTable() throws SQLException {
        if (conn == null) return this;
        try (PreparedStatement statement = conn.prepareStatement("DROP TABLE IF EXISTS " + this.getClass().getSimpleName())) {
            statement.executeUpdate();
        }
        return this;
    }

    public AbstractTableInstance insertData() throws SQLException {
        if (conn == null) return this;
        StringBuilder columnBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        for (Field field : this.getClass().getFields()) {
            try {
                if (field.get(this) == null || field.getName().toLowerCase().contains("auto")) continue;
                if (!valueBuilder.isEmpty()) valueBuilder.append(", ");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            valueBuilder.append("'").append(field.get(this).toString()).append("'");
                    default -> valueBuilder.append(field.get(this).toString());
                }

                if (!columnBuilder.isEmpty()) columnBuilder.append(", ");
                columnBuilder.append(field.getName());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(this) == null || field.getName().toLowerCase().contains("auto")) continue;
                if (!valueBuilder.isEmpty()) valueBuilder.append(", ");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            valueBuilder.append("'").append(field.get(this).toString()).append("'");
                    default -> valueBuilder.append(field.get(this).toString());
                }
                if (!columnBuilder.isEmpty()) columnBuilder.append(", ");
                columnBuilder.append(field.getName());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO " + this.getClass().getSimpleName() + " (" + columnBuilder + ") values (" + valueBuilder + ")")) {
            statement.executeUpdate();
        }
        return this;
    }

    public AbstractTableInstance deleteDataAll() throws SQLException {
        if (conn == null) return this;
        try (PreparedStatement statement = conn.prepareStatement("DELETE FROM " + this.getClass().getSimpleName())) {
            statement.executeQuery().close();
        }
        return this;
    }

    public AbstractTableInstance deleteDataAllOR() throws SQLException {
        if (conn == null) return this;
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields())
            try {
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" OR ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


        for (Field field : this.getClass().getDeclaredFields())
            try {
                field.setAccessible(true);
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" OR ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        try (PreparedStatement statement = conn.prepareStatement("DELETE FROM " + this.getClass().getSimpleName() + " WHERE " + builder)) {
            statement.executeQuery().close();
        }
        return this;
    }

    public AbstractTableInstance deleteDataAllAND() throws SQLException {
        if (conn == null) return this;
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields())
            try {
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" AND ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


        for (Field field : this.getClass().getDeclaredFields())
            try {
                field.setAccessible(true);
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" AND ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        try (PreparedStatement statement = conn.prepareStatement("DELETE FROM " + this.getClass().getSimpleName() + " WHERE " + builder)) {
            statement.executeQuery().close();
        }
        return this;
    }

    public AbstractTableInstance deleteDataAllCustom(String where) throws SQLException {
        if (conn == null) return this;
        try (PreparedStatement statement = conn.prepareStatement("DELETE FROM " + this.getClass().getSimpleName() + " WHERE " + where)) {
            statement.executeQuery().close();
        }
        return this;
    }

    public AbstractTableInstance updateDataCustom(String where) throws SQLException {
        if (conn == null) return this;
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields())
            try {
                if (field.get(this) == null || field.getName().toLowerCase().contains("auto")) continue;
                if (!builder.isEmpty()) builder.append(", ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        for (Field field : this.getClass().getDeclaredFields())
            try {
                field.setAccessible(true);
                if (field.get(this) == null || field.getName().toLowerCase().contains("auto")) continue;
                if (!builder.isEmpty()) builder.append(", ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        try (PreparedStatement statement = conn.prepareStatement("UPDATE " + this.getClass().getSimpleName() + " SET " + builder + (where != null && !where.isBlank() ? " WHERE " + where : ""))) {
            statement.executeUpdate();
        }
        return this;
    }

    public List<AbstractTableInstance> selectAll() throws SQLException {
        List<AbstractTableInstance> list = new ArrayList<>();
        if (conn == null) return list;

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + this.getClass().getSimpleName())) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try {
                    LinkedHashMap<Class<?>, Object> parameters = new LinkedHashMap<>();
                    for (Field field : this.getClass().getFields())
                        put(parameters, field, rs);

                    for (Field field : this.getClass().getDeclaredFields())
                        put(parameters, field, rs);
                    Constructor<?> constructor = this.getClass().getDeclaredConstructor(parameters.keySet().toArray(Class<?>[]::new));
                    constructor.setAccessible(true);
                    Object[] parameterValues = new Object[parameters.size()];
                    int i = 0;
                    for (Class<?> cls : parameters.keySet()) {
                        parameterValues[i++] = switch (cls.getTypeName()) {
                            case "int", "java.lang.Integer" ->
                                    (Integer) Integer.parseInt(parameters.get(cls).toString());
                            case "double", "java.lang.Double" ->
                                    (Double) Double.parseDouble(parameters.get(cls).toString());
                            case "float", "java.lang.Float" -> (Float) Float.parseFloat(parameters.get(cls).toString());
                            case "boolean", "java.lang.Boolean" ->
                                    (Boolean) Boolean.parseBoolean(parameters.get(cls).toString());
                            case "char", "java.lang.Character" -> (Character) parameters.get(cls).toString().charAt(0);
                            default -> parameters.get(cls).toString();
                        };
                    }
                    list.add((AbstractTableInstance) constructor.newInstance(parameterValues));
                } catch (NoSuchMethodException ex) {
                    Bukkit.broadcastMessage("no such method exception");
                } catch (InvocationTargetException ignored) {
                    Bukkit.broadcastMessage("invocationTarget exception");
                } catch (IllegalAccessException ignored) {
                    Bukkit.broadcastMessage("IllegalAccess exception");
                } catch (InstantiationException ignored) {
                    Bukkit.broadcastMessage("result exception");
                }
            }
            rs.close();
        }
        return list;
    }

    public List<AbstractTableInstance> selectAllOR() throws SQLException {
        List<AbstractTableInstance> list = new ArrayList<>();
        if (conn == null) return list;
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields())
            try {
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" OR ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


        for (Field field : this.getClass().getDeclaredFields())
            try {
                field.setAccessible(true);
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" OR ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + this.getClass().getSimpleName() + " WHERE " + builder)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try {
                    LinkedHashMap<Class<?>, Object> parameters = new LinkedHashMap<>();
                    for (Field field : this.getClass().getFields())
                        put(parameters, field, rs);

                    for (Field field : this.getClass().getDeclaredFields())
                        put(parameters, field, rs);
                    Constructor<?> constructor = this.getClass().getDeclaredConstructor(parameters.keySet().toArray(Class<?>[]::new));
                    constructor.setAccessible(true);
                    Object[] parameterValues = new Object[parameters.size()];
                    int i = 0;
                    for (Class<?> cls : parameters.keySet()) {
                        parameterValues[i++] = switch (cls.getTypeName()) {
                            case "int", "java.lang.Integer" ->
                                    (Integer) Integer.parseInt(parameters.get(cls).toString());
                            case "double", "java.lang.Double" ->
                                    (Double) Double.parseDouble(parameters.get(cls).toString());
                            case "float", "java.lang.Float" -> (Float) Float.parseFloat(parameters.get(cls).toString());
                            case "boolean", "java.lang.Boolean" ->
                                    (Boolean) Boolean.parseBoolean(parameters.get(cls).toString());
                            case "char", "java.lang.Character" -> (Character) parameters.get(cls).toString().charAt(0);
                            default -> parameters.get(cls).toString();
                        };
                    }
                    list.add((AbstractTableInstance) constructor.newInstance(parameterValues));
                } catch (NoSuchMethodException ex) {
                    Bukkit.broadcastMessage("no such method exception");
                } catch (InvocationTargetException ignored) {
                    Bukkit.broadcastMessage("invocationTarget exception");
                } catch (IllegalAccessException ignored) {
                    Bukkit.broadcastMessage("IllegalAccess exception");
                } catch (InstantiationException ignored) {
                    Bukkit.broadcastMessage("result exception");
                }
            }
            rs.close();
        }
        return list;
    }

    public List<AbstractTableInstance> selectAllAND() throws SQLException {
        List<AbstractTableInstance> list = new ArrayList<>();
        if (conn == null) return list;
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields())
            try {
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" AND ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


        for (Field field : this.getClass().getDeclaredFields())
            try {
                field.setAccessible(true);
                if (field.get(this) == null) continue;
                if (!builder.isEmpty()) builder.append(" AND ");
                builder.append(field.getName()).append("=");
                switch (field.getType().getName()) {
                    case "char", "java.lang.Character", "java.lang.String" ->
                            builder.append("'").append(field.get(this).toString()).append("'");
                    default -> builder.append(field.get(this).toString());
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + this.getClass().getSimpleName() + " WHERE " + builder)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try {
                    LinkedHashMap<Class<?>, Object> parameters = new LinkedHashMap<>();
                    for (Field field : this.getClass().getFields())
                        put(parameters, field, rs);

                    for (Field field : this.getClass().getDeclaredFields())
                        put(parameters, field, rs);
                    Constructor<?> constructor = this.getClass().getDeclaredConstructor(parameters.keySet().toArray(Class<?>[]::new));
                    constructor.setAccessible(true);
                    Object[] parameterValues = new Object[parameters.size()];
                    int i = 0;
                    for (Class<?> cls : parameters.keySet()) {
                        parameterValues[i++] = switch (cls.getTypeName()) {
                            case "int", "java.lang.Integer" ->
                                    (Integer) Integer.parseInt(parameters.get(cls).toString());
                            case "double", "java.lang.Double" ->
                                    (Double) Double.parseDouble(parameters.get(cls).toString());
                            case "float", "java.lang.Float" -> (Float) Float.parseFloat(parameters.get(cls).toString());
                            case "boolean", "java.lang.Boolean" ->
                                    (Boolean) Boolean.parseBoolean(parameters.get(cls).toString());
                            case "char", "java.lang.Character" -> (Character) parameters.get(cls).toString().charAt(0);
                            default -> parameters.get(cls).toString();
                        };
                    }
                    list.add((AbstractTableInstance) constructor.newInstance(parameterValues));
                } catch (NoSuchMethodException ex) {
                    Bukkit.broadcastMessage("no such method exception");
                } catch (InvocationTargetException ignored) {
                    Bukkit.broadcastMessage("invocationTarget exception");
                } catch (IllegalAccessException ignored) {
                    Bukkit.broadcastMessage("IllegalAccess exception");
                } catch (InstantiationException ignored) {
                    Bukkit.broadcastMessage("result exception");
                }
            }
            rs.close();
        }
        return list;
    }

    public List<AbstractTableInstance> selectWhereCustom(String where) throws SQLException {
        List<AbstractTableInstance> list = new ArrayList<>();
        if (conn == null) return list;

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + this.getClass().getSimpleName() + " WHERE " + where)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try {
                    LinkedHashMap<Class<?>, Object> parameters = new LinkedHashMap<>();
                    for (Field field : this.getClass().getFields())
                        put(parameters, field, rs);

                    for (Field field : this.getClass().getDeclaredFields())
                        put(parameters, field, rs);
                    Constructor<?> constructor = this.getClass().getDeclaredConstructor(parameters.keySet().toArray(Class<?>[]::new));
                    constructor.setAccessible(true);
                    Object[] parameterValues = new Object[parameters.size()];
                    int i = 0;
                    for (Class<?> cls : parameters.keySet()) {
                        parameterValues[i++] = switch (cls.getTypeName()) {
                            case "int", "java.lang.Integer" ->
                                    (Integer) Integer.parseInt(parameters.get(cls).toString());
                            case "double", "java.lang.Double" ->
                                    (Double) Double.parseDouble(parameters.get(cls).toString());
                            case "float", "java.lang.Float" -> (Float) Float.parseFloat(parameters.get(cls).toString());
                            case "boolean", "java.lang.Boolean" ->
                                    (Boolean) Boolean.parseBoolean(parameters.get(cls).toString());
                            case "char", "java.lang.Character" -> (Character) parameters.get(cls).toString().charAt(0);
                            default -> parameters.get(cls).toString();
                        };
                    }
                    list.add((AbstractTableInstance) constructor.newInstance(parameterValues));
                } catch (NoSuchMethodException ex) {
                    Bukkit.broadcastMessage("no such method exception");
                } catch (InvocationTargetException ignored) {
                    Bukkit.broadcastMessage("invocationTarget exception");
                } catch (IllegalAccessException ignored) {
                    Bukkit.broadcastMessage("IllegalAccess exception");
                } catch (InstantiationException ignored) {
                    Bukkit.broadcastMessage("result exception");
                }
            }
            rs.close();
        }
        return list;
    }

    public String instanceInfo() throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        for (Field field : this.getClass().getFields()) {
            if (!builder.isEmpty()) builder.append(", ");
            builder.append(field.getName()).append("(").append(field.get(this).toString()).append(Modifier.isFinal(field.getModifiers()) ? " ) PK" : ")");
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (!builder.isEmpty()) builder.append(", ");
            builder.append(field.getName()).append("(").append(field.get(this).toString()).append(Modifier.isFinal(field.getModifiers()) ? " ) PK" : ")");
        }
        return builder.toString();
    }

    private void put(HashMap<Class<?>, Object> parameters, Field field, ResultSet rs) throws SQLException {
        Class<?> key = field.getType();
        switch (field.getType().getName()) {
            case "java.lang.String", "char", "java.lang.Character" ->
                    parameters.put(key, rs.getString(field.getName()));
            case "int", "java.lang.Integer" -> parameters.put(key, rs.getInt(field.getName()));
            case "double", "java.lang.Double" -> parameters.put(key, rs.getDouble(field.getName()));
            case "float", "java.lang.Float" -> parameters.put(key, rs.getFloat(field.getName()));
            case "boolean", "java.lang.Boolean" -> parameters.put(key, rs.getBoolean(field.getName()));
            default -> throw new RuntimeException("지원하지 않는 형식의 데이터를 사용했습니다!");

        }
        ;
    }

    private String getNameWithType(Field field) {
        String name = field.getName();
        String type = field.getType().getName();
        return switch (type) {
            case "java.lang.String" -> name + " VARCHAR(255)";
            case "char", "java.lang.Character" -> name + " CHAR(1)";
            case "int", "java.lang.Integer" -> name + " INTEGER";
            case "double", "java.lang.Double" -> name + " Double";
            case "float", "java.lang.Float" -> name + " REAL";
            case "boolean", "java.lang.Boolean" -> name + " BOOLEAN";
            default -> throw new RuntimeException("지원하지 않는 형식의 데이터를 사용했습니다!");
        };
    }
}
