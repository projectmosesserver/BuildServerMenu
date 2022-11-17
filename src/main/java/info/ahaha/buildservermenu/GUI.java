package info.ahaha.buildservermenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

    public static Inventory getGui() {
        List<ItemStack> items = TPWorld.getWorldStrings().stream().map(s -> {
            ItemStack item = new ItemStack(Material.ENDER_PEARL);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(s);
            meta.setLore(Collections.singletonList(s + "にTPします"));
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
}
