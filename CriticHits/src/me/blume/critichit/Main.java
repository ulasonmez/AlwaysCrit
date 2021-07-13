package me.blume.critichit;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.blume.critichit.listeners.AddDamager;
import me.blume.critichit.listeners.DamageEvent;

public class Main extends JavaPlugin implements Listener{

	public ArrayList<Player> critPlayers = new ArrayList<Player>();
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DamageEvent(this), this);
		getCommand("critic").setExecutor(new AddDamager(this));
	}
	
}
