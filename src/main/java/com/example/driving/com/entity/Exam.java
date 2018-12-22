package com.example.driving.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author ${lcl}
 * @Title: Exam
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam implements Serializable {
    private Integer id;//试卷id
    private Integer uId;//用户id
    private Integer grade;//考试成绩
    private Timestamp examTime;//考试完成时间

}
