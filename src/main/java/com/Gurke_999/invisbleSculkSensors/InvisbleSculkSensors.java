package com.Gurke_999.invisbleSculkSensors;

import org.bukkit.plugin.java.JavaPlugin;

public final class InvisbleSculkSensors extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new SculkSensorTriggered(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
