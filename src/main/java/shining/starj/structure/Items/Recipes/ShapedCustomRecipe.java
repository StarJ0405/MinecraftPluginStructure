package shining.starj.structure.Items.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import shining.starj.structure.Core;

public class ShapedCustomRecipe extends CustomRecipe {
    protected final ShapedRecipe recipe;
//    protected final String[] shape;
//    protected final Shape[] shapes;

    public ShapedCustomRecipe(String key, ItemStack result, CraftingBookCategory category, String[] shape, Shape... shapes) {
        super(key);
        this.recipe = new ShapedRecipe(new NamespacedKey(Core.getCore(), this.key), result);
        recipe.shape(shape);
        for (Shape s : shapes)
            recipe.setIngredient(s.c(), s.choice());
        recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
