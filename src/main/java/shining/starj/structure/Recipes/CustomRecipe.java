package shining.starj.structure.Recipes;

import org.bukkit.NamespacedKey;
import shining.starj.structure.Core;

public abstract class CustomRecipe {
    protected final String key;
    protected final NamespacedKey namespacedKey;

    public CustomRecipe(String key) {
        this.key = key;
        this.namespacedKey = new NamespacedKey(Core.getCore(), this.key);
    }

    public static void initial() {
        BlastingCustomRecipe.initial();
        CampfireCustomRecipe.initial();
        FurnaceCustomRecipe.initial();
        MerchantCustomRecipe.initial();
        ShapedCustomRecipe.initial();
        ShapelessCustomRecipe.initial();
        SmithingTransformCustomRecipe.initial();
        SmithingTrimCustomRecipe.initial();
        SmokingCustomRecipe.initial();
        StoneCuttingCustomRecipe.initial();
    }
}
