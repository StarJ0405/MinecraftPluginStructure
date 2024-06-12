package shining.starj.structure.Listeners.PreWork;

import lombok.Builder;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.*;
import org.bukkit.block.data.Ageable;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;
import shining.starj.structure.Commands.AbstractCommand;
import shining.starj.structure.Core;
import shining.starj.structure.Exceptions.IncompleteCommandException;
import shining.starj.structure.Exceptions.InvalidCommandArgsException;
import shining.starj.structure.Exceptions.NotFoundPlayerException;
import shining.starj.structure.Listeners.AbstractEventListener;
import shining.starj.structure.Listeners.PreWork.Event.*;
import shining.starj.structure.Predicates.CommandPredicate;
import shining.starj.structure.Predicates.Conditions.*;
import shining.starj.structure.Systems.AttributeModifiers;
import shining.starj.structure.Systems.MessageStore;

import java.util.Comparator;
import java.util.*;

@Builder
public class PreWorkListener extends AbstractEventListener {
    /*
     *  플레이어 targetSelector
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
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
                                if (players.isEmpty()) throw new NotFoundPlayerException();
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

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
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
                                if (predicate.getLimit() != null) players.sort(new Closest(sender));
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
                                if (predicate.getLimit() != null) entities.sort(new Closest(sender));
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

    /*
     * 플레이어 명령어 권한여부에따른 지급
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(PlayerCommandSendEvent e) {
        Player player = e.getPlayer();
        e.getCommands().removeIf(cmd -> !AbstractCommand.isOp(cmd, player) || !AbstractCommand.hasPermission(cmd, player));
    }

    /*
     * 시간 관련
     */
    private void refillItems(Block block) {
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().setFuel(new ItemStack(Material.LAVA_BUCKET));
        furnace.getInventory().setResult(new ItemStack(Material.AIR));
        ItemStack time = new ItemStack(Material.PORKCHOP, 64);
        furnace.getInventory().setSmelting(time);
    }

    private Location getTimeLocation() {
        Location loc = Bukkit.getWorlds().getFirst().getSpawnLocation().getBlock().getLocation().clone();
        loc.setY(-64);
        return loc;
    }

    private final Location timeLocation = getTimeLocation();

    private boolean isCorrectLocation(Block block) {
        return block.getLocation().equals(timeLocation);
    }

    private void removeFurnace(Block block) {
        Location loc = block.getLocation();
        Furnace furnace = (Furnace) block.getState();
        furnace.getInventory().clear();
        if (loc.getY() == -64) block.setType(Material.BEDROCK, true);
        else {
            block.setType(Material.AIR);
            for (int x = -1; x <= 1; x++)
                for (int y = -1; y <= 0; y++)
                    for (int z = -1; z < 1; z++)
                        if (x != 0 && y != 0 && z != 0) {
                            Location now = block.getLocation().clone().add(x, y, z);
                            if (now.getBlock().getType().equals(Material.BEDROCK))
                                now.getBlock().setType(Material.AIR, true);
                        }
        }
    }

    private boolean isItem(ItemStack item) {
        return item.getType().equals(Material.PORKCHOP);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void Event(FurnaceSmeltEvent e) {
        Block block = e.getBlock();
        if (isItem(e.getResult())) if (isCorrectLocation(block)) {
            refillItems(block);
            Bukkit.getPluginManager().callEvent(new TimerEvent(block));
        } else removeFurnace(block);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void Event(ServerLoadEvent e) {
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 0; y++)
                for (int z = -1; z < 1; z++)
                    if (x != 0 && y != 0 && z != 0)
                        timeLocation.clone().add(x, y, z).getBlock().setType(Material.BEDROCK, true);
        Block block = timeLocation.getBlock();
        block.setType(Material.FURNACE);
        block.getChunk().setForceLoaded(true);
        refillItems(block);
    }


    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void Event(FurnaceBurnEvent e) {
        Block block = e.getBlock();
        if (isCorrectLocation(block)) refillItems(block);

    }

    /*
     * 인벤토리 정리
     */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void Events(InventoryClickEvent e) {
        Inventory inventory = e.getClickedInventory();
        int slot = e.getSlot();
        if (e.getClick().equals(ClickType.DOUBLE_CLICK) && e.getCursor().getType().equals(Material.AIR) && e.getCurrentItem().getType().equals(Material.AIR)) {
            List<ItemStack> itemStacks = null;
            InventoryType inventoryType = e.getClickedInventory().getType();
            switch (inventoryType) {
                case PLAYER -> {
                    if (slot < 9)
                        itemStacks = new ArrayList<>(Arrays.stream(inventory.getContents()).toList().subList(0, 9).stream().filter(Objects::nonNull).toList());
                    else if (slot < 36)
                        itemStacks = new ArrayList<>(Arrays.stream(inventory.getContents()).toList().subList(9, 36).stream().filter(Objects::nonNull).toList());
                }
                case CHEST, ENDER_CHEST, SHULKER_BOX, BARREL ->
                        itemStacks = new ArrayList<>(Arrays.stream(inventory.getContents()).filter(Objects::nonNull).toList());
            }
            if (itemStacks == null) return;
            InventorySortEvent event = new InventorySortEvent(inventory, itemStacks, inventoryType);
            Bukkit.getPluginManager().callEvent(event);
            if (!event.isCanceled()) {
                HashMap<ItemStack, Integer> map = new HashMap<>();
                a:
                for (ItemStack item : itemStacks) {
                    List<ItemStack> keys = new ArrayList<>(map.keySet());
                    for (ItemStack key : keys)
                        if (key.isSimilar(item)) {
                            int value = map.get(key);
                            map.put(key, value + item.getAmount());
                            continue a;
                        }
                    map.put(item, item.getAmount());
                }
                ItemStack[] content = inventory.getContents();
                if (event.getInventoryType().equals(InventoryType.PLAYER)) {
                    if (slot < 9) {
                        for (int i = 0; i < 9; i++)
                            content[i] = null;
                        int i = 0;
                        for (ItemStack key : map.keySet()) {
                            int value = map.get(key);
                            final int max = key.getMaxStackSize();
                            while (value > 0) {
                                if (value > max) {
                                    value -= max;
                                    key.setAmount(max);
                                    content[i] = key.clone();
                                    i++;
                                } else {
                                    key.setAmount(value);
                                    content[i] = key.clone();
                                    value = 0;
                                    i++;
                                }
                            }
                        }
                    } else if (slot < 36) {
                        for (int i = 9; i < 36; i++)
                            content[i] = null;
                        int i = 0;
                        for (ItemStack key : map.keySet()) {
                            int value = map.get(key);
                            final int max = key.getMaxStackSize();
                            while (value > 0) {
                                if (value > max) {
                                    value -= max;
                                    key.setAmount(max);
                                    content[9 + i] = key.clone();
                                    i++;
                                } else {
                                    key.setAmount(value);
                                    content[9 + i] = key.clone();
                                    value = 0;
                                    i++;
                                }
                            }
                        }
                    }
                } else {
                    content = new ItemStack[content.length];
                    int i = 0;
                    for (ItemStack key : map.keySet()) {
                        int value = map.get(key);
                        final int max = key.getMaxStackSize();
                        while (value > 0) {
                            if (value > max) {
                                value -= max;
                                key.setAmount(max);
                                content[i] = key.clone();
                                i++;
                            } else {
                                key.setAmount(value);
                                content[i] = key.clone();
                                value = 0;
                                i++;
                            }
                        }
                    }
                }
                inventory.setContents(content);
            }
        }
//        Bukkit.broadcastMessage(e.getClick().equals(ClickType.DOUBLE_CLICK) + ", " + e.getCurrentItem() + " => " + e.getClickedInventory().getType().name() + "(" + e.getSlot() + ")");
    }

    /*
     *  가방
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(EntityPickupItemEvent e) {
        if (e.getEntityType().equals(EntityType.PLAYER)) {
            Player player = (Player) e.getEntity();
            Inventory inv = player.getInventory();
            ItemStack[] contents = inv.getContents();
            for (int i = 0; i < contents.length; i++) {
                ItemStack item = contents[i];
                if (item != null && item.getType().name().contains("SHULKER")) {

                }
            }
        }
    }

    /*
     * 상자 및 블럭 들기
     */

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR) && block != null && e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && player.isSneaking()) {
            ContainerPickupEvent event = getMoveContainerEvent(block, player);
            if (event == null) return;
            Bukkit.getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
                ItemStack result = new ItemStack(event.getBlock().getType());
                ItemMeta meta = result.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                List<ItemStack> stored = event.getStored();
                // 나중에 ItemToString 와 ItemFromString 필요
                for (int i = 0; i < stored.size(); i++) {
                    ItemStack now = stored.get(i);
                    if (now == null) continue;
                    container.set(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.STRING, now.getType().name() + "," + now.getAmount());
                }
                container.set(new NamespacedKey(Core.getCore(), "size"), PersistentDataType.INTEGER, stored.size());
                if (event instanceof FuelContainerPickupEvent fuelEvent) {
                    container.set(new NamespacedKey(Core.getCore(), "burnTime"), PersistentDataType.SHORT, fuelEvent.getBurnTime());
                    container.set(new NamespacedKey(Core.getCore(), "cookTime"), PersistentDataType.SHORT, fuelEvent.getCookTime());
                    container.set(new NamespacedKey(Core.getCore(), "cookTimeTotal"), PersistentDataType.INTEGER, fuelEvent.getCookTimeTotal());
                }
                result.setItemMeta(meta);
                event.getPlayer().getInventory().setItemInMainHand(result);
                event.getBlock().setType(Material.AIR, true);
                AttributeModifiers.builder().uuid(player.getUniqueId()).name(player.getName()).amount(-0.75).operation(AttributeModifier.Operation.ADD_SCALAR).attribute(Attribute.GENERIC_MOVEMENT_SPEED).build().apply(player);
                e.setCancelled(true);
            }
        }
    }

    @Nullable
    private static ContainerPickupEvent getMoveContainerEvent(Block block, Player player) {
        ContainerPickupEvent event = null;
        switch (block.getType()) {
            case CHEST ->
                    event = new ContainerPickupEvent(player, block, Arrays.asList(((Chest) block.getState()).getInventory().getContents()));
            case BARREL ->
                    event = new ContainerPickupEvent(player, block, Arrays.asList(((Barrel) block.getState()).getInventory().getContents()));
            case FURNACE -> {
                Furnace furnace = (Furnace) block.getState();
                event = new FuelContainerPickupEvent(player, block, Arrays.asList(furnace.getInventory().getContents()), furnace.getBurnTime(), furnace.getCookTime(), furnace.getCookTimeTotal());
            }
            case BLAST_FURNACE -> {
                BlastFurnace blastFurnace = (BlastFurnace) block.getState();
                event = new FuelContainerPickupEvent(player, block, Arrays.asList(blastFurnace.getInventory().getContents()), blastFurnace.getBurnTime(), blastFurnace.getCookTime(), blastFurnace.getCookTimeTotal());
            }
            case SMOKER -> {
                Smoker smoker = (Smoker) block.getState();
                event = new FuelContainerPickupEvent(player, block, Arrays.asList(smoker.getInventory().getContents()), smoker.getBurnTime(), smoker.getCookTime(), smoker.getCookTimeTotal());
            }
            case SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX ->
                    event = new ContainerPickupEvent(player, block, Arrays.asList(((ShulkerBox) block.getState()).getInventory().getContents()));
            case ENDER_CHEST -> event = new ContainerPickupEvent(player, block, new ArrayList<>());

        }
        return event;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        if (container.has(new NamespacedKey(Core.getCore(), "size"))) {
            final int size = container.get(new NamespacedKey(Core.getCore(), "size"), PersistentDataType.INTEGER);
            ContainerPlaceEvent event = null;
            switch (item.getType()) {
                case CHEST, BARREL, SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX -> {
                    List<ItemStack> stored = new ArrayList<>();
                    for (int i = 0; i < size; i++)
                        if (container.has(new NamespacedKey(Core.getCore(), "inventory." + i))) {
                            String[] values = container.get(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.STRING).split(",");
                            Material material = Material.valueOf(values[0]);
                            int amount = Integer.parseInt(values[1]);
                            stored.add(new ItemStack(material, amount));
                        } else stored.add(new ItemStack(Material.AIR));
                    event = new ContainerPlaceEvent(player, item, e.getBlockPlaced(), stored);
                }
                case FURNACE, BLAST_FURNACE, SMOKER -> {
                    List<ItemStack> stored = new ArrayList<>();
                    for (int i = 0; i < size; i++)
                        if (container.has(new NamespacedKey(Core.getCore(), "inventory." + i))) {
                            String[] values = container.get(new NamespacedKey(Core.getCore(), "inventory." + i), PersistentDataType.STRING).split(",");
                            Material material = Material.valueOf(values[0]);
                            int amount = Integer.parseInt(values[1]);
                            stored.add(new ItemStack(material, amount));
                        } else stored.add(new ItemStack(Material.AIR));
                    short burnTime = container.has(new NamespacedKey(Core.getCore(), "burnTime")) ? burnTime = container.get(new NamespacedKey(Core.getCore(), "burnTime"), PersistentDataType.SHORT) : 0;
                    short cookTime = container.has(new NamespacedKey(Core.getCore(), "cookTime")) ? container.get(new NamespacedKey(Core.getCore(), "cookTime"), PersistentDataType.SHORT) : 0;
                    int cookTimeTotal = container.has(new NamespacedKey(Core.getCore(), "cookTimeTotal")) ? container.get(new NamespacedKey(Core.getCore(), "cookTimeTotal"), PersistentDataType.INTEGER) : 0;
                    event = new FuelContainerPlaceEvent(player, item, e.getBlockPlaced(), stored, burnTime, cookTime, cookTimeTotal);
                }
                case ENDER_CHEST ->
                        event = new ContainerPlaceEvent(player, item, e.getBlockPlaced(), new ArrayList<>());
            }
            if (!event.isCanceled()) {
                Block placed = event.getPlacedBlock();
                switch (placed.getType()) {
                    case CHEST -> {
                        Chest chest = (Chest) placed.getState();
                        chest.getInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                    }
                    case BARREL -> {
                        Barrel barrel = (Barrel) placed.getState();
                        barrel.getInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                    }
                    case SHULKER_BOX, BLACK_SHULKER_BOX, BLUE_SHULKER_BOX, GREEN_SHULKER_BOX, LIME_SHULKER_BOX, GRAY_SHULKER_BOX, MAGENTA_SHULKER_BOX, PINK_SHULKER_BOX, ORANGE_SHULKER_BOX, RED_SHULKER_BOX, WHITE_SHULKER_BOX, PURPLE_SHULKER_BOX, YELLOW_SHULKER_BOX, BROWN_SHULKER_BOX, CYAN_SHULKER_BOX, LIGHT_BLUE_SHULKER_BOX, LIGHT_GRAY_SHULKER_BOX -> {
                        ShulkerBox shulkerBox = (ShulkerBox) placed.getState();
                        shulkerBox.getInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                    }
                    case FURNACE -> {
                        Furnace furnace = (Furnace) placed.getState();
                        furnace.getSnapshotInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                        if (event instanceof FuelContainerPlaceEvent fuelEvent) {
                            furnace.setBurnTime(fuelEvent.getBurnTime());
                            furnace.setCookTime(fuelEvent.getCookTime());
                            furnace.setCookTimeTotal(fuelEvent.getCookTimeTotal());
                            furnace.update(true, true);
                        }
                    }
                    case BLAST_FURNACE -> {
                        BlastFurnace blastFurnace = (BlastFurnace) placed.getState();
                        blastFurnace.getSnapshotInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                        if (event instanceof FuelContainerPlaceEvent fuelEvent) {
                            blastFurnace.setBurnTime(fuelEvent.getBurnTime());
                            blastFurnace.setCookTime(fuelEvent.getCookTime());
                            blastFurnace.setCookTimeTotal(fuelEvent.getCookTimeTotal());
                            blastFurnace.update(true, true);
                        }
                    }
                    case SMOKER -> {
                        Smoker smoker = (Smoker) placed.getState();
                        smoker.getSnapshotInventory().setContents(event.getStored().toArray(ItemStack[]::new));
                        if (event instanceof FuelContainerPlaceEvent fuelEvent) {
                            smoker.setBurnTime(fuelEvent.getBurnTime());
                            smoker.setCookTime(fuelEvent.getCookTime());
                            smoker.setCookTimeTotal(fuelEvent.getCookTimeTotal());
                            smoker.update(true, true);
                        }
                    }
                    case ENDER_CHEST -> {
                    }
                }
                AttributeModifiers.builder().uuid(player.getUniqueId()).name(player.getName()).amount(0).operation(AttributeModifier.Operation.ADD_SCALAR).attribute(Attribute.GENERIC_MOVEMENT_SPEED).build().apply(player);
            } else e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(PlayerItemHeldEvent e) {
        Player player = e.getPlayer();
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        ItemMeta meta = heldItem.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(PlayerSwapHandItemsEvent e) {
        ItemStack mainHandItem = e.getOffHandItem();
        ItemMeta meta = mainHandItem.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events2(InventoryClickEvent e) {
        ItemStack current = e.getCurrentItem();
        ItemMeta currentItemMeta = current.getItemMeta();
        if (currentItemMeta != null) {
            PersistentDataContainer persistentDataContainer = currentItemMeta.getPersistentDataContainer();
            if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
        }
        if (e.getClick().equals(ClickType.NUMBER_KEY)) {
            Player player = (Player) e.getWhoClicked();
            ItemStack hotBar = player.getInventory().getItem(e.getHotbarButton());
            if (hotBar != null) {
                ItemMeta hotBarItemMeta = hotBar.getItemMeta();
                if (hotBarItemMeta != null) {
                    PersistentDataContainer persistentDataContainer = hotBarItemMeta.getPersistentDataContainer();
                    if (persistentDataContainer.has(new NamespacedKey(Core.getCore(), "size"))) e.setCancelled(true);
                }
            }
        }
    }

    /*
     * 작물캐기
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events2(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && item != null && item.getType().name().contains("HOE")) {
            Block clickedBlock = e.getClickedBlock();
            if (clickedBlock != null) {
                HarvestEvent event = null;
                switch (clickedBlock.getType()) {
                    case WHEAT -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.WHEAT)).length(1).fortune(true).build());
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.WHEAT_SEEDS)).min(0).max(3).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case CARROTS -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.CARROT)).min(1).max(4).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case POTATOES -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.POTATO)).min(1).max(4).fortune(true).build());
                            if (new Random().nextDouble() < 0.02d)
                                rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.POISONOUS_POTATO)).length(1).fortune(false).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case BEETROOTS -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.BEETROOT)).length(1).fortune(true).build());
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.BEETROOT_SEEDS)).min(1).max(4).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case NETHER_WART -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.NETHER_WART)).min(2).max(4).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case COCOA -> {
                        Ageable crops = (Ageable) clickedBlock.getBlockData();
                        if (crops.getAge() == crops.getMaximumAge()) {
                            List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                            rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.COCOA_BEANS)).min(2).max(3).fortune(true).build());
                            event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                        }
                    }
                    case MELON -> {
                        List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                        rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.MELON_SLICE)).min(3).max(7).fortune(true).build());
                        event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                    }
                    case PUMPKIN -> {
                        List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                        rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.PUMPKIN)).length(1).fortune(true).build());
                        event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                    }
                    case SUGAR_CANE -> {
                        List<HarvestEvent.RangeItem> rangeItems = new ArrayList<>();
                        rangeItems.add(HarvestEvent.RangeItem.builder().item(new ItemStack(Material.SUGAR_CANE)).length(1).fortune(true).build());
                        event = HarvestEvent.builder().player(e.getPlayer()).exp(1).block(clickedBlock).rangeItems(rangeItems).hoe(item).build();
                    }
                }
                if (event == null) return;
                Bukkit.getPluginManager().callEvent(event);
                if (!event.isCanceled()) {
                    ItemStack hoe = event.getHoe();
                    Block block = event.getBlock();
                    Location loc = block.getLocation().clone().add(0.5, 0.25, 0.5);
                    int exp = event.getExp();
                    if (exp > 0) {
                        ExperienceOrb experienceOrb = (ExperienceOrb) loc.getWorld().spawnEntity(loc, EntityType.EXPERIENCE_ORB);
                        experienceOrb.setExperience(exp);
                    }

                    int max = event.isFortune() ? hoe.getEnchantmentLevel(Enchantment.FORTUNE) : 0;
                    for (HarvestEvent.RangeItem rangeItem : event.getRangeItems())
                        loc.getWorld().dropItem(loc, rangeItem.getItem(max));
                    block.setType(Material.AIR, true);

                    PlayerItemDamageEvent playerItemDamageEvent = new PlayerItemDamageEvent(event.getPlayer(), hoe, 1);
                    if (!playerItemDamageEvent.isCancelled()) {
                        Damageable damageable = (Damageable) hoe.getItemMeta();
                        int level = event.isUnbreaking() ? hoe.getEnchantmentLevel(Enchantment.UNBREAKING) : 0;
                        double chance = new Random().nextDouble();
                        if (chance < 1d / (1 + level) && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                            damageable.setDamage(damageable.getDamage() + 1);
                            int maxDurability = damageable.hasMaxDamage() ? damageable.getMaxDamage() : hoe.getType().getMaxDurability();
                            if (damageable.getDamage() >= maxDurability) hoe.setAmount(0);
                        }
                        hoe.setItemMeta(damageable);
                    }
                }
            }
        }
    }

    /*
     * 작물 보호
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events3(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.FARMLAND))
            e.setCancelled(true);
    }

    /*
     * 폭발 보호
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(BlockExplodeEvent e) {
        e.blockList().clear();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(EntityExplodeEvent e) {
        e.blockList().clear();
    }

    /*
     * 화염 보호
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void Events(BlockIgniteEvent e) {
        if (e.getCause().equals(BlockIgniteEvent.IgniteCause.SPREAD)) e.setCancelled(true);
    }
}
