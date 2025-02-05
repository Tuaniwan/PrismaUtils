package me.kermx.prismaUtils.Utils;

import me.kermx.prismaUtils.PrismaUtils;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigUtils {

    private static ConfigUtils instance;

    private final PrismaUtils plugin;
    private final FileConfiguration config;

    private ConfigUtils(PrismaUtils plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public static void initialize(PrismaUtils plugin) {
        if (instance == null) {
            instance = new ConfigUtils(plugin);
        }
    }

    public static ConfigUtils getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ConfigUtils is not initialized!");
        }
        return instance;
    }

    // First Join Spawn
    public boolean firstJoinSpawnEnabled;
    public String firstJoinSpawnWorld;
    public double firstJoinSpawnX;
    public double firstJoinSpawnY;
    public double firstJoinSpawnZ;
    public float firstJoinSpawnYaw;
    public float firstJoinSpawnPitch;

    // First Join Commands
    public boolean firstJoinCommandsEnabled;
    public List<String> firstJoinCommands;

    // Health Scale
    public boolean healthScaleEnabled;
    public double healthScaleValue;

    // Remove Crafting Recipes
    public List<String> disabledCraftingRecipes;

    // Spawner Tweaks
    public boolean disableSpawnerMobItemDrops;

    // Mob Tweaks
    public boolean endermitesImmuneToLightning;

    // Cooldowns
    public long cooldownDeathMessageSeconds;

    // General Messages
    public String noPermissionMessage;
    public String mustSpecifyPlayerMessage;
    public String playerNotFoundMessage;
    public String incorrectUsageMessage;

    // Seen Messages
    public String seenOfflineMessage;
    public String seenNeverJoinedMessage;
    public String seenOnlineMessage;

    // Spawner Messages
    public String spawnerNoSilkWarningMessage;
    public String spawnerName;

    // Feed Messages
    public String feedMessage;
    public String feedAllMessage;
    public String feedOtherMessage;
    public String feedFedByOtherMessage;

    // Fly Speed Messages
    public String flyspeedResetMessage;
    public String flyspeedSetMessage;
    public String flyspeedInvalidSpeedMessage;

    // Heal Messages
    public String healMessage;
    public String healAllMessage;
    public String healOtherMessage;
    public String healHealedByOtherMessage;

    // Item Name Messages
    public String itemNameMessage;
    public String itemNameInvalidItemMessage;

    // Near Messages
    public String nearNoPlayersMessage;
    public String nearNearPlayersMessage;
    public String nearNearbyPlayersMessage;
    public String nearInvalidRadiusMessage;

    // ping Messages
    public String pingMessage;
    public String pingOtherMessage;

    // pTime Messages
    public String pTimeResetMessage;
    public String pTimeSetMessage;
    public String pTimeInvalidTimeMessage;

    // pWeather Messages
    public String pWeatherResetMessage;
    public String pWeatherSetMessage;
    public String pWeatherInvalidWeatherMessage;

    // Repair Messages
    public String repairNoItemInHandMessage;
    public String repairInvalidItemMessage;
    public String repairRepairedMessage;
    public String repairAllRepairedMessage;

    // Top Bottom Messages
    public String topMessage;
    public String bottomMessage;
    public String bottomMessageInvalidBlock;

    // God Messages
    public String godEnabledMessage;
    public String godDisabledMessage;

    // AFK Title Messages
    public String afkPlaceholder;
    public List<String> afkTitles;
    public List<String> afkSubtitles;

    // Death Messages - Players and Entities
    public List<String> deathMessageKilledByPlayer;
    public List<String> deathMessageShotByPlayer;
    public List<String> deathMessageShotByEntity;
    public List<String> deathMessageShot;
    public List<String> deathMessageKilledByEntity;

    public List<String> deathMessageSuffix;

    // Death Messages - Damage Causes
    public List<String> deathMessageBlockExplosion; //new
    public List<String> deathMessageCampfire; //new
    public List<String> deathMessageContact;
    public List<String> deathMessageCramming; //new
    public List<String> deathMessageCustom; //new
    public List<String> deathMessageDragonBreath; //new
    public List<String> deathMessageDrowning;
    public List<String> deathMessageEntityExplosion;
    public List<String> deathMessageFall;
    public List<String> deathMessageFallingBlock; //new
    public List<String> deathMessageFire;
    public List<String> deathMessageFireTick;
    public List<String> deathMessageFlyIntoWall; //new
    public List<String> deathMessageFreeze; //new
    public List<String> deathMessageHotFloor; //new
    public List<String> deathMessageKill; //new
    public List<String> deathMessageLava;
    public List<String> deathMessageLightning;
    public List<String> deathMessageMagic;
    public List<String> deathMessagePoison; //new
    public List<String> deathMessageSonicBoom; //new
    public List<String> deathMessageStarvation;
    public List<String> deathMessageSuffocation;
    public List<String> deathMessageSuicide;
    public List<String> deathMessageThorns;
    public List<String> deathMessageVoid;
    public List<String> deathMessageWither;
    public List<String> deathMessageWorldBorder; //new
    public List<String> deathMessageDefault;

    public void loadConfig(){

        // First Join Spawn
        firstJoinSpawnEnabled = config.getBoolean("first_join_spawn.enabled");
        firstJoinSpawnWorld = config.getString("first_join_spawn.world");
        firstJoinSpawnX = config.getDouble("first_join_spawn.x");
        firstJoinSpawnY = config.getDouble("first_join_spawn.y");
        firstJoinSpawnZ = config.getDouble("first_join_spawn.z");
        firstJoinSpawnYaw = (float) config.getDouble("first_join_spawn.yaw");
        firstJoinSpawnPitch = (float) config.getDouble("first_join_spawn.pitch");

        // First Join Commands
        firstJoinCommandsEnabled = config.getBoolean("first_join_commands.enabled");
        firstJoinCommands = config.getStringList("first_join_commands.commands");

        // Health Scale
        healthScaleEnabled = config.getBoolean("health_scale.enabled");
        healthScaleValue = config.getDouble("health_scale.value");

        // Remove Crafting Recipes
        disabledCraftingRecipes = config.getStringList("disabled_recipes");

        // Spawner Tweaks
        disableSpawnerMobItemDrops = config.getBoolean("spawner_tweaks.disable_spawner_mob_item_drops");

        // Mob Tweaks
        endermitesImmuneToLightning = config.getBoolean("mob_tweaks.endermites_immune_to_lightning");

        //Cooldowns
        cooldownDeathMessageSeconds = config.getLong("cooldowns.death_message_cooldown_seconds");

        // General Messages
        noPermissionMessage = config.getString("general_messages.no_permission");
        mustSpecifyPlayerMessage = config.getString("general_messages.must_specify_player");
        playerNotFoundMessage = config.getString("general_messages.player_not_found");
        incorrectUsageMessage = config.getString("general_messages.incorrect_usage");

        // Seen Messages
        seenOfflineMessage = config.getString("seen_messages.seen_offline_message");
        seenNeverJoinedMessage = config.getString("seen_messages.seen_never_joined_message");
        seenOnlineMessage = config.getString("seen_messages.seen_online_message");

        // Spawner Messages
        spawnerNoSilkWarningMessage = config.getString("spawner_messages.no_silk_warning_message");
        spawnerName = config.getString("spawner_messages.spawner_name");

        // Feed Messages
        feedMessage = config.getString("feed_messages.feed_message");
        feedAllMessage = config.getString("feed_messages.feed_all_message");
        feedOtherMessage = config.getString("feed_messages.feed_other_message");
        feedFedByOtherMessage = config.getString("feed_messages.feed_fed_by_other_message");

        // Fly Speed Messages
        flyspeedResetMessage = config.getString("flyspeed_messages.flyspeed_reset_message");
        flyspeedSetMessage = config.getString("flyspeed_messages.flyspeed_set_message");
        flyspeedInvalidSpeedMessage = config.getString("flyspeed_messages.flyspeed_invalid_speed_message");

        // Heal Messages
        healMessage = config.getString("heal_messages.heal_message");
        healAllMessage = config.getString("heal_messages.heal_all_message");
        healOtherMessage = config.getString("heal_messages.heal_other_message");
        healHealedByOtherMessage = config.getString("heal_messages.heal_healed_by_other_message");

        // Item Name Messages
        itemNameMessage = config.getString("itemname_messages.itemname_message");
        itemNameInvalidItemMessage = config.getString("itemname_messages.itemname_no_item_message");

        // Near Messages
        nearNoPlayersMessage = config.getString("near_messages.near_no_players_message");
        nearNearPlayersMessage = config.getString("near_messages.near_near_players_message");
        nearNearbyPlayersMessage = config.getString("near_messages.near_nearby_players_message");
        nearInvalidRadiusMessage = config.getString("near_messages.near_invalid_radius_message");

        // ping Messages
        pingMessage = config.getString("ping_messages.ping_message");
        pingOtherMessage = config.getString("ping_messages.ping_other_message");

        // pTime Messages
        pTimeResetMessage = config.getString("ptime_messages.ptime_reset_message");
        pTimeSetMessage = config.getString("ptime_messages.ptime_set_message");
        pTimeInvalidTimeMessage = config.getString("ptime_messages.ptime_invalid_time_message");

        // pWeather Messages
        pWeatherResetMessage = config.getString("pweather_messages.pweather_reset_message");
        pWeatherSetMessage = config.getString("pweather_messages.pweather_set_message");
        pWeatherInvalidWeatherMessage = config.getString("pweather_messages.pweather_invalid_weather_message");

        // Repair Messages
        repairNoItemInHandMessage = config.getString("repair_messages.repair_no_item_message");
        repairInvalidItemMessage = config.getString("repair_messages.repair_invalid_item_message");
        repairRepairedMessage = config.getString("repair_messages.repair_message");
        repairAllRepairedMessage = config.getString("repair_messages.repair_all_message");

        // Top Bottom Messages
        topMessage = config.getString("top_messages.top_message");
        bottomMessage = config.getString("bottom_messages.bottom_message");
        bottomMessageInvalidBlock = config.getString("bottom_messages.bottom_message_invalid_block");

        // God Messages
        godEnabledMessage = config.getString("god_messages.god_enabled_message");
        godDisabledMessage = config.getString("god_messages.god_disabled_message");

        // AFK Title Messages
        afkPlaceholder = config.getString("afk_title_feature.afk_placeholder");
        afkTitles = config.getStringList("afk_title_feature.afk_titles");
        afkSubtitles = config.getStringList("afk_title_feature.afk_subtitles");

        // Death Messages
        deathMessageSuffix = config.getStringList("death_messages.suffix");

        deathMessageKilledByPlayer = config.getStringList("death_messages.killed_by_player");
        deathMessageShotByPlayer = config.getStringList("death_messages.shot_by_player");
        deathMessageShotByEntity = config.getStringList("death_messages.shot_by_entity");
        deathMessageShot = config.getStringList("death_messages.shot");
        deathMessageKilledByEntity = config.getStringList("death_messages.killed_by_entity");

        deathMessageBlockExplosion = config.getStringList("death_messages.block_explosion");
        deathMessageCampfire = config.getStringList("death_messages.campfire");
        deathMessageContact = config.getStringList("death_messages.contact");
        deathMessageCramming = config.getStringList("death_messages.cramming");
        deathMessageCustom = config.getStringList("death_messages.custom");
        deathMessageDragonBreath = config.getStringList("death_messages.dragon_breath");
        deathMessageDrowning = config.getStringList("death_messages.drowning");
        deathMessageEntityExplosion = config.getStringList("death_messages.entity_explosion");
        deathMessageFall = config.getStringList("death_messages.fall");
        deathMessageFallingBlock = config.getStringList("death_messages.falling_block");
        deathMessageFire = config.getStringList("death_messages.fire");
        deathMessageFireTick = config.getStringList("death_messages.fire_tick");
        deathMessageFlyIntoWall = config.getStringList("death_messages.fly_into_wall");
        deathMessageFreeze = config.getStringList("death_messages.freeze");
        deathMessageHotFloor = config.getStringList("death_messages.hot_floor");
        deathMessageKill = config.getStringList("death_messages.kill");
        deathMessageLava = config.getStringList("death_messages.lava");
        deathMessageLightning = config.getStringList("death_messages.lightning");
        deathMessageMagic = config.getStringList("death_messages.magic");
        deathMessagePoison = config.getStringList("death_messages.poison");
        deathMessageSonicBoom = config.getStringList("death_messages.sonic_boom");
        deathMessageStarvation = config.getStringList("death_messages.starvation");
        deathMessageSuffocation = config.getStringList("death_messages.suffocation");
        deathMessageSuicide = config.getStringList("death_messages.suicide");
        deathMessageThorns = config.getStringList("death_messages.thorns");
        deathMessageVoid = config.getStringList("death_messages.void");
        deathMessageWither = config.getStringList("death_messages.wither");
        deathMessageWorldBorder = config.getStringList("death_messages.world_border");
        deathMessageDefault = config.getStringList("death_messages.default");
    }
}
