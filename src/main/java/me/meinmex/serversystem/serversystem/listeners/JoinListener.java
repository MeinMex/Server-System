package me.meinmex.serversystem.serversystem.listeners;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = event.getPlayer();
        event.setJoinMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Join.Message.All")).replace("%player%", player.getName()));
        player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Join.Message.Privat")).replace("%player%", player.getName()));
    }
}
