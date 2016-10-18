/*
 * Copyright (c) 2016. Soringaming and Sobki. All rights reserved.
 */

package com.MagePVP;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.MagePVP.Commands.LobbyTP;
import com.MagePVP.Commands.SetLobby;
import com.MagePVP.Configuration.ConfigManager;
import com.MagePVP.Handlers.GameManager;
import com.MagePVP.Listeners.PlayerJoin;
import com.MagePVP.Listeners.PlayerLogin;
import com.MagePVP.Utils.GameState;

public class MagePVP extends JavaPlugin {

	public static MagePVP plugin;

	@Override
	public void onEnable() {
		
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			player.kickPlayer("Resetting...");
		}

		plugin = this;
		
		GameState.setCurrentState(GameState.IN_LOBBY);
		
		getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new GameManager(), 0, 1);

		new ConfigManager(plugin);
		registerCommands();
		registerEvents();
	}

	@Override
	public void onDisable() {
		
		
	}
	
	public void registerCommands() {

		getCommand("SetLobby").setExecutor(new SetLobby());
		getCommand("LobbyTP").setExecutor(new LobbyTP());
	}
	
	public void registerEvents() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();

		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerLogin(), this);
	}

}
