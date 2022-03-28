package info.ahaha.buildservermenu.util;

import info.ahaha.buildservermenu.ItemData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CreateItemData {

    private DataManager manager;

    public CreateItemData(DataManager manager) {
        this.manager = manager;
    }

    public void create(){
        for (String s : manager.getConfig().getStringList("Items")) {
            ItemStack item = new ItemStack(Material.valueOf(manager.getConfig().getString(s + ".Material")));
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(manager.getConfig().getString(s + ".Name"));
            if (!manager.getConfig().getStringList(s + ".Lore").isEmpty()) {
                meta.setLore(new ArrayList<>(manager.getConfig().getStringList(s + ".Lore")));
            }
            if (manager.getConfig().getBoolean(s + ".Glow")) {
                meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            item.setItemMeta(meta);
            List<Integer> slots = new ArrayList<>(manager.getConfig().getIntegerList(s + ".Slots"));
            Location location = null;
            for (int i : slots) {
                for (int c : manager.getConfig().getIntegerList("TPSlot")) {
                    if (i == c) {
                        String world = manager.getConfig().getString("Location." + c + ".World");
                        int x = manager.getConfig().getInt("Location." + c + ".X");
                        int y = manager.getConfig().getInt("Location." + c + ".Y");
                        int z = manager.getConfig().getInt("Location." + c + ".Z");
                        location = new Location(Bukkit.getWorld(world), x, y, z);
                        break;
                    }
                }
            }
            ItemData data = new ItemData(s, item, slots, location);
            ItemData.data.add(data);
        }
    }
}
