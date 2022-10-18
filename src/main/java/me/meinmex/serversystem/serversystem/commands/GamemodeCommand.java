package me.meinmex.serversystem.serversystem.commands;

import me.meinmex.serversystem.serversystem.ServerSystem;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration configuration = ServerSystem.getInstance().configuration;
        Player player = (Player) sender;
        if (!player.hasPermission(Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.Gamemode")))) {
            player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.NoPermissions")).replace("&", "§") + Objects.requireNonNull(Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Permission.Gamemode")).replace("&", "§")));
            return true;
        }

        if(!(args.length == 1 || args.length == 2)){
            player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.ArgsWrong")).replace("&", "§"));
            return true;
        }


        if (args.length == 1) {
            switch (args[0]) {
                case "survival", "s", "0" -> {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Self.Survival")).replace("&", "§"));
                }
                case "creative", "c", "1" -> {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Self.Creative")).replace("&", "§"));
                }
                case "Adventure", "a", "2" -> {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Self.Adventure")).replace("&", "§"));
                }
                case "Spectator", "sp", "3" -> {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Self.Spectator")).replace("&", "§"));
                }
            }
            return true;
        }
        if(args.length == 2){
            Player target = player.getServer().getPlayer(args[1]);
            if(target == null){
                player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.PlayerNotFound")).replace("&", "§"));
                return true;
            }
            switch (args[0]) {
                case "survival", "s", "0" -> {
                    target.setGameMode(GameMode.SURVIVAL);
                    target.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Target.Survival")).replace("&", "§").replace("%player%", target.getName()));
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Self.Survival")).replace("&", "§").replace("%target%", target.getName()));
                }
                case "creative", "c", "1" -> {
                    target.setGameMode(GameMode.CREATIVE);
                    target.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Target.Creative")).replace("&", "§").replace("%player%", target.getName()));
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Self.Creative")).replace("&", "§").replace("%target%", target.getName()));
                }
                case "adventure", "a", "2" -> {
                    target.setGameMode(GameMode.ADVENTURE);
                    target.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Target.Adventure")).replace("&", "§").replace("%player%", target.getName()));
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Self.Adventure")).replace("&", "§").replace("%target%", target.getName()));
                }
                case "spectator", "sp", "3" -> {
                    target.setGameMode(GameMode.SPECTATOR);
                    target.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Target.Spectator")).replace("&", "§").replace("%player%", target.getName()));
                    player.sendMessage(Objects.requireNonNull(configuration.getString("ServerSystem.Prefix")).replace("&", "§") + Objects.requireNonNull(configuration.getString("ServerSystem.Commands.Messages.Gamemode.Other.Self.Spectator")).replace("&", "§").replace("%target%", target.getName()));
                }

            }
        }

        return true;
    }
}
