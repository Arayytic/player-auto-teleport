package org.github.playerautoteleport.autoteleport;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AutoTeleportingPlayerCreator {

    private static final Set<AutoTeleportingPlayer> cachedPlayers = new HashSet<>();

    /**
     * Returns an {@link AutoTeleportingPlayer} from the cached players, found by the bukkit player
     *
     * @param bukkitPLayer the bukkit player to find the {@link AutoTeleportingPlayer}
     * @return the auto teleporting player from cache
     */
    public static AutoTeleportingPlayer get(Player bukkitPLayer) {
        Optional<AutoTeleportingPlayer> cachedPlayer = findPlayerInCache(bukkitPLayer);

        if (cachedPlayer.isPresent()) {
            return cachedPlayer.get();
        }

        AutoTeleportingPlayer autoTeleportingPlayer = new AutoTeleportingPlayer(bukkitPLayer);
        cachedPlayers.add(autoTeleportingPlayer);

        return autoTeleportingPlayer;
    }

    private static Optional<AutoTeleportingPlayer> findPlayerInCache(Player bukkitPlayer) {
        return cachedPlayers.stream()
                .filter(autoTeleportingPlayer -> autoTeleportingPlayer.getBukkitPlayer() == bukkitPlayer)
                .findFirst();
    }
}
