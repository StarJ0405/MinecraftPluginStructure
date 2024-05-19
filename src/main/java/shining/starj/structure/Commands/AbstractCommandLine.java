package shining.starj.structure.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class AbstractCommandLine {
    private final int min; // 명령 최소 인자수
    private final int max; // 명령 최대 인자수
    private final SenderType[] senderTypes; // 명령어 사용 가능 유형
    private final String permission; // 퍼미션

    public AbstractCommandLine(Integer length) {
        this(SenderType.values(), length, length, null);
    }

    public AbstractCommandLine(SenderType senderType, Integer length) {
        this(new SenderType[]{senderType}, length, length, null);
    }

    public AbstractCommandLine(SenderType[] senderTypes, Integer length) {
        this(senderTypes, length, length, null);
    }

    public AbstractCommandLine(Integer min, Integer max) {
        this(SenderType.values(), min, max, null);
    }

    public AbstractCommandLine(SenderType senderType, Integer min, Integer max) {
        this(new SenderType[]{senderType}, min, max, null);
    }

    public AbstractCommandLine(SenderType[] senderTypes, Integer min, Integer max) {
        this(senderTypes, min, max, null);
    }

    public AbstractCommandLine(Integer length, String permission) {
        this(SenderType.values(), length, length, permission);
    }

    public AbstractCommandLine(SenderType senderType, Integer length, String permission) {
        this(new SenderType[]{senderType}, length, length, permission);
    }

    public AbstractCommandLine(SenderType[] senderTypes, Integer length, String permission) {
        this(senderTypes, length, length, permission);
    }

    public AbstractCommandLine(Integer min, Integer max, String permission) {
        this(SenderType.values(), min, max, permission);
    }

    public AbstractCommandLine(SenderType senderType, Integer min, Integer max, String permission) {
        this(new SenderType[]{senderType}, min, max, permission);
    }

    public AbstractCommandLine(SenderType[] senderTypes, Integer min, Integer max, String permission) {
        this.senderTypes = senderTypes != null ? senderTypes : new SenderType[0];
        this.min = min != null ? min : 0;
        this.max = max != null ? max : 0;
        this.permission = permission;
    }


    public boolean check(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        return Arrays.stream(senderTypes).anyMatch(senderType -> senderType.iSame(sender)) // sender 일치 여부
                && (permission == null || permission.isBlank() || sender.hasPermission(permission)) && args.length >= min && args.length <= max // 커맨드 길이 여부 확인
                ;
    }

    public abstract boolean run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args);


}
