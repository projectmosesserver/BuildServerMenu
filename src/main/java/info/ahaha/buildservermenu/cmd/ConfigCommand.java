package info.ahaha.buildservermenu.cmd;

import info.ahaha.buildservermenu.BuildServerMenu;
import info.ahaha.buildservermenu.GUI;
import info.ahaha.buildservermenu.Message;
import info.ahaha.buildservermenu.TPWorld;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigCommand implements TabExecutor {
    private final BuildServerMenu plugin;

    public ConfigCommand(BuildServerMenu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length <= 1) {
            sender.sendMessage(Message.getInvalidUsageMessage());
            return false;
        }
        String worldName = args[0];
        String type = args[1];

        if (type.equals("reset")) {
            plugin.getConfig().set("worlds." + worldName, null);
            plugin.saveConfig();
            sender.sendMessage(Message.getResetMessage(worldName));
            return true;
        }

        if (args.length == 2) {
            sender.sendMessage(Message.getInvalidUsageMessage());
            return false;
        }
        String value = args[2];

        if (type.equals("name")) {
            plugin.getConfig().set("worlds." + worldName + ".displayName", value);
            plugin.saveConfig();
            sender.sendMessage(Message.getDisplayNameSetMessage(worldName, value));
        }
        if (type.equals("lore")) {
            plugin.getConfig().set("worlds." + worldName + ".lore", value);
            plugin.saveConfig();
            sender.sendMessage(Message.getLoreSetMessage(worldName, value));
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return TPWorld.getWorldNames(plugin.getServer()).stream().filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
        }
        if (args.length == 2) {
            return Stream.of("name", "lore", "reset").filter(s -> s.startsWith(args[1])).collect(Collectors.toList());
        }
        if (args.length == 3) {
            if (args[1].equals("name")) {
                return Stream.of(args[0]).filter(s -> s.startsWith(args[2])).collect(Collectors.toList());
            }
            if (args[1].equals("lore")) {
                return Stream.of(GUI.getLore(plugin.getConfig(), args[0])).filter(s -> s.startsWith(args[2])).collect(Collectors.toList());
            }
        }
        return null;
    }
}
