package me.blume.critichit.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import me.blume.critichit.Main;
import net.minecraft.server.v1_16_R3.Material;

public class DamageEvent implements Listener{

	private Main plugin;
	public DamageEvent(Main plugin) {
		this.plugin=plugin;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if(plugin.critPlayers.contains(player)) {
				if(player.getFallDistance() > 0.0F && !player.isOnGround() && 
						!player.hasPotionEffect(PotionEffectType.BLINDNESS) && !player.isInsideVehicle() && !player.isSprinting()
						&& !player.getLocation().getBlock().getType().equals(Material.WATER)) {
					event.setDamage(event.getDamage());
					player.sendMessage("dogal kritik");
				}
				else {
					player.sendMessage("yapay kritik");
					event.setDamage(event.getDamage()*3/2);
					event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 100, 20);
				}
			}
		}
	}
}
