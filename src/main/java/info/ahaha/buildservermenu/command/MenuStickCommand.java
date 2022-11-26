package info.ahaha.buildservermenu.command;

import info.ahaha.buildservermenu.MenuStick;
import info.ahaha.buildservermenu.util.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MenuStickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Message.getPlayerOnlyMessage());
            return true;
        }
        Player player = (Player) sender;
        player.getInventory().addItem(MenuStick.getMenuStick());
        return true;
    }
}
