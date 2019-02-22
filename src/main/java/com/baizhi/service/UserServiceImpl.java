package com.baizhi.service;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User user = new User();
        user.setVuUserName(username);
        User user1 = userMapper.selectUserByObj(user);
        System.out.println("-----service--------" + user1);
        // 判断是否存在
        if (user1 == null) {
            return false;
        } else {
            // 判断密码是否正确
            if (password.equals(user1.getVuPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Integer regist(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }

    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setVuUserName(username);
        User user1 = userMapper.selectUserByObj(user);
        return user1;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        int i = userMapper.updateByPrimaryKeySelective(record);
        return i;
    }
}
