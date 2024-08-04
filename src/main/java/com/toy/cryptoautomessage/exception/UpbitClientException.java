package com.toy.cryptoautomessage.exception;

public class UpbitClientException extends RuntimeException{
    public UpbitClientException(String errMsg){
        super(String.format("업비트 API 호출 중 에러 발생. error=%s", errMsg));
    }
}
