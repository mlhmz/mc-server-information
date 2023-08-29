package xyz.mlhmz.mcserverinformation.serverinformationconsumer;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Record that holds the information of the server
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("Information")
public class Information {
    private String motd;
    private String ip;
    private String name;
    private String version;
    private List<String> onlinePlayerNames;
    private long playerCount;
    private int maxPlayerCount;
    private long worldCount;
    private LocalDateTime lastFetched;
}
