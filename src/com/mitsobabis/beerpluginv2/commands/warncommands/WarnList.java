package com.mitsobabis.beerpluginv2.commands.warncommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class WarnList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warnlist")) {
            if (sender.hasPermission("beer.staff") || sender.isOp()) {
                sender.sendMessage(ChatColor.RED + "-------------------------------------WARN COMMANDS-------------------------------------");
                sender.sendMessage(ChatColor.YELLOW + "/griefwarn <player>:" +ChatColor.GOLD + " Warn someone for griefing");
                sender.sendMessage(ChatColor.YELLOW + "/cheatwarn <player>:" +ChatColor.GOLD + " Warn someone for cheating");
                sender.sendMessage(ChatColor.YELLOW + "/warn <player>:" +ChatColor.GOLD + " Warn a player either for reasons not listed, or just generally warn");
                sender.sendMessage(ChatColor.RED + "---------------------------------------------------------------------------------------");
            }
        }
        return false;
    }
}
