package de.phoenixts.phoenix.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.phoenixts.phoenix.Main;
import de.phoenixts.phoenix.utils.Utils;

public class QuitListener implements Listener {

	private Main plugin;

	public QuitListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent f) {
		Player p = f.getPlayer();

		{

			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("QuitMessage").replace("<player>", p.getName())));
		}
	}
}
