package shining.starj.structure.Items.Prework.Bags;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum BagColor {
    NONE(Material.SHULKER_BOX), WHITE(Material.WHITE_SHULKER_BOX), LIGHT_GRAY(Material.LIGHT_GRAY_SHULKER_BOX), GRAY(Material.GRAY_SHULKER_BOX), BLACK(Material.BLACK_SHULKER_BOX), BROWN((Material.BROWN_SHULKER_BOX)), RED(Material.RED_SHULKER_BOX), ORANGE(Material.ORANGE_SHULKER_BOX), YELLOW(Material.YELLOW_SHULKER_BOX), LIME(Material.LIME_SHULKER_BOX), GREEN(Material.GREEN_SHULKER_BOX), CYAN((Material.CYAN_SHULKER_BOX)), LIGHT_BLUE(Material.LIGHT_BLUE_SHULKER_BOX), BLUE(Material.BLUE_SHULKER_BOX), PURPLE(Material.PURPLE_SHULKER_BOX), MAGENTA(Material.MAGENTA_SHULKER_BOX), PINK(Material.PINK_SHULKER_BOX)
    //
    ;
    private final Material material;

    BagColor(Material material) {
        this.material = material;
    }
}
