package shining.starj.structure.Listeners.Prework;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.server.ServerCommandEvent;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Core;
import shining.starj.structure.Exceptions.IncompleteCommandException;
import shining.starj.structure.Exceptions.InvalidCommandArgsException;
import shining.starj.structure.Exceptions.NotFoundPlayerException;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Predicates.CommandPredicate;
import shining.starj.structure.Predicates.Conditions.*;
import shining.starj.structure.Systems.MessageStore;
import shining.starj.structure.Systems.PermissionStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Builder
public class CommandPreprocessListener extends AbstractEventListener {
    // https://www.digminecraft.com/getting_started/target_selectors.php

    @EventHandler
    public void Events(ServerCommandEvent e) {
        String msg = e.getCommand();
        String cmd = (msg.contains(" ") ? msg.split(" ")[0] : msg);
        PluginCommand command = Bukkit.getServer().getPluginCommand(cmd);
        CommandSender sender = e.getSender();
        try {
            if (command != null && command.getPlugin().equals(Core.getCore())) {
                if (msg.contains("@a") || msg.contains("@e")) {
                    String[] sp = msg.split(" ");
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < sp.length; i++) {
                        if (!builder.isEmpty()) builder.append(" ");
                        String s = sp[i];
                        if (s.contains("@a")) {
                            if (s.equals("@a")) {
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    StringBuilder copyBuilder = new StringBuilder(builder);
                                    copyBuilder.append(p.getName());
                                    for (int j = i + 1; j < sp.length; j++) {
                                        if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                        copyBuilder.append(sp[j]);
                                    }
                                    Bukkit.dispatchCommand(sender, copyBuilder.toString().replace("/", ""));
                                }
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getCommand(), sender);
                                List<Player> players = new ArrayList<>();
                                for (Player p : Bukkit.getOnlinePlayers())
                                    if (predicate.test(p)) players.add(p);
                                int num = predicate.getLimit() != null ? predicate.getLimit() : players.size();
                                for (Player p : players)
                                    if (num > 0) {
                                        StringBuilder copyBuilder = new StringBuilder(builder);
                                        copyBuilder.append(p.getName());
                                        for (int j = i + 1; j < sp.length; j++) {
                                            if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                            copyBuilder.append(sp[j]);
                                        }
                                        Bukkit.dispatchCommand(sender, copyBuilder.toString().replace("/", ""));
                                        num--;
                                    }
                            }
                            e.setCancelled(true);
                            return;
                        } else if (s.contains("@e")) {
                            if (s.equals("@e")) {
                                for (World world : Bukkit.getWorlds())
                                    for (Entity entity : world.getEntities()) {
                                        StringBuilder copyBuilder = new StringBuilder(builder);
                                        copyBuilder.append(entity instanceof Player ? ((Player) entity).getName() : entity.getUniqueId().toString());
                                        for (int j = i + 1; j < sp.length; j++) {
                                            if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                            copyBuilder.append(sp[j]);
                                        }
                                        Bukkit.dispatchCommand(sender, copyBuilder.toString().replace("/", ""));
                                    }
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getCommand(), sender);
                                List<Entity> entities = new ArrayList<>();
                                for (World world : Bukkit.getWorlds())
                                    for (Entity entity : world.getEntities())
                                        if (predicate.test(entity)) entities.add(entity);
                                int num = predicate.getLimit() != null ? predicate.getLimit() : entities.size();
                                for (Entity entity : entities)
                                    if (num > 0) {
                                        StringBuilder copyBuilder = new StringBuilder(builder);
                                        copyBuilder.append(entity instanceof Player ? ((Player) entity).getName() : entity.getUniqueId().toString());
                                        for (int j = i + 1; j < sp.length; j++) {
                                            if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                            copyBuilder.append(sp[j]);
                                        }
                                        Bukkit.dispatchCommand(sender, copyBuilder.toString().replace("/", ""));
                                        num--;
                                    }
                            }
                            e.setCancelled(true);
                            return;
                        } else builder.append(s);
                    }
                } else if (msg.contains("@p") || msg.contains("@r")) {
                    String[] sp = msg.split(" ");
                    StringBuilder builder = new StringBuilder();
                    for (String s : sp) {
                        if (!builder.isEmpty()) builder.append(" ");
                        if (s.contains("@p")) {
                            if (s.equals("@p")) {
                                List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                                if (players.isEmpty())
                                    throw new NotFoundPlayerException();
                                builder.append(players.getFirst().getName());
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getCommand(), sender);
                                List<Player> players = new ArrayList<>();
                                for (Player p : Bukkit.getOnlinePlayers())
                                    if (predicate.test(p)) players.add(p);
                                if (players.isEmpty()) throw new NotFoundPlayerException();
                                else builder.append(players.getFirst().getName());
                            }
                        } else if (s.contains("@r")) {
                            if (s.equals("@r")) {
                                List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                                if (!players.isEmpty()) {
                                    Collections.shuffle(players);
                                    builder.append(players.getFirst().getName());
                                } else throw new NotFoundPlayerException();
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getCommand(), sender);
                                List<Player> players = new ArrayList<>();
                                for (Player p : Bukkit.getOnlinePlayers())
                                    if (predicate.test(p)) players.add(p);
                                Collections.shuffle(players);
                                if (players.isEmpty()) throw new NotFoundPlayerException();
                                else builder.append(players.getFirst().getName());
                            }
                        } else builder.append(s);
                    }
                    msg = builder.toString();
                }
                e.setCommand(msg);
            }
        } catch (NotFoundPlayerException | InvalidCommandArgsException | IncompleteCommandException exception) {
            e.setCancelled(true);
            MessageStore.sendMessage(sender, exception.getMessage());
        } catch (ArrayIndexOutOfBoundsException exception) {
            e.setCancelled(true);
            MessageStore.sendMessage(sender, ChatColor.RED + "알 수 없거나 불완전한 명령어입니다. 아래의 오류를 확인하세요.\n" + ChatColor.GRAY + e.getCommand() + ChatColor.RED + "<--[여기]");
        }
    }

    @EventHandler
    public void Events(PlayerCommandSendEvent e) {
        Player player = e.getPlayer();
        e.getCommands().removeIf(cmd -> !AbstractCommand.isOp(cmd, player) || !AbstractCommand.hasPermission(cmd, player));
    }

    @EventHandler
    public void Events(PlayerCommandPreprocessEvent e) {
        String msg = e.getMessage();
        String cmd = (msg.contains(" ") ? msg.split(" ")[0] : msg).replace("/", "");
        PluginCommand command = Bukkit.getServer().getPluginCommand(cmd);
        Player sender = e.getPlayer();
        try {
            if (command != null && command.getPlugin().equals(Core.getCore())) {
                if (msg.contains("@a") || msg.contains("@e")) {
                    String[] sp = msg.split(" ");
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < sp.length; i++) {
                        if (!builder.isEmpty()) builder.append(" ");
                        String s = sp[i];
                        if (s.contains("@a")) {
                            if (s.equals("@a")) {
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    StringBuilder copyBuilder = new StringBuilder(builder);
                                    copyBuilder.append(p.getName());
                                    for (int j = i + 1; j < sp.length; j++) {
                                        if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                        copyBuilder.append(sp[j]);
                                    }
                                    sender.performCommand(copyBuilder.toString().replace("/", ""));
                                }
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getMessage(), sender);
                                List<Player> players = new ArrayList<>();
                                for (Player p : Bukkit.getOnlinePlayers())
                                    if (predicate.test(p)) players.add(p);

                                int num = predicate.getLimit() != null ? predicate.getLimit() : players.size();
                                if (predicate.getLimit() != null)
                                    players.sort(new Closest(sender));
                                for (Player p : players)
                                    if (num > 0) {
                                        StringBuilder copyBuilder = new StringBuilder(builder);
                                        copyBuilder.append(p.getName());
                                        for (int j = i + 1; j < sp.length; j++) {
                                            if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                            copyBuilder.append(sp[j]);
                                        }
                                        sender.performCommand(copyBuilder.toString().replace("/", ""));
                                        num--;
                                    }
                            }
                            e.setCancelled(true);
                            return;
                        } else if (s.contains("@e")) {
                            if (s.equals("@e")) {
                                for (World world : Bukkit.getWorlds())
                                    for (Entity entity : world.getEntities()) {
                                        StringBuilder copyBuilder = new StringBuilder(builder);
                                        copyBuilder.append(entity instanceof Player ? ((Player) entity).getName() : entity.getUniqueId().toString());
                                        for (int j = i + 1; j < sp.length; j++) {
                                            if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                            copyBuilder.append(sp[j]);
                                        }
                                        sender.performCommand(copyBuilder.toString().replace("/", ""));
                                    }
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getMessage(), sender);
                                List<Entity> entities = new ArrayList<>();
                                for (World world : Bukkit.getWorlds())
                                    for (Entity entity : world.getEntities())
                                        if (predicate.test(entity)) entities.add(entity);
                                int num = predicate.getLimit() != null ? predicate.getLimit() : entities.size();
                                if (predicate.getLimit() != null)
                                    entities.sort(new Closest(sender));
                                for (Entity entity : entities)
                                    if (num > 0) {
                                        StringBuilder copyBuilder = new StringBuilder(builder);
                                        copyBuilder.append(entity instanceof Player ? ((Player) entity).getName() : entity.getUniqueId().toString());
                                        for (int j = i + 1; j < sp.length; j++) {
                                            if (!copyBuilder.isEmpty()) copyBuilder.append(" ");
                                            copyBuilder.append(sp[j]);
                                        }
                                        sender.performCommand(copyBuilder.toString().replace("/", ""));
                                        num--;
                                    }
                            }
                            e.setCancelled(true);
                            return;
                        } else builder.append(s);
                    }
                } else if (msg.contains("@p") || msg.contains("@r")) {
                    String[] sp = msg.split(" ");
                    StringBuilder builder = new StringBuilder();
                    for (String s : sp) {
                        if (!builder.isEmpty()) builder.append(" ");
                        if (s.contains("@p")) {
                            if (s.equals("@p")) builder.append(sender.getName());
                            else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getMessage(), sender);
                                List<Player> players = new ArrayList<>();
                                for (Player p : Bukkit.getOnlinePlayers())
                                    if (predicate.test(p)) players.add(p);
                                players.sort(new Closest(sender));
                                if (players.isEmpty()) throw new NotFoundPlayerException();
                                else builder.append(players.getFirst().getName());
                            }
                        } else if (s.contains("@r")) {
                            if (s.equals("@r")) {
                                List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                                if (!players.isEmpty()) {
                                    Collections.shuffle(players);
                                    builder.append(players.getFirst().getName());
                                } else throw new NotFoundPlayerException();
                            } else {
                                CommandPredicate predicate = getCommandPredicate(s, e.getMessage(), sender);
                                List<Player> players = new ArrayList<>();
                                for (Player p : Bukkit.getOnlinePlayers())
                                    if (predicate.test(p)) players.add(p);
                                Collections.shuffle(players);
                                if (players.isEmpty()) throw new NotFoundPlayerException();
                                else builder.append(players.getFirst().getName());
                            }
                        } else builder.append(s);
                    }
                    msg = builder.toString();
                }
                e.setMessage(msg);
            }
        } catch (NotFoundPlayerException | InvalidCommandArgsException | IncompleteCommandException exception) {
            e.setCancelled(true);
            MessageStore.sendMessage(sender, exception.getMessage());
        } catch (IndexOutOfBoundsException exception) {
            e.setCancelled(true);
            MessageStore.sendMessage(sender, ChatColor.RED + "알 수 없거나 불완전한 명령어입니다. 아래의 오류를 확인하세요.\n" + ChatColor.GRAY + e.getMessage() + ChatColor.RED + "<--[여기]");
        }
    }

    static class Closest implements Comparator<Entity> {
        private final Entity entity;

        public Closest(Entity entity) {
            this.entity = entity;
        }

        @Override
        public int compare(Entity o1, Entity o2) {
            int number1 = (int) Math.ceil(o1.getLocation().distance(entity.getLocation()) * 10);
            int number2 = (int) Math.ceil(o2.getLocation().distance(entity.getLocation()) * 10);
            return number1 - number2;
        }
    }

    private CommandPredicate getCommandPredicate(String s, String exceptionMessage, CommandSender sender) throws IndexOutOfBoundsException {
        int start = s.indexOf('[');
        int end = s.lastIndexOf(']');
        String now = s.substring(start + 1, end);
        if (now.isBlank()) throw new InvalidCommandArgsException(exceptionMessage);
        String[] splits = now.split(",");
        CommandPredicate.CommandPredicateBuilder commandPredicateBuilder = CommandPredicate.builder();
        List<ScoreCondition> scoreConditionList = new ArrayList<>();
        for (String split : splits) {
            if (split.contains("=")) {
                String[] temp = split.split("=");
                String key = temp[0];
                StringBuilder valueBuilder = new StringBuilder();
                for (int i = 1; i < temp.length; i++) {
                    if (!valueBuilder.isEmpty()) valueBuilder.append("=");
                    valueBuilder.append(temp[i]);
                }
                String value = valueBuilder.toString();
                try {
                    switch (key) {
                        case "distance" -> {
                            if (value.contains("..")) {
                                String[] numbers = value.split("\\.\\.");
                                if (numbers.length == 1) {
                                    Double min = Double.parseDouble(numbers[0]);
                                    commandPredicateBuilder.distanceCondition(DistanceCondition.builder().sender(sender).minDistance(min).build());
                                } else if (numbers.length == 2) {
                                    Double min = numbers[0].isBlank() ? null : Double.parseDouble(numbers[0]);
                                    Double max = Double.parseDouble(numbers[1]);
                                    commandPredicateBuilder.distanceCondition(DistanceCondition.builder().sender(sender).minDistance(min).maxDistance(max).build());
                                } else throw new IncompleteCommandException(exceptionMessage);
                            } else {
                                Double number = Double.parseDouble(value);
                                commandPredicateBuilder.distanceCondition(DistanceCondition.builder().sender(sender).minDistance(number).maxDistance(number).build());
                            }
                        }
                        case "world" ->
                                commandPredicateBuilder.world(Bukkit.getWorld(value) != null ? "" : Bukkit.getWorld(value).getName());
                        case "x" -> commandPredicateBuilder.x(Double.parseDouble(value));
                        case "y" -> commandPredicateBuilder.y(Double.parseDouble(value));
                        case "z" -> commandPredicateBuilder.z(Double.parseDouble(value));
                        case "dx" -> commandPredicateBuilder.dx(Double.parseDouble(value));
                        case "dy" -> commandPredicateBuilder.dy(Double.parseDouble(value));
                        case "dz" -> commandPredicateBuilder.dz(Double.parseDouble(value));
                        case "score" -> {
                            int score_start = value.indexOf('{');
                            int score_end = value.lastIndexOf('}');
                            String score_now = value.substring(score_start + 1, score_end);
                            if (score_now.isBlank()) throw new InvalidCommandArgsException(exceptionMessage);
                            if (score_now.contains("=")) {
                                String[] score_splits = score_now.split("=");
                                String score_key = score_splits[0];
                                String score_value = score_splits[1];
                                if (score_value.contains("..")) {
                                    String[] numbers = score_value.split("\\.\\.");
                                    if (numbers.length == 1) {
                                        Integer min = Integer.parseInt(numbers[0]);
                                        scoreConditionList.add(ScoreCondition.builder().name(score_key).min(min).build());
                                    } else if (numbers.length == 2) {
                                        Integer min = numbers[0].isBlank() ? null : Integer.parseInt(numbers[0]);
                                        Integer max = Integer.parseInt(numbers[1]);
                                        scoreConditionList.add(ScoreCondition.builder().name(score_key).min(min).max(max).build());
                                    } else throw new IncompleteCommandException(exceptionMessage);
                                } else {
                                    Integer number = Integer.parseInt(score_value);
                                    scoreConditionList.add(ScoreCondition.builder().name(score_key).min(number).max(number).build());
                                }
                            } else throw new IncompleteCommandException(exceptionMessage);
                        }
                        case "level" -> {
                            if (value.contains("..")) {
                                String[] numbers = value.split("\\.\\.");
                                if (numbers.length == 1) {
                                    Integer min = Integer.parseInt(numbers[0]);
                                    commandPredicateBuilder.levelCondition(LevelCondition.builder().min(min).build());
                                } else if (numbers.length == 2) {
                                    Integer min = numbers[0].isBlank() ? null : Integer.parseInt(numbers[0]);
                                    Integer max = Integer.parseInt(numbers[1]);
                                    commandPredicateBuilder.levelCondition(LevelCondition.builder().min(min).max(max).build());
                                } else throw new IncompleteCommandException(exceptionMessage);
                            } else {
                                Integer number = Integer.parseInt(value);
                                commandPredicateBuilder.levelCondition(LevelCondition.builder().min(number).max(number).build());
                            }
                        }
                        case "gamemode" -> {
                            List<GameMode> gameModes = new ArrayList<>();
                            boolean reverse = value.contains("!");
                            for (GameMode gameMode : GameMode.values())
                                if (reverse && !value.toUpperCase().contains(gameMode.name())) gameModes.add(gameMode);
                                else if (!reverse && value.toUpperCase().contains(gameMode.name()))
                                    gameModes.add(gameMode);
                            commandPredicateBuilder.gameModeCondition(GameModeCondition.builder().gameModes(gameModes).build());
                        }
                        case "name" ->
                                commandPredicateBuilder.nameCondition(NameCondition.builder().name(value).build());
                        case "tag" -> commandPredicateBuilder.tagCondition(TagCondition.builder().tag(value).build());
                        case "type" ->
                                commandPredicateBuilder.typeCondition(TypeCondition.builder().type(value).build());
                        case "limit" -> commandPredicateBuilder.limit(Integer.valueOf(value));
                    }
                } catch (NumberFormatException nfe) {
                    throw new IncompleteCommandException(exceptionMessage);
                }
            } else throw new IncompleteCommandException(exceptionMessage);
        }
        return commandPredicateBuilder.scoreConditionList(scoreConditionList).build();
    }

    @EventHandler
    public void Events(PlayerToggleSneakEvent e) {
        Bukkit.broadcastMessage(PermissionStore.hasPermission(e.getPlayer(), "test") + "");
    }
}
