package info.ahaha.buildservermenu;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.stream.Collectors;

public class TPWorld {
    public static List<String> getWorldNames(Server server) {
        Plugin MCPlugin = server.getPluginManager().getPlugin("Multiverse-Core");
        if (MCPlugin instanceof MultiverseCore) {
            MultiverseCore core = (MultiverseCore) MCPlugin;
            return core.getMVWorldManager().getMVWorlds().stream().map(MultiverseWorld::getName).collect(Collectors.toList());
        }
        return server.getWorlds().stream().map(WorldInfo::getName).collect(Collectors.toList());
    }

    public static Location getSpawnLocation(Server server, String worldName) {
        Plugin MCPlugin = server.getPluginManager().getPlugin("Multiverse-Core");
        if (MCPlugin instanceof MultiverseCore) {
            MultiverseCore core = (MultiverseCore) MCPlugin;
            MultiverseWorld multiverseWorld = core.getMVWorldManager().getMVWorld(worldName);
            if (multiverseWorld == null) return null;
            return multiverseWorld.getSpawnLocation();
        }
        World vanillaWorld = server.getWorld(worldName);
        if (vanillaWorld == null) return null;
        return vanillaWorld.getSpawnLocation();
    }
}
