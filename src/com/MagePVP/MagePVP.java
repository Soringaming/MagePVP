/*
 * Copyright (c) 2016. Soringaming and Sobki. All rights reserved.
 */

package com.MagePVP;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.MagePVP.Configuration.ConfigManager;
import com.MagePVP.Threads.StartCountdown;

public class MagePVP extends JavaPlugin {

	public static MagePVP plugin;

	public void onEnable() {

		plugin = this;

		new ConfigManager(plugin);

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new StartCountdown(), 0, 20);
	}

}
