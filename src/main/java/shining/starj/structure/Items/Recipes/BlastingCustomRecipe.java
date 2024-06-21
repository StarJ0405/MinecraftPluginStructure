package shining.starj.structure.Items.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;
import shining.starj.structure.Core;

public class BlastingCustomRecipe extends CustomRecipe {
    protected final BlastingRecipe recipe;
    public BlastingCustomRecipe(String key, ItemStack result, CookingBookCategory category, RecipeChoice choice,
                               float exp, int cookingTime) {
        super(key, result);
        this.recipe = new BlastingRecipe(new NamespacedKey(Core.getCore(), this.key), this.result, choice, exp,
                cookingTime);
        recipe.setInputChoice(choice);
        recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }
    public static void initial(){

    }
}
