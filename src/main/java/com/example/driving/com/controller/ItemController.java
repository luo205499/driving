package com.example.driving.com.controller;

import javax.annotation.Resource;

import com.example.driving.com.entity.Item;
import com.example.driving.com.service.IItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ItemController {
	@Resource
	private IItemService itemService;

	/**
	 * 跳转模拟考试界面
	 *
	 * @author Lcl
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @date 2018年12月16日 下午2:35:16
	 */
	@RequestMapping("mockExam")
	public String mockExam(){
		return "mockExam";
	}
	/**
	 * 模拟考试
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/getitem")
	@ResponseBody
	public Item getItem(int pageNum){
		return itemService.getItem(pageNum); 
	}

	/**
	 * 跳转随机练习界面
	 * @return practice2
	 */
	@RequestMapping("practice")
	public String practice(){
		return "practice";
	}

	/**
	 * 跳转顺序练习界面
	 * @return
	 */
	@RequestMapping("practice2")
	public String practice2(){
		return "practice2";
	}
	/**
	 * 获取随机练习试题
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/practiceAny")
	@ResponseBody
	public Item practiceAny(int pageNum){
		return  itemService.practiceAny(pageNum);
	}

	/**
	 * 顺序练习
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/practiceOrder")
	@ResponseBody
	public Item practiceOrder(int pageNum){
		return  itemService.practiceOrder(pageNum);
	}

	/**
	 * 跳转添加试题界面
	 * @param
	 * @return
	 */
	@RequestMapping("toaddItem")

	public String toaddItem(){
		return "addItem";
	}
	/**
	 * 添加试题
	 * @param item
	 * @return
	 */
	@RequestMapping("addItem")
	@ResponseBody
	public int addItem(Item item){
		return itemService.addItem(item);
	}

}
