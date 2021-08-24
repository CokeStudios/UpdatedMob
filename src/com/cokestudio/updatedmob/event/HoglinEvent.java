package com.cokestudio.updatedmob.event;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Hoglin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Objects;
import java.util.Random;

public class HoglinEvent implements Listener {
    @EventHandler
    public void GuardianSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Hoglin) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Hoglin hoglin = (Hoglin) spawn_event.getEntity();
                hoglin.setCustomName(ChatColor.GRAY + "Hoglin");
                Objects.requireNonNull(hoglin.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(hoglin.getHealth() * 3);
                hoglin.setIsAbleToBeHunted(false);
                hoglin.setImmuneToZombification(true);
                hoglin.setHealth(hoglin.getHealth() * 3);
            }
            else if (choice < 35) {
                Hoglin hoglin = (Hoglin) spawn_event.getEntity();
                hoglin.setCustomName(ChatColor.GOLD + "Hoglin");
                Objects.requireNonNull(hoglin.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(hoglin.getHealth() * 5);
                hoglin.setIsAbleToBeHunted(false);
                hoglin.setImmuneToZombification(true);
                hoglin.setHealth(hoglin.getHealth() * 5);
            }
            else {
                Hoglin hoglin = (Hoglin) spawn_event.getEntity();
                Objects.requireNonNull(hoglin.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(hoglin.getHealth() * 2);
                hoglin.setIsAbleToBeHunted(false);
                hoglin.setImmuneToZombification(true);
                hoglin.setHealth(hoglin.getHealth() * 2);
            }
        }
    }
}
