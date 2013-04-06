package info.iaero.listeners;

import info.iaero.BlockEnchant;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class PlayerEnchantListener implements Listener {

	@EventHandler
	public void onTableOpen(PrepareItemEnchantEvent event) {

		Player player = event.getEnchanter();
		int maxLevel = Integer.parseInt(BlockEnchant.plugin.getConfig().getString("Level"));

		if(!player.isOp() || !player.hasPermission("blockenchant.enchant")) {

			for (int i = 0; i < event.getExpLevelCostsOffered().length; i++) {

				int offeredLevels = event.getExpLevelCostsOffered()[i];

				if(offeredLevels > maxLevel) {

					event.getExpLevelCostsOffered()[i] = maxLevel;

				}

			}

		}

	}

}
