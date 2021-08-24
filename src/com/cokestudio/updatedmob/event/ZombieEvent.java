package com.cokestudio.updatedmob.event;

import com.cokestudio.updatedmob.UpdatedMob;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.Random;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class ZombieEvent implements Listener {
    BossBar legendary = Bukkit.createBossBar(ChatColor.DARK_PURPLE + "Legendary Zombie", BarColor.RED, BarStyle.SOLID);
    Plugin plugin = getPlugin(UpdatedMob.class);
    @EventHandler
    public void ZombieSpawnEvent(CreatureSpawnEvent spawn_event) {
        if (spawn_event.getEntity() instanceof Zombie) {
            Random rand = new Random();
            int choice = rand.nextInt(100) + 1;
            if (choice < 25) {
                Zombie zombie = (Zombie) spawn_event.getEntity();
                zombie.setCustomName(ChatColor.GRAY + "Zombie");
                Objects.requireNonNull(zombie.getEquipment()).setHelmet(new ItemStack(Material.LEATHER_HELMET));
                zombie.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                Objects.requireNonNull(zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(zombie.getHealth() * 3);
                zombie.setHealth(zombie.getHealth() * 3);
                zombie.setAdult();
            }
            else if (choice < 35) {
                Zombie zombie = (Zombie) spawn_event.getEntity();
                zombie.setCustomName(ChatColor.GOLD + "Zombie");
                Objects.requireNonNull(zombie.getEquipment()).setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                Objects.requireNonNull(zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(zombie.getHealth() * 4);
                zombie.setHealth(zombie.getHealth() * 4);
                zombie.setAdult();
            }
            else if (choice < 36) {
                boolean enabled = plugin.getConfig().getBoolean("legendery_zombie_enabled");
                if (enabled) {
                    Bukkit.broadcastMessage("A legendary zombie spawned at " + spawn_event.getLocation().getX() + ", " + spawn_event.getLocation().getY() + ", " + spawn_event.getLocation().getZ());
                    Zombie zombie = (Zombie) spawn_event.getEntity();
                    zombie.setCustomName(ChatColor.DARK_PURPLE + "Legendary Zombie");
                    zombie.setBaby();
                    Objects.requireNonNull(zombie.getEquipment()).setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    chestplate.addEnchantment(Enchantment.THORNS, 1);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    zombie.getEquipment().setChestplate(chestplate);
                    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                    chestplate.addEnchantment(Enchantment.THORNS, 1);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    zombie.getEquipment().setLeggings(leggings);
                    zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                    Objects.requireNonNull(zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(zombie.getHealth() * 10);
                    zombie.setHealth(zombie.getHealth() * 10);
                    Objects.requireNonNull(zombie.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(2.5D);
                /*
                legendary.setProgress(1.0f);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (Player p : legendary.getPlayers()) {
                            if (!zombie.getNearbyEntities(15, 5, 15).contains(p)) {
                                System.out.println(zombie.getNearbyEntities(15, 5, 15));
                                legendary.removePlayer(p);
                            }
                        }

                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                            if (zombie.getNearbyEntities(15, 5, 15).contains(player)) {
                                legendary.addPlayer(player);
                                legendary.setProgress(zombie.getHealth() / 200);
                                if (legendary.getProgress() == 0.0f) {
                                    legendary.removeAll();
                                }
                            }
                        }
                    }
                }.runTaskTimer(getPlugin(UpdatedMob.class), 0, 1);
                */
                }
            }
            else {
                Zombie zombie = (Zombie) spawn_event.getEntity();
                Objects.requireNonNull(zombie.getEquipment()).setHelmet(new ItemStack(Material.LEATHER_HELMET));
                zombie.getEquipment().setHelmetDropChance(0.0f);
                Objects.requireNonNull(zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(zombie.getHealth() * 1.5);
                //zombie.setMaxHealth(zombie.getHealth() * 1.5);
                zombie.setHealth(zombie.getHealth() * 1.5);
                zombie.damage(10);
                zombie.setAdult();
            }
        }
    }

    @EventHandler
    public void ZombieDeathEvent(EntityDeathEvent death_event) {
        if (death_event.getEntity() instanceof Zombie && death_event.getEntity().getCustomName() != null) {
            Entity zombie = death_event.getEntity();
            if (zombie.getCustomName().equals(ChatColor.GRAY + "Zombie")) {
                death_event.getDrops().clear();
                death_event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 5));
                death_event.getDrops().add(new ItemStack(Material.IRON_INGOT, 1));
                death_event.getDrops().add(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
            }
            else if (zombie.getCustomName().equals(ChatColor.GOLD + "Zombie")) {
                death_event.getDrops().clear();
                death_event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 5));
                death_event.getDrops().add(new ItemStack(Material.IRON_INGOT, 1));
                death_event.getDrops().add(new ItemStack(Material.GOLD_INGOT, 1));
                death_event.getDrops().add(new ItemStack(Material.IRON_CHESTPLATE, 1));
            } else if (zombie.getCustomName().equals(ChatColor.DARK_PURPLE + "Legendary Zombie")) {
                death_event.getDrops().clear();
                death_event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 10));
                death_event.getDrops().add(new ItemStack(Material.IRON_BLOCK, 1));
                death_event.getDrops().add(new ItemStack(Material.GOLD_BLOCK, 1));
                death_event.getDrops().add(new ItemStack(Material.DIAMOND_BLOCK, 3));
                death_event.getDrops().add(new ItemStack(Material.DIAMOND_HELMET, 1));

                ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                chestplate.addEnchantment(Enchantment.THORNS, 1);
                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

                ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                chestplate.addEnchantment(Enchantment.THORNS, 1);
                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

                death_event.getDrops().add(chestplate);
                death_event.getDrops().add(leggings);

                death_event.getDrops().add(new ItemStack(Material.DIAMOND_BOOTS, 1));
            }
            else {
                death_event.getDrops().clear();
                death_event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 5));
            }
        }
    }
}