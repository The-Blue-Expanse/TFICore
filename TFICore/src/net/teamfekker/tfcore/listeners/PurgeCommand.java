package net.teamfekker.tfcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PurgeCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

		if (cmd.getName().equalsIgnoreCase("purgeall")) {

			for(Player p: Bukkit.getOnlinePlayers()){
				String title = "Sending to lobby in 30 seconds.";
				String subTitle = "Please wait a moment before reconnecting.";
				p.sendTitle(title, subTitle);
				p.sendMessage(title);
				p.sendMessage(subTitle);
				
				
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
					public void run() {
						p.sendTitle("","Disconnecting in 20s");
						p.sendMessage("Disconnecting in 20s");
					}

				}, 10*20L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
					public void run() {
						p.sendTitle(""," Disconnecting in 10s");
						p.sendMessage("Disconnecting in 10s");
					}

				}, 20*20L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
					public void run() {
						for(Player players : Bukkit.getOnlinePlayers()){
						players.kickPlayer("All players sent to Lobby, please wait a moment before reconnecting! -TF MGMT"); 
						}
					}

				}, 30*20L);
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
					public void run() {
						for(Player players : Bukkit.getOnlinePlayers()){
						players.kickPlayer("All players sent to Lobby, please wait a moment before reconnecting! -TF MGMT"); 
						}
					}

				}, 35*20L);

			}
			return false;
		}
		return false;
	}

	
	
}
