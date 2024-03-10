package com.usercenter.center.common;

import lombok.Data;

import java.io.Serializable;

/**
 *@author  fyy
 *@version 1.0
 *@time    2024-03-0315:23
 *@project Center
 */
@Data
public class baseRespond<T> implements Serializable
{
    private static final long serialVersionUID = -4129184299717699449L;
    private int code;
    private T data;
    private String message;

    private String description;

    public baseRespond(int code, T data, String message,String description)
    {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public baseRespond(int code, T data)
    {
        this(code,data,"","");
    }

    public baseRespond(int code, T data, String message)
    {
        this(code,data,message,"");
    }

    public baseRespond(int code,String message,String description)
    {
        this(code,null,message,description);
    }

    public baseRespond(ErrorCode errorCode)
    {
        this(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription());
    }

    public baseRespond(ErrorCode errorCode, String message, String description)
    {
        this(errorCode.getCode(),null,message,description);
    }
}
