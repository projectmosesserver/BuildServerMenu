package info.ahaha.buildservermenu;

import info.ahaha.buildservermenu.command.MenuCommand;
import info.ahaha.buildservermenu.command.MenuConfigCommand;
import info.ahaha.buildservermenu.command.MenuStickCommand;
import info.ahaha.buildservermenu.listener.GuiListener;
import info.ahaha.buildservermenu.listener.MenuStickListener;
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
        getCommand("menuconfig").setExecutor(new MenuConfigCommand(this));
        getCommand("menustick").setExecutor(new MenuStickCommand());
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GuiListener(this), this);
        pm.registerEvents(new MenuStickListener(this), this);
    }

    @Override
    public void onDisable() {
    }

    public Map<UUID, Inventory> getOpenedGuis() {
        return openedGuis;
    }
}
