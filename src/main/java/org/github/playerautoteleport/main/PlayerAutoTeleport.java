package org.github.playerautoteleport.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.github.playerautoteleport.commands.AutoTeleportCommand;
import org.github.playerautoteleport.listener.InventoryClickListener;

/**
 * Class which initializes the plugin.
 * {@link PlayerAutoTeleport#onEnable()} is called upon plugin startup.
 */
public class PlayerAutoTeleport extends JavaPlugin {

    /**
     * The startup logic
     */
    @Override
    public void onEnable() {
        registerCommands();
        registerEventListener();
    }

    /**
     * Initializes all required event listener for this spigot plugin.
     */
    private void registerEventListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new InventoryClickListener(), this);
    }

    /**
     * Initializes all required commands for this spigot plugin.
     */
    private void registerCommands() {
        getCommand("autoteleport").setExecutor(new AutoTeleportCommand(this));
    }
}
