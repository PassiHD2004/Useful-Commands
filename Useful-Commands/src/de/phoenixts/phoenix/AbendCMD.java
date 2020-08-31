package de.phoenixts.phoenix;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.phoenixts.phoenix.utils.Utils;

public class AbendCMD implements CommandExecutor {

	private Main plugin;

	public AbendCMD(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("abend").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
			return true;

		}
		Player p = (Player) sender;

		if (p.hasPermission(plugin.getConfig().getString("abend_perm"))) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
					("time set 12000"));
			p.sendMessage(Utils.chat(plugin.getConfig().getString("Abend_Message")));
			return true;
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
		}
		return false;
	}

}
