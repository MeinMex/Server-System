package me.meinmex.serversystem.serversystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerSystem extends JavaPlugin {

    public static String Version = "0.0.1#DEVELOPING";
    public static String Name = "ServerSystem";
    public static String Author = "MeinMex#5023";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aServerSystem enabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§aServerSystem disabled!");
        Bukkit.getConsoleSender().sendMessage("§aVersion: " + Version);
        Bukkit.getConsoleSender().sendMessage("§aAuthor: " + Author);
    }
}
