package com.MagePVP;

import com.MagePVP.Utils.ChatUtilities;

import net.md_5.bungee.api.ChatColor;

public class Methods {

	public static void start() {

		ChatUtilities.announceToServer(
				ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig().getString("Chat.GameStarted")));
	}

	public static void stop() {

		// TODO stop the game
	}

}
