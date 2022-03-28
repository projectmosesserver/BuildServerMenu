package info.ahaha.buildservermenu;

import info.ahaha.buildservermenu.cmd.Cmd;
import info.ahaha.buildservermenu.gui.GUI;
import info.ahaha.buildservermenu.listener.MenuListener;
import info.ahaha.buildservermenu.util.CreateItemData;
import info.ahaha.buildservermenu.util.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class BuildServerMenu extends JavaPlugin {

    public static BuildServerMenu plugin;
    public DataManager manager;
    public GUI gui;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        manager = new DataManager(this);

        CreateItemData createItemData = new CreateItemData(manager);
        createItemData.create();
        this.gui = new GUI();

        getCommand("menu").setExecutor(new Cmd());

        getServer().getPluginManager().registerEvents(new MenuListener(this.gui),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
