package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UUIDCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] args) {
        if(cmd.getName().equalsIgnoreCase("uuid")) {
            Player player = (Player) sender;
            if (args.length == 0) {
                sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "B" + ChatColor.RED + "E" + ChatColor.YELLOW + "E" + ChatColor.RED + "R " + ChatColor.YELLOW + "U" + ChatColor.RED + "U" + ChatColor.YELLOW + "I" + ChatColor.RED + "D" + ChatColor.YELLOW + "S" + ChatColor.DARK_RED + "] " + ChatColor.GREEN + "Your UUID is: " + ChatColor.YELLOW + player.getUniqueId());
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1f, 1f);

            } else {
                Player target = Bukkit.getPlayer(args[0]);
                sender = player;
                if (sender.hasPermission("beer.uuid.others") || sender.hasPermission("beer.staff") || sender.isOp()) {
                    if (target != null) {
                        sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "B" + ChatColor.RED + "E" + ChatColor.YELLOW + "E" + ChatColor.RED + "R " + ChatColor.YELLOW + "U" + ChatColor.RED + "U" + ChatColor.YELLOW + "I" + ChatColor.RED + "D" + ChatColor.YELLOW + "S" + ChatColor.DARK_RED + "] " + ChatColor.GREEN + "Their UUID is: " + ChatColor.YELLOW + target.getUniqueId());
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 1f, 1f);
                    }
                }else {
                    player.sendMessage(ChatColor.RED + "You have no permission to use this command!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1f, 1f);
                }
            }
        }
        return false;
    }


}
