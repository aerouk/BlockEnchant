package me.iaero.blockenchant.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatHelper {

    /**
     * Sends a list of messages to the specified CommandSender with '&' colour
     * codes translated.
     *
     * @param sender player to send the message to
     * @param message message to send to the player
     */
    public void sendColorMessage(CommandSender sender, String[] message) {
        for (String str : message) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
        }
    }

    /**
     * Sends a message to the specified CommandSender with '&' colour codes
     * translated.
     *
     * @param sender sender to send the message to
     * @param message message to send to the sender
     */
    public void sendColorMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
