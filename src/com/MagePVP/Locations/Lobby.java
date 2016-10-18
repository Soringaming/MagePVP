package com.MagePVP.Locations;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.MagePVP.MagePVP;

public class Lobby {
	
	public static void setLobby(Location loc) {
		FileConfiguration config = MagePVP.plugin.getConfig();
		

		config.set("Map.Lobby.Activated", Boolean.valueOf(true));
		config.set("Map.Lobby.Location.World", loc.getWorld().getName());
		config.set("Map.Lobby.Location.X", Double.valueOf(loc.getX()));
		config.set("Map.Lobby.Location.Y", Double.valueOf(loc.getY()));
		config.set("Map.Lobby.Location.Z", Double.valueOf(loc.getZ()));
		config.set("Map.Lobby.Location.Yaw", Float.valueOf(loc.getYaw()));
		config.set("Map.Lobby.Location.Pitch", Float.valueOf(loc.getPitch()));
		
		MagePVP.plugin.saveConfig();
		
	}
	
	public static boolean isActivated() {
		
		return MagePVP.plugin.getConfig().getBoolean("Map.Lobby.Activated");
	}
	
	public static Location getLobby() {
		
		return new Location(
				Bukkit.getServer().getWorld(MagePVP.plugin.getConfig().getString("Map.Lobby.Location.World")),
				MagePVP.plugin.getConfig().getDouble("Map.Lobby.Location.X"),
				MagePVP.plugin.getConfig().getDouble("Map.Lobby.Location.Y"),
				MagePVP.plugin.getConfig().getDouble("Map.Lobby.Location.Z"),
				(float) MagePVP.plugin.getConfig().getDouble("Map.Lobby.Location.Yaw"),
				(float) MagePVP.plugin.getConfig().getDouble("Map.Lobby.Location.Pitch"));
	}
	
	public static void sendToLobby(Player player) {
		
		if (isActivated()) {
			player.teleport(getLobby());
		}
	}

}	