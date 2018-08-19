package com.bobo.springboot.lean.controller;

import com.bobo.springboot.lean.dao.entity.Student;
import com.bobo.springboot.lean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bobo on 2018/8/19/9:17.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentInfo(Integer id) {
        return  studentService.getSutdentInfo(id);
    }

    /**
     * restful风格
     */
    @RequestMapping(value = "/userInfo/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Student UserInfo(@PathVariable(value = "id")Integer id) {
        Student student = studentService.getSutdentInfo(id);
        return student;
    }
}
