package com.toy.cryptoautomessage.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackHttpClient {
    public void send(String message){
        try {
            Slack instance = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send("https://hooks.slack.com/services/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", payload);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
