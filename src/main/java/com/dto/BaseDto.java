package com.dto;

import java.util.List;


/**
 * 数据传输层
 * @author:LG
 * @date:Created at 2019/03/09
 */
public class BaseDto<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 传输的单个对象
     */
    private T t;

    /**
     * 需要传输的列表
     */
    private List<T> tList;

    private Object obj;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public BaseDto() {
    }


    public BaseDto(Integer code, String msg, String url) {
        this.code = code;
        this.msg = msg;
        this.url = url;
    }

    /**
     * 自定义信息的构造器
     * @param code
     * @param msg
     */
    public BaseDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 失败的构造
     * @param messageEnum : 对应的消息枚举对象
     */
    public BaseDto(MessageEnum messageEnum) {
        this.code = messageEnum.getCode();
        this.msg = messageEnum.getMessage();
    }


    /**
     * 成功的构造:传递一个对象
     * @param messageEnum
     * @param t
     */
    public BaseDto(MessageEnum messageEnum, T t) {
        this.code = messageEnum.getCode();
        this.msg = messageEnum.getMessage();
        this.t = t;
    }


    /**
     * 成功的构造:传递列表
     * @param messageEnum
     * @param tList
     */
    public BaseDto(MessageEnum messageEnum, List<T> tList) {
        this.code = messageEnum.getCode();
        this.msg = messageEnum.getMessage();
        this.tList = tList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }
}
