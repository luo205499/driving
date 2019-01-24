package com.example.driving.com.controller;

import javax.annotation.Resource;
import com.example.driving.com.entity.User;
import com.example.driving.com.service.IUserService;
import com.example.driving.com.util.JiaMi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
		JiaMi jiaMi=new JiaMi();
		User user = userService.loginTest(username,jiaMi.MD5Jiami(password));
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
		JiaMi jiaMi=new JiaMi();
		User re = userService.saveUser(username, jiaMi.MD5Jiami(password));
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
	public List queryUser(int id,int pageNo,int pageSize){
		return userService.queryUser(id,pageNo,pageSize);
	}

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	@RequestMapping("queryUserByUsername")
	@ResponseBody
	public int queryUserByUsername(String username) {
		return userService.queryUserByUsername(username);
	}

	/**
	 * 查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping("queryUserAll")
	@ResponseBody
	public List queryUser(int id){
		return userService.queryUserAll(id);
	}

	/**
	 * 成绩排行
	 * @return
	 */
	@RequestMapping("orderByUser")
	@ResponseBody
	public List orderByUser(){
		return userService.orderByUser();
	}

	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/")
	public String pageIndex(){
		return "pageIndex";
	}

	/**
	 * 返回主页
	 * @return
	 */
	@RequestMapping("/backHome")
	public String backHome(){
		return "pageIndex";
	}

	@RequestMapping("/test")
	public String uploadimg(){
		return "uploadimg";
	}
}
