package com.MagePVP.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.MagePVP.Locations.Lobby;
import com.MagePVP.Utils.ChatUtilities;

public class SetLobby implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLable, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only a player can use this command!");
			return true;
		}
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("SetLobby")) {
			if(!(player.hasPermission("MagePVP.SetLobby"))) {
				ChatUtilities.insufficientPermission(player);
				return true;
			}
			Lobby.setLobby(player.getLocation());
			ChatUtilities.message(player, ChatColor.GREEN + "Lobby set!");
			return true;
		}

		return true;
	}

}
