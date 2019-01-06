package com.example.driving.com.service;


import com.example.driving.com.entity.Item;

public interface IItemService {

	/**
	 * 获取模拟考试科目一题目
	* 
	* @author Lcl
	* @param @param pageNum
	* @param @return    参数
	* @return Item    返回类型
	* @throws
	* @date 2018年12月16日 下午12:44:59
	 */
	 Item getItem(int pageNum);

	/**
	 * 获取模拟考试科目四题目
	 *
	 * @author Lcl
	 * @param @param pageNum
	 * @param @return    参数
	 * @return Item    返回类型
	 * @throws
	 * @date 2018年12月16日 下午12:44:59
	 */
	Item getItem4(int pageNum);

	/**
	 * 随机练习
	 * @param pageNum
	 * @return
	 */
	 Item practiceAny(int pageNum);

	/**
	 * 顺序练习
	 * @param pageNum
	 * @return
	 */
	Item practiceOrder(int pageNum);

	/**
	 * 添加试题
	 * @param item
	 * @return
	 */
	int addItem(Item item);
}
