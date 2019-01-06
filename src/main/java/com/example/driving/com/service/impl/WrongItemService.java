package com.example.driving.com.service.impl;

import com.example.driving.com.dao.IWrongItemDao;
import com.example.driving.com.entity.Item;
import com.example.driving.com.entity.WrongItem;
import com.example.driving.com.service.IWrongItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WrongItemService implements IWrongItemService {

	@Resource
	private IWrongItemDao wrongItemDao;

	/**
	 * 添加试题
	 * @param item
	 * @return
	 */
	@Override
	public int addItem(WrongItem item) {
		return wrongItemDao.addItem(item);
	}

	@Override
	public WrongItem practiceOrder(int pageNum) {
		return wrongItemDao.practiceOrder(pageNum);
	}

	@Override
	public int delWrongItem(int id) {
		return wrongItemDao.delWrongItem(id);
	}

}
