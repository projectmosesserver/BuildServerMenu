package info.ahaha.buildservermenu.listener;

import info.ahaha.buildservermenu.ItemData;
import info.ahaha.buildservermenu.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    private final GUI gui;

    public MenuListener(GUI gui) {
        this.gui = gui;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getView().getTopInventory().equals(gui.getGui())) return;
        e.setCancelled(true);
        if (e.getClickedInventory() == null)return;
        if (!e.getClickedInventory().equals(e.getView().getTopInventory()))return;
        ItemStack current = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        if (current == null)return;
        for (ItemData data : ItemData.data){
            if (data.isTpItem()){
                if (current.isSimilar(data.getItem())){
                    player.teleport(data.getLocation());
                    return;
                }
            }
        }
    }
}
