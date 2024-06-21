package shining.starj.structure.Items.Recipes;

import lombok.Getter;
import org.bukkit.inventory.RecipeChoice;

@Getter
public record Shape(char c, RecipeChoice choice) {
}
