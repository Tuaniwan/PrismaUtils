package me.kermx.prismaUtils.Commands.OtherCommands;

import me.kermx.prismaUtils.Commands.base.BaseCommand;
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

public class FlySpeedCommand extends BaseCommand {

    public FlySpeedCommand(){
        super("prismautils.command.flyspeed", false, "/flyspeed");
    }

    @Override
    protected boolean onCommandExecute(CommandSender sender, String label, String[] args){
        if (args.length == 0 || args[0].equalsIgnoreCase("reset")) {
            if (sender instanceof Player player) {
                player.setFlySpeed(0.1f);
                player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().flyspeedResetMessage));
                return true;
            }
        }
        try {
            float speed = Float.parseFloat(args[0]);
            if (speed < 0 || speed > 10) {
                sender.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().flyspeedInvalidSpeedMessage));
                return true;
            }
            float adjustedSpeed = speed / 10.0f;
            ((Player) sender).setFlySpeed(adjustedSpeed);

            Component speedComponent = Component.text(speed);
            sender.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().flyspeedSetMessage,
                    Placeholder.component("speed", speedComponent)));

        } catch (NumberFormatException e) {
            sender.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().flyspeedInvalidSpeedMessage));
        }
        return true;
    }

    @Override
    protected List<String> onTabCompleteExecute(CommandSender sender, String[] args){
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("reset");
            for (int i = 0; i <= 10; i++) {
                completions.add(String.valueOf(i));
            }
        }
        return completions;
    }
}
