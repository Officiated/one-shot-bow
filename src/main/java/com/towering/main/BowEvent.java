package com.towering.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;



public class BowEvent implements Listener {


    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        Entity entityDamager = event.getDamager();
        long distance;
        switch (entityDamager.getWorld().getName()) {
            case "HolidayResort":
            case "valleyside":
            case "AlaskanVillage":
            case "survivalgames4":
            case "Zone85":
            case "Breeze2":
            case "Turbulence":
            case "moon":
            case "breeze1":
            case "isla":
            case "avaricia":
            case "secret":
            case "gunslinger":
            case "jurassic":
            case "candyland":
            case "highway":

            if (entityDamager instanceof Arrow) {
            Arrow arrow = (Arrow) entityDamager;
            ProjectileSource shooter = arrow.getShooter();

                if (shooter instanceof Player) {
                Location shooterLocation = ((Player) shooter).getLocation();
                Entity entityHit = event.getEntity();
                    if (entityHit instanceof Player) {
                    Player playerHit = (Player) entityHit;
                    String shooterName = ((Player) shooter).getName();
                    String playerName = playerHit.getName();
                    Location playerHitLocation = playerHit.getLocation();
                    distance = (long) playerHit.getLocation().distance(shooterLocation);
                    distance = Math.round(distance);
                        if (distance <= 10)
                            ((Player) shooter).sendMessage(ChatColor.GREEN + "You hit " + playerName + " from " + distance + " blocks away!");
                        else if (distance <= 25)
                            ((Player) shooter).sendMessage(ChatColor.GOLD + "You hit " + playerName + " from " + distance + " blocks away!");
                        else if (distance <= 34)
                            ((Player) shooter).sendMessage(ChatColor.RED + "You hit " + playerName + " from " + distance + " blocks away!");
                        else {
                            event.setDamage(100);
                            playerHit.getWorld().strikeLightningEffect(playerHitLocation);
                            ((Player) shooter).sendMessage(ChatColor.DARK_RED + "You just ONE SHOT " + playerName + " from " + distance + " blocks away!");
                            playerHit.getWorld().getPlayers().forEach(player -> player.sendMessage(ChatColor.AQUA + playerName + ChatColor.YELLOW + " was just One-Shotted by " + ChatColor.RED + shooterName + ChatColor.YELLOW + "!"));
                        }
                    }
                }
            }
        }
    }
}