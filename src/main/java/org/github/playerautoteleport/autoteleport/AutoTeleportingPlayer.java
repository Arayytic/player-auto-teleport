package org.github.playerautoteleport.autoteleport;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class AutoTeleportingPlayer {

    private final Player bukkitPlayer;
    private final AutoTeleportSetup autoTeleportSetup;

    /**
     * The default constructor of an auto teleporting player
     *
     * @param bukkitPlayer the bukkit player for the teleport
     */
    public AutoTeleportingPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.autoTeleportSetup = new AutoTeleportSetup();
    }

    /**
     * Returns the bukkit player.
     *
     * @return The Bukkit Player.
     */
    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

    /**
     * Returns the setup to start the auto walk.
     *
     * @return the setup for the auto walk
     */
    public AutoTeleportSetup getAutoWalkSetup() {
        return autoTeleportSetup;
    }

    /**
     * Teleports the bukkit player to new location.
     */
    public void teleport() {
        Location playerLocation = bukkitPlayer.getLocation();

        playerLocation = new Location(playerLocation.getWorld(), playerLocation.getX() + autoTeleportSetup.getBlocksEast(), playerLocation.getBlockY(), playerLocation.getZ());
        playerLocation = new Location(playerLocation.getWorld(), playerLocation.getX() - autoTeleportSetup.getBlocksWest(), playerLocation.getBlockY(), playerLocation.getZ());
        playerLocation = new Location(playerLocation.getWorld(), playerLocation.getX(), playerLocation.getBlockY(), playerLocation.getZ() + autoTeleportSetup.getBlocksSouth());
        playerLocation = new Location(playerLocation.getWorld(), playerLocation.getX(), playerLocation.getBlockY(), playerLocation.getZ() - autoTeleportSetup.getBlocksNorth());

        Location overPlayerLocation = new Location(playerLocation.getWorld(), playerLocation.getX(), playerLocation.getBlockY() + 1, playerLocation.getZ());

        if (playerLocation.getBlock().isSolid() || overPlayerLocation.getBlock().isSolid()) {
            bukkitPlayer.sendMessage("§cDer Teleport konnte nicht durchgeführt werden, weil die Ziel-Position blockiert ist!");
            return;
        }

        bukkitPlayer.teleport(playerLocation);
    }
}
