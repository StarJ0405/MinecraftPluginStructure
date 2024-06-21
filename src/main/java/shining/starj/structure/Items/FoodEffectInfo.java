package shining.starj.structure.Items;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@Getter
public class FoodEffectInfo {
    private final PotionEffect potionEffect;
    private final float probability;

    @Builder
    public FoodEffectInfo(PotionEffectType potionEffectType, int tick, int amplifier, boolean ambient, boolean particles, boolean icon, float probability) {
        this.potionEffect = new PotionEffect(potionEffectType, tick, amplifier, ambient, particles, icon);
        this.probability = probability;
    }
}
