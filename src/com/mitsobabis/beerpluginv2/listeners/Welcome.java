package com.mitsobabis.beerpluginv2.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Welcome implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.GOLD + "Welcome to BEER SMP");
        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f);
        player.sendTitle(ChatColor.DARK_RED+"WELCOME" + ChatColor.RED +" TO OUR"+ChatColor.YELLOW + " SMP " , ChatColor.ITALIC + e.getPlayer().getName(), 20, 70, 50 );
        player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "U" + ChatColor.RED + "U" + ChatColor.YELLOW + "I" + ChatColor.RED + "D" + ChatColor.YELLOW + "S" + ChatColor.DARK_RED + "] " + ChatColor.GREEN + "Your UUID is: " + ChatColor.YELLOW +ChatColor.ITALIC + player.getUniqueId());
        player.sendMessage("");
        player.sendMessage(ChatColor.GOLD+ "Have questions? " + ChatColor.RED + "Ask us on discord: /discord");

    }

}
