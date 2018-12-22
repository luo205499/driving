package com.example.driving.com.dao.impl;

import com.example.driving.com.dao.IExamDao;
import com.example.driving.com.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ${lcl}
 * @Title: ExamDao
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:42
 */
@Repository
public class ExamDao implements IExamDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 保存用户考试信息
     * @param uid
     * @param grade
     * @return
     */
    @Override
    public int addExam(int uid, int grade) {
        String sql = "insert into exam (u_id,grade,examTime) values (?,?,?)";
//        Date examTime = new Date();
        Timestamp examTime=new Timestamp(System.currentTimeMillis());
        return jdbcTemplate.update(sql, uid, grade,examTime);
    }
}
