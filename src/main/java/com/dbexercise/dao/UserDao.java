package com.dbexercise.dao;

import com.dbexercise.domain.User;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Map;

public class UserDao {
    private ConnectionMaker connectionMaker = new AwsConnectionMaker();

    public UserDao(){
        this.connectionMaker = new AwsConnectionMaker();
    }
    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException {

        Connection conn = connectionMaker.makeConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, password) values(?, ?, ?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2,user.getName());
        ps.setString(3, user.getPassword());

        int status = ps.executeUpdate();
        System.out.println(status);
        ps.close();
        conn.close();
        System.out.println("DB insert완료");

    }

    public User findById(String id) throws SQLException {
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT id, name, password FROM users WHERE id = ?"
        );
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"),
                rs.getString("name"), rs.getString("password"));
        rs.close();
        ps.close();
        conn.close();
        return user;

    }




}
