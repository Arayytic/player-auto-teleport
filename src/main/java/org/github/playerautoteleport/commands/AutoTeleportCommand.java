package org.github.playerautoteleport.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.github.playerautoteleport.autoteleport.AutoTeleportingPlayerCreator;
import org.github.playerautoteleport.gui.TeleportControlGUI;
import org.github.playerautoteleport.main.PlayerAutoTeleport;
import org.jetbrains.annotations.NotNull;

/**
 * Command which opens the teleport control gui
 */
public class AutoTeleportCommand implements CommandExecutor {

    private final PlayerAutoTeleport plugin;

    /**
     * The default constructor
     *
     * @param plugin Instance of the plugin
     */
    public AutoTeleportCommand(PlayerAutoTeleport plugin) {
        this.plugin = plugin;
    }

    /**
     * Executes this command with the provided arguments
     * Sets a new map for the game
     *
     * @param sender  The sender which executes this command
     * @param command The Bukkit {@link org.bukkit.command.Command} representation
     * @param label   The label of this command
     * @param args    The arguments of this command
     * @return true if this command was executed successfully
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 0) {
            return true;
        }

        TeleportControlGUI teleportControlGUI = new TeleportControlGUI(plugin, AutoTeleportingPlayerCreator.get(player));
        player.openInventory(teleportControlGUI.getInventory());

        return false;
    }
}
