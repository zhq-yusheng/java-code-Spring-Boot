package com.vo;

public class MailUser {
    protected String mailAddress;
    protected String mailName;
    private  String op;


    public MailUser() {
    }

    public MailUser(String mailAddress, String mailName) {
        this.mailAddress = mailAddress;
        this.mailName = mailName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public  void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
