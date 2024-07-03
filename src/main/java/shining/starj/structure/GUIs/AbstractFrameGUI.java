package shining.starj.structure.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public abstract class AbstractFrameGUI extends AbstractGUI {
    public AbstractFrameGUI(String key) {
        super(key, "", null);
    }

    @Override
    public AbstractFrameGUI setInfo(Player player, GUIInfo info) {
        return (AbstractFrameGUI) super.setInfo(player, info);
    }

    @Override
    public Inventory openInv(Player player) {
        GUIInfo guiInfo = getInfo(player);
        if (guiInfo instanceof VariableInfo info && info.getTitle() != null && info.getInventorySize() != null) {
            openGUI.put(player.getUniqueId(), this.key);
            Inventory inv = Bukkit.createInventory(player, info.getInventorySize().getSize(), info.getTitle());
            player.openInventory(inv);
            return inv;
        } else
            throw new RuntimeException("FrameGUI 는 VariableInfo 를 사용해야합니다.");
    }

}
