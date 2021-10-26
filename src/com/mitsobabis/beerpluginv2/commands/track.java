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
    //Public variables and definitions for the command
        Player target = Bukkit.getPlayer(args[0]);
        Player player = (Player) sender;
    //Getting target's location
        var x = target.getLocation().getBlockX();
        var y = target.getLocation().getBlockY();
        var z = target.getLocation().getBlockZ();
     //Getting target's speed, whether they are flying or not
       var walk_speed = target.getWalkSpeed();
       var fly_speed = target.getFlySpeed();

        if(cmd.getName().equalsIgnoreCase("track")) {
            if (player.hasPermission("beer.staff") || sender.isOp()) {
                if (target != null) {
                    if (target.isOnline()) {
                        if (target.isSprinting() || target.isSneaking() || target.isClimbing() || target.isSwimming() || target.isSleeping() || target.isInvisible()) {
                            sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.YELLOW + target + ChatColor.GREEN + " is currently on: " + ChatColor.RED + "X: " + x + " Y: " + y + " Z: " + z + ChatColor.GREEN + ". Moving with a speed of: " + ChatColor.BLUE + walk_speed);
                            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);
                        }
                        if (target.isFlying()) {
                            sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.YELLOW + target + ChatColor.GREEN + " is currently on: " + ChatColor.RED + "X: " + x + " Y: " + y + " Z: " + z + ChatColor.GREEN + ". Flying with a speed of: " + ChatColor.BLUE + fly_speed);
                            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);
                        }
                        if (target.isInsideVehicle()){
                            sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.YELLOW + target + ChatColor.GREEN + " is currently on: " + ChatColor.RED + "X: " + x + " Y: " + y + " Z: " + z + ChatColor.GREEN + ". Moving in a vehicle (" + ChatColor.AQUA + target.getVehicle() + ChatColor.GREEN +  ") with a speed of: " + ChatColor.BLUE + walk_speed);
                            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "This player is not online");
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "Please specify your target!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command");
            }
        }
        return true;
    }
}
