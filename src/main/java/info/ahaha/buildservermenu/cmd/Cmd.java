package info.ahaha.buildservermenu.cmd;

import info.ahaha.buildservermenu.BuildServerMenu;
import info.ahaha.buildservermenu.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class Cmd implements CommandExecutor {
    private final BuildServerMenu plugin;

    public Cmd(BuildServerMenu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        Inventory gui = GUI.getGui();
        plugin.openedGuis.put(player.getUniqueId(), gui);
        player.openInventory(gui);
        return true;
    }
}
