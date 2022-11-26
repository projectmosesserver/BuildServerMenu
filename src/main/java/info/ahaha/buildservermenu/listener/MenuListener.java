package info.ahaha.buildservermenu.listener;

import info.ahaha.buildservermenu.BuildServerMenu;
import info.ahaha.buildservermenu.GUI;
import info.ahaha.buildservermenu.WorldUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {
    private final BuildServerMenu plugin;

    public MenuListener(BuildServerMenu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Inventory gui = plugin.getOpenedGuis().get(player.getUniqueId());
        if (gui == null || !gui.equals(e.getView().getTopInventory())) return;
        e.setCancelled(true);
        if (e.getClickedInventory() == null) return;
        if (!e.getClickedInventory().equals(e.getView().getTopInventory())) return;
        ItemStack current = e.getCurrentItem();
        if (current == null) return;
        Location spawnLocation = WorldUtil.getSpawnLocation(player.getServer(), GUI.getWorldName(current.getItemMeta().getDisplayName()));
        if (spawnLocation == null) return;
        player.teleport(spawnLocation);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        plugin.getOpenedGuis().remove(event.getPlayer().getUniqueId());
    }
}
