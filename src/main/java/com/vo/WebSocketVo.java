package com.vo;

import javax.websocket.Session;
import java.io.Serializable;

/**
 * @Author LG
 * @Email
 * @Date 2020/7/11 上午9:08
 */
public class WebSocketVo implements Serializable {



    private String userName;

    private Session session;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public WebSocketVo(String userName, Session session) {
        this.userName = userName;
        this.session = session;
    }

    public WebSocketVo() {
    }
}
