package org.github.playerautoteleport.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public class ItemBuilder {

    private final List<String> lore = new ArrayList<>();
    private final ItemStack item;
    private ItemMeta meta;

    /**
     * The default constructor to create an ItemBuilder.
     *
     * @param material material of the target item to build
     */
    @Deprecated
    public ItemBuilder(Material material) {
        item = new ItemStack(material, 1, (short) 3);
        meta = item.getItemMeta();
    }

    /**
     * The default constructor to create an ItemBuilder.
     *
     * @param material    material of the target item to build
     * @param amount      amount of the target item to build
     * @param displayname displayname of the target item to build
     */
    @Deprecated
    public ItemBuilder(Material material, int amount, String displayname) {
        item = new ItemStack(material, amount);
        meta.setDisplayName(displayname);
        meta = item.getItemMeta();
    }

    /**
     * Builds item with a custom texture on a player head
     *
     * @param plugin instance of the plugin
     * @param url    URL to the custom texture
     * @return the ItemBuilder
     */
    @Deprecated
    public ItemStack buildAsCustomSkull(Plugin plugin, String url) {
        if (item.getType() != Material.PLAYER_HEAD) {
            return item;
        }

        SkullMeta skullMeta = (SkullMeta) meta;
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Method method = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            method.setAccessible(true);
            method.invoke(skullMeta, profile);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            plugin.getLogger().log(Level.WARNING, "§cFailed to set custom texture from url: " + url);
        }

        skullMeta.setLore(lore);
        item.setItemMeta(skullMeta);

        return item;
    }

    /**
     * Adds a line to the lore of the item
     *
     * @param line lore line to add to the item
     * @return the ItemBuilder
     */
    public ItemBuilder addLoreLine(String line) {
        lore.add(line);
        return this;
    }

    @Deprecated
    public ItemBuilder setDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    @Deprecated
    public ItemBuilder setBannerColor(DyeColor c) {
        ((BannerMeta) meta).setBaseColor(c);
        return this;
    }

    @Deprecated
    public ItemBuilder setUnbreakable(boolean value) {
        meta.setUnbreakable(value);
        return this;
    }

    @Deprecated
    public ItemStack build() {
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

