package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class DrownedEvent implements Listener {
    @EventHandler
    public void DrownedSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Drowned) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Drowned drowned = (Drowned) spawn_event.getEntity();
                drowned.setCustomName(ChatColor.GRAY + "Drowned");
                Objects.requireNonNull(drowned.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(drowned.getHealth() * 3);
                drowned.setHealth(drowned.getHealth() * 3);
            }
            else if (choice < 35) {
                Drowned drowned = (Drowned) spawn_event.getEntity();
                drowned.setCustomName(ChatColor.GOLD + "Drowned");
                Objects.requireNonNull(drowned.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(drowned.getHealth() * 5);
                drowned.setHealth(drowned.getHealth() * 5);
            }
            else {
                Drowned drowned = (Drowned) spawn_event.getEntity();
                Objects.requireNonNull(drowned.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(drowned.getHealth() * 2);
                drowned.setHealth(drowned.getHealth() * 2);
            }
        }
    }
}
