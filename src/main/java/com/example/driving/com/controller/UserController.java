package com.example.driving.com.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.example.driving.com.entity.User;
import com.example.driving.com.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {
	@Resource(name="userService")
	private IUserService userService;

	/**
	 * 登录验证
	 * 
	 * @author Lcl
	 * @param @param username
	 * @param @param password
	 * @param @param request
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @date 2018年12月14日 下午12:01:51
	 */
    @RequestMapping(value="login",method = RequestMethod.POST)
	@ResponseBody
	public User loginTest(String username,String password){
		User user = userService.loginTest(username,password);
		if(user!=null){
			return user;
		}else{
			return null;
		}
	}
	/**
	 * 注册用户
	 * 
	 * @author Lcl
	 * @param @param user
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @date 2018年12月15日 下午9:06:44
	 */

	@RequestMapping(value = "register",method = RequestMethod.POST)
	@ResponseBody
	public User register(String username,String password){
		User result=null;
		User re = userService.saveUser(username, password);
		if(re!=null){
			result= re;
		}
		return result;
	}
	/**
	 * 跳转用户信息界面
	 * @return
	 */
	@RequestMapping("displayUser")
	public String queryUser(){
		return "queryUser";
	}
	/**
	 * 查看用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("queryUser")
	@ResponseBody
	public List queryUser(int id){
		return userService.queryUser(id);
	}
	@RequestMapping("/")
	public String pageIndex(){
		return "pageIndex";
	}
	@RequestMapping("/backHome")
	public String backHome(){
		return "pageIndex";
	}
}
