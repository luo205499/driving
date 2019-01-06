package com.example.driving.com.dao.impl;

import com.example.driving.com.dao.IWrongItemDao;
import com.example.driving.com.entity.Item;
import com.example.driving.com.entity.WrongItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ${lcl}
 * @Title: ItemDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:42
 */
@Repository
public class WrongItemDao implements IWrongItemDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加试题
     * @param item
     * @return
     */
    @Override
    public int addItem(WrongItem item) {
        String sql = "insert into wrong_item (uid,coments,item_a,item_b,item_c,item_d,answer,img,type) values (?,?,?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql,item.getUid(),item.getComents(), item.getItemA(), item.getItemB(), item.getItemC(), item.getItemD(), item.getAnswer(), item.getImg(), item.getType());
        return i;

    }
    /**
     * 错题练习
     * @param pageNum
     * @return
     */
    @Override
    public WrongItem practiceOrder(int pageNum) {
        String sql = "select * from wrong_item";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<WrongItem> itemList=new ArrayList();
        while (rs.next()) {
            itemList.add(generateItem(rs));
        }
        WrongItem ite = itemList.get(pageNum);
        return ite;
    }

    /**
     * 删除错题
     * @param id
     * @return
     */
    @Override
    public int delWrongItem(int id) {
        String sql = "delete from wrong_item where id=?";
        int rs = jdbcTemplate.update(sql,id);
        return rs;
    }

    //保存题库信息
    private WrongItem generateItem(SqlRowSet rs) {
        WrongItem it = new WrongItem();
        it.setId(rs.getInt("id"));
        it.setUid(rs.getInt("uid"));
        it.setComents(rs.getString("coments"));
        it.setItemA(rs.getString("item_a"));
        it.setItemB(rs.getString("item_b"));
        it.setItemC(rs.getString("item_c"));
        it.setItemD(rs.getString("item_d"));
        it.setAnswer(rs.getString("answer"));
        it.setImg(rs.getString("img"));
        it.setType(rs.getInt("type"));
        return it;
    }
}
