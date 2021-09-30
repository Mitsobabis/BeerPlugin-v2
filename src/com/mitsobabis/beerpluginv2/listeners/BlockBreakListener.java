package com.mitsobabis.beerpluginv2.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();
        Random rand = new Random();
        int n = rand.nextInt(100);
        n += 1;
        if (block.getType() == Material.ANCIENT_DEBRIS) {
            if (player.hasPermission("beer.vip")) {
                e.setDropItems(false);
                if (n == 1) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_INGOT));
                }
                if (n > 1 && n <= 21) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP));
                }
                if (n > 21) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ANCIENT_DEBRIS));
                }
            }
            else{
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ANCIENT_DEBRIS));
            }
            if (player.hasPermission("beer.vip+")) {
                e.setDropItems(false);
                if (n < 4) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_INGOT));
                }
                if (n > 3 && n <= 40) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP));
                }
                if (n > 40) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ANCIENT_DEBRIS));
                }
                e.setCancelled(false);
            }
            if (player.hasPermission("beer.vip++")) {
                e.setDropItems(false);
                if (n < 6) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_INGOT));
                }
                if (n > 5 && n <= 50) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP));
                }
                if (n > 50) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ANCIENT_DEBRIS));
                }
                e.setCancelled(false);
            }
        }
    }
}