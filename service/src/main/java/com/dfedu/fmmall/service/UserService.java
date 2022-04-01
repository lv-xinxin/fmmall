package com.dfedu.fmmall.service;

import com.qfedu.fmmall.vo.ResultVO;


public interface UserService {


    /**
     * 用户注册
     * @param name
     * @param pwd
     * @return
     */
    public ResultVO userResgit(String name,String pwd);

    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    public ResultVO checkLogin(String name,String pwd);



}
