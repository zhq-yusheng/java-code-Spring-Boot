package com.web.controller;

import com.dto.BaseDto;
import com.dto.Connect;
import com.dto.User;
import com.entity.Customer;
import com.jdbc.Jdbc;
import com.luckyDraw.RandomDraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
@RequestMapping("/customerController")
public class CustomerController {
    @Autowired
    private Jdbc jdbc;
    @Autowired
    private RandomDraw randomDraw;

    private ArrayList<User> data; //用来存储中奖的名单信息，客户端请求就拿这个数据
    /**
     * 会员充值
     *
     * @param customer
     * @return
     * @throws Exception
     */
    @GetMapping("/customer/ttt")
    @ResponseBody
    public BaseDto<Customer> tt(Customer customer) throws Exception {
        BaseDto dto = new BaseDto();
        dto.setMsg("111");
        System.out.println(customer.getCdesc()+"+++++++++++++++++");
        return dto;
    }
    //录入数据的接口
    @GetMapping("/getFrom")
    @ResponseBody
    public BaseDto getFrom(User user)  {
        BaseDto dto = new BaseDto();
        if(!jdbc.addQuery(user.getId())){
            jdbc.add(user);
            dto.setCode(200);
            dto.setMsg("数据添加成功");
            return dto;
        }else {
            dto.setMsg("你的数据已添加，请勿重复添加！~");
            dto.setCode(200);
            return dto;
        }

    }
    //抽奖调用的接口
    @GetMapping("/random")
    @ResponseBody
    public BaseDto<User> random(Connect connect) {
        BaseDto dto = new BaseDto();
        ArrayList<User> users = randomDraw.randomGet(connect.getCode(), connect.getNumber());
        this.data=users;
        dto.setObj(users);
        dto.setMsg("抽奖完成");
        dto.setCode(200);
        return dto;
    }
    //获取中奖名单的接口
    @GetMapping("/getData")
    @ResponseBody
    public BaseDto<User> getData()  {
        BaseDto dto = new BaseDto();
        dto.setObj(data);
        dto.setMsg("中奖名单");
        dto.setCode(200);
        return dto;
    }
}
