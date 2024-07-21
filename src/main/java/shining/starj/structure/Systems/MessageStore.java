package shining.starj.structure.Systems;

import lombok.Builder;
import lombok.Getter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import shining.starj.structure.Core;
import shining.starj.structure.Exceptions.NotAllowedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;


public class MessageStore {
    @Getter
    private final static List<BoosBarInfo> bossBars = new ArrayList<>();
    @Getter
    private final static MessageStore messageStore = new MessageStore();
    @Getter
    private final static List<ActionBarInfo> actionBars = new ArrayList<>();

    private MessageStore() {

    }


    public MessageStore sendErrorBroadcastMessage(String msg, boolean prefix, double delaySeconds, Predicate<CommandSender> predicate) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            for (World world : Bukkit.getWorlds())
                for (LivingEntity entity : world.getLivingEntities())
                    if (entity instanceof CommandSender sender)
                        if (predicate == null || predicate.test(sender)) sendErrorMessage(sender, msg, prefix);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else for (World world : Bukkit.getWorlds())
            for (LivingEntity entity : world.getLivingEntities())
                if (entity instanceof CommandSender sender)
                    if (predicate == null || predicate.test(sender)) sendErrorMessage(sender, msg, prefix);

        return this;
    }

    public MessageStore sendErrorBroadcastMessage(String msg, boolean prefix, double delaySeconds) {
        return sendErrorBroadcastMessage(msg, prefix, delaySeconds, null);
    }

    public MessageStore sendErrorBroadcastMessage(String msg, double delaySeconds, Predicate<CommandSender> predicate) {
        return sendErrorBroadcastMessage(msg, true, delaySeconds, predicate);
    }

    public MessageStore sendErrorBroadcastMessage(String msg, double delaySeconds) {
        return sendErrorBroadcastMessage(msg, true, delaySeconds, null);
    }

    public MessageStore sendErrorBroadcastMessage(String msg, Predicate<CommandSender> predicate) {
        return sendErrorBroadcastMessage(msg, true, 0, predicate);
    }

    public MessageStore sendErrorBroadcastMessage(String msg) {
        return sendErrorBroadcastMessage(msg, true, 0, null);
    }

    public MessageStore sendErrorBroadcastMessage(String msg, boolean prefix, Predicate<CommandSender> predicate) {
        return sendErrorBroadcastMessage(msg, prefix, 0, predicate);
    }

    public MessageStore sendErrorBroadcastMessage(String msg, boolean prefix) {
        return sendErrorBroadcastMessage(msg, prefix, 0, null);
    }

    public MessageStore sendErrorMessage(CommandSender sender, String msg, boolean prefix, double delaySeconds) {
        if (delaySeconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> sender.sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.RED + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg), (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else
            sender.sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.RED + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg);
        return this;
    }

    public MessageStore sendErrorMessage(CommandSender sender, String msg, double delaySeconds) {
        return sendErrorMessage(sender, msg, true, delaySeconds);
    }

    public MessageStore sendErrorMessage(CommandSender sender, String msg) {
        return sendErrorMessage(sender, msg, true, 0);
    }

    public MessageStore sendErrorMessage(CommandSender sender, String msg, boolean prefix) {
        return sendErrorMessage(sender, msg, prefix, 0);
    }

    public MessageStore sendBroadcastMessage(String msg, boolean prefix, double delaySeconds, Predicate<CommandSender> predicate) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            for (World world : Bukkit.getWorlds())
                for (LivingEntity entity : world.getLivingEntities())
                    if (entity instanceof CommandSender sender)
                        if (predicate == null || predicate.test(sender)) sendMessage(sender, msg, prefix);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else for (World world : Bukkit.getWorlds())
            for (LivingEntity entity : world.getLivingEntities())
                if (entity instanceof CommandSender sender)
                    if (predicate == null || predicate.test(sender)) sendMessage(sender, msg, prefix);
        return this;
    }

    public MessageStore sendBroadcastMessage(String msg, boolean prefix, double delaySeconds) {
        return sendBroadcastMessage(msg, prefix, delaySeconds, null);
    }

    public MessageStore sendBroadcastMessage(String msg, double delaySeconds, Predicate<CommandSender> predicate) {
        return sendBroadcastMessage(msg, true, delaySeconds, predicate);
    }

    public MessageStore sendBroadcastMessage(String msg, double delaySeconds) {
        return sendBroadcastMessage(msg, true, delaySeconds, null);
    }

    public MessageStore sendBroadcastMessage(String msg, boolean prefix, Predicate<CommandSender> predicate) {
        return sendBroadcastMessage(msg, prefix, 0, predicate);
    }

    public MessageStore sendBroadcastMessage(String msg, boolean prefix) {
        return sendBroadcastMessage(msg, prefix, 0, null);
    }

    public MessageStore sendBroadcastMessage(String msg, Predicate<CommandSender> predicate) {
        return sendBroadcastMessage(msg, true, 0, predicate);
    }

    public MessageStore sendBroadcastMessage(String msg) {
        return sendBroadcastMessage(msg, true, 0, null);
    }

    public MessageStore sendMessage(CommandSender sender, String msg, boolean prefix, double delaySeconds) {
        if (delaySeconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> sender.sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.GREEN + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg), (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else
            sender.sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.GREEN + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg);
        return this;
    }

    public MessageStore sendMessage(CommandSender sender, String msg, double delaySeconds) {
        return sendMessage(sender, msg, true, delaySeconds);
    }

    public MessageStore sendMessage(CommandSender sender, String msg, boolean prefix) {
        return sendMessage(sender, msg, prefix, 0);
    }

    public MessageStore sendMessage(CommandSender sender, String msg) {
        return sendMessage(sender, msg, true, 0);
    }

    public MessageStore sendConsoleMessage(String msg, boolean prefix, double delaySeconds) {
        if (delaySeconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> Bukkit.getConsoleSender().sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.GREEN + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg), (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else
            Bukkit.getConsoleSender().sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.GREEN + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg);
        return this;
    }

    public MessageStore sendConsoleMessage(String msg, double delaySeconds) {
        return sendConsoleMessage(msg, true, delaySeconds);
    }

    public MessageStore sendConsoleMessage(String msg) {
        return sendConsoleMessage(msg, true, 0);
    }

    public MessageStore sendConsoleMessage(String msg, boolean prefix) {
        return sendConsoleMessage(msg, prefix, 0);
    }

    public MessageStore sendConsoleErrorMessage(String msg, boolean prefix, double delaySeconds) {
        if (delaySeconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> Bukkit.getConsoleSender().sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.RED + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg), (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else
            Bukkit.getConsoleSender().sendMessage((prefix ? ChatColor.GRAY + "【" + ChatColor.RED + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE : "") + msg);
        return this;
    }

    public MessageStore sendConsoleErrorMessage(String msg, double delaySeconds) {
        return sendConsoleErrorMessage(msg, true, delaySeconds);
    }

    public MessageStore sendConsoleErrorMessage(String msg) {
        return sendConsoleErrorMessage(msg, true, 0);
    }

    public MessageStore sendConsoleErrorMessage(String msg, boolean prefix) {
        return sendConsoleErrorMessage(msg, prefix, 0);
    }

    public MessageStore sendComponentBroadcastMessage(boolean prefix, double delaySeconds, Predicate<Player> predicate, TextInfo... components) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            for (World world : Bukkit.getWorlds())
                for (Player player : world.getPlayers())
                    if (predicate == null || predicate.test(player))
                        sendComponentMessage(player, prefix, 0, components);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else for (World world : Bukkit.getWorlds())
            for (Player player : world.getPlayers())
                if (predicate == null || predicate.test(player)) sendComponentMessage(player, prefix, 0, components);
        return this;
    }

    public MessageStore sendComponentBroadcastMessage(boolean prefix, double delaySeconds, TextInfo... components) {
        return sendComponentBroadcastMessage(prefix, delaySeconds, null, components);
    }

    public MessageStore sendComponentBroadcastMessage(Predicate<Player> predicate, TextInfo... components) {
        return sendComponentBroadcastMessage(true, 0, predicate, components);
    }

    public MessageStore sendComponentBroadcastMessage(TextInfo... components) {
        return sendComponentBroadcastMessage(true, 0, null, components);
    }

    public MessageStore sendComponentBroadcastMessage(boolean prefix, Predicate<Player> predicate, TextInfo... components) {
        return sendComponentBroadcastMessage(prefix, 0, predicate, components);
    }

    public MessageStore sendComponentBroadcastMessage(boolean prefix, TextInfo... components) {
        return sendComponentBroadcastMessage(prefix, 0, null, components);
    }

    public MessageStore sendComponentBroadcastMessage(double delaySeconds, Predicate<Player> predicate, TextInfo... components) {
        return sendComponentBroadcastMessage(true, delaySeconds, predicate, components);
    }

    public MessageStore sendComponentBroadcastMessage(double delaySeconds, TextInfo... components) {
        return sendComponentBroadcastMessage(true, delaySeconds, null, components);
    }

    public MessageStore sendComponentMessage(Player player, boolean prefix, double delaySeconds, TextInfo... components) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            List<TextComponent> list = new ArrayList<>();
            if (prefix)
                list.add(new TextComponent(ChatColor.GRAY + "【" + ChatColor.RED + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE));
            list.addAll(Arrays.stream(components).map(TextInfo::getText).toList());
            player.spigot().sendMessage(list.toArray(TextComponent[]::new));
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            List<TextComponent> list = new ArrayList<>();
            if (prefix)
                list.add(new TextComponent(ChatColor.GRAY + "【" + ChatColor.RED + Core.getCore().getName() + ChatColor.GRAY + "】" + ChatColor.WHITE));
            list.addAll(Arrays.stream(components).map(TextInfo::getText).toList());
            player.spigot().sendMessage(list.toArray(TextComponent[]::new));
        }
        return this;
    }

    public MessageStore sendComponentMessage(Player player, TextInfo... components) {
        return sendComponentMessage(player, true, 0, components);
    }

    public MessageStore sendComponentMessage(Player player, boolean prefix, TextInfo... components) {
        return sendComponentMessage(player, prefix, 0, components);
    }

    public MessageStore sendComponentMessage(Player player, double delaySeconds, TextInfo... components) {
        return sendComponentMessage(player, true, delaySeconds, components);
    }

    @Builder
    public record TextInfo(String msg, String hover_msg, ItemStack hover_Item, String click_command,
                           String click_suggest, String click_copyClipboard, String click_url) {
        public TextComponent getText() {
            TextComponent component = new TextComponent(msg);
            if (hover_msg != null && !hover_msg.isBlank() && hover_Item != null) // 중복 사용 방지
                throw new NotAllowedException("하나의 텍스트에 hover 기능을 msg와 item을 동시에 달 수 없습니다.");
            if (hover_Item != null)
                component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new Item(hover_Item.getType().getKey().toString(), hover_Item.getAmount(), ItemTag.ofNbt(hover_Item.hasItemMeta() ? hover_Item.getItemMeta().getAsString() : "{}"))));
            else if (hover_msg != null && !hover_msg.isBlank())
                component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hover_msg).create()));

            if (click_command != null && !click_command.isBlank() && click_suggest != null && !click_suggest.isBlank() && click_copyClipboard != null && !click_copyClipboard.isBlank() && click_url != null && !click_url.isBlank()) // 중복 사용 방지
                throw new NotAllowedException("하나의 텍스트에 click 기능을 cmd, suggest, clipboard, url 중 하나만 달수 있습니다.");


            if (click_command != null && !click_command.isBlank())
                component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, click_command));
            else if (click_suggest != null && !click_suggest.isBlank())
                component.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, click_suggest));
            else if (click_copyClipboard != null && !click_copyClipboard.isBlank())
                component.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, click_copyClipboard));
            else if (click_url != null && !click_url.isBlank())
                component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, click_url));
            return component;
        }
    }

    public MessageStore sendToastBroadcastMessage(double delaySeconds, String msg, Predicate<Player> predicate) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            for (World world : Bukkit.getWorlds())
                for (Player player : world.getPlayers())
                    if (predicate == null || predicate.test(player)) sendToastMessage(player, 0, msg);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else for (World world : Bukkit.getWorlds())
            for (Player player : world.getPlayers())
                if (predicate == null || predicate.test(player)) sendToastMessage(player, 0, msg);
        return this;
    }

    public MessageStore sendToastBroadcastMessage(double delaySeconds, String msg) {
        return sendToastBroadcastMessage(delaySeconds, msg, null);
    }

    public MessageStore sendToastBroadcastMessage(String msg, Predicate<Player> predicate) {
        return sendToastBroadcastMessage(0, msg, predicate);
    }

    public MessageStore sendToastBroadcastMessage(String msg) {
        return sendToastBroadcastMessage(0, msg, null);
    }

    public MessageStore sendToastMessage(Player player, double delaySeconds, String msg) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {

        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else {

        }
        return this;
    }

    public MessageStore sendToastMessage(Player player, String msg) {
        return sendToastMessage(player, msg);
    }

    public MessageStore sendBroadcastPlayerList(String header, String footer, double delaySeconds, Predicate<Player> predicate) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            for (World world : Bukkit.getWorlds())
                for (Player player : world.getPlayers())
                    if (predicate == null || predicate.test(player)) sendPlayerList(player, header, footer);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else for (World world : Bukkit.getWorlds())
            for (Player player : world.getPlayers())
                if (predicate == null || predicate.test(player)) sendPlayerList(player, header, footer);
        return this;
    }

    public MessageStore sendBroadcastPlayerList(String header, String footer, double delaySeconds) {
        return sendBroadcastPlayerList(header, footer, delaySeconds, null);
    }

    public MessageStore sendBroadcastPlayerList(String header, String footer, Predicate<Player> predicate) {
        return sendBroadcastPlayerList(header, footer, 0, predicate);
    }

    public MessageStore sendBroadcastPlayerList(String header, String footer) {
        return sendBroadcastPlayerList(header, footer, 0, null);
    }

    public MessageStore sendPlayerList(Player player, String header, String footer, double delaySeconds) {
        if (delaySeconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> player.setPlayerListHeaderFooter(header, footer), (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else player.setPlayerListHeaderFooter(header, footer);
        return this;
    }

    public MessageStore sendPlayerList(Player player, String header, String footer) {
        return sendPlayerList(player, header, footer, 0);
    }

    public MessageStore sendTitleBroadcastMessage(String main, String sub, double fadeInSecond, double durationSeconds, double fadeOutSeconds, double delaySeconds, Predicate<Player> predicate) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            for (World world : Bukkit.getWorlds())
                for (Player player : world.getPlayers())
                    if (predicate == null || predicate.test(player))
                        sendTitleMessage(player, main, sub, fadeInSecond, durationSeconds, fadeOutSeconds);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else for (World world : Bukkit.getWorlds())
            for (Player player : world.getPlayers())
                if (predicate == null || predicate.test(player))
                    sendTitleMessage(player, main, sub, fadeInSecond, durationSeconds, fadeOutSeconds);
        return this;
    }

    public MessageStore sendTitleBroadcastMessage(String main, String sub, double fadeInSecond, double durationSeconds, double fadeOutSeconds, double delaySeconds) {
        return sendTitleBroadcastMessage(main, sub, fadeInSecond, durationSeconds, fadeOutSeconds, delaySeconds, null);
    }

    public MessageStore sendTitleBroadcastMessage(String main, String sub, double fadeInSecond, double durationSeconds, double fadeOutSeconds, Predicate<Player> predicate) {
        return sendTitleBroadcastMessage(main, sub, fadeInSecond, durationSeconds, fadeOutSeconds, 0, predicate);
    }

    public MessageStore sendTitleBroadcastMessage(String main, String sub, double fadeInSecond, double durationSeconds, double fadeOutSeconds) {
        return sendTitleBroadcastMessage(main, sub, fadeInSecond, durationSeconds, fadeOutSeconds, 0, null);
    }

    public MessageStore sendTitleMessage(Player player, String main, String sub, double fadeInSecond, double durationSeconds, double fadeOutSeconds, double delaySeconds) {
        float rate = Bukkit.getServerTickManager().getTickRate();
        if (delaySeconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> player.sendTitle(main, sub, (int) Math.floor(fadeInSecond * rate), (int) Math.floor(durationSeconds * rate), (int) Math.floor(fadeOutSeconds * rate)), (int) Math.floor(delaySeconds * rate));
        else
            player.sendTitle(main, sub, (int) Math.floor(fadeInSecond * rate), (int) Math.floor(durationSeconds * rate), (int) Math.floor(fadeOutSeconds * rate));

        return this;
    }

    public MessageStore sendTitleMessage(Player player, String main, String sub, double fadeInSecond, double durationSeconds, double fadeOutSeconds) {
        return sendTitleMessage(player, main, sub, fadeInSecond, durationSeconds, fadeOutSeconds, 0);
    }

    public MessageStore sendBroadcastBossBar(double delaySeconds, double durationSeconds, String title, BarColor barColor, BarStyle barStyle, Predicate<Player> predicate, BarFlag... flags) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            List<UUID> list = new ArrayList<>();
            BossBar bar = Bukkit.createBossBar(title, barColor, barStyle, flags);
            bar.setProgress(1d);
            bar.setVisible(true);
            for (World world : Bukkit.getWorlds())
                for (Player player : world.getPlayers())
                    if (predicate == null || predicate.test(player)) {
                        list.add(player.getUniqueId());
                        bar.addPlayer(player);
                    }
            bossBars.add(BoosBarInfo.builder().bar(bar).startTime(System.currentTimeMillis()).endTime(System.currentTimeMillis() + ((long) durationSeconds * 1000L)).players(list).build());
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            List<UUID> list = new ArrayList<>();
            BossBar bar = Bukkit.createBossBar(title, barColor, barStyle, flags);
            bar.setProgress(1d);
            bar.setVisible(true);
            for (World world : Bukkit.getWorlds())
                for (Player player : world.getPlayers())
                    if (predicate == null || predicate.test(player)) {
                        list.add(player.getUniqueId());
                        bar.addPlayer(player);
                    }
            bossBars.add(BoosBarInfo.builder().bar(bar).startTime(System.currentTimeMillis()).endTime(System.currentTimeMillis() + ((long) durationSeconds * 1000L)).players(list).build());
        }
        return this;
    }

    public MessageStore sendBroadcastBossBar(double delaySeconds, double durationSeconds, String title, BarColor barColor, BarStyle barStyle, BarFlag... flags) {
        return sendBroadcastBossBar(delaySeconds, durationSeconds, title, barColor, barStyle, null, flags);
    }

    public MessageStore sendBroadcastBossBar(double durationSeconds, String title, BarColor barColor, BarStyle barStyle, Predicate<Player> predicate, BarFlag... flags) {
        return sendBroadcastBossBar(0, durationSeconds, title, barColor, barStyle, predicate, flags);
    }

    public MessageStore sendBroadcastBossBar(double durationSeconds, String title, BarColor barColor, BarStyle barStyle, BarFlag... flags) {
        return sendBroadcastBossBar(0, durationSeconds, title, barColor, barStyle, null, flags);
    }

    public MessageStore sendBossBar(Player player, double delaySeconds, double durationSeconds, String title, BarColor barColor, BarStyle barStyle, BarFlag... flags) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            BossBar bar = Bukkit.createBossBar(title, barColor, barStyle, flags);
            bar.addPlayer(player);
            bar.setProgress(1d);
            bar.setVisible(true);
            bossBars.add(BoosBarInfo.builder().bar(bar).startTime(System.currentTimeMillis()).endTime(System.currentTimeMillis() + ((long) durationSeconds * 1000L)).players(Arrays.stream(new UUID[]{player.getUniqueId()}).toList()).build());
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            BossBar bar = Bukkit.createBossBar(title, barColor, barStyle, flags);
            bar.addPlayer(player);
            bar.setProgress(1d);
            bar.setVisible(true);
            bossBars.add(BoosBarInfo.builder().bar(bar).startTime(System.currentTimeMillis()).endTime(System.currentTimeMillis() + ((long) durationSeconds * 1000L)).players(Arrays.stream(new UUID[]{player.getUniqueId()}).toList()).build());
        }
        return this;
    }

    public MessageStore sendBossBar(Player player, double durationSeconds, String title, BarColor barColor, BarStyle barStyle, BarFlag... flags) {
        return sendBossBar(player, 0, durationSeconds, title, barColor, barStyle, flags);
    }

    public MessageStore sendTextDisplay(Location loc, String msg, double delaySeconds, double durationSeconds, byte textOpacity, TextDisplay.TextAlignment alignment, int width, float height, Color bgColor, boolean defaultBackground, boolean seeThrough, boolean shadowed) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            TextDisplay textDisplay = (TextDisplay) loc.getWorld().spawnEntity(loc, EntityType.TEXT_DISPLAY);
            textDisplay.setMetadata("remove", new FixedMetadataValue(Core.getCore(), System.currentTimeMillis() + ((long) durationSeconds * 1000L)));
            textDisplay.setText(msg);
            textDisplay.setTextOpacity(textOpacity);
            textDisplay.setAlignment(alignment);
            textDisplay.setLineWidth(width);
            textDisplay.setDisplayHeight(height);
            textDisplay.setBackgroundColor(bgColor);
            textDisplay.setDefaultBackground(defaultBackground);
            textDisplay.setSeeThrough(seeThrough);
            textDisplay.setShadowed(shadowed);
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            TextDisplay textDisplay = (TextDisplay) loc.getWorld().spawnEntity(loc, EntityType.TEXT_DISPLAY);
            textDisplay.setMetadata("remove", new FixedMetadataValue(Core.getCore(), System.currentTimeMillis() + ((long) durationSeconds * 1000L)));
            textDisplay.setText(msg);
            textDisplay.setTextOpacity(textOpacity);
            textDisplay.setAlignment(alignment);
            textDisplay.setLineWidth(width);
            textDisplay.setDisplayHeight(height);
            textDisplay.setBackgroundColor(bgColor);
            textDisplay.setDefaultBackground(defaultBackground);
            textDisplay.setSeeThrough(seeThrough);
            textDisplay.setShadowed(shadowed);
        }
        return this;
    }

    public MessageStore sendTextDisplay(Location loc, String msg, double durationSeconds, byte textOpacity, TextDisplay.TextAlignment alignment, int width, float height, Color bgColor, boolean defaultBackground, boolean seeThrough, boolean shadowed) {
        return sendTextDisplay(loc, msg, 0, durationSeconds, textOpacity, alignment, width, height, bgColor, defaultBackground, seeThrough, shadowed);
    }

    public MessageStore sendActionbar(Player player, double durationSeconds, String msg, double delaySeconds) {
        if (delaySeconds > 0) Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(msg).create());
            if (durationSeconds > 0)
                actionBars.add(ActionBarInfo.builder().msg(msg).endTime(System.currentTimeMillis() + ((long) durationSeconds * 1000L)).players(Arrays.stream(new UUID[]{player.getUniqueId()}).toList()).build());
        }, (int) Math.floor(delaySeconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(msg).create());
            if (durationSeconds > 0)
                actionBars.add(ActionBarInfo.builder().msg(msg).endTime(System.currentTimeMillis() + ((long) durationSeconds * 1000L)).players(Arrays.stream(new UUID[]{player.getUniqueId()}).toList()).build());
        }
        return this;
    }

    public MessageStore sendActionbar(Player player, double durationSeconds, String msg) {
        return sendActionbar(player, durationSeconds, msg, 0);
    }

    public MessageStore sendActionbar(Player player, String msg, double delaySeconds) {
        return sendActionbar(player, 0, msg, delaySeconds);
    }

    public MessageStore sendActionbar(Player player, String msg) {
        return sendActionbar(player, 0, msg, 0);
    }

    @Builder
    public record BoosBarInfo(BossBar bar, Long startTime, Long endTime, List<UUID> players, boolean every) {
    }

    @Builder
    public record ActionBarInfo(String msg, Long endTime, List<UUID> players, boolean every) {

    }
}
