package arashamini.ghalbesecurity.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class FastFuck implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&8[&a+&8] &7" + player.getName()));
        } else {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&a[GhalbeYou]&6Salam &7" + player.getName() + "&a be server khosh omadi!"));
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&8[&c-&8] &7" + player.getName()));

    }

}