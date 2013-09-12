package me.iaero.blockenchant;

import java.io.File;
import me.iaero.blockenchant.commands.BlockEnchantCommand;
import me.iaero.blockenchant.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockEnchant extends JavaPlugin {

    public static BlockEnchant instance() {
        return (BlockEnchant) Bukkit.getPluginManager().getPlugin("BlockEnchant");
    }

    private static int max;

    public static int maxLevel() {
        return max;
    }

    public static void setMaxLevel(int level) {
        max = level;
    }

    public void onEnable() {
        new PlayerListener();
        new BlockEnchantCommand();
        setupConfig();
        super.onEnable();
    }

    private void setupConfig() {
        File file = new File(getDataFolder(), "config.yml");

        if (!file.exists()) {
            getConfig().set("Level", 15);
            saveConfig();
        }

        max = getConfig().getInt("Level");
    }

}
