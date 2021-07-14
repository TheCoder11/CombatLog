package com.somemone.combatlog.data;

import com.somemone.combatlog.CombatLog;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class LogProfile {

    public final Player player;
    public Integer secondsLeft;
    public BossBar bossBar;


    public LogProfile (Player player) {
        this.player = player;
        secondsLeft = 12;
        bossBar = Bukkit.createBossBar("Do not log out!", BarColor.YELLOW, BarStyle.SEGMENTED_12);
        bossBar.setProgress(CombatLog.increment * 12);

        bossBar.addPlayer(player);
    }

}
