package com.mitsobabis.beerpluginv2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Random;


public class AntiBot implements CommandExecutor, Listener {

    Object message;

    {
        Random rand = new Random();
        int n = rand.nextInt(210000000)+1;
        n += 100000;


        message = n;

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] args){


        if(cmd.getName().equalsIgnoreCase("antibot")) {
            if (sender.hasPermission("beer.staff") || sender.isOp()){
                if (args.length == 0){
                    sender.sendMessage(ChatColor.RED + "Please, include the player");
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        if (target.isOnline()) {
                            target.sendMessage(ChatColor.RED + "Please type: " + ChatColor.YELLOW + message);
                            sender.sendMessage(ChatColor.RED + "Their number is: " + ChatColor.YELLOW + message);
                        }else {
                            sender.sendMessage(ChatColor.RED+ "This player is not online");
                        }
                    }
                }
            }else {
                sender.sendMessage(ChatColor.RED + "You have no permission to use this command");
            }
        }
        return true;
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if (e.getMessage().contains((CharSequence) message)){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "msg Console " + ChatColor.GREEN + " passed the antibot check");
        }else {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "msg Console " + ChatColor.GREEN + " didn't pass the antibot check");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + e.getPlayer() + " Failed AntiBot test");
        }
    }
}
