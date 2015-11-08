package xyz.flarereturns.easyping.bukkit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.flarereturns.easyping.bukkit.Main;
import xyz.flarereturns.easyping.bukkit.utils.Utils;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 0) {
                if(p.hasPermission("easyping.use")) {
                    p.sendMessage(Main.pr + Main.getInstance().ownPing.replaceAll("%ping%", String.valueOf(Utils.getPing(p))));
                    return true;
                } else {
                    p.sendMessage(Main.pr + Main.getInstance().noPermission.replaceAll("%permission%", "easyping.use"));
                    return true;
                }
            }
            if(args.length == 1) {
                if(p.hasPermission("easyping.other")) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t.isOnline()) {
                        p.sendMessage(Main.pr + Main.getInstance().otherPing.replaceAll("%ping%", String.valueOf(Utils.getPing(t))).replaceAll("%name%", t.getName()));
                        return true;
                    } else {
                        p.sendMessage(Main.pr + Main.getInstance().notOnline.replaceAll("%name%", args[0]));
                        return true;
                    }
                } else {
                    p.sendMessage(Main.pr + Main.getInstance().noPermission.replaceAll("%permission%", "easyping.other"));
                    return true;
                }
            }
        } else {
            sender.sendMessage("[EasyPing] Consoles can't have a Ping!");
            return true;
        }
        sender.sendMessage(Main.pr + Main.getInstance().usage.replaceAll("%command%", label));
        return true;
    }

}
