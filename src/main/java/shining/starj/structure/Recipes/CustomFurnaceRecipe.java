package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;
import shining.starj.structure.Items.Items;
import shining.starj.structure.Items.RecipeChoiceCreator;

public class CustomFurnaceRecipe extends CustomRecipe {
    protected final FurnaceRecipe recipe;

    @Builder
    public CustomFurnaceRecipe(String key, ItemStack result, CookingBookCategory category, RecipeChoice choice, float exp, int cookingTime) {
        super(key);
        this.recipe = new FurnaceRecipe(this.namespacedKey, result, choice, exp, cookingTime);
        recipe.setInputChoice(choice);
        if (category != null) recipe.setCategory(category);
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {
        CustomFurnaceRecipe.builder().key("time").result(Items.timer.getItemStack()).choice(RecipeChoiceCreator.fromItemStack(Items.timer.getItemStack())).exp(0f).cookingTime(20).build();
    }
}
