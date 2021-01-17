package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vo.MailUser;

import java.io.Serializable;
import java.util.Date;


/**
 * @author 
 */
public class Customer extends MailUser implements Serializable {
    /**
     * 会员编号
     */
    private String cid;

    /**
     * 会员名
     */
    private String cname;

    /**
     * 性别
     */
    private String csex;

    /**
     * 生日
     */
    private Date cbirthday;

    /**
     * 等级
     */
    private Integer clevel;

    /**
     * 密码
     */
    private String cpwd;

    /**
     * 余额
     */
    private Integer ccost;

    /**
     * 头像
     */
    private String chead;

    /**
     * 身高
     */
    private Integer chigh;

    /**
     * 体重
     */
    private Integer cweight;

    /**
     * 体脂比
     */
    private Integer bodyfat;

    /**
     * 个人既往病史和忌口描述
     */
    private String cdesc;

    /**
     * 会员邮箱
     */
    private String cemail;



    //shiro 准备 登录用的 成员变量和方法
    String salt;//加密用的盐
    Integer isDelete;
    Date createDate;
    Boolean locked = Boolean.FALSE;//是否锁定




    @JsonIgnore

    public String getAccountname() {
        return cname;
    }


    @JsonIgnore

    public String getPassword() {
        return cpwd;
    }


    @JsonIgnore

    public String getSalt() {
        return salt;
    }


    public void setSalt(String salt) {
        this.salt = salt;
    }


    public Integer getIsDelete() {
        return isDelete;
    }


    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Boolean getLocked() {
        return locked;
    }


    public void setLocked(Boolean locked) {
        this.locked = locked;
    }




    @JsonIgnore
    public String getCredentialsSalt()
    {
        return getAccountname() + salt;
    }
    //结束    shiro 准备 登录用的 成员变量和方法









    private static final long serialVersionUID = 1L;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
        this.mailName = cname;
    }






    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public Date getCbirthday() {
        return cbirthday;
    }

    public void setCbirthday(Date cbirthday) {
        this.cbirthday = cbirthday;
    }

    public Integer getClevel() {
        return clevel;
    }

    public void setClevel(Integer clevel) {
        this.clevel = clevel;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public Integer getCcost() {
        return ccost;
    }

    public void setCcost(Integer ccost) {
        this.ccost = ccost;
    }

    public String getChead() {
        return chead;
    }

    public void setChead(String chead) {
        this.chead = chead;
    }

    public Integer getChigh() {
        return chigh;
    }

    public void setChigh(Integer chigh) {
        this.chigh = chigh;
    }

    public Integer getCweight() {
        return cweight;
    }

    public void setCweight(Integer cweight) {
        this.cweight = cweight;
    }

    public Integer getBodyfat() {
        return bodyfat;
    }

    public void setBodyfat(Integer bodyfat) {
        this.bodyfat = bodyfat;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
        this.mailAddress = cemail;
    }





    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Customer other = (Customer) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getCsex() == null ? other.getCsex() == null : this.getCsex().equals(other.getCsex()))
            && (this.getCbirthday() == null ? other.getCbirthday() == null : this.getCbirthday().equals(other.getCbirthday()))
            && (this.getClevel() == null ? other.getClevel() == null : this.getClevel().equals(other.getClevel()))
            && (this.getCpwd() == null ? other.getCpwd() == null : this.getCpwd().equals(other.getCpwd()))
            && (this.getCcost() == null ? other.getCcost() == null : this.getCcost().equals(other.getCcost()))
            && (this.getChead() == null ? other.getChead() == null : this.getChead().equals(other.getChead()))
            && (this.getChigh() == null ? other.getChigh() == null : this.getChigh().equals(other.getChigh()))
            && (this.getCweight() == null ? other.getCweight() == null : this.getCweight().equals(other.getCweight()))
            && (this.getBodyfat() == null ? other.getBodyfat() == null : this.getBodyfat().equals(other.getBodyfat()))
            && (this.getCdesc() == null ? other.getCdesc() == null : this.getCdesc().equals(other.getCdesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getCsex() == null) ? 0 : getCsex().hashCode());
        result = prime * result + ((getCbirthday() == null) ? 0 : getCbirthday().hashCode());
        result = prime * result + ((getClevel() == null) ? 0 : getClevel().hashCode());
        result = prime * result + ((getCpwd() == null) ? 0 : getCpwd().hashCode());
        result = prime * result + ((getCcost() == null) ? 0 : getCcost().hashCode());
        result = prime * result + ((getChead() == null) ? 0 : getChead().hashCode());
        result = prime * result + ((getChigh() == null) ? 0 : getChigh().hashCode());
        result = prime * result + ((getCweight() == null) ? 0 : getCweight().hashCode());
        result = prime * result + ((getBodyfat() == null) ? 0 : getBodyfat().hashCode());
        result = prime * result + ((getCdesc() == null) ? 0 : getCdesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", cname=").append(cname);
        sb.append(", csex=").append(csex);
        sb.append(", cbirthday=").append(cbirthday);
        sb.append(", clevel=").append(clevel);
        sb.append(", cpwd=").append(cpwd);
        sb.append(", ccost=").append(ccost);
        sb.append(", chead=").append(chead);
        sb.append(", chigh=").append(chigh);
        sb.append(", cweight=").append(cweight);
        sb.append(", bodyfat=").append(bodyfat);
        sb.append(", cdesc=").append(cdesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}