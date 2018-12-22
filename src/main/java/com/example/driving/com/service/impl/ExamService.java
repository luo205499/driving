package com.example.driving.com.service.impl;

import com.example.driving.com.dao.IExamDao;
import com.example.driving.com.service.IExamService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 业务逻辑service实现类
* @author:         Lcl
* @createDate:     2018/12/20 0020 13:06
* @version:        1.0
*/
@Service
public class ExamService implements IExamService {

    @Resource
    private IExamDao examDao;

    /**
     * 保存用户考试信息
     * @param uid
     * @param grade
     * @return
     */
    @Override
    public int addExam(int uid, int grade) {
        return examDao.addExam(uid,grade);
    }
}
