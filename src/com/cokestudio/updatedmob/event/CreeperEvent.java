package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class CreeperEvent implements Listener {
    @EventHandler
    public void CreeperSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Creeper) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Creeper creeper = (Creeper) spawn_event.getEntity();
                creeper.setPowered(true);
                creeper.setCustomName(ChatColor.GRAY + "Creeper");
                Objects.requireNonNull(creeper.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(creeper.getHealth() * 3);
                creeper.setHealth(creeper.getHealth() * 3);
                creeper.setFuseTicks(10);
                creeper.setExplosionRadius(creeper.getExplosionRadius() + 10);
            }
            else if (choice < 35) {
                Creeper creeper = (Creeper) spawn_event.getEntity();
                creeper.setPowered(true);
                creeper.setCustomName(ChatColor.GOLD + "Creeper");
                Objects.requireNonNull(creeper.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(creeper.getHealth() * 5);
                creeper.setHealth(creeper.getHealth() * 5);
                creeper.setFuseTicks(0);
                creeper.setExplosionRadius(creeper.getExplosionRadius() + 15);
            }
            else {
                Creeper creeper = (Creeper) spawn_event.getEntity();
                Objects.requireNonNull(creeper.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(creeper.getHealth() * 2);
                creeper.setHealth(creeper.getHealth() * 2);
                creeper.setFuseTicks(20);
                creeper.setExplosionRadius(creeper.getExplosionRadius() + 5);
            }
        }
    }
}
