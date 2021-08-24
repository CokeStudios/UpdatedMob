package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Guardian;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class GuardianEvent implements Listener {
    @EventHandler
    public void GuardianSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Guardian) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Guardian guardian = (Guardian) spawn_event.getEntity();
                guardian.setCustomName(ChatColor.GRAY + "Guardian");
                Objects.requireNonNull(guardian.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(guardian.getHealth() * 3);
                guardian.setHealth(guardian.getHealth() * 3);
            }
            else if (choice < 35) {
                Guardian guardian = (Guardian) spawn_event.getEntity();
                guardian.setCustomName(ChatColor.GOLD + "Guardian");
                Objects.requireNonNull(guardian.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(guardian.getHealth() * 5);
                guardian.setHealth(guardian.getHealth() * 5);
            }
            else {
                Guardian guardian = (Guardian) spawn_event.getEntity();
                Objects.requireNonNull(guardian.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(guardian.getHealth() * 2);
                guardian.setHealth(guardian.getHealth() * 2);
            }
        }
    }
}
