package info.ahaha.buildservermenu;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.stream.Collectors;

public class TPWorld {
    public static List<String> getWorldStrings() {
        Plugin MCPlugin = Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        if (MCPlugin == null) {
            return Bukkit.getWorlds().stream().map(WorldInfo::getName).collect(Collectors.toList());
        }
        MultiverseCore core = (MultiverseCore) MCPlugin;
        return core.getMVWorldManager().getMVWorlds().stream().map(MultiverseWorld::getName).collect(Collectors.toList());
    }

    public static Location getSpawnLocation(String world) {
        Plugin MCPlugin = Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        if (MCPlugin == null) {
            World vanillaWorld = Bukkit.getWorld(world);
            if (vanillaWorld == null) return null;
            return vanillaWorld.getSpawnLocation();
        }
        MultiverseCore core = (MultiverseCore) MCPlugin;
        MultiverseWorld multiverseWorld = core.getMVWorldManager().getMVWorld(world);
        if (multiverseWorld == null) return null;
        return multiverseWorld.getSpawnLocation();
    }
}
