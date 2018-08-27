package com.bobo.springboot.lean.controller;

import com.bobo.springboot.lean.commons.ResultInfo;
import com.bobo.springboot.lean.dao.entity.Student;
import com.bobo.springboot.lean.service.DataService;
import com.bobo.springboot.lean.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bobo on 2018/8/19/9:17.
 */
@Controller
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "student/getStudentInfo",method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentInfo(Integer id) {
        return  studentService.getSutdentInfo(id);
    }

    /**
     * restful风格
     */
    @RequestMapping(value = "student/userInfo/{id}",method = RequestMethod.GET)
    @ResponseBody
    /**
     * 这里也可以简化为@PathVariable Integer id
     */
    public Student UserInfo(@PathVariable(value = "id")Integer id) {
        Student student = studentService.getSutdentInfo(id);
        return student;
    }

    @RequestMapping(value = "student/{id}",produces={"application/json;charset=UTF-8"},
            method = RequestMethod.GET)
    @ResponseBody
    public Student selectStudent(@PathVariable(value = "id") Integer id) {
        Student student = studentService.getSutdentInfo(id);
        return student;
    }

    @PostMapping(value = "student")
    @ResponseBody
    public ResultInfo insertStudent(@ModelAttribute Student student) {
        ResultInfo resultInfo= studentService.insertStudent(student);
        return resultInfo;
    }

    @RequestMapping("/put")
    @ResponseBody
    public String put(Long id, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(new Date()) + " : value is " + dataService.put(id, value) ;
    }

    @RequestMapping("/get")
    @ResponseBody
    public String query(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " : value is " +dataService.query(id) ;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataService.remove(id) ;
        return sdf.format(new Date()) + " : success " ;
    }

}
