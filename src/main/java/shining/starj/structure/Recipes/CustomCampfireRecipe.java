package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;
import shining.starj.structure.Core;

public class CustomCampfireRecipe extends CustomRecipe {
    protected final CampfireRecipe recipe;

    @Builder
    public CustomCampfireRecipe(String key, ItemStack result, CookingBookCategory category, RecipeChoice choice, float exp, int cookingTime) {
        super(key);
        this.recipe = new CampfireRecipe(new NamespacedKey(Core.getCore(), this.key), result, choice, exp, cookingTime);
        recipe.setInputChoice(choice);
        if (category != null) recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
