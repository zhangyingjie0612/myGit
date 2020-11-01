package com.jxd.follow_sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.follow_sys.mapper.IStudentMapper;
import com.jxd.follow_sys.model.Course;
import com.jxd.follow_sys.model.Student;
import com.jxd.follow_sys.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/30
 * @Version 1.0
 */
@Service
public class StudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {
    @Autowired
    IStudentMapper iStudentMapper;
    /**
     * @Author: zhangyingjie
     * @Description:管理员看到的学生列表
     * @Date:14:42 2020/10/31
     */
    public List<Map<String, Object>> getStudents(List<Course> courseId,Integer counts, Integer pageSize) {
        return iStudentMapper.getStudents(courseId,counts,pageSize);
    }
//    public List<Map<String, Object>> getStudents(List<Course> courseId) {
//        return iStudentMapper.getStudents(courseId);
//    }
}
