package xyz.flarereturns.easyping.bukkit.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

    public static int getPing(Player p) {
        try {
            String ver = Bukkit.getServer().getClass().getPackage().getName().substring(23);
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + ver + ".entity.CraftPlayer");
            Object handle = craftPlayer.getMethod("getHandle").invoke(p);
            return (Integer) handle.getClass().getDeclaredField("ping").get(handle);
        } catch(Exception ex) {
            return -1;
        }
    }

}
