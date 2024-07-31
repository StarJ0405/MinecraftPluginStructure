package shining.starj.structure.Atrributes;

import lombok.Builder;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class AttributeModifiers extends Attributes {
    protected final UUID uuid;
    protected final String name;
    protected final Operation operation;
    protected final EquipmentSlot slot;

    @Builder
    public AttributeModifiers(Attribute attribute, double amount, UUID uuid, String name, Operation operation,
                              EquipmentSlot slot) {
        super(attribute, amount);
        this.uuid = uuid;
        this.name = name;
        this.operation = operation;
        this.slot = slot;
    }

    private AttributeModifier getAttributeModifier() {
        if (this.slot == null)
            return new AttributeModifier(this.uuid, this.name, this.amount, this.operation);
        else
            return new AttributeModifier(this.uuid, this.name, this.amount, this.operation, this.slot);
    }

    @Override
    public void apply(LivingEntity livingEntity) {
        livingEntity.getAttribute(this.attribute).removeModifier(getAttributeModifier());
        if (amount != 0)
            livingEntity.getAttribute(this.attribute).addModifier(getAttributeModifier());
    }

    public void apply(ItemStack item) {
        if (item != null) {
            ItemMeta meta = item.getItemMeta();
            if (amount == 0)
                meta.removeAttributeModifier(this.attribute, getAttributeModifier());
            else
                meta.addAttributeModifier(this.attribute, getAttributeModifier());
            item.setItemMeta(meta);
        }
    }
}
