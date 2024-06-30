package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingTransformRecipe;

public class CustomSmithingTransformRecipe extends CustomRecipe {
    protected final SmithingTransformRecipe recipe;
    @Builder
    public CustomSmithingTransformRecipe(String key, ItemStack result, RecipeChoice template, RecipeChoice base, RecipeChoice addition) {
        super(key);
        this.recipe = new SmithingTransformRecipe(namespacedKey, result, template, base, addition);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
