package me.meinmex.serversystem.serversystem.commands;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class HelpCommand implements CommandExecutor {
    //Credits MeinMex#5023
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = (Player) sender;
        if (!player.hasPermission(Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.Help")))) {
            player.sendMessage(configuration.getString("ServerSystem.NoPermissions") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.Help")).replace("&", "§"));
            return true;
        }
        if (!(args.length == 0)) {
            player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.ArgsWrong")).replace("&", "§"));
            return true;
        }
        player.sendMessage(configuration.getString("ServerSystem.Prefix").replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Help")).replace("&", "§"));

        return true;
    }
}
