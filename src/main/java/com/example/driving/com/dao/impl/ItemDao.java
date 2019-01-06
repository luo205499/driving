package com.example.driving.com.dao.impl;

import com.example.driving.com.dao.IItemDao;
import com.example.driving.com.entity.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author ${lcl}
 * @Title: ItemDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:42
 */
@Repository
public class ItemDao implements IItemDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 科目一模拟考试
     * @param pageNum
     * @return
     */
    @Override
    public Item getItem(int pageNum) {
        String sql = "select * from item where type=0";
        if(pageNum>=40){
            sql="select * from item where type=1";
            pageNum=pageNum-40;
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Item> itemList=new ArrayList();
        while (rs.next()) {
            itemList.add(generateItem(rs));
        }
        Random rand=new Random();
        Collections.shuffle(itemList,rand);
        Item ite = itemList.get(pageNum);
        return ite;
    }
    /**
     * 科目四模拟考试
     * @param pageNum
     * @return
     */
    @Override
    public Item getItem4(int pageNum) {
        String sql = "select * from item where type=0";
        if(pageNum>=20){
            sql="select * from item where type=1";
            pageNum=pageNum-20;
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Item> itemList=new ArrayList();
        while (rs.next()) {
            itemList.add(generateItem(rs));
        }
        Random rand=new Random();
        Collections.shuffle(itemList,rand);
        Item ite = itemList.get(pageNum);
        return ite;
    }

    /**
     * 随机练习
     * @param pageNum
     * @return
     */
    @Override
    public Item practiceAny(int pageNum) {
        String sql = "select * from item";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Item> itemList=new ArrayList();
        while (rs.next()) {
            itemList.add(generateItem(rs));
        }
        Random rand=new Random();
        Collections.shuffle(itemList,rand);
        Item ite = itemList.get(pageNum);
        return ite;
    }

    /**
     * 顺序练习
     * @param pageNum
     * @return
     */
    @Override
    public Item practiceOrder(int pageNum) {
        String sql = "select * from item";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<Item> itemList=new ArrayList();
        while (rs.next()) {
            itemList.add(generateItem(rs));
        }
        Item ite = itemList.get(pageNum);
        return ite;
    }

    /**
     * 添加试题
     * @param item
     * @return
     */
    @Override
    public int addItem(Item item) {
        String sql = "insert into item (coments,item_a,item_b,item_c,item_d,answer,img,type) values (?,?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, item.getComents(), item.getItemA(), item.getItemB(), item.getItemC(), item.getItemD(), item.getAnswer(), item.getImg(), item.getType());
        return i;

    }

    //保存题库信息
    private Item generateItem(SqlRowSet rs) {
        Item it = new Item();
        it.setId(rs.getInt("id"));
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
