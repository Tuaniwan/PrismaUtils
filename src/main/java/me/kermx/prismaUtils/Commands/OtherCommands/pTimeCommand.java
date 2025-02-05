package me.kermx.prismaUtils.Commands.OtherCommands;

import me.kermx.prismaUtils.Utils.ConfigUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class pTimeCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        if (!player.hasPermission("prismautils.command.ptime")) {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().noPermissionMessage));
            return true;
        }

        if (args.length == 0 || args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("sync")) {
            player.resetPlayerTime();
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().pTimeResetMessage));
            return true;
        }

        try {
            long time = parseTime(args[0]);
            player.setPlayerTime(time, false);

            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().pTimeSetMessage,
                    Placeholder.component("time", Component.text(time))));
        } catch (IllegalArgumentException e) {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().pTimeInvalidTimeMessage));
        }
        return true;
    }

    private long parseTime(String input) {
        switch (input.toLowerCase()) {
            case "day", "noon", "midday":
                return 6000L;
            case "night":
                return 13000L;
            case "morning":
                return 0L;
            case "sunrise":
                return 23000L;
            case "sunset":
                return 12500L;
            case "evening":
                return 11000L;
            case "midnight":
                return 18000L;
            default:
                long time = Long.parseLong(input);
                if (time < 0 || time > 24000) {
                    throw new IllegalArgumentException("Invalid time! Must be between 0 and 24000.");
                }
                return time;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("day");
            completions.add("noon");
            completions.add("midday");
            completions.add("night");
            completions.add("morning");
            completions.add("sunrise");
            completions.add("sunset");
            completions.add("evening");
            completions.add("midnight");
            completions.add("reset");
        }
        return completions;
    }

}
