package xyz.flarereturns.easyping.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import xyz.flarereturns.easyping.bungee.Main;
import xyz.flarereturns.easyping.bungee.utils.Utils;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping", "pong", Main.getInstance().getConfig().usage);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(args.length == 0) {
                if(p.hasPermission("easyping.use")) {
                    p.sendMessage(new TextComponent(Main.pr + Main.getInstance().getConfig().successOwn.replaceAll("%ping%", String.valueOf(Utils.getPing(p)))));
                } else {
                    p.sendMessage(new TextComponent(Main.pr + Main.getInstance().getConfig().noPermission.replaceAll("%permission%", "easyping.use")));
                }
            } else if(args.length == 1) {
                if(p.hasPermission("easyping.other")) {
                    ProxiedPlayer t = ProxyServer.getInstance().getPlayer(args[0]);
                    if(t != null) {
                        p.sendMessage(new TextComponent(Main.pr + Main.getInstance().getConfig().successOther.replaceAll("%ping%", String.valueOf(Utils.getPing(t))).replaceAll("%name%", t.getName())));
                    } else {
                        p.sendMessage(new TextComponent(Main.pr + Main.getInstance().getConfig().notOnline.replaceAll("%name%", args[0])));
                    }
                } else {
                    p.sendMessage(new TextComponent(Main.pr + Main.getInstance().getConfig().noPermission.replaceAll("%permission%", "easyping.other")));
                }
            } else {
                p.sendMessage(new TextComponent(Main.pr + Main.getInstance().getConfig().usage.replaceAll("%command%", "ping")));
            }
        } else {
            sender.sendMessage(new TextComponent("[EasyPing] A console doesn't has a ping!"));
        }
    }

}
