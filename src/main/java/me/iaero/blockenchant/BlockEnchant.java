package me.iaero.blockenchant;

import java.io.File;

import me.iaero.blockenchant.commands.BlockEnchantCommand;
import me.iaero.blockenchant.listeners.PlayerListener;

import org.bukkit.plugin.java.JavaPlugin;

public class BlockEnchant extends JavaPlugin {

    @Override
    public void onEnable() {
        blockenchant = this;

        new PlayerListener();
        new BlockEnchantCommand();

        setupConfig();
    }
    
    @Override
    public void onDisable() {
        blockenchant = null;
    }

    private static BlockEnchant blockenchant;

    public static BlockEnchant getInstance() {
        return blockenchant;
    }

    private static int max;

    public static int maxLevel() {
        return max;
    }

    public static void setMaxLevel(int level) {
        max = level;
    }

    private void setupConfig() {
        File file = new File(getDataFolder(), "config.yml");

        if ( ! file.exists()) {
            try {
                getConfig().set("Level", 15);
                saveConfig();
            } catch(Exception e) { }
        }

        max = getConfig().getInt("Level");
    }

}
