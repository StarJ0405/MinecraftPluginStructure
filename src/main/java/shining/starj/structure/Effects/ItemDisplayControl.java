package shining.starj.structure.Effects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Transformation;
import org.joml.Matrix4f;
import shining.starj.structure.Core;

@Getter
public class ItemDisplayControl {
    private final ItemDisplay display;

    private ItemDisplayControl(ItemDisplay display) {
        this.display = display;
    }

    public ItemDisplayControl setRightRotation(float x, float y, float z, float w) {
        return setRightRotation(x, y, z, w, 0);
    }

    public ItemDisplayControl setRightRotation(float x, float y, float z, float w, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
                Transformation transformation = display.getTransformation();
                transformation.getRightRotation().set(x, y, z, w);
                display.setTransformation(transformation);
            }, (long) (seconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            Transformation transformation = display.getTransformation();
            transformation.getRightRotation().set(x, y, z, w);
            display.setTransformation(transformation);
        }
        return this;
    }

    public ItemDisplayControl setLeftRotation(float x, float y, float z, float w) {
        return setLeftRotation(x, y, z, w, 0);
    }

    public ItemDisplayControl setLeftRotation(float x, float y, float z, float w, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
                Transformation transformation = display.getTransformation();
                transformation.getLeftRotation().set(x, y, z, w);
                display.setTransformation(transformation);
            }, (long) (seconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            Transformation transformation = display.getTransformation();
            transformation.getLeftRotation().set(x, y, z, w);
            display.setTransformation(transformation);
        }
        return this;
    }

    public ItemDisplayControl setTranslation(float x, float y, float z) {
        return setTranslation(x, y, z, 0);
    }

    public ItemDisplayControl setTranslation(float x, float y, float z, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
                Transformation transformation = display.getTransformation();
                transformation.getTranslation().set(x, y, z);
                display.setTransformation(transformation);
            }, (long) (seconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            Transformation transformation = display.getTransformation();
            transformation.getTranslation().set(x, y, z);
            display.setTransformation(transformation);
        }
        return this;
    }

    public ItemDisplayControl setScale(float size) {
        return setScale(size, size, size, 0);
    }

    public ItemDisplayControl setScale(float size, double seconds) {
        return setScale(size, size, size, seconds);
    }

    public ItemDisplayControl setScale(float sizeX, float sizeY, float sizeZ) {
        return setScale(sizeX, sizeY, sizeZ, 0);
    }

    public ItemDisplayControl setScale(float sizeX, float sizeY, float sizeZ, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> {
                Transformation transformation = display.getTransformation();
                transformation.getScale().set(sizeX, sizeY, sizeZ);
                display.setTransformation(transformation);
            }, (long) (seconds * Bukkit.getServerTickManager().getTickRate()));
        else {
            Transformation transformation = display.getTransformation();
            transformation.getScale().set(sizeX, sizeY, sizeZ);
            display.setTransformation(transformation);
        }
        return this;
    }

    public ItemDisplayControl setLiveTick(int second) {
        display.setMetadata("live", new FixedMetadataValue(Core.getCore(), second));
        return this;
    }

    public ItemDisplayControl setLife(double seconds) { // 현재 시간 비례
        display.setMetadata("life", new FixedMetadataValue(Core.getCore(), System.currentTimeMillis() + (long) (seconds * 1000)));
        return this;
    }

    public void remove() {
        this.display.remove();
    }

    public ItemDisplayControl setItemDisplayTransform(ItemDisplay.ItemDisplayTransform itemDisplayTransform) {
        return setItemDisplayTransform(itemDisplayTransform, 0);
    }

    public ItemDisplayControl setItemDisplayTransform(ItemDisplay.ItemDisplayTransform itemDisplayTransform, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> display.setItemDisplayTransform(itemDisplayTransform), (long) (Bukkit.getServerTickManager().getTickRate() * seconds));
        else
            display.setItemDisplayTransform(itemDisplayTransform);
        return this;
    }

    public ItemDisplayControl setTransformationMatrix(Matrix4f matrix4f) {
        return setTransformationMatrix(matrix4f, 0);
    }

    public ItemDisplayControl setTransformationMatrix(Matrix4f matrix4f, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> display.setTransformationMatrix(matrix4f), (long) (Bukkit.getServerTickManager().getTickRate() * seconds));
        else
            display.setTransformationMatrix(matrix4f);
        return this;
    }

    public ItemDisplayControl setTransformation(Transformation transformation) {
        return setTransformation(transformation, 0);
    }

    public ItemDisplayControl setTransformation(Transformation transformation, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> display.setTransformation(transformation), (long) (Bukkit.getServerTickManager().getTickRate() * seconds));
        else
            display.setTransformation(transformation);
        return this;
    }

    public ItemDisplayControl setViewRange(float range) {
        display.setViewRange(range);
        return this;
    }

    public ItemDisplayControl setTeleportDuration(int duration) {
        display.setTeleportDuration(duration);
        return this;
    }

    public ItemDisplayControl setShadowStrength(float strength) {
        display.setShadowStrength(strength);
        return this;
    }

    public ItemDisplayControl setShadowRadius(float radius) {
        display.setShadowRadius(radius);
        return this;
    }

    public ItemDisplayControl setInterpolationDuration(int tick) {
        display.setInterpolationDuration(tick);
        return this;
    }

    public ItemDisplayControl setInterpolationDelay(int tick) {
        display.setInterpolationDelay(tick);
        return this;
    }

    public ItemDisplayControl setGlowing(boolean glow) {
        display.setGlowing(glow);
        return this;
    }

    public ItemDisplayControl setGlowColorOverride(Color color) {
        display.setGlowColorOverride(color);
        return this;
    }

    public ItemDisplayControl setBrightness(Display.Brightness brightness) {
        display.setBrightness(brightness);
        return this;
    }

    public ItemDisplayControl setBillboard(Display.Billboard billboard) {
        display.setBillboard(billboard);
        return this;
    }

    public ItemDisplayControl setDisplayHeight(float height) {
        display.setDisplayHeight(height);
        return this;
    }

    public ItemDisplayControl setDisplayWidth(float width) {
        display.setDisplayWidth(width);
        return this;
    }

    public ItemDisplayControl setItem(Material type) {
        return setItem(new ItemStack(type));
    }

    public ItemDisplayControl setItem(ItemStack data) {
        display.setItemStack(data);
        return this;
    }

    public static ItemDisplayControl spawn(Location loc) {
        ItemDisplay display = (ItemDisplay) loc.getWorld().spawnEntity(loc, EntityType.ITEM_DISPLAY);
        return new ItemDisplayControl(display);
    }
}
