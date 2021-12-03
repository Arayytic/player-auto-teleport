package org.github.playerautoteleport.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.github.playerautoteleport.autoteleport.AutoTeleportSetup;
import org.github.playerautoteleport.autoteleport.AutoTeleportingPlayer;
import org.github.playerautoteleport.autoteleport.AutoTeleportingPlayerCreator;
import org.github.playerautoteleport.main.PlayerAutoTeleport;
import org.github.playerautoteleport.utils.ItemBuilder;
import org.jetbrains.annotations.NotNull;

public class TeleportControlGUI implements GUIHolder {

    private final PlayerAutoTeleport plugin;
    private final AutoTeleportingPlayer autoTeleportingPlayer;

    /**
     * The default constructor of the gui.
     *
     * @param plugin instance of the plugin
     */
    public TeleportControlGUI(PlayerAutoTeleport plugin, AutoTeleportingPlayer autoTeleportingPlayer) {
        this.plugin = plugin;
        this.autoTeleportingPlayer = autoTeleportingPlayer;
    }

    @Override
    public @NotNull Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, 9 * 5, "§3Teleport-Controller");

        ItemStack northItem = new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§aBlöcke in Richtung §cNorden")
                .buildAsCustomSkull(plugin, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWM3Yzk3MmU2Nzg1ZDZiMGFjZWI3NzlhYmRkNzcwMmQ5ODM0MWMyNGMyYTcxZTcwMjkzMGVjYTU4MDU1In19fQ==");

        ItemStack westItem = new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§aBlöcke in Richtung §cWesten")
                .buildAsCustomSkull(plugin, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjdlMTY1YzNlZGM1NTQxZDQ2NTRjNDcyODg3MWU2OTA4ZjYxM2ZjMGVjNDZlODIzYzk2ZWFjODJhYzYyZTYyIn19fQ==");

        ItemStack southItem = new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§aBlöcke in Richtung §cSüden")
                .buildAsCustomSkull(plugin, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY1NzJlNjU1NzI1ZDc4Mzc1YTk4MTdlYjllZThiMzc4MjljYTFmZWE5M2I2MDk1Y2M3YWExOWU1ZWFjIn19fQ==");

        ItemStack eastItem = new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§aBlöcke in Richtung §cOsten")
                .buildAsCustomSkull(plugin, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE1N2Q2NWIxOTkyMWM3NjBmZjQ5MTBiMzQwNDQ1NWI5YzJlZTM2YWZjMjAyZDg1MzhiYWVmZWM2NzY5NTMifX19");

        inventory.setItem(11, northItem);
        inventory.setItem(12, westItem);
        inventory.setItem(14, southItem);
        inventory.setItem(15, eastItem);

        ItemBuilder northGreenGlassPaneBuilder = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setDisplayName("§eAnzahl der Blöcke ändern")
                .addLoreLine("§f➜ §7" + autoTeleportingPlayer.getAutoWalkSetup().getBlocksNorth() + " Blöcke Richtung Norden")
                .addLoreLine("§f➜ §7§oRechtsklick: Verringern")
                .addLoreLine("§f➜ §7§oLinksklick: Erhöhen");

        ItemBuilder westGreenGlassPaneBuilder = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setDisplayName("§eAnzahl der Blöcke ändern")
                .addLoreLine("§f➜ §7" + autoTeleportingPlayer.getAutoWalkSetup().getBlocksWest() + " Blöcke Richtung Westen")
                .addLoreLine("§f➜ §7§oRechtsklick: Verringern")
                .addLoreLine("§f➜ §7§oLinksklick: Erhöhen");

        ItemBuilder southGreenGlassPaneBuilder = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setDisplayName("§eAnzahl der Blöcke ändern")
                .addLoreLine("§f➜ §7" + autoTeleportingPlayer.getAutoWalkSetup().getBlocksSouth() + " Blöcke Richtung Süden")
                .addLoreLine("§f➜ §7§oRechtsklick: Verringern")
                .addLoreLine("§f➜ §7§oLinksklick: Erhöhen");

        ItemBuilder eastGreenGlassPaneBuilder = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setDisplayName("§eAnzahl der Blöcke ändern")
                .addLoreLine("§f➜ §7" + autoTeleportingPlayer.getAutoWalkSetup().getBlocksEast() + " Blöcke Richtung Osten")
                .addLoreLine("§f➜ §7§oRechtsklick: Verringern")
                .addLoreLine("§f➜ §7§oLinksklick: Erhöhen");

        inventory.setItem(20, northGreenGlassPaneBuilder.build());
        inventory.setItem(21, westGreenGlassPaneBuilder.build());
        inventory.setItem(23, southGreenGlassPaneBuilder.build());
        inventory.setItem(24, eastGreenGlassPaneBuilder.build());

        ItemStack startItem = new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName("§eAuto-Teleport starten")
                .buildAsCustomSkull(plugin, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzFlZWFkMWUxN2VjZjUzZjIyMjQ3NWRhZWViYWQzNTI2MTM3Yjc5N2U1Y2I3NjdiOThhYzVlN2ViYjlmZTkifX19");

        inventory.setItem(40, startItem);

        return inventory;
    }

    @Override
    public void handleInventoryClick(InventoryClickEvent event) {

        // Check if who-clicked ist a bukkit player
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        AutoTeleportingPlayer autoTeleportingPlayer = AutoTeleportingPlayerCreator.get(player);
        AutoTeleportSetup autoTeleportSetup = autoTeleportingPlayer.getAutoWalkSetup();

        // Check if current item or current item meta is null
        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) {
            return;
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§eAuto-Teleport starten")) {
            autoTeleportingPlayer.teleport();
            player.closeInventory();
        } else if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE &&
                event.getCurrentItem().getItemMeta().getDisplayName().equals("§eAnzahl der Blöcke ändern")) {

            ItemStack itemAboveClicked = event.getInventory().getItem(event.getRawSlot() - 9);

            if (itemAboveClicked == null || itemAboveClicked.getItemMeta() == null) {
                return;
            }

            if (event.getClick() == ClickType.LEFT) {
                if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Norden")) {
                    autoTeleportSetup.addBlockNorth();
                } else if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Westen")) {
                    autoTeleportSetup.addBlockWest();
                } else if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Süden")) {
                    autoTeleportSetup.addBlockSouth();
                } else if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Osten")) {
                    autoTeleportSetup.addBlockEast();
                }
            } else if (event.getClick() == ClickType.RIGHT) {
                if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Norden") && autoTeleportSetup.getBlocksNorth() > 0) {
                    autoTeleportSetup.removeBlockNorth();
                } else if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Westen") && autoTeleportSetup.getBlocksWest() > 0) {
                    autoTeleportSetup.removeBlockWest();
                } else if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Süden") && autoTeleportSetup.getBlocksSouth() > 0) {
                    autoTeleportSetup.removeBlockSouth();
                } else if (itemAboveClicked.getItemMeta().getDisplayName().endsWith("Osten") && autoTeleportSetup.getBlocksEast() > 0) {
                    autoTeleportSetup.removeBlockEast();
                }
            }

            player.openInventory(getInventory());
        }
    }
}
