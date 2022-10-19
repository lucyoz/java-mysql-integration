package com.dbexercise.dao;

public class UserDaoFactory {
    //조립을 해줍니다.
    public UserDao awsUserDao(){
        AwsConnectionMaker awsConnectionMaker = new AwsConnectionMaker();
        UserDao userDao = new UserDao(awsConnectionMaker);
        return userDao;
    }

    public UserDao localUserDao(){
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }

}
