package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class EvokerEvent implements Listener {
    @EventHandler
    public void DrownedSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Evoker) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Evoker evoker = (Evoker) spawn_event.getEntity();
                evoker.setCustomName(ChatColor.GRAY + "Evoker");
                Objects.requireNonNull(evoker.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(evoker.getHealth() * 3);
                evoker.setHealth(evoker.getHealth() * 3);
            }
            else if (choice < 35) {
                Evoker evoker = (Evoker) spawn_event.getEntity();
                evoker.setCustomName(ChatColor.GOLD + "Evoker");
                Objects.requireNonNull(evoker.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(evoker.getHealth() * 5);
                evoker.setHealth(evoker.getHealth() * 5);
            }
            else {
                Evoker evoker = (Evoker) spawn_event.getEntity();
                Objects.requireNonNull(evoker.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(evoker.getHealth() * 2);
                evoker.setHealth(evoker.getHealth() * 2);
            }
        }
    }
}
