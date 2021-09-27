package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;
            sender.sendMessage(ChatColor.YELLOW + " -----------------------------------RULES-----------------------------------");
            sender.sendMessage(ChatColor.YELLOW + "➥ Απαγορεύεται να κάνετε spamm αλλα και tag owners/co owners! Καλύτερα κάντε tag ένα staff.");
            sender.sendMessage(ChatColor.YELLOW + "➥ Απαγορεύεται να στέλνετε nsfw content σε κανάλια που δεν είναι φτιαγμένα για αυτό!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Απαγορεύεται να κάνετε leak προσωπικά στοιχία άλλων members!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Δεν επιτρέπεται να στέλνετε μηνύματα τα οποία περιέχουν ρατσιστικα σχόλια κλπ!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Δεν επιτρέπεται το advertisement! Είτε σε dm είτε σε κανάλια!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Τα alt accounts τρώνε instant ban!");
            sender.sendMessage(ChatColor.YELLOW + "---------------------------------------------------------------------------");
            sender.sendMessage(ChatColor.DARK_RED + "Have fun and remember: " + ChatColor.RED + "Stay safe");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1f, 1f);

        }else {

            sender.sendMessage(ChatColor.YELLOW + " -----------------------------------RULES-----------------------------------");
            sender.sendMessage(ChatColor.YELLOW + "➥ Απαγορεύεται να κάνετε spamm αλλα και tag owners/co owners! Καλύτερα κάντε tag ένα staff.");
            sender.sendMessage(ChatColor.YELLOW + "➥ Απαγορεύεται να στέλνετε nsfw content σε κανάλια που δεν είναι φτιαγμένα για αυτό!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Απαγορεύεται να κάνετε leak προσωπικά στοιχία άλλων members!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Δεν επιτρέπεται να στέλνετε μηνύματα τα οποία περιέχουν ρατσιστικα σχόλια κλπ!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Δεν επιτρέπεται το advertisement! Είτε σε dm είτε σε κανάλια!");
            sender.sendMessage(ChatColor.YELLOW + "➥ Τα alt accounts τρώνε instant ban!");
            sender.sendMessage(ChatColor.YELLOW + "---------------------------------------------------------------------------");
            sender.sendMessage(ChatColor.DARK_RED + "Have fun and remember: " + ChatColor.RED + "Stay safe");

        }
        return true;
    }
}
