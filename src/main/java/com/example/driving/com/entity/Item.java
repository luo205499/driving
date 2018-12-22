package com.example.driving.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ${lcl}
 * @Title: Item
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private Integer id;//试题id
    private String coments;//试题题目内容
    private String itemA;//A选项
    private String itemB;//B选项
    private String itemC;//C选项
    private String itemD;//D选项
    private String answer;//答案
    private String img;//图片
    private Integer type;//类型,0:判断题；1：选择题
}
