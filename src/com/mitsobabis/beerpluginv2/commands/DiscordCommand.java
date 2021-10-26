package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] args) {
        Player player = (Player) sender;
        sender.sendMessage(ChatColor.BLUE + "Our discord is: " + ChatColor.DARK_BLUE + "https://discord.gg/jwEaFevBky");
        player.spawnParticle(Particle.TOTEM, player.getLocation(), 10);
        player.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1f,1f);
        return true;
    }
}
