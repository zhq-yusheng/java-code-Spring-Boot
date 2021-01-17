package com.luckyDraw;

import com.dto.User;
import com.jdbc.Jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Component
public class RandomDraw {
    @Autowired
    private Jdbc jdbc;
    public ArrayList<User> randomGet(int code,int number){
        ArrayList<User> query = jdbc.query();
        Collections.shuffle(query);//打乱集合
        ArrayList<Integer> indexs= new ArrayList<>();
        Random random = new Random();
        while (indexs.size()<number){
            int i = random.nextInt(query.size());
            if(!indexs.contains(i)) indexs.add(i);
        }
        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        for (Integer index : indexs) {
            ids.add(query.get(index).getId());
            users.add(query.get(index));
        }
        jdbc.update(code,ids);
        return users;
    }
}
