package com.night.appinfo.exception;

/*
 * @description: 自定义业务异常
 * @author: ASUS-
 * @create: 2020-10-16
 * @version: 1.0
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }
}
