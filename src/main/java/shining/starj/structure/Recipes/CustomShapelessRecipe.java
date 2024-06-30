package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;

public class CustomShapelessRecipe extends CustomRecipe {
    protected final ShapelessRecipe recipe;

    @Builder
    public CustomShapelessRecipe(String key, ItemStack result, CraftingBookCategory category, RecipeChoice... choices) {
        super(key);
        this.recipe = new ShapelessRecipe(this.namespacedKey, result);
        for (RecipeChoice choice : choices)
            this.recipe.addIngredient(choice);
        if (category != null) this.recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
