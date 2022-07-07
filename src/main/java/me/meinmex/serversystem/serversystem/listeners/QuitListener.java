package me.meinmex.serversystem.serversystem.listeners;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = event.getPlayer();
        event.setQuitMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Quit.Message.All")).replace("%player%", player.getName()).replace("&", "§"));
    }

}
