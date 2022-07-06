package me.meinmex.serversystem.serversystem;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

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


        saveConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Name + "enabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
    }
}
