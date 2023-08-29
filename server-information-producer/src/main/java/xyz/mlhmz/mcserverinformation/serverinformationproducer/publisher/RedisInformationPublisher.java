package xyz.mlhmz.mcserverinformation.serverinformationproducer.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.Information;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.ServerInformationProducer;

import java.util.logging.Level;

public class RedisInformationPublisher implements InformationPublisher {
    private final Jedis client;
    private final String channel;
    private final ServerInformationProducer plugin;

    public RedisInformationPublisher(Jedis client, String channel,
                                     ServerInformationProducer plugin) {
        this.client = client;
        this.channel = channel;
        this.plugin = plugin;
    }

    @Override
    public void publish(Information information) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            client.publish(channel, objectMapper.writeValueAsString(information));
        } catch (JsonProcessingException e) {
            plugin.getLogger().log(Level.SEVERE, "The information couldn't be mapped to JSON.");
        }
    }
}
