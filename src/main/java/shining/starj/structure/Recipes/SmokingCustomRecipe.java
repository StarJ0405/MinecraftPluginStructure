package shining.starj.structure.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.inventory.recipe.CookingBookCategory;
import shining.starj.structure.Core;

public class SmokingCustomRecipe extends CustomRecipe {
    protected final SmokingRecipe recipe;

    public SmokingCustomRecipe(String key, ItemStack result, CookingBookCategory category, RecipeChoice choice,
                               float exp, int cookingTime) {
        super(key);
        this.recipe = new SmokingRecipe(new NamespacedKey(Core.getCore(), this.key), result, choice, exp,
                cookingTime);
        recipe.setInputChoice(choice);
        recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}