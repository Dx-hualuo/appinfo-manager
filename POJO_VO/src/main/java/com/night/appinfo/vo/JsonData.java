package com.night.appinfo.vo;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 *  Json前端交互数据
 * @author night
 */
public class JsonData implements Serializable {
    private Integer code;
    private String errorCode;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public JsonData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public JsonData setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonData setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonData setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JsonData.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("errorCode=" + errorCode)
                .add("message='" + message + "'")
                .add("data=" + data)
                .toString();
    }
}
