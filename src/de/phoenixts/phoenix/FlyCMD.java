package de.phoenixts.phoenix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.phoenixts.phoenix.utils.Utils;

public class FlyCMD implements CommandExecutor {

	private Main plugin;

	public FlyCMD(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("gfly").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission(plugin.getConfig().getString("fly_perm"))) {
			if (p.isFlying()) {
				p.setAllowFlight(false);
				p.setFlying(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("Fly_disabled")));
				return true;
			} else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("Fly_enabled")));
				return true;
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("fly_noperm")));
		}

		return false;
	}
}