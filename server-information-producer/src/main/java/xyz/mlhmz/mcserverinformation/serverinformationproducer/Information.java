package xyz.mlhmz.mcserverinformation.serverinformationproducer;

import java.util.List;

/**
 * Record that holds the information of the server
 */
public record Information(
    String motd,
    String ip,
    String name,
    String version,
    List<String> onlinePlayerNames,
    long playerCount,
    int maxPlayerCount,
    long worldCount
) {}
