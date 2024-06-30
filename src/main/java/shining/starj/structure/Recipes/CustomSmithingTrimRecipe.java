package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingTrimRecipe;

public class CustomSmithingTrimRecipe extends CustomRecipe {
    protected final SmithingTrimRecipe recipe;

    @Builder
    public CustomSmithingTrimRecipe(String key, RecipeChoice template, RecipeChoice base, RecipeChoice addition) {
        super(key);
        this.recipe = new SmithingTrimRecipe(this.namespacedKey, template, base, addition);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
