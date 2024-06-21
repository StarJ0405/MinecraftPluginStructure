package shining.starj.structure.Items.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingTransformRecipe;

public class SmithingCustomTransformRecipe extends CustomRecipe {
    protected SmithingTransformRecipe recipe;

    public SmithingCustomTransformRecipe(String key, ItemStack result, RecipeChoice template, RecipeChoice base, RecipeChoice addition) {
        super(key);
        recipe = new SmithingTransformRecipe(this.namespacedKey, result, template, base, addition);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
