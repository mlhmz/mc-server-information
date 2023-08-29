package xyz.mlhmz.mcserverinformation.serverinformationproducer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.ServerInformationProducer;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ServerInformationProducerCommand implements CommandExecutor {
    private final ServerInformationProducer plugin;

    public ServerInformationProducerCommand(ServerInformationProducer plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
                             String[] args) {
        Map<String, Runnable> subCommands = getSubCommands(sender);
        String availableCommands = String.join("|", subCommands.keySet());
        if (args.length == 0 || args[0] == null) {
            sender.sendMessage(String.format("No args were provided. Please try again. Usage: /%s <%s>", label,
                    availableCommands));
            return false;
        }
        Runnable subCommand = subCommands.get(args[0]);
        if (subCommand == null) {
            sender.sendMessage(String.format("No command was found. Please try again. Usage: /%s <%s>", label,
                    availableCommands));
            return false;
        }
        subCommand.run();
        return true;
    }

    private Map<String, Runnable> getSubCommands(CommandSender sender) {
        Map<String, Runnable> subCommands = new HashMap<>();
        subCommands.put("reload", () -> executeReloadCommand(sender));
        subCommands.put("info", () -> executeInfoCommand(sender));
        return subCommands;
    }

    private void executeReloadCommand(CommandSender sender) {
        if (!sender.hasPermission("sip.reload")) {
            sender.sendMessage("You have no permission to reload this plugin.");
            return;
        }
        plugin.reload();
    }

    private void executeInfoCommand(CommandSender sender) {
        if (!sender.hasPermission("sip.info")) {
            sender.sendMessage("You have no permission to look at this plugins info.");
            return;
        }
        sender.sendMessage("ServerInformationProducer Info");
        sender.sendMessage("Redis");
        sender.sendMessage(String.format("Host: %s", plugin.getRedisHost()));
        sender.sendMessage(String.format("Port: %d", plugin.getRedisPort()));
        sender.sendMessage(String.format("Channel: %s", plugin.getRedisChannel()));
        sender.sendMessage("Scheduling");
        sender.sendMessage(String.format("Delay: %d", plugin.getScheduleDelay()));
        sender.sendMessage(String.format("Last Executed: %s",
                DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss").format(plugin.getLastExecution())));
    }
}
