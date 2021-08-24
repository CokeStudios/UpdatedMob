package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class HuskEvent implements Listener {
    @EventHandler
    public void CreeperSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Husk) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 40) {
                Husk husk = (Husk) spawn_event.getEntity();
                husk.setCustomName(ChatColor.GRAY + "Husk");
                Objects.requireNonNull(husk.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(husk.getHealth() * 3);
                husk.setHealth(husk.getHealth() * 3);
            }
            else if (choice < 50) {
                Husk husk = (Husk) spawn_event.getEntity();
                husk.setCustomName(ChatColor.GOLD + "Husk");
                Objects.requireNonNull(husk.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(husk.getHealth() * 5);
                husk.setHealth(husk.getHealth() * 5);
            }
            else {
                Husk husk = (Husk) spawn_event.getEntity();
                Objects.requireNonNull(husk.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(husk.getHealth() * 2);
                husk.setHealth(husk.getHealth() * 2);
            }
        }
    }
}
