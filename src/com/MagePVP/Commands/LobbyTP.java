package com.MagePVP.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.MagePVP.Locations.Lobby;
import com.MagePVP.Utils.ChatUtilities;

public class LobbyTP implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLable, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("LobbyTP")) {
			if(!player.hasPermission("MagePVP.LobbyTp")) {
				ChatUtilities.insufficientPermission(player);
				return true;
			}
			if(!Lobby.isActivated()) {
				ChatUtilities.message(player, ChatColor.RED + "The lobby has not been set yet!");
				return true;
			}
			Lobby.sendToLobby(player);
			return true;
		}
		
		return true;
	}

}
