package info.ahaha.buildservermenu.util;

import org.bukkit.ChatColor;

public class Message {
    private static final String prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + "BuildServerMenu" + ChatColor.GRAY + "] " + ChatColor.RESET;

    public static String getInvalidUsageMessage() {
        return prefix + ChatColor.RED + "コマンドが正しくありません";
    }

    public static String getPlayerOnlyMessage() {
        return prefix + ChatColor.RED + "このコマンドはプレイヤーのみが実行できます";
    }

    public static String getResetMessage(String worldName) {
        return prefix + ChatColor.AQUA + worldName + ChatColor.BLUE + "の設定をリセットしました";
    }

    public static String getDisplayNameSetMessage(String worldName, String displayName) {
        return prefix + ChatColor.AQUA + worldName + ChatColor.BLUE + "の表示名を" + ChatColor.AQUA + displayName + ChatColor.BLUE + "に設定しました";
    }
}
