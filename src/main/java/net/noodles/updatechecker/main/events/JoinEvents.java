/*
 * Copyright (c) BGHDDevelopment.
 * Please refer to the plugin page or GitHub page for our open-source license.
 * If you have any questions please email ceo@bghddevelopment or reach us on Discord
 */

package net.noodles.updatechecker.main.events;

import net.noodles.updatechecker.main.Main;
import net.noodles.updatechecker.main.util.Settings;
import net.noodles.updatechecker.main.util.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {


    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (Main.plugin.getConfig().getBoolean("Update.Enabled") == true) {
            if (p.hasPermission("pluginname.update")) {
                //PLEASE REPLACE THE RESOURCE ID WITH YOUR SPIGOT RESOURCE
                new UpdateChecker(Main.getPlugin(), 53460).getLatestVersion(version -> {
                    if (!Main.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                        p.sendMessage(ChatColor.RED + "PluginName is outdated!");
                        p.sendMessage(ChatColor.RED + "Newest version: " + version);
                        p.sendMessage(ChatColor.RED + "Your version: " + ChatColor.BOLD + Settings.VERSION);
                        p.sendMessage(ChatColor.GOLD + "Please Update Here: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");                    }
                });
            }
        }
    }
}
    