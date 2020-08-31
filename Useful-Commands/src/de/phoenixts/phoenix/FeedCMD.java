package de.phoenixts.phoenix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.phoenixts.phoenix.utils.Utils;

public class FeedCMD implements CommandExecutor {

	private Main plugin;

	public FeedCMD(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("feed").setExecutor(this);

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
			return true;
		
		}
		Player p = (Player) sender;

		if (p.hasPermission(plugin.getConfig().getString("feed_perm"))) {
			
			int maxFoodLevel = 20;
			
			if (p.getFoodLevel() < maxFoodLevel) {
				p.setFoodLevel(maxFoodLevel);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("feed_filled")));	
			} else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("feed_full")));
			}
			return true;
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
		}
		return false;
	}
}
