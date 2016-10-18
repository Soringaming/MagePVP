package com.MagePVP.Configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigManager {

	public ConfigManager(Plugin plugin) {
		
		FileConfiguration config = plugin.getConfig();
		config.options().copyDefaults(true);
		
		config.addDefault("Chat.Prefix", "&7>>");
		config.addDefault("Chat.GameStarted", "&5The game is now starting!");
		config.addDefault("Chat.GameStarting", "&5The game will start in &b{X} &5second(s).");
		
		plugin.saveConfig();
	}

}
