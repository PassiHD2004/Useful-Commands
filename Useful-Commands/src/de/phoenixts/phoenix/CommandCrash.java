package de.phoenixts.phoenix;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by Nicolai on 24.05.2015.
 */
public class CommandCrash implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        if(cs instanceof Player) {
            Player p = (Player) cs;

            // Permissions prüfen
            if (!p.hasPermission("phoenixts.crash") && !p.hasPermission("phoenixts.crash")) {
                p.sendMessage("§7[§6§lPhoenix§b§lTS§7]§cError: You have no permissions");
                return true;
            }

        }
        // /crash (username)
        if(args.length == 1) {
            try {
                Player target = Bukkit.getPlayer(args[0]);
                crash(target);
                cs.sendMessage("§7[§6§lPhoenix§b§lTS§7]§6Du hast §c" + target.getName() + "'s §6Minecraft gecrasht");
            } catch(NullPointerException exception) {
                cs.sendMessage("§7[§6§lPhoenix§b§lTS§7]§cError: §4" + args[0] +" §cist nicht online");
            }
        } else {
            cs.sendMessage("§7[§6§lPhoenix§b§lTS§7]§6/crash (username)");
        }


        return true;
    }

    private static void crash(Player target) {
        Inventory inv = Bukkit.createInventory(null, 9*12800);
        target.openInventory(inv);
    }

}
