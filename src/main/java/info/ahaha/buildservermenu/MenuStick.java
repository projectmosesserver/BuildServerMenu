package info.ahaha.buildservermenu;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuStick {
    private static final String menuStickName = "Menu Stick";
    private static final Enchantment menuStickEnchantment = Enchantment.MENDING;

    public static ItemStack getMenuStick() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName(menuStickName);
        meta.addEnchant(menuStickEnchantment, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stick.setItemMeta(meta);
        return stick;
    }

    public static boolean isMenuStick(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;
        return meta.getDisplayName().equals(menuStickName) && meta.getEnchants().containsKey(menuStickEnchantment);
    }
}
