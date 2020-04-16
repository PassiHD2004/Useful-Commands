package de.phoenixts.phoenix;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.phoenixts.phoenix.utils.Utils;

public class BierCMD implements CommandExecutor {

	private Main plugin;

	public BierCMD(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("bier").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
			return true;

		}
		Player p = (Player) sender;

		if (p.hasPermission(plugin.getConfig().getString("bier_permission"))) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
					("effect <player> nausea 60 150").replace("<player>", p.getDisplayName()));
			p.sendMessage(Utils.chat(plugin.getConfig().getString("Bier_Message")));
			return true;
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
		}
		return false;
	}

}
