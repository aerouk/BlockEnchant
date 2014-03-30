package me.iaero.blockenchant.listeners;

import me.iaero.blockenchant.BlockEnchant;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class PlayerListener implements Listener {

    public PlayerListener() {
        Bukkit.getPluginManager().registerEvents(this, BlockEnchant.instance());
    }

    @EventHandler (ignoreCancelled = true)
    public void onItemPrepare(PrepareItemEnchantEvent event) {
        Player player = event.getEnchanter();

        if (!player.isOp() || !player.hasPermission("blockenchant.enchant")) {
            for (int i = 0; i < event.getExpLevelCostsOffered().length; i++) {
                int offered = event.getExpLevelCostsOffered()[i];

                if (offered > BlockEnchant.maxLevel()) {
                    event.getExpLevelCostsOffered()[i] = BlockEnchant.maxLevel();
                }
            }
        }
    }

}