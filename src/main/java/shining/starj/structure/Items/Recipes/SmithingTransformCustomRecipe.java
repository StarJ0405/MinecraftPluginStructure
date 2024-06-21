package shining.starj.structure.Items.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingTransformRecipe;

public class SmithingTransformCustomRecipe extends CustomRecipe {
    protected final SmithingTransformRecipe recipe;

    public SmithingTransformCustomRecipe(String key, ItemStack result, RecipeChoice template, RecipeChoice base, RecipeChoice addition) {
        super(key);
        this.recipe = new SmithingTransformRecipe(namespacedKey, result, template, base, addition);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
