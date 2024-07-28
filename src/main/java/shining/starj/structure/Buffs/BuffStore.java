package shining.starj.structure.Buffs;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public abstract class BuffStore {
    @Getter
    private static final List<BuffStore> list = new ArrayList<>();
    //
    protected String name;
    protected BuffType[] buffTypes;
    protected double duration;
    protected List<Player> targets = new ArrayList<>();

    public void start() {
        list.add(this);
    }

    public void end() {
        list.remove(this);
    }

    public abstract void tick(Player player);

    public void tickAll() {
        this.duration = duration - 1;
        for (Player target : targets)
            tick(target);
        if (duration == 0)
            end();
    }

    public BuffStore(String name, double duration, List<Player> targets, BuffType... buffTypes) {
        this.name = name;
        this.buffTypes = buffTypes;
        this.duration = duration;
        this.targets = targets;
    }

    public static void remove(Player player, String name) {
        for (BuffStore buff : list)
            if (buff.name.equals(name)) {
                List<Player> targets = buff.getTargets();
                buff.targets = targets.stream().filter(f -> !f.getUniqueId().equals(player.getUniqueId())).toList();
            }
    }

    public static void remove(Player player, BuffType type) {
        for (BuffStore buff : list)
            if (Arrays.stream(buff.buffTypes).toList().contains(type)) {
                List<Player> targets = buff.getTargets();
                buff.targets = targets.stream().filter(f -> !f.getUniqueId().equals(player.getUniqueId())).toList();
            }
    }
}
