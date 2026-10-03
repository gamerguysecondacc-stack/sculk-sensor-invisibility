package com.Gurke_999.invisbleSculkSensors;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockReceiveGameEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

public class SculkSensorTriggered implements Listener {
    @EventHandler
    public void onSculkSensorActivated(BlockReceiveGameEvent event) {
        Block block = event.getBlock();
        Material blockType = block.getType();


        if (event.getEntity() instanceof Player) {
            Player plr = (Player) event.getEntity();
            if (blockType == Material.SCULK_SENSOR || blockType == Material.CALIBRATED_SCULK_SENSOR) {
                // Bukkit.getLogger().info("Sculk Sensor Activated");
                // plr.sendMessage("Sculk Sensor Activated");
                if (plr.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    event.setCancelled(true);
                    // plr.sendMessage("cancel");
                }
            }
        }
    }

    @EventHandler
    public void onSculkSensorSteppedOn(PlayerInteractEvent event) {
        Player plr = event.getPlayer();
        if (event.getAction() == Action.PHYSICAL) {
            Material block = event.getClickedBlock().getType();
            if (block == Material.SCULK_SENSOR || block == Material.CALIBRATED_SCULK_SENSOR) {
                if (plr.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
