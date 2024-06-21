package shining.starj.structure.Items.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;

public class FurnaceCustomRecipe extends CustomRecipe {
    protected final FurnaceRecipe recipe;

    public FurnaceCustomRecipe(String key, ItemStack result, CookingBookCategory category, RecipeChoice choice, float exp, int cookingTime) {
        super(key);
        this.recipe = new FurnaceRecipe(this.namespacedKey, result, choice, exp, cookingTime);
        recipe.setInputChoice(choice);
        recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
