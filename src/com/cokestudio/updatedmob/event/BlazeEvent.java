package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Blaze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class BlazeEvent implements Listener {
    @EventHandler
    public void BlazeSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Blaze) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Blaze blaze = (Blaze) spawn_event.getEntity();
                blaze.setCustomName(ChatColor.GRAY + "Blaze");
                Objects.requireNonNull(blaze.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(blaze.getHealth() * 3);
                blaze.setHealth(blaze.getHealth() * 3);
            }
            else if (choice < 35) {
                Blaze blaze = (Blaze) spawn_event.getEntity();
                blaze.setCustomName(ChatColor.GOLD + "Blaze");
                Objects.requireNonNull(blaze.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(blaze.getHealth() * 3);
                blaze.setHealth(blaze.getHealth() * 5);
            }
            else {
                Blaze blaze = (Blaze) spawn_event.getEntity();
                Objects.requireNonNull(blaze.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(blaze.getHealth() * 3);
                blaze.setHealth(blaze.getHealth() * 2);
            }
        }
    }
}
