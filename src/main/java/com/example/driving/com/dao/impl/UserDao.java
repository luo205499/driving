package com.example.driving.com.dao.impl;

import com.example.driving.com.dao.IUserDao;
import com.example.driving.com.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ${lcl}
 * @Title: UserDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:42
 */
@Repository
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User loginTest(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,username,password);
        //映射每行数据存入实体类
        if (rs.next()) {
            User sa = generateEntity(rs);
            return sa;
        }
        return null;
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @Override
    public User register(String username,String password) {
        String sql = "insert into user (username,password) values (?,?)";
        if(jdbcTemplate.update(sql, username, password)>0){
            SqlRowSet us = jdbcTemplate.queryForRowSet("select * from user where username=?", username);
            User sa=null;
            if (us.next()) {
                sa = generateEntity(us);
            }
            return sa;
        }else {
            return null;
        }
    }

    /**
     * 查看用户信息
     * @param id
     * @return
     */
    @Override
    public List queryUser(int id) {
        String sql = "select u.username,e.grade,e.examTime from user as u,exam as e where u.id=e.u_id and u.id=?";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,id);
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,id);
        if(list==null){
            return null;
        }
        else{
            return list;
        }
    }


    //保存用户信息
    private User generateEntity(SqlRowSet rs) {
        User sa = new User();
        sa.setId(rs.getInt("id"));
//        sa.setPassword(rs.getString("password"));
        sa.setUsername(rs.getString("username"));
        sa.setType(rs.getInt("type"));
        return sa;
    }

}
