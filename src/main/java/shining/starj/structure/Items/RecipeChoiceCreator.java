package shining.starj.structure.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class RecipeChoiceCreator {
    public static RecipeChoice fromItemStack(ItemStack... items) {
        return new RecipeChoice.ExactChoice(items);
    }

    public static RecipeChoice fromMaterial(Material... types) {
        return new RecipeChoice.MaterialChoice(types);
    }
}
