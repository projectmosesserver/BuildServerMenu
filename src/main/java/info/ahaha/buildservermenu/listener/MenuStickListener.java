package info.ahaha.buildservermenu.listener;

import info.ahaha.buildservermenu.BuildServerMenu;
import info.ahaha.buildservermenu.MenuStick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static info.ahaha.buildservermenu.Gui.getGui;

public class MenuStickListener implements Listener {
    private final BuildServerMenu plugin;

    public MenuStickListener(BuildServerMenu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            return;

        ItemStack item = event.getItem();
        if (item == null) return;
        if (!MenuStick.isMenuStick(item)) return;

        Inventory gui = getGui(plugin);
        plugin.getOpenedGuis().put(event.getPlayer().getUniqueId(), gui);
        event.getPlayer().openInventory(gui);
    }
}
