package com.somemone.combatlog.listener;

import com.somemone.combatlog.CombatLog;
import com.somemone.combatlog.data.LogProfile;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitListener implements Listener {

    @EventHandler
    public void onEntityHit (EntityDamageByEntityEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER )) return;

        if (!event.getDamager().getType().equals(EntityType.PLAYER)) return;

        if (CombatLog.getBypasses().containsKey((Player) event.getEntity())) return;

        LogProfile logProfile = new LogProfile( (Player) event.getEntity());

        CombatLog.profiles.add(logProfile);

        ((Player) event.getEntity()).sendMessage(ChatColor.RED + "You have been hit by a player! You cannot log out for 12 seconds now!");
    }
}
