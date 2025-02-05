package me.kermx.prismaUtils.Commands.OtherCommands;

import me.kermx.prismaUtils.Utils.ConfigUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RepairCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        if (!player.hasPermission("prismautils.command.repair")) {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().noPermissionMessage));
            return true;
        }

        if (args.length != 1 || (!args[0].equalsIgnoreCase("hand") && !args[0].equalsIgnoreCase("all"))) {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().incorrectUsageMessage,
                    Placeholder.component("usage", Component.text(command.getUsage()))));
            return true;
        }

        if (args[0].equalsIgnoreCase("hand")) {
            repairHand(player);
        } else if (args[0].equalsIgnoreCase("all")) {
            repairAll(player);
        } else {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().incorrectUsageMessage,
                    Placeholder.component("usage", Component.text(command.getUsage()))));
        }
        return true;
    }

    private void repairHand(Player player) {
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (itemInHand.getType() == Material.AIR) {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().repairNoItemInHandMessage));
            return;
        }

        ItemMeta meta = itemInHand.getItemMeta();
        if (meta instanceof Damageable damageable) {
            damageable.setDamage(0);
            itemInHand.setItemMeta(meta);
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().repairRepairedMessage));
        } else {
            player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().repairInvalidItemMessage));
        }
    }

    private void repairAll(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }

            ItemMeta meta = item.getItemMeta();
            if (meta instanceof Damageable damageable) {
                damageable.setDamage(0);
                item.setItemMeta(meta);
            }
        }
        player.sendMessage(MiniMessage.miniMessage().deserialize(ConfigUtils.getInstance().repairAllRepairedMessage));
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String partialArg = args[0].toLowerCase(); // The partially typed argument
            if ("hand".startsWith(partialArg)) {
                completions.add("hand");
            }
            if ("all".startsWith(partialArg)) {
                completions.add("all");
            }
        }
        return completions;
    }
}
