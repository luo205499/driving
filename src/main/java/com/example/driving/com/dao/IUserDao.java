package com.example.driving.com.dao;

import com.example.driving.com.entity.User;

import java.util.List;

/**
 * @author ${lcl}
 * @Title: IUserDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:39
 */
public interface IUserDao {
    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    User loginTest(String username, String password);

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    User register(String username,String password);

    /**
     * 查看用户信息
     * @param id
     * @return
     */
    List queryUser(int id,int pageNo,int pageSize);

    List queryUserAll(int id);
}
