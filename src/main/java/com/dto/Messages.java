package com.dto;

import java.io.IOException;
import java.util.Properties;

/**
 * 主要用于存放各种提示信息
 * @author:LG
 * @date:Created at 2019/03/09
 */
public class Messages {
    public static String getGetallstudentsuccess= "";

   static{
       Properties prop = new Properties();// 空的配置类
       try {
           prop.load(Messages.class.getResourceAsStream("/messages.properties"));// Object.class找到jvm运行的class文件所在的目录，
       } catch (IOException e) {
           e.printStackTrace();
       }
       // getResourceAsStream 以流的形式将文件读到内存，不写/ 根路径表示当前class所在的文件夹下面找文件 写
       // 根路径就是当前项目下面找文件 bin
       getGetallstudentsuccess = prop.get("getGetallstudentsuccess").toString();
   }
    /*会员模块操作信息*/
    public final static String GETALLSTUDENTSUCCESS= getGetallstudentsuccess;
    public final static String GETALLSTUDENTFAIL= "查询全部学生失败，请联系管理员";
    public final static String GETALLSTUDENTNODATA= "没有数据";


    public final static String GETSTUDENTBYPAGESUCCESS= "分页查询成功";
    public final static String GETSTUDENTBYPAGEFAIL= "分页查询失败";

    public final static String ADDCUSTOMERSUCCESS= "增加成功";
    public final static String ADDCUSTOMERFAIL= "增加失败";

/*合同操作信息*/
    public final static String ADDEMPLOYRECORDSUCCESS= "签约成功";
    public final static String ADDEMPLOYRECORDSFAIL= "签约失败";

    public final static String SEARCHEMPLOYBYPAGESUCCESS= "搜索合同成功";
    public final static String SEARCHEMPLOYBYPAGEFAIl= "搜索合同没有查询到数据";


    /*图表数据信息*/
    public final static String CHARTREFRESHSUCCESS= "图表数据读取成功";
    public final static String CHARTREFRESHFAIl= "图表数据读取失败";






}
