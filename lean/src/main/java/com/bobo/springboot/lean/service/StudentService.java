package com.bobo.springboot.lean.service;

import com.bobo.springboot.lean.dao.entity.Student;
import com.bobo.springboot.lean.dao.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/8/19/9:17.
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student getSutdentInfo(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
