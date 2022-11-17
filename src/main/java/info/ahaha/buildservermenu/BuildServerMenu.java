package info.ahaha.buildservermenu;

import info.ahaha.buildservermenu.cmd.Cmd;
import info.ahaha.buildservermenu.listener.MenuListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class BuildServerMenu extends JavaPlugin {
    public final Map<UUID, Inventory> openedGuis = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new Cmd(this));
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
    }

    @Override
    public void onDisable() {
    }
}
