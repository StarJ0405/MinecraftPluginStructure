package shining.starj.structure.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingTrimRecipe;

public class SmithingTrimCustomRecipe extends  CustomRecipe{
    protected final SmithingTrimRecipe recipe;
    public SmithingTrimCustomRecipe(String key, RecipeChoice template, RecipeChoice base, RecipeChoice addition) {
        super(key);
        this.recipe= new SmithingTrimRecipe(this.namespacedKey, template,base,addition);
        Bukkit.addRecipe(recipe);
    }
    public static void initial(){

    }
}
