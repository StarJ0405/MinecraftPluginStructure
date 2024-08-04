package shining.starj.structure.Systems;

import lombok.Builder;
import org.bukkit.*;

public class WorldStore {
    private final String name;
    private WorldType type = WorldType.NORMAL;
    private boolean hardcore = false;
    private boolean autoSave = true;
    private Difficulty difficulty = Difficulty.NORMAL;
    private boolean pvp = true;
    private Location spawnlocation = null;
    private boolean announceAdvancements = true;
    private boolean blockExplosionDropDecay = true;
    private boolean commandBlockOutput = true;
    private int commandModificationBlockLimit = 32768;
    private boolean disableElytraMovementCheck = false;
    private boolean disableRaids = false;
    private boolean doDaylightCycle = true;
    private boolean doEntityDrops = true;
    private boolean doFireTick = true;
    private boolean doInsomnia = true;
    private boolean doImmediateRespawn = false;
    private boolean doLimitedCrafting = false;
    private boolean doMobLoot = true;
    private boolean doMobSpawning = true;
    private boolean doPatrolSpawning = true;
    private boolean doTileDrops = true;
    private boolean doTraderSpawning = true;
    private boolean doVinesSpread = true;
    private boolean doWeatherCycle = true;
    private boolean doWardenSpawning = true;
    private boolean drowningDamage = true;
    private boolean enderPearlsVanishOnDeath = true;
    private boolean fallDamage = true;
    private boolean fireDamage = true;
    private boolean forgiveDeadPlayers = true;
    private boolean freezeDamage = true;
    private boolean globalSoundEvents = true;
    private boolean keepInventory = false;
    private boolean lavaSourceConversion = false;
    private boolean logAdminCommands = false;
    private int maxCommandChainLength = 65536;
    private int maxEntityCramming = 24;
    private boolean mobExplosionDropDecay = true;
    private boolean mobGriefing = true;
    private boolean naturalRegeneration = true;
    private int playersSleepingPercentage = 100;
    private int randomTickSpeed = 3;
    private boolean reducedDebugInfo = false;
    private boolean sendCommandFeedback = true;
    private boolean showDeathMessages = true;
    private int snowAccumulationHeight = 1;
    private int spawnRadius = 10;
    private boolean spectatorsGenerateChunks = true;
    private boolean tntExplosionDropDecay = false;
    private boolean universalAnger = false;
    private boolean waterSourceConversion = false;

    @Builder
    public WorldStore(String name) {
        this.name = name;
    }

    public WorldStore type(WorldType type) {
        this.type = type;
        return this;
    }

    public WorldStore hardcore(boolean hardcore) {
        this.hardcore = hardcore;
        return this;
    }

    public WorldStore autoSave(boolean autoSave) {
        this.autoSave = autoSave;
        return this;
    }

    public WorldStore difficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public WorldStore pvp(boolean pvp) {
        this.pvp = pvp;
        return this;
    }

    public WorldStore spawnLocation(Location spawnlocation) {
        this.spawnlocation = spawnlocation;
        return this;
    }

    public WorldStore announceAdvancements(boolean announceAdvancements) {
        this.announceAdvancements = announceAdvancements;
        return this;
    }

    public WorldStore blockExplosionDropDecay(boolean blockExplosionDropDecay) {
        this.blockExplosionDropDecay = blockExplosionDropDecay;
        return this;
    }

    public WorldStore commandBlockOutput(boolean commandBlockOutput) {
        this.commandBlockOutput = commandBlockOutput;
        return this;
    }

    public WorldStore commandModificationBlockLimit(int commandModificationBlockLimit) {
        this.commandModificationBlockLimit = commandModificationBlockLimit;
        return this;
    }

    public WorldStore disableElytraMovementCheck(boolean disableElytraMovementCheck) {
        this.disableElytraMovementCheck = disableElytraMovementCheck;
        return this;
    }

    public WorldStore disableRaids(boolean disableRaids) {
        this.disableRaids = disableRaids;
        return this;
    }

    public WorldStore doDaylightCycle(boolean doDaylightCycle) {
        this.doDaylightCycle = doDaylightCycle;
        return this;
    }

    public WorldStore doEntityDrops(boolean doEntityDrops) {
        this.doEntityDrops = doEntityDrops;
        return this;
    }

    public WorldStore doFireTick(boolean doFireTick) {
        this.doFireTick = doFireTick;
        return this;
    }

    public WorldStore doInsomnia(boolean doInsomnia) {
        this.doInsomnia = doInsomnia;
        return this;
    }

    public WorldStore doImmediateRespawn(boolean doImmediateRespawn) {
        this.doImmediateRespawn = doImmediateRespawn;
        return this;
    }

    public WorldStore doLimitedCrafting(boolean doLimitedCrafting) {
        this.doLimitedCrafting = doLimitedCrafting;
        return this;
    }

    public WorldStore doMobLoot(boolean doMobLoot) {
        this.doMobLoot = doMobLoot;
        return this;
    }

    public WorldStore doMobSpawning(boolean doMobSpawning) {
        this.doMobSpawning = doMobSpawning;
        return this;
    }

    public WorldStore doPatrolSpawning(boolean doPatrolSpawning) {
        this.doPatrolSpawning = doPatrolSpawning;
        return this;
    }

    public WorldStore doTileDrops(boolean doTileDrops) {
        this.doTileDrops = doTileDrops;
        return this;
    }

    public WorldStore doTraderSpawning(boolean doTraderSpawning) {
        this.doTraderSpawning = doTraderSpawning;
        return this;
    }

    public WorldStore doVinesSpread(boolean doVinesSpread) {
        this.doVinesSpread = doVinesSpread;
        return this;
    }

    public WorldStore doWeatherCycle(boolean doWeatherCycle) {
        this.doWeatherCycle = doWeatherCycle;
        return this;
    }

    public WorldStore doWardenSpawning(boolean doWardenSpawning) {
        this.doWardenSpawning = doWardenSpawning;
        return this;
    }

    public WorldStore drowningDamage(boolean drowningDamage) {
        this.drowningDamage = drowningDamage;
        return this;
    }

    public WorldStore enderPearlsVanishOnDeath(boolean enderPearlsVanishOnDeath) {
        this.enderPearlsVanishOnDeath = enderPearlsVanishOnDeath;
        return this;
    }

    public WorldStore fallDamage(boolean fallDamage) {
        this.fallDamage = fallDamage;
        return this;
    }

    public WorldStore fireDamage(boolean fireDamage) {
        this.fireDamage = fireDamage;
        return this;
    }

    public WorldStore forgiveDeadPlayers(boolean forgiveDeadPlayers) {
        this.forgiveDeadPlayers = forgiveDeadPlayers;
        return this;
    }

    public WorldStore freezeDamage(boolean freezeDamage) {
        this.freezeDamage = freezeDamage;
        return this;
    }

    public WorldStore globalSoundEvents(boolean globalSoundEvents) {
        this.globalSoundEvents = globalSoundEvents;
        return this;
    }

    public WorldStore keepInventory(boolean keepInventory) {
        this.keepInventory = keepInventory;
        return this;
    }

    public WorldStore lavaSourceConversion(boolean lavaSourceConversion) {
        this.lavaSourceConversion = lavaSourceConversion;
        return this;
    }

    public WorldStore logAdminCommands(boolean logAdminCommands) {
        this.logAdminCommands = logAdminCommands;
        return this;
    }

    public WorldStore maxCommandChainLength(int maxCommandChainLength) {
        this.maxCommandChainLength = maxCommandChainLength;
        return this;
    }

    public WorldStore maxEntityCramming(int maxEntityCramming) {
        this.maxEntityCramming = maxEntityCramming;
        return this;
    }

    public WorldStore mobExplosionDropDecay(boolean mobExplosionDropDecay) {
        this.mobExplosionDropDecay = mobExplosionDropDecay;
        return this;
    }

    public WorldStore mobGriefing(boolean mobGriefing) {
        this.mobGriefing = mobGriefing;
        return this;
    }

    public WorldStore naturalRegeneration(boolean naturalRegeneration) {
        this.naturalRegeneration = naturalRegeneration;
        return this;
    }

    public WorldStore playersSleepingPercentage(int playersSleepingPercentage) {
        this.playersSleepingPercentage = playersSleepingPercentage;
        return this;
    }

    public WorldStore randomTickSpeed(int randomTickSpeed) {
        this.randomTickSpeed = randomTickSpeed;
        return this;
    }

    public WorldStore reducedDebugInfo(boolean reducedDebugInfo) {
        this.reducedDebugInfo = reducedDebugInfo;
        return this;
    }

    public WorldStore sendCommandFeedback(boolean sendCommandFeedback) {
        this.sendCommandFeedback = sendCommandFeedback;
        return this;
    }

    public WorldStore showDeathMessages(boolean showDeathMessages) {
        this.showDeathMessages = showDeathMessages;
        return this;
    }

    public WorldStore snowAccumulationHeight(int snowAccumulationHeight) {
        this.snowAccumulationHeight = snowAccumulationHeight;
        return this;
    }

    public WorldStore spawnRadius(int spawnRadius) {
        this.spawnRadius = spawnRadius;
        return this;
    }

    public WorldStore spectatorsGenerateChunks(boolean spectatorsGenerateChunks) {
        this.spectatorsGenerateChunks = spectatorsGenerateChunks;
        return this;
    }

    public WorldStore tntExplosionDropDecay(boolean tntExplosionDropDecay) {
        this.tntExplosionDropDecay = tntExplosionDropDecay;
        return this;
    }

    public WorldStore universalAnger(boolean universalAnger) {
        this.universalAnger = universalAnger;
        return this;
    }

    public WorldStore waterSourceConversion(boolean waterSourceConversion) {
        this.waterSourceConversion = waterSourceConversion;
        return this;
    }

    public World build() {
        if (name == null || name.isBlank()) return null;
        World world = Bukkit.getWorld(name);
        if (world == null) {
            WorldCreator creator = new WorldCreator(name);
            creator = creator.type(type);
            world = Bukkit.createWorld(creator);
        }
        world.setHardcore(hardcore);
        world.setAutoSave(autoSave);
        world.setDifficulty(difficulty);
        world.setPVP(pvp);
        if (spawnlocation != null) world.setSpawnLocation(spawnlocation);
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, announceAdvancements);
        world.setGameRule(GameRule.BLOCK_EXPLOSION_DROP_DECAY, blockExplosionDropDecay);
        world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, commandBlockOutput);
        world.setGameRule(GameRule.COMMAND_MODIFICATION_BLOCK_LIMIT, commandModificationBlockLimit);
        world.setGameRule(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, disableElytraMovementCheck);
        world.setGameRule(GameRule.DISABLE_RAIDS, disableRaids);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, doDaylightCycle);
        world.setGameRule(GameRule.DO_ENTITY_DROPS, doEntityDrops);
        world.setGameRule(GameRule.DO_FIRE_TICK, doFireTick);
        world.setGameRule(GameRule.DO_INSOMNIA, doInsomnia);
        world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, doImmediateRespawn);
        world.setGameRule(GameRule.DO_LIMITED_CRAFTING, doLimitedCrafting);
        world.setGameRule(GameRule.DO_MOB_LOOT, doMobLoot);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, doMobSpawning);
        world.setGameRule(GameRule.DO_PATROL_SPAWNING, doPatrolSpawning);
        world.setGameRule(GameRule.DO_TILE_DROPS, doTileDrops);
        world.setGameRule(GameRule.DO_TRADER_SPAWNING, doTraderSpawning);
        world.setGameRule(GameRule.DO_VINES_SPREAD, doVinesSpread);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, doWeatherCycle);
        world.setGameRule(GameRule.DO_WARDEN_SPAWNING, doWardenSpawning);
        world.setGameRule(GameRule.DROWNING_DAMAGE, drowningDamage);
        world.setGameRule(GameRule.ENDER_PEARLS_VANISH_ON_DEATH, enderPearlsVanishOnDeath);
        world.setGameRule(GameRule.FALL_DAMAGE, fallDamage);
        world.setGameRule(GameRule.FIRE_DAMAGE, fireDamage);
        world.setGameRule(GameRule.FORGIVE_DEAD_PLAYERS, forgiveDeadPlayers);
        world.setGameRule(GameRule.FREEZE_DAMAGE, freezeDamage);
        world.setGameRule(GameRule.GLOBAL_SOUND_EVENTS, globalSoundEvents);
        world.setGameRule(GameRule.KEEP_INVENTORY, keepInventory);
        world.setGameRule(GameRule.LAVA_SOURCE_CONVERSION, lavaSourceConversion);
        world.setGameRule(GameRule.LOG_ADMIN_COMMANDS, logAdminCommands);
        world.setGameRule(GameRule.MAX_COMMAND_CHAIN_LENGTH, maxCommandChainLength);
        world.setGameRule(GameRule.MAX_ENTITY_CRAMMING, maxEntityCramming);
        world.setGameRule(GameRule.MOB_EXPLOSION_DROP_DECAY, mobExplosionDropDecay);
        world.setGameRule(GameRule.MOB_GRIEFING, mobGriefing);
        world.setGameRule(GameRule.NATURAL_REGENERATION, naturalRegeneration);
        world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, playersSleepingPercentage);
        world.setGameRule(GameRule.RANDOM_TICK_SPEED, randomTickSpeed);
        world.setGameRule(GameRule.REDUCED_DEBUG_INFO, reducedDebugInfo);
        world.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, sendCommandFeedback);
        world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, showDeathMessages);
        world.setGameRule(GameRule.SNOW_ACCUMULATION_HEIGHT, snowAccumulationHeight);
        world.setGameRule(GameRule.SPAWN_RADIUS, spawnRadius);
        world.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, spectatorsGenerateChunks);
        world.setGameRule(GameRule.TNT_EXPLOSION_DROP_DECAY, tntExplosionDropDecay);
        world.setGameRule(GameRule.UNIVERSAL_ANGER, universalAnger);
        world.setGameRule(GameRule.WATER_SOURCE_CONVERSION, waterSourceConversion);
        return world;
    }
}
