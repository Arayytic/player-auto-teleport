package org.github.playerautoteleport.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * Interface to handle a GUI.
 */
public interface GUIHolder extends InventoryHolder {

    /**
     * Returns the inventory with the contents of this GUI.
     *
     * @return New inventory with the content.
     */
    @Override
    @NotNull
    Inventory getInventory();

    /**
     * Handles the click in the inventory of this GUI.
     *
     * @param event The InventoryClickEvent provided by Bukkit.
     */
    void handleInventoryClick(InventoryClickEvent event);
}
