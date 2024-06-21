package shining.starj.structure.Items.Recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import shining.starj.structure.Core;

public abstract class CustomRecipe {
    protected final String key;
    protected final NamespacedKey namespacedKey;

    public CustomRecipe(String key) {
        this.key = key;
        this.namespacedKey = new NamespacedKey(Core.getCore(), this.key);
    }

    protected RecipeChoice fromItemStack(ItemStack... items) {
        return new RecipeChoice.ExactChoice(items);
    }

    protected RecipeChoice fromMaterial(Material... types) {
        return new RecipeChoice.MaterialChoice(types);
    }

    public static void initial() {
        ShapelessCustomRecipe.initial();
        ShapedCustomRecipe.initial();
        FurnaceCustomRecipe.initial();
        SmithingCustomTransformRecipe.initial();
    }
}
