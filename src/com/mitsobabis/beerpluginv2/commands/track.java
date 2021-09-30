package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class track implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player target = Bukkit.getPlayer(args[0]);
        Player player = (Player) sender;

        var x = target.getLocation().getBlockX();
        var y = target.getLocation().getBlockY();
        var z = target.getLocation().getBlockZ();

       var walk_speed = target.getWalkSpeed();

        if (target != null) {
            if(target.isOnline()) {
                sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.YELLOW + target + ChatColor.GREEN + " is currently on: " + ChatColor.RED + "X: " + x + " Y: " + y + " Z: " + z + ". And moving with a speed of: " + ChatColor.BLUE + walk_speed);
                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);
            }else {
                sender.sendMessage(ChatColor.RED+ "This player is not online");
            }
        }else {
            sender.sendMessage(ChatColor.DARK_RED + "Please specify your target!");
        }
        return true;
    }
}
