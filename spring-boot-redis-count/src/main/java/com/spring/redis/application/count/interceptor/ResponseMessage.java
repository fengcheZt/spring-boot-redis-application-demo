package com.spring.redis.application.count.interceptor;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 8068359291479546370L;

    private int code;

    private String errorMsg;

    private T Data;

    public ResponseMessage(int code, String errorMsg, T data) {
        this.code = code;
        this.errorMsg = errorMsg;
        Data = data;
    }

    public ResponseMessage(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public ResponseMessage() {
    }
}
