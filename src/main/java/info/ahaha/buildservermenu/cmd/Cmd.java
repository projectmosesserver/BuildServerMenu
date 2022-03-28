package info.ahaha.buildservermenu.cmd;

import info.ahaha.buildservermenu.BuildServerMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))return true;
        Player player = (Player) sender;
        BuildServerMenu.plugin.gui.openGUI(player);
        return true;
    }
}
