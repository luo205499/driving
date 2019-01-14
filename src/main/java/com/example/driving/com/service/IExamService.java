package com.example.driving.com.service;

/**
* 试卷业务逻辑service接口
* @author:         Lcl
* @createDate:     2018/12/20 0020 13:06
* @version:        1.0
*/
public interface IExamService {
    /**
     * 保存用户考试信息
     * @param uid
     * @param grade
     * @return
     */
     int addExam(int uid, int grade,int type);

}
