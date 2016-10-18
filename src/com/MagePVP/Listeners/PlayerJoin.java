package com.MagePVP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.MagePVP.MagePVP;
import com.MagePVP.Methods;
import com.MagePVP.Locations.Lobby;
import com.MagePVP.Utils.ChatUtilities;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		event.setJoinMessage("");
		ChatUtilities.announce(ChatColor.translateAlternateColorCodes('&',
				MagePVP.plugin.getConfig().getString("Chat.JoinMessage")
						.replace("{PLAYER}", event.getPlayer().getName())
						.replace("{CURRENT_PLAYERS}", String.valueOf(Bukkit.getServer().getOnlinePlayers().size()))
						.replace("{MAX_PLAYERS}", String.valueOf(Methods.getMaxRequiredPlayers()))));

		Lobby.sendToLobby(event.getPlayer());

		if (!Methods.canStart()) {

			ChatUtilities.announce(ChatColor.translateAlternateColorCodes('&',
					MagePVP.plugin.getConfig().getString("Chat.WaitingForPlayers").replace("{X}", String
							.valueOf(Methods.getMinRequiredPlayers() - Bukkit.getServer().getOnlinePlayers().size()))));
		} else {

			Methods.startCounter();
		}
	}

}
