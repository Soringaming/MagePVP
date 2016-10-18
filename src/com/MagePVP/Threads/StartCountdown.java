/*
 * Copyright (c) 2016. Soringaming and Sobki. All rights reserved.
 */

package com.MagePVP.Threads;

import org.bukkit.Bukkit;

/**
 * Created by Soringaming on 10/18/2016.
 */
public class StartCountdown implements Runnable {

    private static int timeUntilStart;

    @Override
    public void run() {

        timeUntilStart = 60;
        while (true) {
            for (; timeUntilStart >= 0; timeUntilStart--) {
                if (timeUntilStart == 0) {
                    //Start le game
                    break;
                }
                if (timeUntilStart % 10 == 0 || timeUntilStart < 10) {
                    // say some shit
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Bukkit.shutdown();
                }
            }

        }

    }

}
