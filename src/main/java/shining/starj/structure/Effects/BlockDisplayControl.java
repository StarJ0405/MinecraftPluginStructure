package shining.starj.structure.Effects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Transformation;
import org.joml.Matrix4f;
import shining.starj.structure.Core;

@Getter
public class BlockDisplayControl {
    private final BlockDisplay display;

    private BlockDisplayControl(BlockDisplay display) {
        this.display = display;
    }

    public BlockDisplayControl setScale(float size) {
        return setScale(size, size, size, 0);
    }

    public BlockDisplayControl setScale(float size, double seconds) {
        return setScale(size, size, size, seconds);
    }

    public BlockDisplayControl setScale(float sizeX, float sizeY, float sizeZ) {
        return setScale(sizeX, sizeY, sizeZ, 0);
    }

    public BlockDisplayControl setScale(float sizeX, float sizeY, float sizeZ, double seconds) {
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

    public BlockDisplayControl setLiveTick(int second) {
        display.setMetadata("live", new FixedMetadataValue(Core.getCore(), second));
        return this;
    }

    public BlockDisplayControl setLife(double seconds) { // 현재 시간 비례
        display.setMetadata("life", new FixedMetadataValue(Core.getCore(), System.currentTimeMillis() + (long) (seconds * 1000)));
        return this;
    }

    public void remove() {
        this.display.remove();
    }

    public BlockDisplayControl setTransformationMatrix(Matrix4f matrix4f) {
        return setTransformationMatrix(matrix4f, 0);
    }

    public BlockDisplayControl setTransformationMatrix(Matrix4f matrix4f, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> display.setTransformationMatrix(matrix4f), (long) (Bukkit.getServerTickManager().getTickRate() * seconds));
        else
            display.setTransformationMatrix(matrix4f);
        return this;
    }

    public BlockDisplayControl setTransformation(Transformation transformation) {
        return setTransformation(transformation, 0);
    }

    public BlockDisplayControl setTransformation(Transformation transformation, double seconds) {
        if (seconds > 0)
            Bukkit.getScheduler().runTaskLater(Core.getCore(), () -> display.setTransformation(transformation), (long) (Bukkit.getServerTickManager().getTickRate() * seconds));
        else
            display.setTransformation(transformation);
        return this;
    }

    public BlockDisplayControl setViewRange(float range) {
        display.setViewRange(range);
        return this;
    }

    public BlockDisplayControl setTeleportDuration(int duration) {
        display.setTeleportDuration(duration);
        return this;
    }

    public BlockDisplayControl setShadowStrength(float strength) {
        display.setShadowStrength(strength);
        return this;
    }

    public BlockDisplayControl setShadowRadius(float radius) {
        display.setShadowRadius(radius);
        return this;
    }

    public BlockDisplayControl setInterpolationDuration(int tick) {
        display.setInterpolationDuration(tick);
        return this;
    }

    public BlockDisplayControl setInterpolationDelay(int tick) {
        display.setInterpolationDelay(tick);
        return this;
    }

    public BlockDisplayControl setGlowing(boolean glow) {
        display.setGlowing(glow);
        return this;
    }

    public BlockDisplayControl setGlowColorOverride(Color color) {
        display.setGlowColorOverride(color);
        return this;
    }

    public BlockDisplayControl setBrightness(Display.Brightness brightness) {
        display.setBrightness(brightness);
        return this;
    }

    public BlockDisplayControl setBillboard(Display.Billboard billboard) {
        display.setBillboard(billboard);
        return this;
    }

    public BlockDisplayControl setDisplayHeight(float height) {
        display.setDisplayHeight(height);
        return this;
    }

    public BlockDisplayControl setDisplayWidth(float width) {
        display.setDisplayWidth(width);
        return this;
    }

    public BlockDisplayControl setBlock(Material type) {
        return setBlock(type.createBlockData());
    }

    public BlockDisplayControl setBlock(BlockData data) {
        display.setBlock(data);
        return this;
    }

    public static BlockDisplayControl spawn(Location loc) {
        BlockDisplay display = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);
        return new BlockDisplayControl(display);
    }
}