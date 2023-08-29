package xyz.mlhmz.mcserverinformation.serverinformationconsumer.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.listeners.ServerInformationListener;

@Configuration
@AllArgsConstructor
public class ListenerConfig {
    private final ServerInformationListener serverInformationListener;
    private final ChannelTopic channelTopic;
    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListener(), channelTopic);
        return container;
    }

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(serverInformationListener);
    }
}
