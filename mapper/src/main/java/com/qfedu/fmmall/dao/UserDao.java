package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {


    /**
     * 用户注册
     * @param user
     * @return
     */
    public int insertUser(Users user);

    /**
     * 根据用户查询用户信息
     * @param name
     * @return
     */
    public Users queryUserByName(String name);



}
