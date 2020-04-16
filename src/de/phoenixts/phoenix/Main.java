package de.phoenixts.phoenix;

import org.bukkit.plugin.java.JavaPlugin;

import de.phoenixts.phoenix.listeners.JoinListener;
import de.phoenixts.phoenix.listeners.QuitListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new TeamCMD(this);
		new TeamspeakCMD(this);
		new DiscordCMD(this);
		new JoinListener(this);
		new QuitListener(this);
		new BierCMD(this);
		saveDefaultConfig();

	}

}
