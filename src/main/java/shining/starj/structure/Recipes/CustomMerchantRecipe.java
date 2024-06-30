package shining.starj.structure.Recipes;

import lombok.Builder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.Arrays;

public class CustomMerchantRecipe extends CustomRecipe {
    protected final MerchantRecipe recipe;

    // use 사용된 횟수
    // maxUse 최대 거래횟수
    // experienceReward 경험치 보상
    // priceMultiplier 비용 계산 배수
    // demand 수요
    // specialPrice 특별 가격
    // items 재료
    @Builder
    public CustomMerchantRecipe(String key, ItemStack result, int uses, int maxUses, boolean experienceReward, int villagerExperience, float priceMultiplier, int demand, int specialPrice, ItemStack[] items) {
        super(key);
        this.recipe = new MerchantRecipe(result, uses, maxUses, experienceReward, villagerExperience, priceMultiplier, demand, specialPrice);
        this.recipe.setIngredients(Arrays.stream(items).toList());
        Bukkit.addRecipe(recipe);
    }

    public static void initial() {

    }
}
