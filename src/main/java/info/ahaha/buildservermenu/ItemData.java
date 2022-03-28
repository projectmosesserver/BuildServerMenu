package info.ahaha.buildservermenu;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemData {

    private final String configName;
    private final ItemStack item;
    private final List<Integer>slots;
    private final Location location;
    private boolean isTpItem = false;

    public static List<ItemData>data = new ArrayList<>();

    public ItemData(String configName , ItemStack item , List<Integer>slots , Location location){
        this.configName = configName;
        this.item = item;
        this.slots = slots;
        this.location = location;
        if (location != null){
            isTpItem = true;
        }
    }

    public String getConfigName() {
        return configName;
    }

    public boolean isTpItem() {
        return isTpItem;
    }

    public ItemStack getItem() {
        return item;
    }

    public Location getLocation() {
        return location;
    }

    public List<Integer> getSlots() {
        return slots;
    }
}
