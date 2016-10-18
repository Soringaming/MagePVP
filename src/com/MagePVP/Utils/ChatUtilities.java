package com.MagePVP.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.MagePVP.MagePVP;

public class ChatUtilities {

	public static String prefix() {

		return ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig().getString("Chat.Prefix")) + " ";
	}

	public static void announceToPlayers(String msg) {

		for (Player p : Bukkit.getOnlinePlayers()) {
			// TODO change to only the players IN THE GAME :D
			p.sendMessage(prefix() + " " + msg);
		}
	}

	public static void announceToServer(String msg) {

		Bukkit.getServer().broadcastMessage(prefix() + " " +msg);
	}

}