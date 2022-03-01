package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.ApiApplication;
import com.qfedu.fmmall.fmmall.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;





    @Test
    public void queryUserByName() {
        User user = userDao.queryUserByName("lvxinxin");
        System.out.println(user);
    }
}