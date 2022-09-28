package me.meinmex.serversystem.serversystem;

import me.meinmex.serversystem.serversystem.commands.ClearChatCommand;
import me.meinmex.serversystem.serversystem.commands.FlyCommand;
import me.meinmex.serversystem.serversystem.commands.GamemodeCommand;
import me.meinmex.serversystem.serversystem.commands.HelpCommand;
import me.meinmex.serversystem.serversystem.listeners.DeathListener;
import me.meinmex.serversystem.serversystem.listeners.JoinListener;
import me.meinmex.serversystem.serversystem.listeners.QuitListener;
import me.meinmex.serversystem.serversystem.tabcompleters.GamemodeTabCompelter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerSystem extends JavaPlugin {
    //Credits MeinMex#5023
    public static String Version = "0.0.3#DEVELOPING";
    public static String Name = "ServerSystem ";
    public static String Author = "MeinMex#5023";
    public static ServerSystem instance;
    public FileConfiguration configuration = getConfig();

    public static ServerSystem getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {
        instance = this;
        FileConfiguration configuration = getConfig();
        configuration.options().copyDefaults(true);
        PluginManager pluginManager = Bukkit.getPluginManager();
        Bukkit.getConsoleSender().sendMessage(Name + "enabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
        Bukkit.getConsoleSender().sendMessage("§aConfig loaded!");

        configuration.addDefault("ServerSystem.Prefix", "&8[&7System&8] &7|&r ");
        configuration.addDefault("ServerSystem.NoPermissions", "&8[&7System&8] &7|&r &cYou need the following permissions to use this command:&4 ");
        configuration.addDefault("ServerSystem.PlayerNotFound", "&8[&7System&8] &7|&r &cThis player ist not online ore dont exists");
        configuration.addDefault("ServerSystem.ArgsTooMany", "&8[&7System&8] &7|&r &cToo many arguments");

        configuration.addDefault("ServerSystem.Commands.Permission.Help", "ServerSystem.Help");
        configuration.addDefault("ServerSystem.Commands.Permission.Fly", "ServerSystem.Fly");
        configuration.addDefault("ServerSystem.Commands.Permission.ClearChat", "ServerSystem.ClearChat");
        configuration.addDefault("ServerSystem.Commands.Permission.ClearChat.Bypass", "ServerSystem.ClearChat.Bypass");
        configuration.addDefault("ServerSystem.Commands.Permission.Gamemode", "ServerSystem.Gamemode");

        configuration.addDefault("ServerSystem.Commands.Messages.Help.ArgsWrong", "&cWrong arguments! Use: /help");
        configuration.addDefault("ServerSystem.Commands.Messages.Help", "&aHelp not set yet!");

        configuration.addDefault("ServerSystem.Commands.Messages.Fly.ArgsWrong", "&cWrong arguments! Use: /fly");
        configuration.addDefault("ServerSystem.Commands.Messages.Fly.Enabled", "&aFly message not set yet! (enable)");
        configuration.addDefault("ServerSystem.Commands.Messages.Fly.Disabled", "&aFly message not set yet! (disable)!");

        configuration.addDefault("ServerSystem.Commands.Messages.ClearChat.ArgsWrong", "&cWrong arguments! Use: /clearchat");
        configuration.addDefault("ServerSystem.Commands.Messages.ClearChat.Success", "%player% &cCleared the Chat!");

        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Self.Survival", "&aGammemode (Survival) message not set yet!");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Self.Creative", "&aGammemode (Creative) message not set yet!");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Self.Adventure", "&aGammemode (Adventure) message not set yet!");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Self.Spectator", "&aGammemode (Spectator) message not set yet!");

        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Self.Survival", "&aGammemode (Survival) message not set yet! to %target%");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Self.Creative", "&aGammemode (Creative) message not set yet! to %target%");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Self.Adventure", "&aGammemode (Adventure) message not set yet! to %target%");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Self.Spectator", "&aGammemode (Spectator) message not set yet! to %target%");

        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Target.Survival", "&aGammemode (Survival) message not set yet! by %player%");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Target.Creative", "&aGammemode (Creative) message not set yet! by %player%");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Target.Adventure", "&aGammemode (Adventure) message not set yet! by %player%");
        configuration.addDefault("ServerSystem.Commands.Messages.Gammemode.Other.Target.Spectator", "&aGammemode (Spectator) message not set yet! by %player%");


        configuration.addDefault("ServerSystem.Join.Message.All", "&a%player% joined the server!");
        configuration.addDefault("ServerSystem.Join.Message.Privat", "&a%player% welcome on the server!");

        configuration.addDefault("ServerSystem.Quit.Message.All", "&a%player% left the server!");

        configuration.addDefault("ServerSystem.Death.Message.All", "&a%player% died!");
        configuration.addDefault("ServerSystem.Death.Message.Privat", "");

        Objects.requireNonNull(getCommand("Help")).setExecutor(new HelpCommand());
        Objects.requireNonNull(getCommand("Fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(getCommand("ClearChat")).setExecutor(new ClearChatCommand());
        Objects.requireNonNull(getCommand("Gamemode")).setExecutor(new GamemodeCommand());

        Objects.requireNonNull(getCommand("Gamemode")).setTabCompleter(new GamemodeTabCompelter());


        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);


        saveConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Name + "enabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
    }
}
