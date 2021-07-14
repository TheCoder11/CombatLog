package com.somemone.combatlog.tasks;

import com.somemone.combatlog.CombatLog;
import com.somemone.combatlog.data.FileHandler;
import com.somemone.combatlog.data.LogProfile;
import com.somemone.combatlog.data.VisionType;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateTask extends BukkitRunnable {
    @Override
    public void run() {

        ArrayList<LogProfile> profiles = CombatLog.profiles;
        try {
            FileHandler handler = new FileHandler();
            for (LogProfile profile : profiles) {

                VisionType type = handler.getPlayerType(profile.player);
                type.update(profile);
                profile.secondsLeft = profile.secondsLeft - 1;

                if (profile.secondsLeft == 0) {
                    profiles.remove(profile);
                }

            }

        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
