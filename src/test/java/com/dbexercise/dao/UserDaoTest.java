package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDaoFactory().awsUserDao();
        String id = "21";
        userDao.add(new User(id, "NuNum","1123qqwe"));

        User user = userDao.findById(id);
        Assertions.assertEquals("NuNum",user.getName());
    }
}