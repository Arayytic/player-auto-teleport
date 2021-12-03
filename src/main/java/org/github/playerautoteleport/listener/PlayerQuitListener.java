package org.github.playerautoteleport.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.github.playerautoteleport.autoteleport.AutoTeleportingPlayer;
import org.github.playerautoteleport.autoteleport.AutoTeleportingPlayerCreator;

/**
 * Event listener class to handle the quit of a bukkit player
 */
public class PlayerQuitListener implements Listener {

    /**
     * Event to handle the quit of a bukkit player
     *
     * @param event The PlayerQuitEvent provided by Bukkit.
     */
    @EventHandler
    public void handelPlayerQuit(PlayerQuitEvent event) {
        AutoTeleportingPlayer autoTeleportingPlayer = AutoTeleportingPlayerCreator.get(event.getPlayer());
        autoTeleportingPlayer.getAutoWalkSetup().reset();
    }
}
