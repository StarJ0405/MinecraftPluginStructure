package shining.starj.structure.Items.Recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CraftingBookCategory;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomRecipe {
    private final static List<CustomRecipe> list = new ArrayList<CustomRecipe>();
    // 기타
    protected final String key;
    protected final ItemStack result;
    protected final CraftingBookCategory category;

    public CustomRecipe(String key, ItemStack result) {
        this(key, result, CraftingBookCategory.MISC);
    }

    public CustomRecipe(String key, ItemStack result, CraftingBookCategory category) {
        this.key = key;
        this.result = result;
        this.category = category;
        //
        list.add(this);
    }

    public abstract void regist();

    public static List<CustomRecipe> values() {
        return list;
    }

    public static RecipeChoice fromItemStack(ItemStack... items) {
        return new RecipeChoice.ExactChoice(items);
    }

    public static RecipeChoice fromMaterial(Material... types) {
        return new RecipeChoice.MaterialChoice(types);
    }
}
