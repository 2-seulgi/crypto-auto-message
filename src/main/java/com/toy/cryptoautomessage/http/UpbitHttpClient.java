package com.toy.cryptoautomessage.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpbitHttpClient {
    private final HttpClient httpClient;

    public UpbitTickerDto getTickerByMarket (String market)  {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("accept", "application/json");
            String execute = httpClient.execute(
                    "https://api.upbit.com/v1/ticker?markets="+market,
                    HttpMethod.GET,
                    headers
            );
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(
                    execute,
                    new TypeReference<List<UpbitTickerDto>>()  {}
            ).stream().findFirst().get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
