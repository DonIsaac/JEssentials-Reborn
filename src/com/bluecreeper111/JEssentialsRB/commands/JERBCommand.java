package com.bluecreeper111.JEssentialsRB.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.bluecreeper111.JEssentialsRB.main.JEssentialsRB;
import com.bluecreeper111.JEssentialsRB.main.LanguageFile;
import com.bluecreeper111.JEssentialsRB.main.Main;
import com.bluecreeper111.JEssentialsRB.main.Permissions;
import com.bluecreeper111.JEssentialsRB.utils.QuickMessage;

public abstract class JERBCommand implements CommandExecutor {
	
	private final String commandName;
	private final String commandPermission;
	private final boolean consoleUse;
	public static JavaPlugin plugin;
	public static Permissions perm;
	
	public JERBCommand(String commandName, String commandPermission, boolean consoleUse) {
		this.commandName = commandName;
		this.commandPermission = commandPermission;
		this.consoleUse = consoleUse;
		plugin.getCommand(commandName).setExecutor(this);
		perm = new Permissions((Main)plugin);
		perm.addPermission(commandPermission);
		JEssentialsRB.addCommand(commandName, plugin.getCommand(commandName).getDescription());
	}

	public final static void registerCommands(JavaPlugin pl) {
		plugin = pl;
		new Heal();
		new Feed();
		new Clear();
		new JHelp();
		new Back();
		new Fly();
		new Broadcast();
		new ChatClear();
		new Enderchest();
		new God();
		new Hat();
		new Workbench();
		new JEReborn();
		new Weather();
		new Time();
		new Gamemode();
		new Sudo();
		new Speed();
		new Skull();
		new More();
		new Me();
		new Motd();
		new Exp();
		new Enchant();
		new Spawn();
		new SetSpawn();
		new SetWorldSpawn();
		new SetHome();
		new DelHome();
		new Home();
		new Item();
		new Afk();
	}
	
	public abstract void execute(CommandSender sender, Command cmd, String label, String[] args);
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase(commandName)) return true;
		if (!consoleUse && !(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(LanguageFile.getMessage("onlyPlayerCanExecuteCommand"));
			return true;
		}
		if (!perm.hasPermission(sender, commandPermission)) {
			QuickMessage.noPermission(sender);
			return true;
		}
		execute(sender, cmd, label, args);
		return true;
	}
}