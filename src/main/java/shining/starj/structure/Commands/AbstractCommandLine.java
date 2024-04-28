package shining.starj.structure.Commands;

import lombok.Builder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class AbstractCommandLine {
    private final int min; // 명령 최소 인자수
    private final int max; // 명령 최대 인자수
    private final SenderType[] senderTypes; // 명령어 사용 가능 유형



    public AbstractCommandLine(SenderType senderType, SenderType[] senderTypes, Integer length, Integer min, Integer max) {
        this.senderTypes = senderTypes != null && senderTypes.length > 0 ? senderTypes : (senderType != null ? new SenderType[]{senderType} : new SenderType[0]);
        length = length != null ? length : 0;
        this.min = min != null ? min : length;
        this.max = max != null ? max : length;
    }

    public boolean check(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        return Arrays.stream(senderTypes).anyMatch(senderType -> senderType.iSame(sender)) // sender 일치 여부
                && args.length >= min && args.length <= max // 커맨드 길이 여부 확인
                ;
    }

    public abstract void run(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args);


}
