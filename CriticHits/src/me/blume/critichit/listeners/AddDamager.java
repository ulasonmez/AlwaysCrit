package me.blume.critichit.listeners;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.critichit.Main;

public class AddDamager implements CommandExecutor{


	private Main plugin;
	public AddDamager(Main plugin) {
		this.plugin=plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {

		if(label.equals("critic")) {
			if(args.length==2) {
				if(args[0].equals("add")) {
					Player player = Bukkit.getPlayer(args[1]);
					if(player != null) {
						plugin.critPlayers.add(player);
						AttributeInstance instance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
						instance.setBaseValue(999);
					}
				}
				else if(args[0].equals("remove")) {
					Player player = Bukkit.getPlayer(args[1]);
					if(player!=null && plugin.critPlayers.contains(player)) {
						plugin.critPlayers.remove(player);
						AttributeInstance instance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
						instance.setBaseValue(4);
					}
				}
			}
			if(args.length==1) {
				if(args[0].equals("clear")) {
					plugin.critPlayers.clear();
				}
				else if(args[0].equals("all")) {
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(!plugin.critPlayers.contains(p)) {
							plugin.critPlayers.add(p);
						}
					}
				}
			}
			
		}
		
		return false;
	}
}
