package com.cokestudio.updatedmob;

import com.cokestudio.updatedmob.event.*;

import org.bukkit.Bukkit;
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

        String v = Bukkit.getBukkitVersion();
        String v1 = v.split("-")[0];
        String version;
        int length = v1.length();
        if (length == 3 || length == 5) {
            version = v1.substring(0, 3);
        } else {
            version = v1.substring(0, 4);
        }

        System.out.println("[UpdatedMob] Detected Minecraft Version: " + v1);
        if (v1.startsWith("1.7")) {
            System.out.println("[UpdatedMob] Error: This Minecraft Version is not supported.");
            System.out.println("[UpdatedMob] Disabling this plugin.");
            getPluginManager().disablePlugin(this);
        } else {
            int int_version = Integer.parseInt(version.substring(2, 4));

            PluginManager event = getServer().getPluginManager();
            event.registerEvents(new ZombieEvent(), this);
            event.registerEvents(new CreeperEvent(), this);
            if (int_version >= 13) {
                event.registerEvents(new DrownedEvent(), this);
                event.registerEvents(new EvokerEvent(), this);
            }
            if (int_version >= 11) {
                event.registerEvents(new HuskEvent(), this);
            }

            event.registerEvents(new BlazeEvent(), this);
            event.registerEvents(new GuardianEvent(), this);
            if (int_version >= 17) {
                event.registerEvents(new GoatEvent(), this);
            }

            if (int_version >= 16) {
                event.registerEvents(new HoglinEvent(), this);
            }

            if (!enabled) {
                System.out.println("[UpdatedMob] Failed to enable because of the config.");
                System.out.println("[UpdatedMob] Disabling this plugin.");
                getPluginManager().disablePlugin(this);
            }
            else {
                System.out.println("[UpdatedMob] Successfully Enabled");
            }
        }
    }

    @Override
    public void onDisable() {
        System.out.println("[UpdatedMob] Successfully Disabled");
    }
}
