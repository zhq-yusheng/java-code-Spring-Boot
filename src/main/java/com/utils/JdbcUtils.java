package com.utils;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class JdbcUtils {
    public static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?characterEncoding=UTF-8&serverTimezone=GMT&useUnicode=true", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  Connection getConnection(){
        return connection;
    }

    public   void close(Connection con,PreparedStatement pst){
        close(con,null,pst);
    }
    public   void close(Connection con, ResultSet resultSet, PreparedStatement pst){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
