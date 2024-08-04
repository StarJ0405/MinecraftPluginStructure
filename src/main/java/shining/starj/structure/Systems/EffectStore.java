package shining.starj.structure.Systems;

import lombok.Getter;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Transformation;
import org.joml.Matrix4f;
import shining.starj.structure.Core;

public class EffectStore {
    @Getter
    public static final EffectStore instance = new EffectStore();

    public enum Simple {
        ANGRY_VILLAGER(Particle.ANGRY_VILLAGER), ASH(Particle.ASH), BUBBLE(Particle.BUBBLE), BUBBLE_COLUMN_UP(Particle.BUBBLE_COLUMN_UP), BUBBLE_POP(Particle.BUBBLE_POP), CAMPFIRE_COSY_SMOKE(Particle.CAMPFIRE_COSY_SMOKE), CAMPFIRE_SIGNAL_SMOKE(Particle.CAMPFIRE_SIGNAL_SMOKE), CHERRY_LEAVES(Particle.CHERRY_LEAVES), CLOUD(Particle.CLOUD), COMPOSTER(Particle.COMPOSTER), CRIMSON_SPORE(Particle.CRIMSON_SPORE), CRIT(Particle.CRIT), CURRENT_DOWN(Particle.CURRENT_DOWN), DAMAGE_INDICATOR(Particle.DAMAGE_INDICATOR), DOLPHIN(Particle.DOLPHIN), DRAGON_BREATH(Particle.DRAGON_BREATH), DRIPPING_DRIPSTONE_LAVA(Particle.DRIPPING_DRIPSTONE_LAVA), DRIPPING_DRIPSTONE_WATER(Particle.DRIPPING_DRIPSTONE_WATER), DRIPPING_HONEY(Particle.DRIPPING_HONEY), DRIPPING_LAVA(Particle.DRIPPING_LAVA), DRIPPING_OBSIDIAN_TEAR(Particle.DRIPPING_OBSIDIAN_TEAR), DRIPPING_WATER(Particle.DRIPPING_WATER), DUST_PLUME(Particle.DUST_PLUME), EFFECT(Particle.EFFECT), EGG_CRACK(Particle.EGG_CRACK), ELDER_GUARDIAN(Particle.ELDER_GUARDIAN), ELECTRIC_SPARK(Particle.ELECTRIC_SPARK), ENCHANT(Particle.ENCHANT), ENCHANTED_HIT(Particle.ENCHANTED_HIT), END_ROD(Particle.END_ROD), EXPLOSION(Particle.EXPLOSION), EXPLOSION_EMITTER(Particle.EXPLOSION_EMITTER), FALLING_DRIPSTONE_LAVA(Particle.FALLING_DRIPSTONE_LAVA), FALLING_DRIPSTONE_WATER(Particle.FALLING_DRIPSTONE_WATER), FALLING_HONEY(Particle.FALLING_HONEY), FALLING_LAVA(Particle.FALLING_LAVA), FALLING_NECTAR(Particle.FALLING_NECTAR), FALLING_OBSIDIAN_TEAR(Particle.FALLING_OBSIDIAN_TEAR), FALLING_SPORE_BLOSSOM(Particle.FALLING_SPORE_BLOSSOM), FALLING_WATER(Particle.FALLING_WATER), FIREWORK(Particle.FIREWORK), FISHING(Particle.FISHING), FLAME(Particle.FLAME), FLASH(Particle.FLASH), GLOW(Particle.GLOW), GLOW_SQUID_INK(Particle.GLOW_SQUID_INK), GUST(Particle.GUST), GUST_EMITTER_LARGE(Particle.GUST_EMITTER_LARGE), GUST_EMITTER_SMALL(Particle.GUST_EMITTER_SMALL), HAPPY_VILLAGER(Particle.HAPPY_VILLAGER), HEART(Particle.HEART), INFESTED(Particle.INFESTED), INSTANT_EFFECT(Particle.INSTANT_EFFECT), ITEM_COBWEB(Particle.ITEM_COBWEB), ITEM_SLIME(Particle.ITEM_SLIME), ITEM_SNOWBALL(Particle.ITEM_SNOWBALL), LANDING_HONEY(Particle.LANDING_HONEY), LANDING_LAVA(Particle.LANDING_LAVA), LANDING_OBSIDIAN_TEAR(Particle.LANDING_OBSIDIAN_TEAR), LARGE_SMOKE(Particle.LARGE_SMOKE), LAVA(Particle.LAVA), MYCELIUM(Particle.MYCELIUM), NAUTILUS(Particle.NAUTILUS), NOTE(Particle.NOTE), OMINOUS_SPAWNING(Particle.OMINOUS_SPAWNING), POOF(Particle.POOF), PORTAL(Particle.PORTAL), RAID_OMEN(Particle.RAID_OMEN), RAIN(Particle.RAIN), REVERSE_PORTAL(Particle.REVERSE_PORTAL), SCRAPE(Particle.SCRAPE), SCULK_CHARGE_POP(Particle.SCULK_CHARGE_POP), SCULK_SOUL(Particle.SCULK_SOUL), SMALL_FLAME(Particle.SMALL_FLAME), SMALL_GUST(Particle.SMALL_GUST), SMOKE(Particle.SMOKE), SNEEZE(Particle.SNEEZE), SNOWFLAKE(Particle.SNOWFLAKE), SONIC_BOOM(Particle.SONIC_BOOM), SOUL(Particle.SOUL), SOUL_FIRE_FLAME(Particle.SOUL_FIRE_FLAME), SPIT(Particle.SPIT), SPLASH(Particle.SPLASH), SPORE_BLOSSOM_AIR(Particle.SPORE_BLOSSOM_AIR), SQUID_INK(Particle.SQUID_INK), SWEEP_ATTACK(Particle.SWEEP_ATTACK), TOTEM_OF_UNDYING(Particle.TOTEM_OF_UNDYING), TRIAL_OMEN(Particle.TRIAL_OMEN), TRIAL_SPAWNER_DETECTION(Particle.TRIAL_SPAWNER_DETECTION), TRIAL_SPAWNER_DETECTION_OMINOUS(Particle.TRIAL_SPAWNER_DETECTION_OMINOUS), UNDERWATER(Particle.UNDERWATER), VAULT_CONNECTION(Particle.VAULT_CONNECTION), WARPED_SPORE(Particle.WARPED_SPORE), WAX_OFF(Particle.WAX_OFF), WAX_ON(Particle.WAX_ON), WHITE_ASH(Particle.WHITE_ASH), WHITE_SMOKE(Particle.WHITE_SMOKE), WITCH(Particle.WITCH)
        //
        ;
        @Getter
        private final Particle particle;

        Simple(Particle particle) {
            this.particle = particle;
        }

        public EffectStore spawnParticle(Location location) {
            return spawnParticle(location, 1, 0, 0, 0, 0);
        }

        public EffectStore spawnParticle(Location location, int count) {
            return spawnParticle(location, count, 0, 0, 0, 0);
        }

        public EffectStore spawnParticle(Location location, int count, double d) {
            return spawnParticle(location, count, d, d, d, 0);
        }

        public EffectStore spawnParticle(Location location, int count, double dx, double dy, double dz) {
            return spawnParticle(location, count, dx, dy, dz, 0);
        }

        public EffectStore spawnParticle(Location location, int count, double dx, double dy, double dz, double extra) {
            location.getWorld().spawnParticle(particle, location, count, dx, dy, dz, extra);
            return instance;
        }

        public EffectStore spawnParticle(Player player, Location location) {
            return spawnParticle(player, location, 1, 0, 0, 0, 0);
        }

        public EffectStore spawnParticle(Player player, Location location, double d) {
            return spawnParticle(player, location, 1, d, d, d, 0);
        }

        public EffectStore spawnParticle(Player player, Location location, int count) {
            return spawnParticle(player, location, count, 0, 0, 0, 0);
        }

        public EffectStore spawnParticle(Player player, Location location, int count, double dx, double dy, double dz) {
            return spawnParticle(player, location, count, dx, dy, dz, 0);
        }

        public EffectStore spawnParticle(Player player, Location location, int count, double dx, double dy, double dz, double extra) {
            player.spawnParticle(particle, location, count, dx, dy, dz, extra);
            return instance;
        }
    }

    private EffectStore() {
    }

    public EffectStore spawnBlockParticle(Location location, Material type) {
        return spawnBlockParticle(location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnBlockParticle(Player player, Location location, Material type) {
        return spawnBlockParticle(player, location, type, 1, 0, 0, 0, 0);
    }


    public EffectStore spawnBlockParticle(Location location, Material type, int count) {
        return spawnBlockParticle(location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnBlockParticle(Player player, Location location, Material type, int count) {
        return spawnBlockParticle(player, location, type, count, 0, 0, 0, 0);
    }


    public EffectStore spawnBlockParticle(Location location, Material type, int count, double d) {
        return spawnBlockParticle(location, type, count, d, d, d, 0);
    }

    public EffectStore spawnBlockParticle(Player player, Location location, Material type, int count, double d) {
        return spawnBlockParticle(player, location, type, count, d, d, d, 0);
    }

    public EffectStore spawnBlockParticle(Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnBlockParticle(location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnBlockParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnBlockParticle(player, location, type, count, dx, dy, dz, 0);
    }


    public EffectStore spawnBlockParticle(Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.BLOCK, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnBlockParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.BLOCK, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnBlockMakerParticle(Location location, Material type) {
        return spawnBlockMakerParticle(location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnBlockMakerParticle(Player player, Location location, Material type) {
        return spawnBlockMakerParticle(player, location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnBlockMakerParticle(Location location, Material type, int count) {
        return spawnBlockMakerParticle(location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnBlockMakerParticle(Player player, Location location, Material type, int count) {
        return spawnBlockMakerParticle(player, location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnBlockMakerParticle(Location location, Material type, int count, double d) {
        return spawnBlockMakerParticle(location, type, count, d, d, d, 0);
    }

    public EffectStore spawnBlockMakerParticle(Player player, Location location, Material type, int count, double d) {
        return spawnBlockMakerParticle(player, location, type, count, d, d, d, 0);
    }


    public EffectStore spawnBlockMakerParticle(Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnBlockMakerParticle(location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnBlockMakerParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnBlockMakerParticle(player, location, type, count, dx, dy, dz, 0);
    }


    public EffectStore spawnBlockMakerParticle(Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.BLOCK_MARKER, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnBlockMakerParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.BLOCK_MARKER, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnDustParticle(Location location, int red, int green, int blue) {
        return spawnDustParticle(location, Color.fromRGB(red, green, blue), 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, int red, int green, int blue) {
        return spawnDustParticle(player, location, Color.fromRGB(red, green, blue), 1f, 1, 0, 0, 0, 0);
    }


    public EffectStore spawnDustParticle(Location location, Color color) {
        return spawnDustParticle(location, color, 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, Color color) {
        return spawnDustParticle(player, location, color, 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Location location, int red, int green, int blue, float size) {
        return spawnDustParticle(location, Color.fromRGB(red, green, blue), size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, int red, int green, int blue, float size) {
        return spawnDustParticle(player, location, Color.fromRGB(red, green, blue), size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Location location, Color color, float size) {
        return spawnDustParticle(location, color, size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, Color color, float size) {
        return spawnDustParticle(player, location, color, size, 1, 0, 0, 0, 0);
    }


    public EffectStore spawnDustParticle(Location location, int red, int green, int blue, float size, int count) {
        return spawnDustParticle(location, Color.fromRGB(red, green, blue), size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, int red, int green, int blue, float size, int count) {
        return spawnDustParticle(player, location, Color.fromRGB(red, green, blue), size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Location location, Color color, float size, int count) {
        return spawnDustParticle(location, color, size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, Color color, float size, int count) {
        return spawnDustParticle(player, location, color, size, count, 0, 0, 0, 0);
    }


    public EffectStore spawnDustParticle(Location location, int red, int green, int blue, float size, int count, double d) {
        return spawnDustParticle(location, Color.fromRGB(red, blue, green), size, count, d, d, d, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, int red, int green, int blue, float size, int count, double d) {
        return spawnDustParticle(player, location, Color.fromRGB(red, blue, green), size, count, d, d, d, 0);
    }

    public EffectStore spawnDustParticle(Location location, Color color, float size, int count, double d) {
        return spawnDustParticle(location, color, size, count, d, d, d, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, Color color, float size, int count, double d) {
        return spawnDustParticle(player, location, color, size, count, d, d, d, 0);
    }

    public EffectStore spawnDustParticle(Location location, int red, int green, int blue, float size, int count, double dx, double dy, double dz) {
        return spawnDustParticle(location, Color.fromRGB(red, blue, green), size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, int red, int green, int blue, float size, int count, double dx, double dy, double dz) {
        return spawnDustParticle(player, location, Color.fromRGB(red, blue, green), size, count, dx, dy, dz, 0);
    }


    public EffectStore spawnDustParticle(Location location, Color color, float size, int count, double dx, double dy, double dz) {
        return spawnDustParticle(location, color, size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustParticle(Player player, Location location, Color color, float size, int count, double dx, double dy, double dz) {
        return spawnDustParticle(player, location, color, size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustParticle(Location location, int red, int green, int blue, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustParticle(location, Color.fromRGB(red, blue, green), size, count, dx, dy, dz, extra);
    }

    public EffectStore spawnDustParticle(Player player, Location location, int red, int green, int blue, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustParticle(player, location, Color.fromRGB(red, blue, green), size, count, dx, dy, dz, extra);
    }


    public EffectStore spawnDustParticle(Location location, Color color, float size, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.DUST, location, count, dx, dy, dz, extra, new Particle.DustOptions(color, size));
        return this;
    }

    public EffectStore spawnDustParticle(Player player, Location location, Color color, float size, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.DUST, location, count, dx, dy, dz, extra, new Particle.DustOptions(color, size));
        return this;
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, int red2, int green2, int blue2) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, int red2, int green2, int blue2) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, int red2, int green2, int blue2) {
        return spawnDustColorTransitionParticle(location, color1, Color.fromRGB(red2, green2, blue2), 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, int red2, int green2, int blue2) {
        return spawnDustColorTransitionParticle(player, location, color1, Color.fromRGB(red2, green2, blue2), 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, Color color2) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), color2, 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, Color color2) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), color2, 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, Color color2) {
        return spawnDustColorTransitionParticle(location, color1, color2, 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, Color color2) {
        return spawnDustColorTransitionParticle(player, location, color1, color2, 1f, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, int red2, int green2, int blue2, float size) {
        return spawnDustColorTransitionParticle(location, color1, Color.fromRGB(red2, green2, blue2), size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, int red2, int green2, int blue2, float size) {
        return spawnDustColorTransitionParticle(player, location, color1, Color.fromRGB(red2, green2, blue2), size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, Color color2, float size) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), color2, size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, Color color2, float size) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), color2, size, 1, 0, 0, 0, 0);
    }


    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, Color color2, float size) {
        return spawnDustColorTransitionParticle(location, color1, color2, size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, Color color2, float size) {
        return spawnDustColorTransitionParticle(player, location, color1, color2, size, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, int red2, int green2, int blue2, float size, int count) {
        return spawnDustColorTransitionParticle(location, color1, Color.fromRGB(red2, green2, blue2), size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, int red2, int green2, int blue2, float size, int count) {
        return spawnDustColorTransitionParticle(player, location, color1, Color.fromRGB(red2, green2, blue2), size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, Color color2, float size, int count) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), color2, size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, Color color2, float size, int count) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), color2, size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, Color color2, float size, int count) {
        return spawnDustColorTransitionParticle(location, color1, color2, size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, Color color2, float size, int count) {
        return spawnDustColorTransitionParticle(player, location, color1, color2, size, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, d, d, d, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, d, d, d, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, int red2, int green2, int blue2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(location, color1, Color.fromRGB(red2, green2, blue2), size, count, d, d, d, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, int red2, int green2, int blue2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(player, location, color1, Color.fromRGB(red2, green2, blue2), size, count, d, d, d, 0);
    }


    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, Color color2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), color2, size, count, d, d, d, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, Color color2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), color2, size, count, d, d, d, 0);
    }


    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, Color color2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(location, color1, color2, size, count, d, d, d, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, Color color2, float size, int count, double d) {
        return spawnDustColorTransitionParticle(player, location, color1, color2, size, count, d, d, d, 0);
    }


    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(location, color1, Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(player, location, color1, Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, Color color2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), color2, size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, Color color2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), color2, size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, Color color2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(location, color1, color2, size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, Color color2, float size, int count, double dx, double dy, double dz) {
        return spawnDustColorTransitionParticle(player, location, color1, color2, size, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, extra);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, extra);
    }


    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustColorTransitionParticle(location, color1, Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, extra);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, int red2, int green2, int blue2, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustColorTransitionParticle(player, location, color1, Color.fromRGB(red2, green2, blue2), size, count, dx, dy, dz, extra);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, int red1, int green1, int blue1, Color color2, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustColorTransitionParticle(location, Color.fromRGB(red1, green1, blue1), color2, size, count, dx, dy, dz, extra);
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, int red1, int green1, int blue1, Color color2, float size, int count, double dx, double dy, double dz, double extra) {
        return spawnDustColorTransitionParticle(player, location, Color.fromRGB(red1, green1, blue1), color2, size, count, dx, dy, dz, extra);
    }

    public EffectStore spawnDustColorTransitionParticle(Location location, Color color1, Color color2, float size, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.DUST_COLOR_TRANSITION, location, count, dx, dy, dz, extra, new Particle.DustTransition(color1, color2, size));
        return this;
    }

    public EffectStore spawnDustColorTransitionParticle(Player player, Location location, Color color1, Color color2, float size, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, count, dx, dy, dz, extra, new Particle.DustTransition(color1, color2, size));
        return this;
    }

    public EffectStore spawnDustPillarParticle(Location location, Material type) {
        return spawnDustPillarParticle(location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnDustPillarParticle(Player player, Location location, Material type) {
        return spawnDustPillarParticle(player, location, type, 1, 0, 0, 0, 0);
    }


    public EffectStore spawnDustPillarParticle(Location location, Material type, int count) {
        return spawnDustPillarParticle(location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustPillarParticle(Player player, Location location, Material type, int count) {
        return spawnDustPillarParticle(player, location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnDustPillarParticle(Location location, Material type, int count, double d) {
        return spawnDustPillarParticle(location, type, count, d, d, d, 0);
    }

    public EffectStore spawnDustPillarParticle(Player player, Location location, Material type, int count, double d) {
        return spawnDustPillarParticle(player, location, type, count, d, d, d, 0);
    }

    public EffectStore spawnDustPillarParticle(Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnDustPillarParticle(location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnDustPillarParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnDustPillarParticle(player, location, type, count, dx, dy, dz, 0);
    }


    public EffectStore spawnDustPillarParticle(Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.DUST_PILLAR, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnDustPillarParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.DUST_PILLAR, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }


    public EffectStore spawnEntityEffectParticle(Location location, int red, int green, int blue) {
        return spawnEntityEffectParticle(location, Color.fromRGB(red, green, blue), 1, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, int red, int green, int blue) {
        return spawnEntityEffectParticle(player, location, Color.fromRGB(red, green, blue), 1, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Location location, Color color) {
        return spawnEntityEffectParticle(location, color, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, Color color) {
        return spawnEntityEffectParticle(player, location, color, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Location location, int red, int green, int blue, int count) {
        return spawnEntityEffectParticle(location, Color.fromRGB(red, green, blue), count, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, int red, int green, int blue, int count) {
        return spawnEntityEffectParticle(player, location, Color.fromRGB(red, green, blue), count, 0, 0, 0, 0);
    }


    public EffectStore spawnEntityEffectParticle(Location location, Color color, int count) {
        return spawnEntityEffectParticle(location, color, count, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, Color color, int count) {
        return spawnEntityEffectParticle(player, location, color, count, 0, 0, 0, 0);
    }

    public EffectStore spawnEntityEffectParticle(Location location, int red, int green, int blue, int count, double d) {
        return spawnEntityEffectParticle(location, Color.fromRGB(red, green, blue), count, d, d, d, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, int red, int green, int blue, int count, double d) {
        return spawnEntityEffectParticle(player, location, Color.fromRGB(red, green, blue), count, d, d, d, 0);
    }

    public EffectStore spawnEntityEffectParticle(Location location, Color color, int count, double d) {
        return spawnEntityEffectParticle(location, color, count, d, d, d, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, Color color, int count, double d) {
        return spawnEntityEffectParticle(player, location, color, count, d, d, d, 0);
    }


    public EffectStore spawnEntityEffectParticle(Location location, int red, int green, int blue, int count, double dx, double dy, double dz) {
        return spawnEntityEffectParticle(location, Color.fromRGB(red, green, blue), count, dx, dy, dz, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, int red, int green, int blue, int count, double dx, double dy, double dz) {
        return spawnEntityEffectParticle(player, location, Color.fromRGB(red, green, blue), count, dx, dy, dz, 0);
    }


    public EffectStore spawnEntityEffectParticle(Location location, Color color, int count, double dx, double dy, double dz) {
        return spawnEntityEffectParticle(location, color, count, dx, dy, dz, 0);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, Color color, int count, double dx, double dy, double dz) {
        return spawnEntityEffectParticle(player, location, color, count, dx, dy, dz, 0);
    }

    public EffectStore spawnEntityEffectParticle(Location location, int red, int green, int blue, int count, double dx, double dy, double dz, double extra) {
        return spawnEntityEffectParticle(location, Color.fromRGB(red, blue, green), count, dx, dy, dz, extra);
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, int red, int green, int blue, int count, double dx, double dy, double dz, double extra) {
        return spawnEntityEffectParticle(player, location, Color.fromRGB(red, blue, green), count, dx, dy, dz, extra);
    }

    public EffectStore spawnEntityEffectParticle(Location location, Color color, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.ENTITY_EFFECT, location, 1, 1, 1, 1, 0, color);
        return this;
    }

    public EffectStore spawnEntityEffectParticle(Player player, Location location, Color color, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.ENTITY_EFFECT, location, 1, 1, 1, 1, 0, color);
        return this;
    }

    public EffectStore spawnFallingDustParticle(Location location, Material type) {
        return spawnFallingDustParticle(location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnFallingDustParticle(Player player, Location location, Material type) {
        return spawnFallingDustParticle(player, location, type, 1, 0, 0, 0, 0);
    }


    public EffectStore spawnFallingDustParticle(Location location, Material type, int count) {
        return spawnFallingDustParticle(location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnFallingDustParticle(Player player, Location location, Material type, int count) {
        return spawnFallingDustParticle(player, location, type, count, 0, 0, 0, 0);
    }


    public EffectStore spawnFallingDustParticle(Location location, Material type, int count, double d) {
        return spawnFallingDustParticle(location, type, count, d, d, d, 0);
    }

    public EffectStore spawnFallingDustParticle(Player player, Location location, Material type, int count, double d) {
        return spawnFallingDustParticle(player, location, type, count, d, d, d, 0);
    }

    public EffectStore spawnFallingDustParticle(Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnFallingDustParticle(location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnFallingDustParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnFallingDustParticle(player, location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnFallingDustParticle(Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.FALLING_DUST, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnFallingDustParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.FALLING_DUST, location, count, dx, dy, dz, extra, type.createBlockData());
        return this;
    }

    public EffectStore spawnItemParticle(Location location, Material type) {
        return spawnItemParticle(location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, Material type) {
        return spawnItemParticle(player, location, type, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Location location, ItemStack item) {
        return spawnItemParticle(location, item, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, ItemStack item) {
        return spawnItemParticle(player, location, item, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Location location, Material type, int count) {
        return spawnItemParticle(location, type, count, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, Material type, int count) {
        return spawnItemParticle(player, location, type, count, 0, 0, 0, 0);
    }


    public EffectStore spawnItemParticle(Location location, ItemStack item, int count) {
        return spawnItemParticle(location, item, count, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, ItemStack item, int count) {
        return spawnItemParticle(player, location, item, count, 0, 0, 0, 0);
    }

    public EffectStore spawnItemParticle(Location location, Material type, int count, double d) {
        return spawnItemParticle(location, type, count, d, d, d, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, Material type, int count, double d) {
        return spawnItemParticle(player, location, type, count, d, d, d, 0);
    }


    public EffectStore spawnItemParticle(Location location, ItemStack item, int count, double d) {
        return spawnItemParticle(location, item, count, d, d, d, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, ItemStack item, int count, double d) {
        return spawnItemParticle(player, location, item, count, d, d, d, 0);
    }

    public EffectStore spawnItemParticle(Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnItemParticle(location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz) {
        return spawnItemParticle(player, location, type, count, dx, dy, dz, 0);
    }

    public EffectStore spawnItemParticle(Location location, ItemStack item, int count, double dx, double dy, double dz) {
        return spawnItemParticle(location, item, count, dx, dy, dz, 0);
    }

    public EffectStore spawnItemParticle(Player player, Location location, ItemStack item, int count, double dx, double dy, double dz) {
        return spawnItemParticle(player, location, item, count, dx, dy, dz, 0);
    }

    public EffectStore spawnItemParticle(Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        return spawnItemParticle(location, new ItemStack(type), count, dx, dy, dz, extra);
    }

    public EffectStore spawnItemParticle(Player player, Location location, Material type, int count, double dx, double dy, double dz, double extra) {
        return spawnItemParticle(player, location, new ItemStack(type), count, dx, dy, dz, extra);
    }


    public EffectStore spawnItemParticle(Location location, ItemStack item, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.ITEM, location, count, dx, dy, dz, extra, item);
        return this;
    }

    public EffectStore spawnItemParticle(Player player, Location location, ItemStack item, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.ITEM, location, count, dx, dy, dz, extra, item);
        return this;
    }

    public EffectStore spawnSculkChargeParticle(Location location, float data) {
        return spawnSculkChargeParticle(location, data, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnSculkChargeParticle(Player player, Location location, float data) {
        return spawnSculkChargeParticle(player, location, data, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnSculkChargeParticle(Location location, float data, int count) {
        return spawnSculkChargeParticle(location, data, count, 0, 0, 0, 0);
    }

    public EffectStore spawnSculkChargeParticle(Player player, Location location, float data, int count) {
        return spawnSculkChargeParticle(player, location, data, count, 0, 0, 0, 0);
    }


    public EffectStore spawnSculkChargeParticle(Location location, float data, int count, double d) {
        return spawnSculkChargeParticle(location, data, count, d, d, d, 0);
    }

    public EffectStore spawnSculkChargeParticle(Player player, Location location, float data, int count, double d) {
        return spawnSculkChargeParticle(player, location, data, count, d, d, d, 0);
    }


    public EffectStore spawnSculkChargeParticle(Location location, float data, int count, double dx, double dy, double dz) {
        return spawnSculkChargeParticle(location, data, count, dx, dy, dz, 0);
    }

    public EffectStore spawnSculkChargeParticle(Player player, Location location, float data, int count, double dx, double dy, double dz) {
        return spawnSculkChargeParticle(player, location, data, count, dx, dy, dz, 0);
    }

    public EffectStore spawnSculkChargeParticle(Location location, float data, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.SCULK_CHARGE, location, count, dx, dy, dz, extra, data);
        return this;
    }

    public EffectStore spawnSculkChargeParticle(Player player, Location location, float data, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.SCULK_CHARGE, location, count, dx, dy, dz, extra, data);
        return this;
    }

    public EffectStore spawnShriekParticle(Location location, int data) {
        return spawnShriekParticle(location, data, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnShriekParticle(Player player, Location location, int data) {
        return spawnShriekParticle(player, location, data, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnShriekParticle(Location location, int data, int count) {
        return spawnShriekParticle(location, data, count, 0, 0, 0, 0);
    }

    public EffectStore spawnShriekParticle(Player player, Location location, int data, int count) {
        return spawnShriekParticle(player, location, data, count, 0, 0, 0, 0);
    }

    public EffectStore spawnShriekParticle(Location location, int data, int count, double d) {
        return spawnShriekParticle(location, data, count, d, d, d, 0);
    }

    public EffectStore spawnShriekParticle(Player player, Location location, int data, int count, double d) {
        return spawnShriekParticle(player, location, data, count, d, d, d, 0);
    }


    public EffectStore spawnShriekParticle(Location location, int data, int count, double dx, double dy, double dz) {
        return spawnShriekParticle(location, data, count, dx, dy, dz, 0);
    }

    public EffectStore spawnShriekParticle(Player player, Location location, int data, int count, double dx, double dy, double dz) {
        return spawnShriekParticle(player, location, data, count, dx, dy, dz, 0);
    }


    public EffectStore spawnShriekParticle(Location location, int data, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.SHRIEK, location, count, dx, dy, dz, extra, data);
        return this;
    }

    public EffectStore spawnShriekParticle(Player player, Location location, int data, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.SHRIEK, location, count, dx, dy, dz, extra, data);
        return this;
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Entity end, int arrivalTime) {
        return spawnVibrationParticle(location, start, end, arrivalTime, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Entity end, int arrivalTime) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Block end, int arrivalTime) {
        return spawnVibrationParticle(location, start, end, arrivalTime, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Block end, int arrivalTime) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Location end, int arrivalTime) {
        return spawnVibrationParticle(location, start, end, arrivalTime, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Location end, int arrivalTime) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, 1, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Entity end, int arrivalTime, int count) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Entity end, int arrivalTime, int count) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, 0, 0, 0, 0);
    }


    public EffectStore spawnVibrationParticle(Location location, Location start, Block end, int arrivalTime, int count) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Block end, int arrivalTime, int count) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, 0, 0, 0, 0);
    }


    public EffectStore spawnVibrationParticle(Location location, Location start, Location end, int arrivalTime, int count) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Location end, int arrivalTime, int count) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, 0, 0, 0, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Entity end, int arrivalTime, int count, double d) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, d, d, d, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Entity end, int arrivalTime, int count, double d) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, d, d, d, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Block end, int arrivalTime, int count, double d) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, d, d, d, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Block end, int arrivalTime, int count, double d) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, d, d, d, 0);
    }


    public EffectStore spawnVibrationParticle(Location location, Location start, Location end, int arrivalTime, int count, double d) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, d, d, d, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Location end, int arrivalTime, int count, double d) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, d, d, d, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Entity end, int arrivalTime, int count, double dx, double dy, double dz) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, dx, dy, dz, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Entity end, int arrivalTime, int count, double dx, double dy, double dz) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, dx, dy, dz, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Block end, int arrivalTime, int count, double dx, double dy, double dz) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, dx, dy, dz, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Block end, int arrivalTime, int count, double dx, double dy, double dz) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, dx, dy, dz, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Location end, int arrivalTime, int count, double dx, double dy, double dz) {
        return spawnVibrationParticle(location, start, end, arrivalTime, count, dx, dy, dz, 0);
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Location end, int arrivalTime, int count, double dx, double dy, double dz) {
        return spawnVibrationParticle(player, location, start, end, arrivalTime, count, dx, dy, dz, 0);
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Entity end, int arrivalTime, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.VIBRATION, location, count, dx, dy, dz, extra, new Vibration(start, new Vibration.Destination.EntityDestination(end), arrivalTime));
        return this;
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Entity end, int arrivalTime, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.VIBRATION, location, count, dx, dy, dz, extra, new Vibration(start, new Vibration.Destination.EntityDestination(end), arrivalTime));
        return this;
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Block end, int arrivalTime, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.VIBRATION, location, count, dx, dy, dz, extra, new Vibration(start, new Vibration.Destination.BlockDestination(end), arrivalTime));
        return this;
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Block end, int arrivalTime, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.VIBRATION, location, count, dx, dy, dz, extra, new Vibration(start, new Vibration.Destination.BlockDestination(end), arrivalTime));
        return this;
    }

    public EffectStore spawnVibrationParticle(Location location, Location start, Location end, int arrivalTime, int count, double dx, double dy, double dz, double extra) {
        location.getWorld().spawnParticle(Particle.VIBRATION, location, count, dx, dy, dz, extra, new Vibration(start, new Vibration.Destination.BlockDestination(end), arrivalTime));
        return this;
    }

    public EffectStore spawnVibrationParticle(Player player, Location location, Location start, Location end, int arrivalTime, int count, double dx, double dy, double dz, double extra) {
        player.spawnParticle(Particle.VIBRATION, location, count, dx, dy, dz, extra, new Vibration(start, new Vibration.Destination.BlockDestination(end), arrivalTime));
        return this;
    }

    public EffectStore spawnLightning(Location location) {
        location.getWorld().strikeLightning(location);
        return this;
    }

    public EffectStore spawnLightningEffect(Location location) {
        location.getWorld().strikeLightningEffect(location);
        return this;
    }

    @Getter
    public static class BlockDisplayControl {
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

    @Getter
    public static class ItemDisplayControl {
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
}
