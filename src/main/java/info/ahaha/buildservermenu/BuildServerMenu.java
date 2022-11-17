package info.ahaha.buildservermenu;

import info.ahaha.buildservermenu.cmd.Cmd;
import info.ahaha.buildservermenu.listener.MenuCloseListener;
import info.ahaha.buildservermenu.listener.MenuListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class BuildServerMenu extends JavaPlugin {
    public final Map<UUID, Inventory> openedGuis = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new Cmd(this));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new MenuListener(this), this);
        pm.registerEvents(new MenuCloseListener(this), this);
    }

    @Override
    public void onDisable() {
    }
}
