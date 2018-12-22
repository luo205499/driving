package com.example.driving.com.controller;

import com.example.driving.com.service.IExamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ${lcl}
 * @Title: ExamController
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/20 002013:09
 */
@Controller
public class ExamController {
    @Resource
    private IExamService examService;
    @RequestMapping("addExam")
    @ResponseBody
    public int addExam(int uid, int grade) {
        return examService.addExam(uid,grade);
    }

}
