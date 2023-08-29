package xyz.mlhmz.mcserverinformation.serverinformationconsumer.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.Information;

@Configuration
@AllArgsConstructor
public class RedisConfiguration {
    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Information> redisTemplate() {
        final RedisTemplate<String, Information> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Information.class));
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Information.class));
        return template;
    }
}
