package info.iaero;

import info.iaero.commands.BlockEnchantCommand;
import info.iaero.listeners.PlayerEnchantListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockEnchant extends JavaPlugin {
	
	public static BlockEnchant plugin;
	public String prefix  = "§6BE §7> §r";
	public String version = "2.0";
	
	public BlockEnchant() {
		plugin = this;
	}
	
	public void onEnable() {
		setupPlugin();
		getServer().getLogger().info("BlockEnchant" + " has been enabled");
	}
	
	public void onDisable() {
		getServer().getLogger().info("BlockEnchant" + " has been disabled");
	}
	
	void setupPlugin() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerEnchantListener(), this);
		
		getCommand("blockenchant").setExecutor(new BlockEnchantCommand(this));
		
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
