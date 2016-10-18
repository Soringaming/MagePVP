package com.MagePVP.Configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigManager {

	public ConfigManager(Plugin plugin) {
		
		FileConfiguration config = plugin.getConfig();
		config.options().copyDefaults(true);
		
		config.addDefault("Chat.Prefix", "&7>>");
		config.addDefault("Chat.JoinMessage", "&b{PLAYER} &5has joined the queue! &8[&7{CURRENT_PLAYERS} / {MAX_PLAYERS}&8]");
		config.addDefault("Chat.GameStarted", "&5The game is now starting!");
		config.addDefault("Chat.GameStarting", "&5The game will start in &b{X} &5second(s).");
		config.addDefault("Chat.WaitingForPlayers", "&5Waiting for players... &b{X} &5more required to start the game.");
		
		config.addDefault("Chat.Error.InsufficientPermissions", "&cSorry, but you do not have enough permissions to do this!");
		
		config.addDefault("Settings.MinimumPlayers", Integer.valueOf(2));
		config.addDefault("Settings.MaximumPlayers", Integer.valueOf(8));

		config.addDefault("Map.Lobby.Activated", Boolean.valueOf(false));
		
		plugin.saveConfig();
	}

}
