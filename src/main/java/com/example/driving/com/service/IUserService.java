package com.example.driving.com.service;

import com.example.driving.com.entity.User;

import java.util.List;

public interface IUserService {
	/**
	 * 登录验证
	* 
	* @author Lcl
	* @param @param username
	* @param @param password
	* @param @return    参数
	* @return List    返回类型
	* @throws
	* @date 2018年12月12日 下午10:03:59
	 */
	public User loginTest(String username, String password);
	/**
	 * 用户注册
	* 
	* @author Lcl
	* @param @param user
	* @param @return    参数
	* @return boolean    返回类型
	* @throws
	* @date 2018年12月14日 下午12:10:07
	 */
	User saveUser(String username,String password);

	/**
	 * 查看用户信息
	 * @param id
	 * @return
	 */
	List queryUser(int id,int pageNo,int pageSize);

	List queryUserAll(int id);
}
