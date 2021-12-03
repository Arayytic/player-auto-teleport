package org.github.playerautoteleport.listener;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.github.playerautoteleport.gui.GUIHolder;

/**
 * Event listener class to handle the click in the inventory
 * of a {@link GUIHolder}
 */
public class InventoryClickListener implements Listener {

    /**
     * Event to deny the click in the inventory of a {@link GUIHolder}
     *
     * @param event The InventoryClickEvent provided by Bukkit.
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        // Check if the clicked inventory or the clicked item is null
        if (event.getClickedInventory() == null || event.getCurrentItem() == null) {
            return;
        }

        InventoryHolder inventoryHolder = event.getClickedInventory().getHolder();

        // Check if the InventoryHolder has the correct type
        if (!(inventoryHolder instanceof GUIHolder)) {
            return;
        }

        event.setResult(Event.Result.DENY);
        ((GUIHolder) inventoryHolder).handleInventoryClick(event);
    }
}
