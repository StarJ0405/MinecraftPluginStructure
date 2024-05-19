package shining.starj.structure.Commands;

import java.util.List;

public abstract class AbstractTab {
    private final int slot; // 0부터 게산, 알아서 1 더해줌

    public AbstractTab(int slot) {
        this.slot = slot + 1;
    }

    public boolean isSlot(String[] args) {
        return isSlot(args.length);
    }

    public boolean isSlot(int slot) {
        return this.slot == slot;
    }

    public abstract List<String> getString(String value, String[] args);

}
