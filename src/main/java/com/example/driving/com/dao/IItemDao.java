package com.example.driving.com.dao;

import com.example.driving.com.entity.Item;
import org.springframework.stereotype.Repository;

/**
 * @author ${lcl}
 * @Title: IItemDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:39
 */
public interface IItemDao {

    /**
     * 获取模拟考试试题
     *
     * @author Lcl
     * @param @param pageNum
     * @param @param pageSize
     * @param @return    参数
     * @return Item    返回类型
     * @throws
     * @date 2018年12月15日 下午11:54:16
     */
     Item getItem(int pageNum);

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
     * 添加题库
     * @param item
     * @return
     */
    int addItem(Item item);
}
