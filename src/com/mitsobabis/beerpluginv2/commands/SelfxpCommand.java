package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class SelfxpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] args) {
        Player player = (Player) sender;
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(ChatColor.DARK_RED + "You can't use that from here...");
        }else {
            if (sender.hasPermission("beer.selfxp") || sender.isOp() || sender.hasPermission("beer.staff")) {
                player.giveExpLevels(Integer.parseInt("30"));
                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1f, 1f);
            } else {
                player.sendMessage(ChatColor.DARK_RED + "You have no permission to use this command!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1f, 1f);
            }
        }
        return false;
    }
}

