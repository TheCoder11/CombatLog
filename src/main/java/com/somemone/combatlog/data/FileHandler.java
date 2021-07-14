package com.somemone.combatlog.data;

import com.somemone.combatlog.CombatLog;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    private YamlConfiguration config;
    private final File file;

    public FileHandler () throws IOException, InvalidConfigurationException {
        File parentFile = CombatLog.getPlugin().getDataFolder();

        this.file = new File(parentFile, "player-settings.yml");
        config.load(file);
    }

    public VisionType getPlayerType (Player player) {

        String vision = config.getString(player.getName());

        if (vision == null) {
            return VisionType.BOSSBAR;
        } else {
            VisionType type = VisionType.valueOf(vision);
            return type;
        }

    }

    public void savePlayerType (Player player, VisionType type) throws IOException {

        config.set(player.getName(), type.name());
        config.save(file);

    }

}
