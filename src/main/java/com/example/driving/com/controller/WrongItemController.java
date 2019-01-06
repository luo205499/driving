package com.example.driving.com.controller;

import com.example.driving.com.entity.Item;
import com.example.driving.com.entity.WrongItem;
import com.example.driving.com.service.IWrongItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;


@Controller
public class WrongItemController {
	@Resource
	private IWrongItemService wrongItemService;
	/**
	 * 保存错误试题
	 * @param item
	 * @return
	 */
	@RequestMapping("addWrongItem")
	@ResponseBody
	public int addItem(WrongItem item){
		return wrongItemService.addItem(item);
	}

	/**
	 * 进入错题界面
	 * @return
	 */
	@RequestMapping("toWrongPractice")
	public String  toWrongPractice(){
		return "wrongPractice";
	}
	/**
	 * 查询错题
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/getWrongItem")
	@ResponseBody
	public WrongItem practiceOrder(int pageNum){
		return  wrongItemService.practiceOrder(pageNum);
	}

	/**
	 * 删除错题
	 * @param id
	 * @return
	 */
	@RequestMapping("/delWrongItem")
	@ResponseBody
	public int delWrongItem(int id){
		return wrongItemService.delWrongItem(id);
	}

}
