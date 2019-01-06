package com.example.driving.com.service;


import com.example.driving.com.entity.Item;
import com.example.driving.com.entity.WrongItem;

public interface IWrongItemService {

	/**
	 * 添加错误试题
	 * @param item
	 * @return
	 */
	int addItem(WrongItem item);

	/**
	 * 查询错误试题
	 * @param pageNum
	 * @return
	 */
	WrongItem practiceOrder(int pageNum);

	/**
	 * 删除错题
	 * @param id
	 * @return
	 */
	int delWrongItem(int id);
}
