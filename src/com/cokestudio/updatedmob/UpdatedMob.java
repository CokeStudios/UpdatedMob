package com.cokestudio.updatedmob;

import com.cokestudio.updatedmob.event.*;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getPluginManager;

public class UpdatedMob extends JavaPlugin {
    @Override
    public void onEnable() {
        Plugin plugin = getPlugin(this.getClass());
        getConfig().options().copyDefaults();
        boolean enabled = plugin.getConfig().getBoolean("enabled");

        PluginManager event = getServer().getPluginManager();
        event.registerEvents(new ZombieEvent(), this);
        event.registerEvents(new CreeperEvent(), this);
        event.registerEvents(new DrownedEvent(), this);
        event.registerEvents(new EvokerEvent(), this);
        event.registerEvents(new HuskEvent(), this);

        if (!enabled) {
            System.out.println("[UpdatedMob] Failed to enable because of the config.");
            getPluginManager().disablePlugin(this);
        }
        else {
            System.out.println("[UpdatedMob] Successfully Enabled");
        }
    }

    @Override
    public void onDisable() {
        System.out.println("[UpdatedMob] Successfully Disabled");
    }
}
