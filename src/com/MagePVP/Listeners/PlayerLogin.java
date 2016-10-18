package com.MagePVP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.MagePVP.Methods;
import com.MagePVP.Utils.GameState;

public class PlayerLogin implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		
		if (!GameState.isCurrentState(GameState.IN_LOBBY)) {
			
			kick(event.getPlayer(), "Cannot join mid-game!");
			return;
		}
		
		if (Bukkit.getServer().getOnlinePlayers().size() == Methods.getMaxRequiredPlayers()) {
			
			kick(event.getPlayer(), "Game lobby full!");
			return;
		}

	}
	
	public void kick(Player player, String msg) {
		
		player.kickPlayer(msg);
	}

}