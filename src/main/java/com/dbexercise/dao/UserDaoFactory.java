package com.dbexercise.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {
    //조립을 해줍니다.
    @Bean
    public UserDao awsUserDao(){
        AwsConnectionMaker awsConnectionMaker = new AwsConnectionMaker();
        UserDao userDao = new UserDao(awsConnectionMaker);
        return userDao;
    }

    @Bean
    public UserDao localUserDao(){
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }

}
