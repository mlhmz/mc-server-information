package xyz.mlhmz.mcserverinformation.serverinformationproducer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Record that holds the information of the server
 *
 * @param motd Server Information from Minecraft
 * @param ip Server Information from Minecraft
 * @param name Name so that the subscriber can distinguish between producers
 * @param version Server Information from Minecraft
 * @param onlinePlayerNames Server Information from Minecraft
 * @param playerCount Server Information from Minecraft
 * @param maxPlayerCount Server Information from Minecraft
 * @param worldCount Server Information from Minecraft
 */
public record Information(
    String motd,
    String ip,
    String name,
    String version,
    List<String> onlinePlayerNames,
    long playerCount,
    int maxPlayerCount,
    long worldCount,
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    LocalDateTime lastFetched
) {}
