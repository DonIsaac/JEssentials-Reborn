package com.bluecreeper111.JEssentialsRB.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class JEssentialsRB {
	
	// Stores commands and their descriptions, accessed from abstract command class
	private static HashMap<String, String> commandmap = new HashMap<>();
	
	// Addes command to above map
	public static void addCommand(String command, String description) {
		commandmap.put(command, description);
	}
	
	// Returns commandmap
	public static HashMap<String, String> getCommandMap() {
		return commandmap;
	}
	
	// Gets a player from username
	public static Player getPlayer(String name) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player.getName().equals(name)) {
				return Bukkit.getPlayer(player.getUniqueId());
			}
		}
		return null;
	}
	// Checks if a player is online with a specific name
	public static boolean isPlayer(String name) {
		Player p = getPlayer(name);
		if (p == null) return false;
		return true;
	}
	// Checks if a player is online with a specific UUID
	public static boolean isPlayer(UUID id) {
		Player p = Bukkit.getPlayer(id);
		if (p == null)return false;
		return true;
	}
	
	// Checks if a string is an int
	public static boolean isInt(String num) {
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	// Checks if a string is a boolean
	public static boolean isBoolean(String string) {
		try {
			Boolean.parseBoolean(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	// Quick way to save a file
	public static void saveFile(File file, YamlConfiguration config) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Checks if a world exists by name
	public static boolean doesWorldExist(String name) {
		World world = Bukkit.getWorld(name);
		if (world == null) return false;
		return true;
	}
	
	// Gets an offline player (by name)
	public static OfflinePlayer getOfflinePlayer(String name) {
		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
			if (p.getName().equals(name)) return p;
		}
		return null;
	}
	
	// Gets a players group
	public static String getPlayerGroup(Player p) {
		if (!Main.areVaultPermissionsEnabled()) {
			return null;
		}
		return Main.getPermissions().getPrimaryGroup(p);
	}
	
	// Quick method for coloring a string
	public static String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
