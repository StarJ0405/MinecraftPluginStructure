package shining.starj.structure.Commands.Prework;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import shining.starj.structure.Commands.AbstractTab;

import java.util.ArrayList;
import java.util.List;

public class PlayerTab extends AbstractTab {

    @Builder
    public PlayerTab(int slot, String permission, boolean isOp) {
        super(slot, permission, isOp);
    }

    @Getter
    private enum Parameters {
        Distance("distance=") {
            @Override
            public boolean check(String value, String begin) {
                return super.check(value, begin) && !begin.contains("..");
            }

            @Override
            public void add(String value, List<String> list) {
                super.add(value, list);
                list.add(value + "..");
            }
        }, World("world=") {
            @Override
            public boolean check(String value, String begin) {
//             && !begin.contains("..")
                return value.lastIndexOf("]") == -1 && begin.contains(this.value) && value.lastIndexOf("=") <= value.length() - 1;
            }

            @Override
            public void add(String value, List<String> list) {
                super.add(value, list);
                if (value.contains("=")) {
                    String confirm = value.substring(value.lastIndexOf('=') + 1);
                    String begin = value.substring(0, value.lastIndexOf('=') + 1);
                    for (org.bukkit.World world : Bukkit.getWorlds())
                        if (world.getName().toLowerCase().startsWith(confirm.toLowerCase()))
                            list.add(begin + world.getName());
                }
            }
        }, X("x=") {}, Y("y="), Z("z="), dx("dx="), dy("dy="), dz("dz="), Score("score={") {
            @Override
            public boolean check(String value, String begin) {
                return super.check(value, begin) && !begin.contains("..");
            }

            @Override
            public void add(String value, List<String> list) {
                super.add(value, list);
                if (value.lastIndexOf('}') != value.length() - 1) {
                    list.add(value + "..");
                    list.add(value + "}");
                }
            }
        }, Level("level=") {
            @Override
            public boolean check(String value, String begin) {
                return super.check(value, begin) && !begin.contains("..");
            }

            @Override
            public void add(String value, List<String> list) {
                super.add(value, list);
                list.add(value + "..");
            }
        }, Gamemode("gamemode=") {
            @Override
            public boolean check(String value, String begin) {
                return value.lastIndexOf("]") == -1 && begin.contains(this.value) && value.lastIndexOf("=") <= value.length() - 1;
            }

            @Override
            public void add(String value, List<String> list) {
                super.add(value, list);
                if (value.contains("=")) {
                    String confirm = value.substring(value.lastIndexOf('=') + 1);
                    String begin = value.substring(0, value.lastIndexOf('=') + 1);
                    for (GameMode gamemode : GameMode.values())
                        if (gamemode.name().toLowerCase().startsWith(confirm.toLowerCase()))
                            list.add(begin + gamemode.name());
                }
            }
        }, Name("name="), Tag("tag="), Type("type=") {
            @Override
            public boolean check(String value, String begin) {
                return value.lastIndexOf("]") == -1 && begin.contains(this.value) && value.lastIndexOf("=") <= value.length() - 1;
            }

            @Override
            public void add(String value, List<String> list) {
                super.add(value, list);
                if (value.contains("=")) {
                    String confirm = value.substring(value.lastIndexOf('=') + 1);
                    String begin = value.substring(0, value.lastIndexOf('=') + 1);
                    for (EntityType entityType : EntityType.values())
                        if (entityType.name().toLowerCase().startsWith(confirm.toLowerCase()))
                            list.add(begin + entityType.name());
                }
            }
        }, Limit("limit=")
        //
        ;

        protected final String value;

        Parameters(String value) {
            this.value = value;
        }

        public boolean check(String value, String begin) {
            return value.lastIndexOf("]") == -1 && begin.contains(this.value) && value.lastIndexOf("=") < value.length() - 1;
        }

        public void add(String value, List<String> list) {
            list.add(value + "]");
        }
    }

    @Override
    public List<String> getString(CommandSender sender, String value, String[] args) {
        final List<String> list = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers())
            if (value.isBlank() || player.getName().toLowerCase().contains(value.toLowerCase()))
                list.add(player.getName());
        if (value.isBlank() || value.startsWith("@")) {
            if (value.startsWith("@p") || value.startsWith("@a") || value.startsWith("@e") || value.startsWith("@r")) {
                if (value.indexOf('[') == 2 || value.lastIndexOf(",") == value.length() - 1) {
                    boolean blank = value.length() == 3 || value.lastIndexOf(",") == value.length() - 1;
                    int loc = value.indexOf('[');
                    if (value.lastIndexOf(",") != -1) loc = value.lastIndexOf(",");
                    if (blank) for (Parameters parameter : Parameters.values())
                        list.add(value + parameter.getValue());
                    else {
                        String begin = value.substring(0, loc + 1);
                        String end = value.substring(loc + 1);
                        for (Parameters parameters : Parameters.values())
                            if (parameters.check(value, end)) {
                                if (end.contains(parameters.getValue())) parameters.add(value, list);
                            } else {
                                if (parameters.getValue().startsWith(end.toLowerCase()))
                                    list.add(begin + parameters.getValue());
                            }
                    }
                } else {
                    list.add("@p[");
                    list.add("@a[");
                    list.add("@e[");
                    list.add("@r[");
                }
            } else {
                list.add("@p");
                list.add("@a");
                list.add("@e");
                list.add("@r");
            }
        }
        return list;
    }
}
