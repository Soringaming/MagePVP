/*
 * Copyright (c) 2016. Soringaming and Sobki. All rights reserved.
 */

package com.MagePVP.Threads;

import org.bukkit.ChatColor;

import com.MagePVP.MagePVP;
import com.MagePVP.Methods;
import com.MagePVP.Utils.ChatUtilities;

public class StartCountdown implements Runnable {

	private static int timeUntilStart = 60;

	@Override
	public void run() {
		
		if (timeUntilStart == 0) {
			Methods.start();
			timeUntilStart = 60;
			return;
		}
		
		if (timeUntilStart % 10 == 0 || timeUntilStart < 10) {
			ChatUtilities.announceToServer(ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig()
					.getString("Chat.GameStarting").replace("{X}", String.valueOf(timeUntilStart))));
		}
		
		timeUntilStart--;
	}

}
