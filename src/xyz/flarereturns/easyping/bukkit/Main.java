package xyz.flarereturns.easyping.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.flarereturns.easyping.bukkit.commands.PingCommand;

public class Main extends JavaPlugin {

    public static String pr;
    private static Main instance;

    public String ownPing;
    public String otherPing;
    public String usage;
    public String noPermission;
    public String notOnline;

    @Override
    public void onEnable() {
        instance = this;
        registerConfig();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage("[EasyPing] EasyPing v" + getDescription().getDescription() + " was enabled.");
    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getConsoleSender().sendMessage("[EasyPing] EasyPing v" + getDescription().getDescription() + " was disabled.");
    }

    private void registerCommands() {
        Bukkit.getPluginCommand("ping").setExecutor(new PingCommand());
    }

    private void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        pr = ChatColor.translateAlternateColorCodes('&', getConfig().getString("EasyPing.Prefix"));
        ownPing = ChatColor.translateAlternateColorCodes('&', getConfig().getString("EasyPing.SuccessOwn"));
        otherPing = ChatColor.translateAlternateColorCodes('&', getConfig().getString("EasyPing.SuccessOther"));
        usage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("EasyPing.Usage"));
        noPermission = ChatColor.translateAlternateColorCodes('&', getConfig().getString("EasyPing.NoPermission"));
        notOnline = ChatColor.translateAlternateColorCodes('&', getConfig().getString("EasyPing.NotOnline"));
    }

    public static Main getInstance() {
        return instance;
    }

}
