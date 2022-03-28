package info.ahaha.buildservermenu.gui;

import info.ahaha.buildservermenu.BuildServerMenu;
import info.ahaha.buildservermenu.ItemData;
import info.ahaha.buildservermenu.util.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class GUI {

    private DataManager manager;
    private Inventory gui;

    public GUI() {
        manager = BuildServerMenu.plugin.manager;
        createGUI();
    }

    private void createGUI() {
        String guiType = manager.getConfig().getString("GUIType");
        InventoryType type = null;
        boolean large = false;
        switch (guiType) {
            case "HOPPER":
                type = InventoryType.HOPPER;
                break;
            case "CHEST":
                type = InventoryType.CHEST;
                break;
            case "LARGE":
                large = true;
                break;
        }
        if (type == null && large) {
            this.gui = Bukkit.createInventory(null, 54,manager.getConfig().getString("GUITitle"));
        }else if (type == InventoryType.HOPPER){
            this.gui = Bukkit.createInventory(null, InventoryType.HOPPER,manager.getConfig().getString("GUITitle"));
        }else if (type == InventoryType.CHEST){
            this.gui = Bukkit.createInventory(null, InventoryType.CHEST,manager.getConfig().getString("GUITitle"));
        }

        for (ItemData data : ItemData.data){
            for (int slot : data.getSlots()){
                gui.setItem(slot,data.getItem());
            }
        }
    }

    public Inventory getGui() {
        return gui;
    }

    public void openGUI(Player player){
        player.openInventory(getGui());
    }
}
