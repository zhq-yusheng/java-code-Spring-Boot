package com.web.controller;

import com.dto.BaseDto;
import com.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * websocket
 * 消息推送(个人和广播)
 */
@RestController
public class WebSocketController {

    @Autowired
    private SocketServer socketServer;
    /**
     *
     * 客户端页面
     * @return
     */
    @RequestMapping(value = "/index")
    public String idnex() {

        return "index";
    }

    /**
     *
     * 服务端页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/webSocketAdmin")
    public BaseDto admin(Model model) {
        int num = socketServer.getOnlineNum();
        List<String> list = socketServer.getOnlineUsers();

       BaseDto dto = new BaseDto();
       dto.setT(num);
       dto.settList(list);
        return dto;
    }

    /**
     * 个人信息推送
     * @return
     */
    @RequestMapping("sendmsg")
    @ResponseBody
    public BaseDto sendmsg(String msg, String username){
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的用户人数
        String [] persons = username.split(",");
        SocketServer.sendMany(msg,persons);
        return new BaseDto(200,"success");
    }

    /**
     * 推送给所有在线用户
     * @return
     */
    @RequestMapping("sendAll")
    @ResponseBody
    public BaseDto sendAll(String msg){
        SocketServer.sendAll(msg);
        return new BaseDto(200,"success");
    }
}
