package com.MagePVP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.MagePVP.Threads.StartCountdown;
import com.MagePVP.Utils.ChatUtilities;
import com.MagePVP.Utils.GameState;

public class Methods {

	public static void startCounter() {
		
		// start counter

		if (!canStart()) {
			return;
		}

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(MagePVP.plugin, new StartCountdown(), 0, 20);

	}
	
	public static void start() {
		
		// start game
		GameState.setCurrentState(GameState.IN_GAME);
		ChatUtilities.announce(
				ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig().getString("Chat.GameStarted")));
		
		GameState.setCurrentState(GameState.IN_GAME);
	}

	public static void stop() {

		// TODO stop game
	}

	public static boolean canStart() {
		if (Bukkit.getServer().getOnlinePlayers().size() >= getMinRequiredPlayers()) {
			return true;
		}
		return false;
	}

	public static int getMinRequiredPlayers() {

		return MagePVP.plugin.getConfig().getInt("Settings.MinimumPlayers");
	}

	public static int getMaxRequiredPlayers() {

		return MagePVP.plugin.getConfig().getInt("Settings.MaximumPlayers");
	}

}
