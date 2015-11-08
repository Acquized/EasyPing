package xyz.flarereturns.easyping.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import xyz.flarereturns.easyping.bungee.commands.PingCommand;
import xyz.flarereturns.easyping.bungee.utils.Config;

public class Main extends Plugin {

    public static String pr;
    private static Config config;
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        config = new Config();
        getConfig().registerConfig();
        registerCommands();
    }

    @Override
    public void onDisable() {
        config = null;
        instance = null;
    }

    private void registerCommands() {
        PluginManager pm = ProxyServer.getInstance().getPluginManager();
        pm.registerCommand(this, new PingCommand());
    }

    public Config getConfig() {
        return config;
    }

    public static Main getInstance() {
        return instance;
    }

}
