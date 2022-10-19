package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    void addAndSelect() throws SQLException {
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        UserDao userDao2 = context.getBean("awsUserDao", UserDao.class);

        System.out.println(userDao2);
        System.out.println(userDao);

        String id = "23";
        userDao.add(new User(id, "NuNum","1123qqwe"));

        User user = userDao.findById(id);
        Assertions.assertEquals("NuNum",user.getName());
    }
}