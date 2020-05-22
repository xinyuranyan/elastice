package com.lixx.elasticsearchtemplate.exception;

/**
 * @author : lxx
 * @date: 2020/5/22 17:25
 * @description:
 */
public class ErrorCodeException extends RuntimeException {
    private String code;

    public ErrorCodeException(String code) {
        this.code = code;
    }

    public ErrorCodeException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public ErrorCodeException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public ErrorCodeException(String code, String msg, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}