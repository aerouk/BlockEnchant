package me.iaero.blockenchant;

import java.io.File;

import me.iaero.blockenchant.commands.BlockEnchantCommand;
import me.iaero.blockenchant.listeners.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockEnchant extends JavaPlugin
{
    public static BlockEnchant instance()
    {
        return (BlockEnchant) Bukkit.getPluginManager().getPlugin("BlockEnchant");
    }

    private static int max;

    public static int maxLevel()
    {
        return max;
    }

    public static void setMaxLevel(int level)
    {
        max = level;
    }

    @Override
    public void onEnable()
    {
        new PlayerListener();
        new BlockEnchantCommand();

        setupConfig();
    }

    private void setupConfig()
    {
        File file = new File(getDataFolder(), "config.yml");

        if (!file.exists())
        {
            try
            {
                getConfig().set("Level", 15);
                saveConfig();
            }
            catch(Exception e)
            {
            }
        }

        max = getConfig().getInt("Level");
    }
}
