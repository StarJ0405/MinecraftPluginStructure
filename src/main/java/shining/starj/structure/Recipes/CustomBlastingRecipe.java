package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;
import shining.starj.structure.Core;

public class CustomBlastingRecipe extends CustomRecipe {
    protected final BlastingRecipe recipe;

    @Builder
    public CustomBlastingRecipe(String key, ItemStack result, CookingBookCategory category, RecipeChoice choice, float exp, int cookingTime) {
        super(key);
        this.recipe = new BlastingRecipe(new NamespacedKey(Core.getCore(), this.key), result, choice, exp, cookingTime);
        recipe.setInputChoice(choice);
        if (category != null) recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
