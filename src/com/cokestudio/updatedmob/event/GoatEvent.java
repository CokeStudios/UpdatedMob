package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Goat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class GoatEvent implements Listener {
    @EventHandler
    public void GoatSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Goat) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Goat goat = (Goat) spawn_event.getEntity();
                goat.setCustomName(ChatColor.GRAY + "Goat");
                Objects.requireNonNull(goat.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(goat.getHealth() * 3);
                goat.setScreaming(true);
                goat.setHealth(goat.getHealth() * 3);
            }
            else if (choice < 35) {
                Goat goat = (Goat) spawn_event.getEntity();
                goat.setCustomName(ChatColor.GOLD + "Goat");
                Objects.requireNonNull(goat.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(goat.getHealth() * 3);
                goat.setScreaming(true);
                goat.setHealth(goat.getHealth() * 5);
            }
            else {
                Goat goat = (Goat) spawn_event.getEntity();
                Objects.requireNonNull(goat.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(goat.getHealth() * 3);
                goat.setHealth(goat.getHealth() * 2);
            }
        }
    }
}
