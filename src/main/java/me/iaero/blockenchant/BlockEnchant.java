package me.iaero.blockenchant;
 
import java.io.File;
 
import me.iaero.blockenchant.commands.BlockEnchantCommand;
import me.iaero.blockenchant.listeners.PlayerListener;
import me.iaero.blockenchant.utils.ChatHelper;
 
import org.bukkit.plugin.java.JavaPlugin;
 
public class BlockEnchant extends JavaPlugin {
 
    private static BlockEnchant blockenchant;
    public static ChatHelper chat;
    private static int max;
 
    public static BlockEnchant getInstance() {
        return blockenchant;
    }
 
    public static ChatHelper getChat() {
        return chat;
    }
 
    public static int maxLevel() {
        return max;
    }
 
    public static void setMaxLevel(int level) {
        max = level;
    }
 
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
 
    private void setupConfig() {
        if (!getConfig().has("Level")) {
            getConfig().set("Level", 15);
        }
    
        max = getConfig().getInt("Level");
    }
 
}
