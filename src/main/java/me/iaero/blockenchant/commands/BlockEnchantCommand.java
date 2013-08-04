package me.iaero.blockenchant.commands;

import me.iaero.blockenchant.BlockEnchant;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BlockEnchantCommand implements CommandExecutor {

    public BlockEnchantCommand() {
        BlockEnchant.instance().getCommand("blockenchant").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new String[] {
                "§6§lBlockEnchant v" + BlockEnchant.instance().getDescription().getVersion() + " §r| Help & FAQ",
                "  §oWhat does your plugin do?",
                "  §aIt stops you from enchanting over a specified level.",
                "  §oHow can I get this plugin?",
                "  §aYou can head over to http://bit.ly/BE-Bukkit",
                "",
                "§a§o/" + label + " §r- Shows this screen.",
                "§a§o/" + label + " level §r- Shows the max level available.",
                "§a§o/" + label + " set <level> §r- Sets the maximum available level."
            });
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("level")) {
                sender.sendMessage("The maximum available level is: §a" + BlockEnchant.maxLevel());
            } else if (args[0].equalsIgnoreCase("set")) {
                sender.sendMessage("Usage: §a/" + label + " set <number>");
            } else {
                sender.sendMessage("Usage: §a/" + label + " <level, set>");
            }
            return true;
        } else if (args.length >= 2) {
            if (args[0].equalsIgnoreCase("set")) {
                if (sender.isOp() || sender.hasPermission("blockenchant.modify")) {
                    try {
                        int level = Integer.parseInt(args[1]);
                        if (level <= 30) {
                            BlockEnchant.instance().getConfig().set("Level", level);
                            BlockEnchant.instance().saveConfig();
                            BlockEnchant.setMaxLevel(level);
                            sender.sendMessage("Maximum level changed to §a" + level);
                        } else {
                            sender.sendMessage("§4You can't enchant over level 30!");
                        }
                    } catch (Exception e) {
                        sender.sendMessage("§4Incorrect command usage.");
                    }
                } else {
                    sender.sendMessage("Usage: §a/" + label + " <level, set>");
                }
            } else {
                sender.sendMessage("§4You don't have permission to do this.");
            }
            return true;
        }

        return false;
    }

}