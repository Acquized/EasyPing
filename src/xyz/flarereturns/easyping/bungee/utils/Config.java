package xyz.flarereturns.easyping.bungee.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import xyz.flarereturns.easyping.bungee.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Config {

    public String successOwn;
    public String successOther;
    public String usage;
    public String noPermission;
    public String notOnline;

    public void registerConfig() {
        try {
            if (!(Main.getInstance().getDataFolder().exists())) {
                Main.getInstance().getDataFolder().mkdir();
            }
            File f = new File(Main.getInstance().getDataFolder(), "config.yml");
            if (!(f.exists())) {
                Files.copy(Main.getInstance().getResourceAsStream("config.yml"), f.toPath());
            }
            Configuration cfg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(Main.getInstance().getDataFolder(), "config.yml"));
            Main.pr = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasyPing.Prefix"));
            successOwn = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasyPing.SuccessOwn"));
            successOther = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasyPing.SuccessOther"));
            usage = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasyPing.Usage"));
            noPermission = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasyPing.NoPermission"));
            notOnline = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasyPing.NotOnline"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
