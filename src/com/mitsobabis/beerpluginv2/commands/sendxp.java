package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class sendxp implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("uuid")) {
                Player player = (Player) sender;
                if (player.hasPermission("beer.sendxp") || sender.hasPermission("beer.staff") || sender.isOp()) {
                    if (args.length == 0) {
                        sender.sendMessage(ChatColor.DARK_RED + "Incorrect usage of command! Please use /sendxp <target>");
                    } else {
                        Player target = Bukkit.getPlayer(args[0]);
                        sender = player;
                        if (target != null) {
                            target.giveExpLevels(Integer.parseInt("30"));
                            sender.sendMessage(ChatColor.GREEN + "Succesfully buffed " + ChatColor.YELLOW + target + ChatColor.GREEN + " with xp");
                            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);
                            target.sendMessage(ChatColor.GREEN + "You have been buffed with xp by " + ChatColor.YELLOW + sender);
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "You have no permission to use this command!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1f, 1f);
                }
            }
        } else {
            if (cmd.getName().equalsIgnoreCase("uuid")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.DARK_RED + "Incorrect usage of command! Please use /sendxp <target>");
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.giveExpLevels(Integer.parseInt("30"));
                        sender.sendMessage(ChatColor.GREEN + "Succesfully buffed " + ChatColor.YELLOW + target + ChatColor.GREEN + " with xp");
                        target.sendMessage(ChatColor.GREEN + "You have been buffed with xp by " + ChatColor.YELLOW + sender);
                    }
                }
            }
        }
        return false;
    }
}
