package xyz.mlhmz.mcserverinformation.serverinformationconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
public class TopicConfig {
    @Value("${app.redis.topic}")
    private String topic;

    @Bean
    ChannelTopic channelTopic() {
        return new ChannelTopic(topic);
    }
}
