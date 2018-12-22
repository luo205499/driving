package com.example.driving.com.dao;

/**
 * @author ${lcl}
 * @Title: IExam
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:40
 */
public interface IExamDao {
    /**
     * 保存用户考试信息
     * @param uid
     * @param grade
     * @return
     */
    int addExam(int uid,int grade);
}
