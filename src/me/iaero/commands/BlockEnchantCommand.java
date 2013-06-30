package me.iaero.commands;

import me.iaero.BlockEnchant;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockEnchantCommand implements CommandExecutor {

	final BlockEnchant plugin;

	public BlockEnchantCommand(BlockEnchant instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {

		Player player = (Player) sender;

		if(args.length == 0) {

			player.sendMessage(plugin.prefix + "§6§lBlockEnchant §r| Help & FAQ");
			player.sendMessage(plugin.prefix + "  §f§oWhat does your plugin do?");
			player.sendMessage(plugin.prefix + "  §aIt stops you from enchanting over a specified level.");
			player.sendMessage(plugin.prefix + "  §f§oHow can I get this plugin?");
			player.sendMessage(plugin.prefix + "  §aYou can head over to http://bit.ly/BE-Bukkit");
			player.sendMessage(plugin.prefix + "");
			player.sendMessage(plugin.prefix + "§a§o/" + tag + " §r- Shows this screen.");
			player.sendMessage(plugin.prefix + "§a§o/" + tag + " level §r- Shows the max level available.");

		} else if(args.length >= 1) {

			if(args[0].equalsIgnoreCase("level")) {

				player.sendMessage(plugin.prefix + "The max level available is: §a" + plugin.getConfig().getString("Level"));

			} else {

				player.sendMessage(plugin.prefix + "§cInvalid arguments. §rUsage: §a§o/" + tag);

			}

		}

		return false;

	}

}