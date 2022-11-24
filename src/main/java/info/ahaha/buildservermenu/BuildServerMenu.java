package info.ahaha.buildservermenu;

import info.ahaha.buildservermenu.cmd.ConfigCommand;
import info.ahaha.buildservermenu.cmd.MenuCommand;
import info.ahaha.buildservermenu.listener.MenuListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class BuildServerMenu extends JavaPlugin {
    private final Map<UUID, Inventory> openedGuis = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new MenuCommand(this));
        getCommand("menuconfig").setExecutor(new ConfigCommand(this));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new MenuListener(this), this);
    }

    @Override
    public void onDisable() {}

    public Map<UUID, Inventory> getOpenedGuis() {
        return openedGuis;
    }
}
