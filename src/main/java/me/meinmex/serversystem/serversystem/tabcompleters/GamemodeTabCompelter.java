package me.meinmex.serversystem.serversystem.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;


public class GamemodeTabCompelter implements TabCompleter {
    List<String> arg = new ArrayList<>();

    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (arg.isEmpty()) {
            arg.add("survival");
            arg.add("creative");
            arg.add("adventure");
            arg.add("spectator");
        }

        List<String> result = new ArrayList<>();
        if(args.length == 1){
            for (String a : arg){
                if(a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }

        return null;
    }
}