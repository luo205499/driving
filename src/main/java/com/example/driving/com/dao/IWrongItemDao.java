package com.example.driving.com.dao;

import com.example.driving.com.entity.Item;
import com.example.driving.com.entity.WrongItem;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${lcl}
 * @Title: IItemDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:39
 */
public interface IWrongItemDao {
    /**
     * 添加题库
     * @param item
     * @return
     */
    int addItem(WrongItem item);

    /**
     * 错题练习
     * @param pageNum
     * @return
     */
     WrongItem practiceOrder(int pageNum);

    /**
     * 删除错题
     */
    int delWrongItem(int id);
}
