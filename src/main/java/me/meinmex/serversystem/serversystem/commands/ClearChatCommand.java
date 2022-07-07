package me.meinmex.serversystem.serversystem.commands;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = (Player) sender;
        if (!player.hasPermission(Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.ClearChat")))) {
            player.sendMessage(configuration.getString("ServerSystem.NoPermissions") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.ClearChat")).replace("&", "§"));
            return true;
        }
        if (!(args.length == 0)) {
            player.sendMessage(configuration.getString("ServerSystem.Prefix") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.ClearChat.ArgsWrong")).replace("&", "§"));
            return true;
        }
        for(Player allPlayers : Bukkit.getOnlinePlayers()){
            if(!(allPlayers.hasPermission(Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.ClearChat.Bypass"))))){
                for(int i = 0; i < 100; i++){
                    allPlayers.sendMessage(" ");
                }
            }
            allPlayers.sendMessage(configuration.getString("ServerSystem.Prefix") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.ClearChat.Success")).replace("&", "§").replace("%player%", player.getName()));
        }


        return true;
    }
}
