package com.web.controller;

import com.dto.BaseDto;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/configController")
public class ConfigCotroller {
    @Resource
    Environment environment;

    @GetMapping("/websocketServerInfo")
    public BaseDto<String> getWebSocketServerIP() throws UnknownHostException {
        String port = environment.getProperty("server.port");
        String netStr = InetAddress.getLocalHost().toString();
        return new BaseDto<String>(200,"ws://"+netStr.substring(netStr.indexOf('/')+1)+":"+port+"/socketServer/");


    }
}
