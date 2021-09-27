package com.mitsobabis.beerpluginv2.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent d) {
        Player player = d.getEntity();
        var killer = player.getKiller();
        var x = player.getLocation().getBlockX();
        var y = player.getLocation().getBlockY();
        var z = player.getLocation().getBlockZ();
        if (player.hasPermission("beer.death")) {
            if (d.getDeathMessage().contains("was slain by")) {
                player.sendTitle(ChatColor.DARK_RED+ "You were killed by " + ChatColor.RED + killer, "", 40, 70, 40);
                player.playSound(player.getLocation(), Sound.ENTITY_PIG_DEATH, 1f, 1f);
            }
        }
        if (killer.getUniqueId() == player.getUniqueId()) {
            player.sendTitle(ChatColor.DARK_RED+ "You suicided", "", 40, 70, 40);
        }
        player.sendMessage(ChatColor.RED + "Your coordinates were + " + ChatColor.YELLOW + "x: " + x + " y: "+ y + " z: " + z);
    }
}
