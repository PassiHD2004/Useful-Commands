package de.phoenixts.phoenix;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.phoenixts.phoenix.utils.Utils;

public class HealCMD implements CommandExecutor {

	private Main plugin;

	public HealCMD(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("heal").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission(plugin.getConfig().getString("heal_perm")));
		
		if (args.length == 0) {
			if (!(p.getGameMode() == GameMode.CREATIVE)) {
				p.setHealth(20);
				p.setFoodLevel(20);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("Heal_msg")));
			} else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("Heal_fail_msg")));
			}
		} else if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if (target != null) {

				if (!(target.getGameMode() == GameMode.CREATIVE)) {
					target.setHealth(20);
					target.setFoodLevel(20);
					target.sendMessage(Utils.chat(plugin.getConfig().getString("Heal_msg")));
					p.sendMessage(Utils.chat(
							plugin.getConfig().getString("Heal_other_msg").replace("<player>", target.getName())));

				} else
					p.sendMessage(Utils.chat("&e" + target.getName() + " &c&list im &4" + target.getGameMode()
							+ " &c&lModus! &9&lEr muss aber im Survival Modus sein!"));
			} else
				p.sendMessage(Utils
						.chat("&c&lDer Spieler &e" + args[0] + "&c&lexistiert nicht, oder ist nicht auf dem Server!"));
		} else
			p.sendMessage(Utils.chat("&CDiesen Command darf nur das Team benutzen"));
		return false;
	}

}
