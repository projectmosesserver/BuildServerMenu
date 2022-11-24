package info.ahaha.buildservermenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GUI {
    private static final int inventorySize = 54;

    public static Inventory getGui(BuildServerMenu plugin) {
        List<ItemStack> items = TPWorld.getWorldNames(plugin.getServer()).stream().map(s -> {
            ItemStack item = new ItemStack(Material.ENDER_PEARL);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(getFixedDisplayName(plugin.getConfig(), s));
            meta.setLore(Collections.singletonList(getLore(plugin.getConfig(), s)));
            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
            return item;
        }).limit(inventorySize).collect(Collectors.toList());
        Inventory gui = Bukkit.createInventory(null, inventorySize, "Menu");
        for (int i = 0; i < items.size(); i++) {
            gui.setItem(i, items.get(i));
        }
        return gui;
    }

    private static String getFixedDisplayName(FileConfiguration config, String worldName) {
        String displayName = getDisplayName(config, worldName);
        if (displayName.equals(worldName)) {
            return displayName;
        }
        return displayName + " (" + worldName + ")";
    }

    private static String getDisplayName(FileConfiguration config, String worldName) {
        String displayName = config.getString("worlds." + worldName + ".displayName");
        return displayName != null ? displayName : worldName;
    }

    public static String getWorldName(String fixedDisplayName) {
        if (fixedDisplayName.matches(".*\\(.*\\)")) {
            return fixedDisplayName.split("(\\()|(\\))")[1];
        }
        return fixedDisplayName;
    }

    public static String getLore(FileConfiguration config, String worldName) {
        String lore = config.getString("worlds." + worldName + ".lore");
        return lore != null ? lore : getDisplayName(config, worldName) + "にTPします";
    }
}
