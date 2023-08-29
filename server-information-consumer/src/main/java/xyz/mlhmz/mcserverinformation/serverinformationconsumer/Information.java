package xyz.mlhmz.mcserverinformation.serverinformationconsumer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime lastFetched;
}
