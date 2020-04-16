package de.phoenixts.phoenix.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.phoenixts.phoenix.Main;
import de.phoenixts.phoenix.utils.Utils;

public class JoinListener implements Listener {

	private static Main plugin;

	public JoinListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (!p.hasPlayedBefore()) {
			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("First_JoinMessage").replace("<player>", p.getName())));
		} else {
			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("JoinMessage").replace("<player>", p.getName())));
		}
	}

}
