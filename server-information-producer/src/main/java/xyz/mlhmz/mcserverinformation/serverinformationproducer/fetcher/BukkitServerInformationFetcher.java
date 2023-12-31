package xyz.mlhmz.mcserverinformation.serverinformationproducer.fetcher;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.Information;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of {@link InformationFetcher} that gets the server information by using the Bukkit {@link Server} Object
 */
public class BukkitServerInformationFetcher implements InformationFetcher {
    private final Server server;
    private final String serverName;

    public BukkitServerInformationFetcher(String serverName, Server server) {
        this.serverName = serverName;
        this.server = server;
    }

    @Override
    public Information fetch() {
        String motd = server.getMotd();
        String ip = server.getIp();
        String version = server.getVersion();
        List<String> onlinePlayerNames = server.getOnlinePlayers().stream()
                .map(Player::getDisplayName)
                .toList();
        // Long forced by stream().count()
        long playerCount = server.getOnlinePlayers().size();
        int maxPlayerCount = server.getMaxPlayers();
        long worldCount = server.getWorlds().size();
        return new Information(
                motd, ip, serverName, version, onlinePlayerNames, playerCount, maxPlayerCount, worldCount,
                LocalDateTime.now()
        );
    }
}
