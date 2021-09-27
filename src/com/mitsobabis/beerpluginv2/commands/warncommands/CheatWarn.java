package com.mitsobabis.beerpluginv2.commands.warncommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CheatWarn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("cheatwarn")){
            if (sender.hasPermission("beer.staff") || sender.isOp()){
                if (args.length == 0) {
                    sender.sendMessage("Please, include the player!");
                }else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        target.sendMessage(ChatColor.DARK_RED + "You have been warned for cheating");
                        target.sendTitle(ChatColor.RED + "You were warned for cheating by " + ChatColor.GOLD + sender, "", 20, 60, 20);
                        target.spawnParticle(Particle.EXPLOSION_HUGE, target.getLocation(), 100);
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say " + ChatColor.DARK_RED + target + ChatColor.RED + " has been warned for cheating");
                    }
                }
            }else {
                sender.sendMessage(ChatColor.RED + "You have no permission to use this command");
            }
        }
        return false;
    }
}
