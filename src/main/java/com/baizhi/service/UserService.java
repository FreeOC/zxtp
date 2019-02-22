package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {

    Integer regist(User user);

    boolean login(String username, String password);

    User getUser(String username);

    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);
}
