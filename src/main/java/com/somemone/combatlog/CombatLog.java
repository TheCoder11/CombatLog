package com.somemone.combatlog;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Factions;
import com.somemone.combatlog.data.LogProfile;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class CombatLog extends JavaPlugin {

    private static HashMap<Player, Boolean> bypasses = new HashMap<>();
    public static double increment = 1 / 12;

    public static ArrayList<LogProfile> profiles;

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static HashMap<Player, Boolean> getBypasses() {
        return bypasses;
    }

    public static void setBypass (Player player, Boolean bool) {
        bypasses.put(player, bool);
    }

    public static JavaPlugin getPlugin() {
        return getPlugin();
    }
}
