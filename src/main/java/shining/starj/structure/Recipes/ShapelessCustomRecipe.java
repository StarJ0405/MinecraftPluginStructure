package shining.starj.structure.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;

public class ShapelessCustomRecipe extends CustomRecipe {
    protected final ShapelessRecipe recipe;

    public ShapelessCustomRecipe(String key, ItemStack result, CraftingBookCategory category, RecipeChoice... choices) {
        super(key);
        this.recipe = new ShapelessRecipe(this.namespacedKey, result);
        for (RecipeChoice choice : choices)
            this.recipe.addIngredient(choice);
        this.recipe.setCategory(category != null ? category : CraftingBookCategory.MISC);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
