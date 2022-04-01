package com.dfedu.fmmall.service.impl;

import com.dfedu.fmmall.service.UserService;
import com.qfedu.fmmall.dao.UserDao;
import com.qfedu.fmmall.entity.Users;
import com.qfedu.fmmall.utils.MD5Utils;
import com.qfedu.fmmall.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDAO;

    /**
     * 注册
     * @param name
     * @param pwd
     * @return
     */
    @Transactional
    public ResultVO userResgit(String name, String pwd) {
        synchronized (this) {
            //1.根据⽤户查询，这个⽤户是否已经被注册
            Users user = userDAO.queryUserByName(name);
            //2.如果没有被注册则进⾏保存操作
            if (user == null) {
                String md5Pwd = MD5Utils.md5(pwd);
                user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = userDAO.insertUser(user);
                if (i > 0) {
                    return new ResultVO(10000, "注册成功！", null);
                } else {
                    return new ResultVO(10002, "注册失败！", null);
                }
            } else {
                return new ResultVO(10001, "⽤户名已经被注册！", null);
            }
        }
    }

    /**
     * 登录
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public ResultVO checkLogin(String name, String pwd) {
        Users user = userDAO.queryUserByName(name);
        if(user == null){
            return new ResultVO(10001,"登录失败，⽤户名不存在！",null);
        }else{
            String md5Pwd = MD5Utils.md5(pwd);
            if(md5Pwd.equals(user.getPassword())){
                return new ResultVO(10000,"登录成功！",user.getUsername());
            }else{
                return new ResultVO(10001,"登录失败，密码错误！",null);
            }
        }
    }
}
