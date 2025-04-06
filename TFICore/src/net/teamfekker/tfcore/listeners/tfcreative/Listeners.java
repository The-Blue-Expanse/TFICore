package net.teamfekker.tfcore.listeners.tfcreative;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import net.teamfekker.tfcore.Main;


public class Listeners implements Listener {



	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {	
		if (Main.plugin.getConfig().getBoolean("Enable automatic creative mode?")) {
			Player player = event.getPlayer();
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage("Creative Mode Activated");
		}
	}
	
	@EventHandler
	public void blockPlace(BlockPlaceEvent event) {
		if(Main.plugin.getConfig().getBoolean("Enable block banning?")) {
			if(event.getBlock().getType().equals(Material.HOPPER)) {
				event.setCancelled(true);
				event.getPlayer().sendMessage("The Hopper block is disabled currently.");
			}
			if(event.getBlock().getType().equals(Material.HOPPER_MINECART)) {
				event.setCancelled(true);
				event.getPlayer().sendMessage("The Hopper block is disabled currently.");
			}
		}
		
	}
}
