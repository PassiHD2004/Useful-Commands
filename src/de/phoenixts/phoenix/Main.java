package de.phoenixts.phoenix;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new TeamCMD(this);
		new TeamspeakCMD(this);
		new DiscordCMD(this);
		saveDefaultConfig();

	}

}
