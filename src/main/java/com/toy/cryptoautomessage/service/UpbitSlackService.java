package com.toy.cryptoautomessage.service;

import com.toy.cryptoautomessage.http.SlackHttpClient;
import com.toy.cryptoautomessage.http.UpbitHttpClient;
import com.toy.cryptoautomessage.http.UpbitTickerDto;
import com.toy.cryptoautomessage.repository.ReportHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final ReportHistoryRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(UpbitSlackService.class);

    public void execute(String market){
        // 호출
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerByMarket(market);
        // 가격 포맷팅
        DecimalFormat df = new DecimalFormat("#,###");
        String formatPrice = df.format(tickerByMarket.getTrade_price()) + "원";

        // 메세지 발송
        StringBuilder sb = new StringBuilder();
        sb.append("실시간 데이터 ");
        sb.append(market);
        sb.append(" 비트코인 가격 : " );
        sb.append(formatPrice);

        // 메세지 발송 전 로그 출력
        String message = sb.toString();
        logger.info("Slack message: " + message);

        slackHttpClient.send(sb.toString());

        // 메세지 발송 후 로그 출력
        logger.info("market: " + market);

        // 메세지 내역 저장
        repository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }

}

