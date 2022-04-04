package com.towering.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("OneShotBow has been enabled");
        getServer().getPluginManager().registerEvents(new BowEvent(), this);
        getServer().getPluginManager().registerEvents((Listener) new Lapiz(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("OneShotBow has been disabled");
    }
}
