package com.somemone.combatlog.data;

import com.somemone.combatlog.CombatLog;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public enum VisionType {

    CHAT_MESSAGE {
        @Override
        public void update(LogProfile profile) {
            String secondsLeft = profile.secondsLeft.toString();

            profile.player.sendMessage("You cannot log out! You have " + ChatColor.BOLD + ChatColor.RED + secondsLeft + ChatColor.RESET + " seconds left!");
        }
    },
    BOSSBAR {
        @Override
        public void update(LogProfile profile) {
            double progress = CombatLog.increment * profile.secondsLeft;

            profile.bossBar.setProgress(progress);
        }
    },
    NONE {
        @Override
        public void update(LogProfile profile) { }
    };

    public abstract void update(LogProfile profile);

}
