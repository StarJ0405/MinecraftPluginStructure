package shining.starj.structure.Buffs;

import lombok.Getter;

@Getter
public enum BuffType {
    POSITIVE("버프"), NEGATIVE("디버프"), ETC("기타")
    //
    ;
    private final String name;

    BuffType(String name) {
        this.name = name;
    }
}
