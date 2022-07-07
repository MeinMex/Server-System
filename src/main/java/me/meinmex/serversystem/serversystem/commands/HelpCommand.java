package me.meinmex.serversystem.serversystem.commands;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = (Player) sender;
        if (!player.hasPermission(Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.Help")))) {
            player.sendMessage(configuration.getString("ServerSystem.NoPermissions") + configuration.getString("ServerSystem.Commands.Permission.Help"));
            return true;
        }
        if (!(args.length == 0)) {
            player.sendMessage(configuration.getString("ServerSystem.Prefix") + configuration.getString("ServerSystem.Commands.Messages.ArgsWrong.Help"));
            return true;
        }
        player.sendMessage(configuration.getString("ServerSystem.Prefix") + configuration.getString("ServerSystem.Commands.Messages.Help"));

        return true;
    }
}
