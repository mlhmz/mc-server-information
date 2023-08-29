package xyz.mlhmz.mcserverinformation.serverinformationconsumer.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.Information;
import xyz.mlhmz.mcserverinformation.serverinformationconsumer.services.InformationService;

import java.io.IOException;
import java.util.Arrays;

/**
 * Server Information Listener that listens to the Server Info Event
 */
@Service
@Slf4j
public class ServerInformationListener implements MessageListener {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final InformationService informationService;

    public ServerInformationListener(InformationService informationService) {
        this.informationService = informationService;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            String body = new String(message.getBody());
            log.info("Incoming message {}", body);

            Information information = objectMapper.readValue(body, Information.class);
            informationService.saveInformation(information);
        } catch (IOException e) {
            log.error("The server information message couldn't be casted to the information class", e);
        }
    }
}
