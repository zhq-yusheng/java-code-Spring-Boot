package com.jdbc;

import com.dto.User;
import com.utils.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class Jdbc {
    @Autowired
    public JdbcUtils jdbcUtils;
    public void add(User user) {
        Connection connection = jdbcUtils.getConnection();
        String sql = "insert into user(id,username,phoneId) values(?,?,?)";
        PreparedStatement statement =null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getId());
            statement.setString(2,user.getUser());
            statement.setString(3,user.getPhoneId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean addQuery(String id){
        Connection connection = jdbcUtils.getConnection();
        String sql="select * from user where id=?";
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        boolean flg=true;
        try {
          statement = connection.prepareStatement(sql);
          statement.setString(1,id);
          resultSet = statement.executeQuery();
          flg=resultSet.next();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flg;
    }
    public ArrayList<User> query(){
        ArrayList<User> users = new ArrayList<>();
        Connection connection = jdbcUtils.getConnection();
        String sql = "select * from user where code=?";
        PreparedStatement statement =null;
        ResultSet resultSet =null;
        try {
             statement = connection.prepareStatement(sql);
             statement.setInt(1,0);
             resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("id");
                String userName = resultSet.getString(2);
                String phoneId = resultSet.getString("phoneId");
                users.add(new User(id,userName,phoneId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void update(int code,ArrayList<String> ids){
        Connection connection = jdbcUtils.getConnection();
        String sql ="update user set code=? where id in (";
        for (int i = 0; i < ids.size(); i++) {
            if(i==ids.size()-1) sql+="?)";
            else sql+="?,";
        }
        PreparedStatement statement =null;
        try {
             statement = connection.prepareStatement(sql);
             statement.setInt(1,code);
            for (int i = 2; i < ids.size()+2; i++) {
                statement.setString(i,ids.get(i-2));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
