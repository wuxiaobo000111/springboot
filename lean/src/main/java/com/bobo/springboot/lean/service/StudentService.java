package com.bobo.springboot.lean.service;

import com.bobo.springboot.lean.commons.ResultInfo;
import com.bobo.springboot.lean.dao.entity.Student;
import com.bobo.springboot.lean.dao.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/8/19/9:17.
 */
@Service
public class StudentService extends BaseService{

    @Autowired
    private StudentMapper studentMapper;

    public Student getSutdentInfo(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public ResultInfo insertStudent(Student student) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            if (student == null) {
                return resultInfo;
            }
            studentMapper.insertSelective(student);
        }catch (Exception e) {
            logger.error("StudentService insertStudent errror, the params:{}", student.toString(),e);
            resultInfo.setCode(-1);
        }
        return resultInfo;
    }
}
