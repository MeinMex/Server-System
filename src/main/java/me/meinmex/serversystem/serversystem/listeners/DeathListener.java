package me.meinmex.serversystem.serversystem.listeners;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = event.getEntity();
        event.setDeathMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Death.Message.All")).replace("%player%", player.getName()));

    }

}
