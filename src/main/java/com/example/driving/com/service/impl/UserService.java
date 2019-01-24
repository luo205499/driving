package com.example.driving.com.service.impl;


import javax.annotation.Resource;

import com.example.driving.com.dao.IUserDao;
import com.example.driving.com.entity.User;
import com.example.driving.com.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @Description: 用户处理Service实现类
 * @author lcl
 * @date 2018年12月14日
 */
@Service
public class UserService implements IUserService {

	@Resource(name="userDao")
	private IUserDao userDao;

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User loginTest(String username, String password) {
		User re = userDao.loginTest(username,password);
		if(re!=null){
				return re;
		}
		return null;
	}

	/**
	 * 用户注册
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User saveUser(String username,String password) {
		return userDao.register(username,password);
	}

	@Override
	public List queryUser(int id,int pageNo,int pageSize) {
		return userDao.queryUser(id,pageNo,pageSize);
	}

	@Override
	public List queryUserAll(int id) {
		return userDao.queryUserAll(id);
	}

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	@Override
	public int queryUserByUsername(String username) {
		return userDao.queryUserByUsername(username);
	}

	/**
	 * 成绩排行
	 * @return
	 */
	@Override
	public List orderByUser() {
		return userDao.orderByUser();
	}


}
