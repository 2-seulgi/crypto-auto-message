package com.toy.cryptoautomessage.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Component
public class SlackHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(SlackHttpClient.class);

    public void send(String message){
        try {
            logger.info("Sending Slack message: " + message);

            Slack instance = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send("https://hooks.slack.com/services/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", payload);
            logger.info("메세지 전송 성공");

        }catch (IOException e){
            logger.error("메세지 전송 실패", e);
            throw new RuntimeException(e);
        }
    }
}
