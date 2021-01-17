package com.dto;

import java.util.ArrayList;

public class Connect {
    private int code; // 第几次抽奖
    private int number; // 抽几个

    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Connect(int code, int number) {
        this.code = code;
        this.number = number;
    }

    public Connect() {
    }
}
