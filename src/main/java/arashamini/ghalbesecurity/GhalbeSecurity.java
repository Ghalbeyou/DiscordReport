package arashamini.ghalbesecurity;

import arashamini.ghalbesecurity.listeners.FastFuck;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import arashamini.ghalbesecurity.listeners.FastFuck;
import java.io.IOException;

public final class GhalbeSecurity extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Plugin startup login
        config.addDefault("discordWebhook", "https://webhook");
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info("GhalbeSecurity is now enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("GhalbeSecurity is now disabled!");
    }
    // add command /report to report a player

    // add command /report list to list all reports
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("report")) {
            if (args.length == 0 || args.length == 1) {
                CustomMsg.sendMessage("&cUsage: /report <player> <reason>\n&1DiscordReport! spigotmc.org/resources/discordreport.104796/", sender);
                return true;
            }
            // check if the user is played on this server or no
            if (getServer().getPlayer(args[0]) == null) {
                CustomMsg.sendMessage("&cMake sure that player is online", sender);
                return true;
            }
            if (args[0].equalsIgnoreCase(sender.getName())) {
                CustomMsg.sendMessage("&cYou can't report yourself", sender);
                return true;
            }
            CustomMsg.sendMessage("&aSending report for " + args[0] + " from " + sender.getName(), sender);
            sendWebHook webhook = new sendWebHook(config.getString("discordWebhook"));
            webhook.setContent("Player " + sender.getName() + " has reported " + args[0] + " for " + args[1]);
            webhook.setUsername(sender.getName());
            try {
                webhook.execute();
            } catch (IOException e) {
//                sender.sendMessage("Error: " + e.getMessage());
                CustomMsg.sendMessage("&cError: &4Cannot sent! please try again", sender);
                return true;
            }
            CustomMsg.sendMessage("&aReport sent!", sender);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("gsreload")){
            reloadConfig();
            CustomMsg.sendMessage("&aWell, reloaded", sender);
            return true;
        }
        return false;
    }

}
