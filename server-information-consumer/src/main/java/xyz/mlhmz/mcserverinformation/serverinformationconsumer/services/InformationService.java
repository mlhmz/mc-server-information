package xyz.mlhmz.mcserverinformation.serverinformationconsumer.services;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.Information;

import java.util.List;

@Service
public class InformationService {
    public static final String INFORMATION_SERVER_HASH_KEY = "information:server";
    private final RedisTemplate<String, Information> template;

    public InformationService(RedisTemplate<String, Information> template) {
        this.template = template;
    }

    public void saveInformation(Information information) {
        template.opsForHash().put(INFORMATION_SERVER_HASH_KEY, information.getName(), information);
    }

    public List<Information> readAllInformation() {
        return template.opsForHash().entries(INFORMATION_SERVER_HASH_KEY)
                .values()
                .stream()
                .filter(Information.class::isInstance)
                .map(Information.class::cast)
                .toList();
    }
}
