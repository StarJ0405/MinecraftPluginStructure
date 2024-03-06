package shining.starj.structure.Systems;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public enum GUIs {
    test("테스트"){
        @Override
        public void openInv(Player player) {

        }

        @Override
        public boolean clickInv(Player player, InventoryView view, ClickType clickType, int rawSlot, int slot, ItemStack cursor, ItemStack current) {
            return false;
        }

        @Override
        public void close(Player player, Inventory inv, ItemStack[] contents) {

        }
    }
    //
    ;

    protected final String title;
    protected final HashMap<UUID, String> infos;

    private GUIs(String title) {
        this.title = title;
        this.infos = new HashMap<UUID, String>();

    }

    public String getTitle() {
        return this.title;
    }

    public abstract void openInv(Player player);

    public abstract boolean clickInv(Player player, InventoryView view, ClickType clickType, int rawSlot, int slot,
                                     ItemStack cursor, ItemStack current);

    public abstract void close(Player player, Inventory inv, ItemStack[] contents);

    public void setInfo(Player player, String info) {
        infos.put(player.getUniqueId(), info);
    }

    public String getInfo(Player player) {
        return infos.containsKey(player.getUniqueId()) ? infos.get(player.getUniqueId()) : "";
    }

    public static GUIs getGUI(String title) {
        for (GUIs gui : values())
            if (gui.title.contentEquals(title))
                return gui;
        return null;
    }


}
