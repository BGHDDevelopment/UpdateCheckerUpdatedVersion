package net.noodles.updatechecker.main;

import net.noodles.updatechecker.main.util.Logger;
import net.noodles.updatechecker.main.util.Settings;
import net.noodles.updatechecker.main.util.UpdateChecker;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Plugin instance;
    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        plugin = this;
        //PLEASE REPLACE THE RESOURCE ID WITH YOUR SPIGOT RESOURCE
        new UpdateChecker(this, 53460).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.log(Logger.LogLevel.SUCCESS,("PluginName is up to date!"));
            } else {
                Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
                Logger.log(Logger.LogLevel.WARNING,("PluginName is outdated!"));
                Logger.log(Logger.LogLevel.WARNING,("Newest version: " + version));
                Logger.log(Logger.LogLevel.WARNING,("Your version: " + Settings.VERSION));
                Logger.log(Logger.LogLevel.WARNING,("Please Update Here: " + Settings.PLUGIN_URL));
                Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");			}
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static Plugin getInstance() {
        return instance;
    }
}
