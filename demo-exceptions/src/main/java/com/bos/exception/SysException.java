package com.bos.exception;

/**
 * Created by LaoWang on 2017/7/26.
 */
public class SysException extends Exception {
    private String message;
    public String getMessage() {
        return message;
    }

    public SysException(String message) {
        this.message = message;
    }
}