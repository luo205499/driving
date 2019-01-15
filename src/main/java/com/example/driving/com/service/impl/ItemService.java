package com.example.driving.com.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.driving.com.dao.IItemDao;
import com.example.driving.com.entity.Item;
import com.example.driving.com.service.IItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemService implements IItemService {

	@Resource
	private IItemDao itemDao;

	/**
	 * 获取模拟考试试题
	 * @param pageNum
	 * @return
	 */
	@Override
	public Item getItem(int pageNum) {
		return itemDao.getItem(pageNum);
	}

	@Override
	public Item getItem4(int pageNum) {
		return itemDao.getItem4(pageNum);
	}

	/**
	 * 获取随机练习试题
	 * @param pageNum
	 * @return
	 */
	@Override
	public Item practiceAny(int pageNum) {
		return itemDao.practiceAny(pageNum);
	}

	/**
	 * 获取顺序考试试题
	 * @param pageNum
	 * @return
	 */
	@Override
	public Item practiceOrder(int pageNum) {
		return itemDao.practiceOrder(pageNum);
	}

	/**
	 * 添加试题
	 * @param item
	 * @return
	 */
	@Override
	public int addItem(Item item) {
		return itemDao.addItem(item);
	}

	/**
	 * 针对练习
	 * @param pageNum
	 * @return
	 */
	@Override
	public Item forPractice(int pageNum,HttpServletRequest request) {
		return itemDao.forPractice(pageNum,request);
	}

}
