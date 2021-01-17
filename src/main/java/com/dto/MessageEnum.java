package com.dto;



/**
 * 消息的枚举 就是把所有的消息可能都列出来的
 */
//查询全部学生为例  查询成功   查询失败  当前没有数据
public enum MessageEnum {
     // 学生管理模块的提示
    GETALLSTUDENTSUCCESS(200, Messages.GETALLSTUDENTSUCCESS),
    GETALLSTUDENTFAIL(500,Messages.GETALLSTUDENTFAIL),
    GETALLSTUDENTNODATA(404,Messages.GETALLSTUDENTNODATA),

    GETCUSTOMERBYPAGESUCCESS(200, Messages.GETSTUDENTBYPAGESUCCESS),
    GETCUSTOMERBYPAGEFAIL(500,Messages.GETSTUDENTBYPAGEFAIL),

    ADDCUSTOMERSUCCESS(200, Messages.ADDCUSTOMERSUCCESS),
    ADDCUSTOMERFAIL(4003,Messages.ADDCUSTOMERFAIL),

    ADDEMPLOYRECORDSUCCESS(200, Messages.ADDEMPLOYRECORDSUCCESS),
    ADDEMPLOYRECORDSFAIL(4003,Messages.ADDEMPLOYRECORDSFAIL),

    //统计数据提示
    CHARTREFRESHSUCCESS(200, Messages.CHARTREFRESHSUCCESS),
    CHARTREFRESHFAIl(4003,Messages.CHARTREFRESHFAIl),

    //营养点餐模块的提示



    //合同管理 提示

    SEARCHEMPLOYBYPAGESUCCESS(200, Messages.SEARCHEMPLOYBYPAGESUCCESS),
    SEARCHEMPLOYBYPAGEFAIl(4003,Messages.SEARCHEMPLOYBYPAGEFAIl)
    ;
    private Integer code;//状态码
    private String message;




    MessageEnum() {
    }

    public Integer getCode() {
        return code;
    }

    MessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
