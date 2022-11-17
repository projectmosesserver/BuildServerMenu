package info.ahaha.buildservermenu.listener;

import info.ahaha.buildservermenu.BuildServerMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class MenuCloseListener implements Listener {
    private final BuildServerMenu plugin;

    public MenuCloseListener(BuildServerMenu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        plugin.openedGuis.remove(event.getPlayer().getUniqueId());
    }
}
