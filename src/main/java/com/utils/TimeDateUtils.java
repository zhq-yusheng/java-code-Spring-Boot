package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDateUtils {
     public static synchronized Date getCurrDate() throws ParseException {
         long currTime = System.currentTimeMillis();
         SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
         String mno = sf.format(new Date(currTime));//生成由时间格式化成的主键

         sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.parse(sf.format(new Date(currTime)));
     }

    public static synchronized String getCurrDateAndTimeString(){
        long currTime = System.currentTimeMillis();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentString = sf.format(new Date(currTime));//生成由时间格式化成的主键
      return currentString;
    }
}
