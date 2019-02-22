package com.baizhi;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZxtpApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setVuUserName("qweqwe");
        User user1 = userMapper.selectUserByObj(user);
        //User user1 = userMapper.selectByPrimaryKey(1);
        System.out.println(user1);
    }

}
