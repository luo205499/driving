package com.example.driving.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ${lcl}
 * @Title: User
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/18 001812:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id; //用户id
    private String username;//用户名
    private String password;//用户密码
    private Integer type;//用户类型，0：普通用户；1：管理员
}
