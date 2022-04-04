package com.towering.main;

import org.bukkit.DyeColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class Lapiz implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        if (e.getInventory() instanceof EnchantingInventory) {
            EnchantingInventory inv = (EnchantingInventory) e.getInventory();
            Dye d = new Dye();
            d.setColor(DyeColor.BLUE);
            ItemStack i = d.toItemStack();
            i.setAmount(20);
            inv.setItem(1, i);
        }
    }
}
