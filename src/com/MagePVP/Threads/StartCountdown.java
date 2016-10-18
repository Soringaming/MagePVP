/*
 * Copyright (c) 2016. Soringaming and Sobki. All rights reserved.
 */

package com.MagePVP.Threads;

import org.bukkit.ChatColor;

import com.MagePVP.MagePVP;
import com.MagePVP.Methods;
import com.MagePVP.Utils.ChatUtilities;
import com.MagePVP.Utils.GameState;

public class StartCountdown implements Runnable {

	private static int timeUntilStart = 60;

	@Override
	public void run() {

		if (GameState.isCurrentState(GameState.IN_LOBBY)) {
			if (Methods.canStart()) {
				if (timeUntilStart == 0) {
					
					return;
				}

				if (timeUntilStart % 10 == 0 || timeUntilStart < 10) {
					ChatUtilities
							.announce(ChatColor.translateAlternateColorCodes('&', MagePVP.plugin.getConfig()
									.getString("Chat.GameStarting").replace("{X}", String.valueOf(timeUntilStart))));
				}

				timeUntilStart--;
			} else {
				timeUntilStart = 60;
			}
		}
	}

}
