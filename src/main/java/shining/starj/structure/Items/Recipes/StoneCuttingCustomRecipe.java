package shining.starj.structure.Items.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.StonecuttingRecipe;

public class StoneCuttingCustomRecipe extends CustomRecipe {
    protected final StonecuttingRecipe recipe;

    public StoneCuttingCustomRecipe(String key, ItemStack result, RecipeChoice input) {
        super(key);
        this.recipe = new StonecuttingRecipe(this.namespacedKey, result, input);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
