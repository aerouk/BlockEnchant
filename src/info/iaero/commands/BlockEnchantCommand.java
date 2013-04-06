package info.iaero.commands;

import info.iaero.BlockEnchant;

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

		player.sendMessage(plugin.prefix + "§6§lBlockEnchant §r| Help & FAQ");
		player.sendMessage(plugin.prefix + "  §o§fWhat does your plugin do?");
		player.sendMessage(plugin.prefix + "  §aIt stops you from enchanting over a specified level.");
		player.sendMessage(plugin.prefix + "  §o§fHow can I get this plugin?");
		player.sendMessage(plugin.prefix + "  §aYou can head over to http://bit.ly/BE-Bukkit");
		player.sendMessage(plugin.prefix + "");
		player.sendMessage(plugin.prefix + "§o§a/blockenchant §r- Shows this screen.");

		return false;
		
	}

}
