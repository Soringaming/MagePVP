package com.MagePVP.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.MagePVP.MagePVP;

public class ChatUtilities {

	public static String prefix() {

		return ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig().getString("Chat.Prefix")) + " ";
	}

	public static void announce(String msg) {

		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(prefix() + " " + msg);
		}
	}
	
	public static void insufficientPermission(Player player) {
		
		player.sendMessage(prefix() + ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig().getString("Chat.Error.InsufficientPermissions")));
	}
	
	public static void message(Player player, String msg) {
		
		player.sendMessage(prefix() + msg);
	}

}