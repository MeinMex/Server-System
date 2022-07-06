package me.meinmex.serversystem.serversystem;

import me.meinmex.serversystem.serversystem.commands.HelpCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerSystem extends JavaPlugin {

    public static String Version = "0.0.1#DEVELOPING";
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
        Bukkit.getConsoleSender().sendMessage(Name + "enabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
        Bukkit.getConsoleSender().sendMessage("§aConfig loaded!");

        configuration.addDefault("ServerSystem.Prefix", "§8[§7System§8] §7|§r ");
        configuration.addDefault("ServerSystem.NoPermissions", "§8[§7System§8] §7|§r §cYou need the following permissions to use this command:§4 ");

        configuration.addDefault("ServerSystem.Commands.Permission.Help", "ServerSystem.Help");

        configuration.addDefault("ServerSystem.Commands.Messages.ArgsWrong.Help", "§cWrong arguments! Right: /help");
        configuration.addDefault("ServerSystem.Commands.Messages.Help", "§aHelp not set yet!");

        Objects.requireNonNull(getCommand("Help")).setExecutor(new HelpCommand());
        saveConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Name + "enabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
    }
}
