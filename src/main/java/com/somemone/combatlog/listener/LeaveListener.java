package com.somemone.combatlog.listener;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.somemone.combatlog.CombatLog;
import com.somemone.combatlog.data.LogProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    @EventHandler
    public void onPlayerLeave (PlayerQuitEvent event) {

        if (event.getReason() != PlayerQuitEvent.QuitReason.DISCONNECTED) return;

        for (LogProfile profile : CombatLog.profiles) {

            if (profile.player.getName().equals( event.getPlayer().getName() )) {


                Player player = event.getPlayer();
                FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);

                fplayer.alterPower( -5.0 );
                CombatLog.profiles.remove(profile);


            }

        }

    }

}
