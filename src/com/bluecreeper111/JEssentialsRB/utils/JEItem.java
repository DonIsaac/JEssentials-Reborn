package com.bluecreeper111.JEssentialsRB.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JEItem {
	
	// Gives a player an item WITH inventory full detection
	public static void giveItem(Player p, ItemStack item) {
		if (p.getInventory().firstEmpty() == -1) {
			p.getLocation().getWorld().dropItem(p.getLocation(), item);
		} else {
			p.getInventory().addItem(item);
		}
	}

}
